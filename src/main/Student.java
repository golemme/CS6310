package main;

import java.util.ArrayList;

/**
 * Student class. Inherits from Person class, and represents a Student at university
 * @author Mark Arita
 *
 */
public class Student extends Person
{
	private int maxCoursesPerSemester;					//Sets the maximum number of Courses a Student can take in a Semester
	private ArrayList<Course> preferredCourses;			//List of preferred Courses for the Student
	private ArrayList<SemesterCourse> scheduledCourses;	//List of Semester Courses for the Student
	private Program program;							//Program containing Student Course information
	
	/**
	 * Constructor for the Student object
	 */
	Student()
	{
		super();
		this.maxCoursesPerSemester = 2;
		this.preferredCourses = new ArrayList<Course>();
		this.scheduledCourses = new ArrayList<SemesterCourse>();
	}
	
	/**
	 * Secondary constructor for Student object
	 * @param id
	 */
	Student(int id)
	{
		super();
		this.SetId(id);
		this.preferredCourses = new ArrayList<Course>();
		this.scheduledCourses = new ArrayList<SemesterCourse>();
	}
	
	// Getters
	
	/**
	 * Gets the maximum number of courses per semester for this student
	 * @return: int max number of allowed Courses the Student can take for a Semester
	 */
	public int GetMaxCoursesPerSemester()
	{
		return this.maxCoursesPerSemester;
	}
	
	/**
	 * Gets the list of PreferredCourses that the Student wants
	 * @return: ArrayList of Preferred Courses for the Student
	 */
	public ArrayList<Course> GetPreferredCourses()
	{
		return this.preferredCourses;
	}
	
	/**
	 * Gets the Schedule Courses for the Student
	 * @return: ArrayList of Scheduled Courses for the Student
	 */
	public ArrayList<SemesterCourse> GetScheduledCourses()
	{
		return this.scheduledCourses;
	}
	
	/**
	 * Gets whether the specified Course is one that the Student wants
	 * @param course: Course to check whether the Student wants or not
	 * @return: Boolean of whether the Student wants to take the Course or not
	 */
	public boolean isPreferredCourse(Course course)
	{
		boolean isPreferredCourse = false;
		
		//Check whether the specified Course is preferred by the Student or not
		for (Course c : this.preferredCourses)
		{
			if (c.GetId() == course.GetId())
			{
				isPreferredCourse = true;
				continue;
			}
		}
		  
		return isPreferredCourse;
	}
	
	// End Getters
	
	
	// Setters
	
	/**
	 * Adds a Preferred Course to the list for the Student
	 * @param pCourse: Preferred Course to add to the Student's Preferred Course list
	 */
	public void AddPreferredCourse(Course pCourse)
	{
		if (this.preferredCourses == null)
			this.preferredCourses = new ArrayList<Course>();
		
		this.preferredCourses.add(pCourse);
	}
	

	/**
	 * Adds a Semester (scheduled) Course to the list for the Student
	 * @param pCourse: Preferred Course to add to the Student's Semester Course list
	 */
	public void AddScheduledCourse(SemesterCourse pCourse)
	{
		if (this.scheduledCourses == null)
			this.scheduledCourses = new ArrayList<SemesterCourse>();
		
		this.scheduledCourses.add(pCourse);
	}
	
	/**
	 * Sets the maximum number of Course the Student can take in a Semester
	 * @param max: in max number of allowed Course the Student can take in a Semester
	 */
	public void SetMaxCoursesPerSemester(int max)
	{
		this.maxCoursesPerSemester = max;
	}
	
	// End Setters
	
}