package main;

import javax.persistence.Entity;

/**
 * ProgramRequirement class. Represents a ProgramOfStudy's requirement
 * @author Mark Arita
 *
 */
@Entity
public class ProgramRequirement
{
	private int alternateCourseId;	//ID of an alternate required course
	private int requiredCourseId;	//ID of a required course
	
	/**
	 * ProgramRequirement constructor
	 */
	ProgramRequirement()
	{
		requiredCourseId = -1;
		alternateCourseId = -1;
	}
	
	// Getters

	/**
	 * Gets the ID of the course that may be taken instead of the required course
	 * @return: Integer value of the alternate course
	 */
	public int GetAlternateCourseId()
	{
		return this.alternateCourseId;
	}
	
	/**
	 * Gets the required course ID associated with program
	 * @return: Integer value of required course ID
	 */
	public int GetRequiredCourseId()
	{
		return this.requiredCourseId;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the alternate course's ID
	 * @param altCourseId: Alternate Course ID value
	 */
	public void SetAlternateCourseId(int altCourseId)
	{
		this.alternateCourseId = altCourseId;
	}
	
	/**
	 * Sets the ID of the required course
	 * @param requiredCourseId: Integer Course ID value
	 */
	public void SetRequiredCourseId(int requiredCourseId)
	{
		this.requiredCourseId = requiredCourseId;
	}
	
	// End Setters
}
