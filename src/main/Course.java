package main;

import java.util.ArrayList;
import java.util.Map;

/**
 * Course class. Represents a course in a school system
 * @author Mark Arita
 *
 */
public class Course 
{
	private int id;										//Id value of the course
	private int credits;								//Number of credits for the course
	private int maxOverrides;							//Maximum number of overrides
	private int maxEnrollment;							//Maximum number of seats for the course
	private String name;								//Name of the course
	private ArrayList<Course> preRequisite;				//Pre-requisites for this course
	private ArrayList<SemesterCourse> semesterCourses;	//Course for the Semester
	private int semesterId; 							//Id value of the semester this course is associated with
	private int year;									//Year associated with this Course
	
	/**
	 * Default Course constructor
	 */
	Course()
	{
		id = -1;
		semesterId = -1;
		credits = -1;
		name = "";
		maxOverrides = -1;
		maxEnrollment = -1;
		preRequisite = new ArrayList<Course>();
		semesterCourses = new ArrayList<SemesterCourse>();
		year = 2015;
	}
	
	/**
	 * Course constructor
	 */
	Course(int id)
	{
		this.id = id;
		this.semesterId = -1;
		this.credits = -1;
		this.name = "";
		this.maxOverrides = -1;
		this.maxEnrollment = -1;
		this.preRequisite = new ArrayList<Course>();
		this.semesterCourses = new ArrayList<SemesterCourse>();
		this.year = 2015;
	}

	/**
	 * Course constructor
	 */
	Course(int id, String name)
	{
		this.id = id;
		this.semesterId = -1;
		this.credits = -1;
		this.name = name;
		this.maxOverrides = -1;
		this.maxEnrollment = -1;
		this.preRequisite = new ArrayList<Course>();
		this.semesterCourses = new ArrayList<SemesterCourse>();
		this.year = 2015;
	}
	
	// Getters
	
	/**
	 * Returns the Course's id
	 * @return: Integer Id of the Course
	 */
	public int GetId()
	{
		return this.id;
	}
	
	/**
	 * Gets the number of credits this course is worth
	 * @return: Integer value of the number of credits the course is worth
	 */
	public int GetCredits()
	{
		return this.credits;
	}
	
	/**
	 * Returns the Course name
	 * @return: String name of the Course
	 */
	public String GetName()
	{
		return this.name;
	}

	/**
	 * Gets the maximum number of student overrides to enroll in the course
	 * @return: Integer of the number of student overrides allowed
	 */
	public int GetMaxOverrides()
	{
		return this.maxOverrides;
	}
	
	/**
	 * Gets the maximum enrollment for the course
	 * @return: Integer value of the maximum enrollment for the course
	 */
	public int GetMaxEnrollment()
	{
		return this.maxEnrollment;
	}
	
	/**
	 * Gets the pre-requisites for this Course
	 * @return
	 */
	public ArrayList<Course> GetPrereqs()
	{
		return this.preRequisite;
	}
	
	/**
	 * Gets the Semester's id this course is associated with
	 * @return: Integer value of the Semester associated with this course
	 */
	public int GetSemesterId()
	{
		return this.semesterId;
	}
	
	/**
	 * Gets the year for this Course
	 * @return: Int year for the Course
	 */
	public int GetYear()
	{
		return this.year;
	}
	
	// End Getters
	
	
	// Setters
	
	/**
	 * Add a prerequisite to the Course's prerequisite list
	 * @param preReq: Course to add as a prerequisite
	 */
	public void AddPrerequisite(Course preReq)
	{
		if (preRequisite == null)
			preRequisite = new ArrayList<Course>();
		
		preRequisite.add(preReq);
	}
	
	/**
	 * Returns the Course's id
	 * @return: Integer Id of the Course
	 */
	public void SetId(int courseId)
	{
		this.id = courseId;
	}
	
	/**
	 * Gets the number of credits this course is worth
	 * @return: Integer value of the number of credits the course is worth
	 */
	public void SetCredits(int credits)
	{
		this.credits = credits;
	}
	
	/**
	 * Returns the Course name
	 * @return: String name of the Course
	 */
	public void SetName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the maximum number of student overrides to enroll in the course
	 * @return: Integer of the number of student overrides allowed
	 */
	public void SetMaxOverrides(int maxOverrides)
	{
		this.maxOverrides = maxOverrides;
	}
	
	/**
	 * Gets the maximum enrollment for the course
	 * @return: Integer value of the maximum enrollment for the course
	 */
	public void SetMaxEnrollment(int maxEnrollment)
	{
		this.maxEnrollment = maxEnrollment;
	}
	
	/**
	 * Sets List of Prerequisite courses for this course from a hash map.
	 * @param preRequisiteHashMap
	 */
	public void SetPrequisite(Map<Integer, ArrayList<Integer>> preRequisiteHashMap)
	{
		 
		for ( int key : preRequisiteHashMap.keySet() ) 
		{
			if (this.id == key)
			{
				ArrayList<Integer> preReqIds = preRequisiteHashMap.get(key);
				for (int id : preReqIds){
					this.preRequisite.add(new Course(id));
				}
			}
		}	
	}	
	
	/**
	 * Gets the Semester's id this course is associated with
	 * @return: Integer value of the Semester associated with this course
	 */
	public void SetSemesterId(int semesterId)
	{
		this.semesterId = semesterId;
	}
	
	// End Setters
	
	
}
