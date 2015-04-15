package main;

import javax.persistence.Entity;

/**
 * School class. Represents a School in a university or university system
 * @author Mark Arita
 *
 */
@Entity
public class School 
{
	SchoolType sType;			//Type of the school for this school
	
	public enum SchoolType		//Type of the school (online, standard)
	{
		none,
		inperson,
		online
	}
	
	/**
	 * School constructor
	 */
	School()
	{
		sType = SchoolType.none;
	}

	// Getters
	
	/**
	 * Gets the SchoolType associated with this School object
	 * @return: SchoolType associated with this School object
	 */
	public SchoolType GetSchoolType()
	{
		return this.sType;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the SchoolType for the School object
	 * @param sType: SchoolType value
	 */
	public void SetSchoolType(SchoolType sType)
	{
		this.sType = sType;
	}
	
	// End Setters
}
