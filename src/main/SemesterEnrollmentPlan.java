package main;

import java.util.ArrayList;

/**
 * SemesterEnrollmentPlan class. Represents a Semester's enrollment plan associated with a Student
 * @author Mark Arita
 *
 */
public class SemesterEnrollmentPlan 
{
	private int id; 								//ID for the semester's enrollment plan
	private ArrayList<Course>	courseEnrollment;
	
	/**
	 * SemesterEnrollmentPlan constructor
	 */
	SemesterEnrollmentPlan()
	{
		id = -1;
		courseEnrollment = new ArrayList<Course>();
	}
	
	// Getters
	
	/**
	 * Returns the courses associated with this enrollment plan
	 * @return: List of Courses in the plan
	 */
	public ArrayList<Course> GetCourses()
	{
		return this.courseEnrollment;
	}
	
	/**
	 * Gets the id associated with the semester's enrollment plan
	 * @return
	 */
	public int GetId()
	{
		return this.id;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Adds a Course to the enrollment plan
	 * @param course: Course to add to the plan
	 */
	public void AddCourse(Course course)
	{
		this.courseEnrollment.add(course);
	}
	
	/**
	 * Sets the list of Courses for the Enrollment plan 
	 * @param enrollmentPlan: List of courses for the enrollment plan
	 */
	public void SetEnrollmentPlan(ArrayList<Course> enrollmentPlan)
	{
		this.courseEnrollment.clear();
		this.courseEnrollment.addAll(enrollmentPlan);
	}
	
	/**
	 * Sets the id for the enrollment plan
	 * @param id
	 */
	public void SetId(int id)
	{
		this.id = id;
	}
	
	// End Setters
}
