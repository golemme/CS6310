package main;

/**
 * Person class. Represents a person (admin, student, professor, TA)
 * @author Mark Arita
 *
 */
public class Person 
{
	private int id;				//ID # of the person
	private String name;		//Name of the person
	private String password;	//Person's login password
	PersonType pType;			//Type of the person (student, TA, professor, admin)
	
	public enum PersonType
	{
		admin,
		professor,
		student,
		ta
	}
	 
	// Person constructor
	Person()
	{
		id = -1;
		name = "";
		password = "";
		pType = PersonType.student;
	}
	
	// Getters
	
	/**
	 * Returns the Person's id
	 * @return: Integer Id of the person
	 */
	public int GetId()
	{
		return this.id;
	}
	
	/**
	 * Returns the Person's name
	 * @return: String name of the person
	 */
	public String GetName()
	{
		return this.name;
	}
	
	/**
	 * Returns the Person's password
	 * @return: String password of the person
	 */
	public String GetPassword()
	{
		return this.password;
	}
	
	/**
	 * Returns the type of the Person
	 * @return: String type of the Person
	 */
	public PersonType GetPersonType()
	{
		return this.pType;
	}
	
	// End Getters
	
	
	
	// Setters
	/**
	 * Sets the Person's id
	 * @param: Integer Id of the person
	 */
	public void SetId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sets the Person's name
	 * @param: String name of the person
	 */
	public void SetName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the Person's password
	 * @return: String password of the person
	 */
	public void SetPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Sets the type of the Person
	 * @param: String type of the Person
	 */
	public void SetPersonType(PersonType pType)
	{
		this.pType = pType;
	}
	
	// End Setters
	
}
