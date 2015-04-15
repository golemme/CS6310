package main;

import javax.persistence.Entity;

/**
 * ProgramOfStudy class. Represents the program of study associated with a Student
 * @author Mark Arita
 *
 */
@Entity
public class ProgramOfStudy 
{
	private String name; 				//Name of the program of study
	private int numberOfSemesters; 		//Number of semesters involved in the program (minimum number)
	private int totalNumCredits;		//Total number of credits required of the program of study

	/**
	 * ProgramOfStudy constructor
	 */
	ProgramOfStudy()
	{
		name = "";
		numberOfSemesters = -1;
		totalNumCredits = -1;
	}
	
	// Getters
	
	/**
	 * Gets the name associated with the program of study
	 * @return: String value name of the program of study
	 */
	public String GetName()
	{
		return this.name;
	}
	
	/**
	 * Gets the number of semesters associated with the program of study
	 * @return: Integer value of the number of semesters for the program of study
	 */
	public int GetNumberOfSemester()
	{
		return this.numberOfSemesters;
	}
	
	/**
	 * Gets the total number of credits required of the program of study
	 * @return: Integer number of credits required for the program of study
	 */
	public int GetTotalNumberOfCredits()
	{
		return this.totalNumCredits;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the name for the program of study
	 * @param name: Sets the name for the program of study
	 */
	public void SetName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the number of semesters required for the program 
	 * @param numSemesters: Integer number of semesters required for the program
	 */
	public void SetNumberOfSemesters(int numSemesters)
	{
		this.numberOfSemesters = numSemesters;
	}
	
	/**
	 * Sets the total number of credits o the program of study
	 * @param numCredits: Total number of credits for the program of study
	 */
	public void SetTotalNumberOfCredits(int numCredits)
	{
		this.totalNumCredits = numCredits;
	}
	
	// End Setters
}
