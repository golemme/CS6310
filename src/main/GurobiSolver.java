package main;

import java.io.IOException;
import java.io.PrintWriter;

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;


/**
 * Utilizes Gurobi as the IP solver for Student-Course pairing
 * Adapted from provided project code
 * Source: Sethuraman, Amudha exemplary project from Resources
 * @author Mark Arita
 *
 */
public class GurobiSolver implements Solver
{
	/**
	 * Main Solver, using Gurobi for Student-Course pairing
	 * @throws Exception 
	 */
	public void Solve(Program program) throws Exception
	{
		try
		{
			int num_of_students = program.programStudents.size();
			int num_of_courses = program.programCourses.size();
			int num_of_semesters = program.programSemesters.size();
			
			if (num_of_students == 0)
				throw new Exception("Can't solve. Student count is 0");
			
			if (num_of_courses == 0)
				throw new Exception("Can't solve. Courses count is 0");
			
			if (num_of_semesters ==0)
				throw new Exception("Can't solve. Semesters count is 0");
			
			
			//Setup Gurobi
			GRBEnv env = new GRBEnv("StudentScheduler.log");
			GRBModel model = new GRBModel(env);
			GRBVar[][][] vars = new GRBVar[num_of_students + 1][num_of_courses + 1][num_of_semesters + 1];
			
			int i, j, k;
			
			// Create variables - All variables are binary except X. X is an integer. X is the capacity of the class.
			for (Student student : program.programStudents)
			{
				for (Course course: program.programCourses)
				{
					for (Semester sem: program.programSemesters)
					{
						i = student.GetId(); j = course.GetId(); k = sem.GetId();
						vars[i][j][k] = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "Y_" + i + "_" + j + "_" + k);	
					} 
				}
			}
			 
			// Add X as Integer variable for class capacity. Can range from 0 to total number of student in the program.
			GRBVar x = model.addVar(0.0, num_of_students, 1.0, GRB.INTEGER, "x");

			// Integrate new variables.	
			model.update();
		
			// Set objective: minimize x - class capacity variable	
			GRBLinExpr expr = new GRBLinExpr();
			expr.addTerm(1.0, x); 
			model.setObjective(expr, GRB.MINIMIZE);
		
			//Create constraints
				/*constraints group 1 - student can take a course only once. considering student's 12 preferred courses.
				y_i_j_k - i - students, j- courses, k-semesters
				constraint 1: y_1_1_1 + y_1_1_2 + .. + y_1_1_6 = 1
				constraint 2: y_1_2_1 + y_1_2_2 + .. + y_1_2_6 = 1
				constraint 3: y_2_1_1 + y_2_1_2 + .. + y_2_1_6 = 1
				*/
						
			for (Student student : program.programStudents)
			{
				i = student.GetId();
				for (Course course : student.GetPreferredCourses()) //considering only student's 12 preferred courses.
				{
					expr = new GRBLinExpr();		
					j = course.GetId();
					for (Semester sem : program.programSemesters)
					{
						k = sem.GetId();
						expr.addTerm(1.0, vars[i][j][k]);				 				 
					}
					model.addConstr(expr, GRB.EQUAL, 1.0,"c1" + "_" + i + "_" + j);
				}
			}
	
				
			/*constraint group 2 - students can take up to two courses in a semester. considering student's 12 preferred courses.
			y_i_j_k - i - students, j- courses, k-semesters
			constraint 1: y_1_1_1 + y_1_2_1 + .. + y_1_18_1 <= 2
			constraint 2: y_1_1_2 + y_1_2_2 + .. + y_1_18_2 <= 2
			constraint 3: y_2_1_1 + y_2_2_1 + .. + y_2_18_1 <= 2
			*/			 	
				 
			for (Student student : program.programStudents)
			{
				i = student.GetId();
				for (Semester sem : program.programSemesters)
				{
					k = sem.GetId();
					expr = new GRBLinExpr();		
					for (Course course : student.GetPreferredCourses()) //considering only student's 12 preferred courses.
					{
						j = course.GetId();
						expr.addTerm(1.0, vars[i][j][k]);							
					}
					model.addConstr(expr, GRB.LESS_EQUAL, student.GetMaxCoursesPerSemester(), "c2" + "_" + i + "_" + k);
				}
			}
			
			/*constraint group 3 - number of students in a course that is not offered during any semester is equal to 0.
		y_i_j_k - i - students, j- courses, k-semesters. j course is not offered in k semester.
			constraint 1: y_1_1_1 + y_2_1_1 + .. + y_600_1_1 = 0
			constraint 2: y_1_2_1 + y_2_2_1 + .. + y_600_2_1 = 0
			*/
			
			for (Semester sem : program.programSemesters)
			{
				k = sem.GetId();
				for (Course course : program.programCourses)
				{
					j = course.GetId();
					if (program.GetCapacityOfSemesterCourse(sem.GetId(), course.GetId()) == 0)
					{
						expr = new GRBLinExpr();		
						for (Student student : program.programStudents)
						{
							i = student.GetId();
							expr.addTerm(1.0, vars[i][j][k]);								
						}
						model.addConstr(expr, GRB.EQUAL, 0,"c3" + "_" + k + "_" + j);	
					}
				}
			}
			
			 /*constraints group 4 - Prerequisites - student can take a course only after taking its prerequisite in a previous semester 
			y_i_j_k - i - students, j- courses, k-semesters. 9 is a prerequisite for 13. considering only student's 12 preferred courses.
			constraint 1: y_1_13_2 <= y_1_9_1 
			constraint 2: y_1_13_3 <= y_1_9_2 
			constraint 3: y_2_13_2 <= y_2_9_1 
			y_600_13_1 >= y_600_9_12
			*/
					
			//int constraintCount = 0;
			for (Student student : program.programStudents)
			{
				i = student.GetId();
				for (Course course : student.GetPreferredCourses()) //considering only student's 12 preferred courses.
				{
					j = course.GetId();
					if ((course.GetPrereqs().size() > 0)) { 
						for (Course preReq : course.GetPrereqs()) //Prereq constraint for 12th semester
						{											
							expr = new GRBLinExpr();										
							expr.addTerm(1.0, vars[i][j][1]);
							int p = preReq.GetId();
							model.addConstr(expr, GRB.GREATER_EQUAL, vars[i][p][num_of_semesters],"c4" + "_" + i + "_" + p + "_" + num_of_semesters);

							//System.out.println("Y" + "_" + i + "_" + j + "_" + 1 + " <= " + "Y" + "_" + i + "_" + p + "_" + num_of_semesters);
						}
					}
					for (Semester sem : program.programSemesters)//Prereq constraints for 1 - 11 semesters
					{
						k = sem.GetId();
						if ((course.GetPrereqs().size() > 0) && (k < num_of_semesters)) 
						{
							for (Course preReq : course.GetPrereqs())
							{
								//constraintCount++;
								int s = k + 1;
								
								expr = new GRBLinExpr();										
								expr.addTerm(1.0, vars[i][j][s]);
								int p = preReq.GetId();
								model.addConstr(expr, GRB.GREATER_EQUAL, vars[i][p][k],"c4" + "_" + i + "_" + p + "_" + k);
								 
								//System.out.println("Y" + "_" + i + "_" + j + "_" + s + " <= " + "Y" + "_" + i + "_" + p + "_" + k);
							}
						}
					}					 
				}
			}
			//System.out.println("Prereq Constraint count: " + constraintCount);
			
			/*constraint group 5 - number of students in any course during any semester is less than or equal to X.
			y_i_j_k - i - students, j- courses, k-semesters
			constraint 1: y_1_1_1 + y_2_1_1 + .. + y_600_1_1 <= X
			constraint 2: y_1_1_2 + y_2_1_2 + .. + y_600_1_2 <= 1
			constraint 3: y_1_2_1 + y_2_2_1 + .. + y_600_2_1 <= 1
			*/
			for (Semester sem : program.programSemesters)
			{
				k = sem.GetId();
				for (Course course : program.programCourses)
				{
					j = course.GetId();
					expr = new GRBLinExpr();		
					for (Student student : program.programStudents)
					{
						i = student.GetId();
						expr.addTerm(1.0, vars[i][j][k]);								
					}
					model.addConstr(expr, GRB.LESS_EQUAL, x,"c5" + "_" + k + "_" + j);					
				}
			}
		 	
			// Optimize model
		
			model.optimize();
			
			String rowHeader = "Student		";
			for (Semester sem: program.programSemesters)
			{
				k = sem.GetId();
				rowHeader =rowHeader + "Semester" + k +"	";
			}
			//System.out.println(rowHeader);
			
			/* Print Student Schedule */
			try
			{
				//Print student schedule
				PrintWriter out = new PrintWriter("C:\\Users\\sethuramana\\workspace\\StudentScheduler\\StudentScheduler.txt");
				out.println(rowHeader);
				
				String rowStudentSchedule = "";
				for (Student student : program.programStudents)
				{
					i = student.GetId();
					rowStudentSchedule = "S" + i+"		";
					for (Semester sem: program.programSemesters)
					{
						k = sem.GetId();
						String courseList = "";
						for (Course course: program.programCourses)
						{
							j = course.GetId();			
							int capacity = (int) x.get(GRB.DoubleAttr.X);
							if (vars[i][j][k].get(GRB.DoubleAttr.X) == 1){
								courseList = courseList + j + ".";
								student.AddScheduledCourse(new SemesterCourse(sem, course, capacity));
							}
							 
						} 
						rowStudentSchedule = rowStudentSchedule + courseList + "		";
					}
					out.println(rowStudentSchedule);
				}
				
				out.close();
				//System.out.println(rowStudentSchedule);
			}
			catch (IOException e) 
			{
					System.err.format("IOException: %s%n", e);
			}
				
			for (Student student : program.programStudents)
			{
				i = student.GetId();
				for (Semester sem: program.programSemesters)
				{
					k = sem.GetId();
					for (Course course: program.programCourses)
					{
						 j = course.GetId();	
						 System.out.println(vars[i][j][k].get(GRB.StringAttr.VarName) + " " +vars[i][j][k].get(GRB.DoubleAttr.X));					 
					} 				
				}
			}	
			 
			System.out.println(x.get(GRB.StringAttr.VarName) + " " +x.get(GRB.DoubleAttr.X));				
				
			System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal));
			
			model.write("StudentScheduler.lp");
			model.write("StudentScheduler.sol");
		
			// Dispose of model and environment
		
			model.dispose();
			env.dispose();
		} 
		catch (GRBException e) 
		{
			System.out.println("Error code: " + e.getErrorCode() + ". " + e.getMessage());
		}
	}	
}
