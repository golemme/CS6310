package main;

import java.util.ArrayList;

/**
 * Professor class. Inherits from the Person class.
 * @author Mark Arita
 *
 */
public class Professor extends Person
{
	ArrayList<CompetencyLookUp> competencies; 	//List of course competencies for the Professor
	
	/**
	 * Professor constructor (uses Parent, Person, class)
	 */
	Professor()
	{
		super();
		competencies = new ArrayList<CompetencyLookUp>();
	}
	
	// Getters
	
	/**
	 * Gets all competency values
	 * @return
	 */
	public ArrayList<CompetencyLookUp> GetCompetencyLookUp()
	{
		return this.competencies;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Adds the specified competency to the CompetencyLookUp for the professor
	 * @param competency: CompetencyLookUp object to add
	 */
	public void AddCompetency(CompetencyLookUp competency)
	{
		this.competencies.add(competency);
	}
	
	/**
	 * Removes the specified competency
	 * @param competency: Competency to remove
	 */
	public void RemoveCompetency(CompetencyLookUp competency)
	{
		if (this.competencies.contains(competency))
			this.competencies.remove(competency);
	}
	
	// End Setters
}
