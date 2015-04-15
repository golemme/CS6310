package main;

import javax.persistence.Entity;

/**
 * CompetencyLookUp class, to describe a teaching competence for a professor or TA
 * @author Mark Arita
 *
 */
@Entity
public class Classroom 
{
	private int classroomNumber; 	//Number of the classroom
	private int numSeats;			//Number of seats available in the classroom
	
	/**
	 * Classroom object constructor
	 */
	Classroom()
	{
		classroomNumber = -1;
	}
	
	// Getters
	
	/**
	 * Gets the number of the classroom
	 * @return: Integer value of the classroom
	 */
	public int GetClassroomNumber()
	{
		return this.classroomNumber;
	}
	
	/**
	 * Gets the number of seats in the classroom
	 * @return: Integer value of number of seats
	 */
	public int GetNumSeats()
	{
		return this.numSeats;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the number of the classroom
	 * @param classroomNumber: Integer value to set for the classroom number
	 */
	public void SetClassroomNumber(int classroomNumber)
	{
		this.classroomNumber = classroomNumber;
	}
	
	/**
	 * Sets the number of seats in the classroom
	 * @param numSeats: Integer value number of seats for the classroom
	 */
	public void SetNumberOfSeats(int numSeats)
	{
		this.numSeats = numSeats;
	}
	
	// End Setters

}
