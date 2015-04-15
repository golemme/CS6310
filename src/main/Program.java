package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents the main program for Student-Course pairing
 * 
 * Adapted from provided exemplary project code
 * Source: Sethuraman, Amudha exemplary project from Resources
 * @author Mark Arita
 * 
 */
public class Program 
{
	public int programId;
	public String programName;
	public ArrayList<Semester> programSemesters;
	public ArrayList<SemesterCourse> programSemesterCourses;
	public ArrayList<Student> programStudents;
	public ArrayList<Course> programCourses;
	public int TotalSemesterCount; 
	
	/**
	 * Program Constructor
	 * @param id: Id of the Program
	 * @param name: Name of the Program
	 */
	public Program(int id, String name)
	{
		this.programId = id;
		this.programName = name;
		this.programSemesterCourses = new ArrayList<SemesterCourse>();
		this.programSemesters = new ArrayList<Semester>();
		this.programStudents = new ArrayList<Student>();
		this.programCourses = new ArrayList<Course>();
		this.TotalSemesterCount = InputData.TotalSemesterCount;
	}
	
	/**
	 * Check that all required data was imported correctly
	 */
	private void CheckData()
	{
		//Check data was imported correctly
		if (this.programStudents.isEmpty())
			System.out.println("Error: Data is missing for Students!");
		
		if (this.programCourses.isEmpty())
			System.out.println("Error: Data is missing for Courses!");
	}
	
	/**
	 * Loads the main Program, including the Student, Course, and Semester data from file
	 */
	public void LoadProgram()
	{
		FileReader.ReadFiles(); 							//Reads text files for Student_Schedule, Courses and prerequisites.
		LoadCourses(InputData.courseHashMap); 				//Loads courses with prerequisites.
		LoadStudents(InputData.studentPreferredSchedule); 	//Loads students with preferred courses and their prerequisites.
		
		CheckData();
		
		SemesterCourse semesterCourse;	
		Semester semester;
		String semesterName, nextSemesterName = "";
		
		//Load all of the Semester and Courses into corresponding objects
		for(int i = 0; i < TotalSemesterCount; i++)
		{
			//Set the Semester id and Name
			int semesterId = i + 1;			
			if (semesterId == 1) 
				semesterName = InputData.FirstSemester; 				
			else
				semesterName = nextSemesterName;
			
			if (semesterName.equals("Spring"))
				nextSemesterName = "Summer";
			else if (semesterName.equals("Summer"))
				nextSemesterName = "Fall";
			else if (semesterName.equals("Fall"))
				nextSemesterName = "Spring";

			
			semester = new Semester(semesterId, semesterName);		
			this.programSemesters.add(semester);			
		
			//Add all of the available courses for the Semester; Some are only available during particular Semesters
			for(Course course : this.programCourses)
			{
				semesterCourse = new SemesterCourse(semester, course);				
				switch (semesterCourse.course.GetId())
				{
					case 1: case 7: case 11: case 15: case 17:
						if ((semester.GetName().equals("Spring")) || (semester.GetName().equals("Summer")))
							semesterCourse.capacity = 0;
						else
							semesterCourse.capacity = -1;
						break;
					case 5: case 10: case 14: case 16: case 18: 
						if ((semester.GetName().equals("Fall")) || (semester.GetName().equals("Summer")))
							semesterCourse.capacity = 0;
						else
							semesterCourse.capacity = -1;
						break;
					case 2: case 3: case 4: case 6: case 8: case 9: case 12: case 13: 
						semesterCourse.capacity = -1;
						break;
					default: 
						semesterCourse.capacity = -1;
						break;
				}
								
				this.programSemesterCourses.add(semesterCourse);
			}
		}
	}
	
	/**
	 * Loads all of the Student data, including, for each Student, what classes they want to take
	 * @param studentPreferredSchedule: List of Students with List of desired Courses
	 */
 	private void LoadStudents(ArrayList<ArrayList<Integer>> studentPreferredSchedule)
 	{
 		ArrayList<Student> students = new ArrayList<Student>();
 		
 		try
 		{
			Student student;
			
			//Iterate through the list of Students and their desired Courses and place them in appropriate container objects
			for(int i = 1; i <= studentPreferredSchedule.size(); i ++)
			{
				student = new Student();
				student.SetId(i);
				student.SetMaxCoursesPerSemester(InputData.MaxCoursePerSemester);
				
				//Get all of the desired Courses for the Student
				for(Integer courseId: studentPreferredSchedule.get(i - 1))
				{
					Course preferredCourse = new Course(courseId); 
					preferredCourse.SetPrequisite(InputData.preRequisiteHashMap);
					student.AddPreferredCourse(preferredCourse);				
				}
				
				students.add(student);	//add the student to to parent Student list
			}
 		}
 		catch (Exception e)
 		{
 			System.err.format("Exception: %s%n", e);
 		}
 		
		this.programStudents = students;				
	}
 	
 	/**
 	 * Loads all of the Courses into the program from file. 
 	 * @param courseHashMap
 	 */
 	private void LoadCourses(Map<Integer, String> courseHashMap) 
 	{
 		ArrayList<Course> courses = new ArrayList<Course>();
		Course course;
		
		try 
		{
			//Put all of the Courses into appropriate container objects
			for ( int key : courseHashMap.keySet() ) 
			{
				String value = courseHashMap.get(key);
				course = new Course(key, value);
				course.SetPrequisite(InputData.preRequisiteHashMap);
				courses.add(course);	
			}								
		} 
		catch (Exception e) 
		{
			System.err.format("Exception: %s%n", e);
		}
		
		this.programCourses = courses;
	}

 	/**
 	 * Gets the capacity of a Course for the Semester
 	 * @param semesterId: Semester to use for the Course
 	 * @param courseId: Course to obtain capacity for
 	 * @return
 	 */
	public int GetCapacityOfSemesterCourse(int semesterId, int courseId)
	{
		int capacity = -1;
		for (SemesterCourse sc : this.programSemesterCourses)
		{
			//find match
			if ((sc.course.GetId() == courseId) && (sc.semester.GetId() == semesterId) )
			{
				capacity = sc.capacity;
				break;	//marita3 added
			}
		}
		
		return capacity;
	}
}
