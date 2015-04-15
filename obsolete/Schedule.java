package main;

import javax.persistence.Entity;

/**
 * Schedule class. Represents a Schedule associated with a student's course listings across semesters
 * @author Mark Arita
 *
 */
@Entity
public class Schedule 
{
	private int Id; 		//Id number for the Schedule
	
	/**
	 * Schedule constructor
	 */
	Schedule()
	{
		Id = -1;
	}
	
	// Getters
	
	/**
	 * Gets the Id associated with the Schedule
	 * @return: Gets the Schedule Id
	 */
	public int GetId()
	{
		return this.Id;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the Schedule Id
	 * @param Id: Integer Id value to assign to the Schedule
	 */
	public void SetId(int Id)
	{
		this.Id = Id;
	}
	
	// End Setters
}
