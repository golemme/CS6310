package main;

import javax.persistence.Entity;

/**
 * Enrollment class. Represents the enrollment information associated with a student and course
 * @author Mark Arita
 *
 */
@Entity
public class Enrollment 
{
	EnrollmentType eType;
	
	public enum EnrollmentType
	{
		none
	}
	
	Enrollment()
	{
		eType = EnrollmentType.none;
	}
	
	// Getters
	
	/**
	 * Gets the enrollment type associated with this enrollment
	 * @return: EnrollmentType value
	 */
	public EnrollmentType GetEnrollmentType()
	{
		return this.eType;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the enrollment type associated with this enrollment
	 * @return: EnrollmentType value
	 */
	public void SetEnrollmentType(EnrollmentType eType)
	{
		this.eType = eType;
	}
	
	// End Setters
	
}
