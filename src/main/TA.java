package main;

import java.util.ArrayList;

/**
 * TA class. Inherits from the Person class, and represents a Teaching Assistant at a School
 * @author Mark Arita
 *
 */
public class TA extends Student
{
	ArrayList<CompetencyLookUp> competencies; 	//List of course competencies for the TA
	
	/**
	 * TA constructor (uses Parent, Person, class)
	 */
	TA()
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
	 * Adds the specified competency to the CompetencyLookUp for the TA
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
