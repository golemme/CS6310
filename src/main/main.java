package main;

/**
 * CS 6310: Project 4
 * @author: Mark Arita
 * 
 */
public class main 
{
	
	/**
	 * Student-Course pairing program
	 * @param arg
	 */
	public static void main(String[] arg)
	{
		try
		{	
			//Load program data (Students, Courses, Semesters)
			Program OMSCS = new Program(1, "OMSCS");
			OMSCS.LoadProgram();	
			
			//Use Gurobi to Solve the problem
			Solver solver = new GurobiSolver();
			
			//Solve the problem using the selected Solver
			solver.Solve(OMSCS);
			
			//Handle Student requests
				//Login
					//need to find the user and do a string compare of the passwords
					//allow login
					//fail login
			
				//Logged-in
					//Add course
						//Save data
					//Remove course
						//Save data
					//View Courses
					//View recommendation
						//Save data?
			
		}
		catch (Exception e)
		{
			System.out.println(String.format("Error running program: %s", e.toString()));
		}
	}
}
