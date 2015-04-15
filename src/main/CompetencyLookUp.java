package main;



/**
 * CompetencyLookUp class, to describe a teaching competence for a professor or TA
 * @author Mark Arita
 *
 */
public class CompetencyLookUp 
{
	private int id; 		//Course ID competence identifier
	
	/**
	 * CompetencyLookUp constructor
	 */
	CompetencyLookUp()
	{
		id = -1;
	}

	// Getters
	
	/**
	 * Gets the id associated with a course competence
	 * @return
	 */
	public int GetId()
	{
		return this.id;
	}
	
	// End Getters
	
	// Setters
	
	public void SetId(int id)
	{
		this.id = id;
	}
	
	// End Setters
	
}
