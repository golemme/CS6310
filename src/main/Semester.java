package main;


/**
 * Semester class. Represent a single Semester during a year at a School
 * @author Mark Arita
 *
 */
public class Semester
{
	private int id; 		//Semester id
	private int year; 		//Semester year
	private String name;	//Name of the semester
	
	/**
	 * Constructor for the Semester object
	 */
	Semester()
	{
		this.id = -1;
		this.name = "";
		this.year = -1;
	}
	
	Semester(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	//Getters
	
	/**
	 * Gets the Semester ID
	 * @return: Integer id value of the Semester
	 */
	public int GetId()
	{
		return this.id;
	}
	
	/**
	 * Gets the Semester name
	 * @return: Name of the semester (Fall, Spring, Summer)
	 */
	public String GetName()
	{
		return this.name;
	}
	
	/**
	 * Gets the Semester year
	 * @return: Integer year value of the semester
	 */
	public int GetYear()
	{
		return this.year;
	}
	
	//End Getters
	
	
	// Setters
	
	/**
	 * Sets the Semester ID
	 * 
	 * @param id: The integer ID to use for the Semester ID
	 */
	public void SetId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sets the Semester name
	 * @param name: Name to use for the Semester name
	 */
	public void SetName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the Semester year
	 * @param year: Integer year value to use for the Semester
	 */
	public void SetYear(int year)
	{
		this.year = year;
	}
	
	//End Setters
}
