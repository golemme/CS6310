package main;

import java.util.Date;

/**
 * Professor class. Represents a slot of time associated with a Schedule
 * @author Mark Arita
 *
 */
public class TimeSlot 
{
	private Date start; 		//TimeSlot start time
	private Date end;			//TimeSlot end time
	
	/**
	 * TimeSlot constructor
	 */
	TimeSlot()
	{
		start = null;
		end = null;
	}
	
	// Getters
	
	/**
	 * Gets the start time for the TimeSlot
	 * @return: Date start time
	 */
	public Date GetStart()
	{
		return this.start;
	}
	
	/**
	 * Gets the end time for the TimeSlot
	 * @return: Date end time
	 */
	public Date GetEnd()
	{
		return this.end;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the start time for the TimeSlot
	 * @param start: Start Date
	 */
	public void SetStart(Date start)
	{
		this.start = start;
	}
	
	/**
	 * Sets the end time for the TimeSlot
	 * @param end: End Date
	 */
	public void SetEnd(Date end)
	{
		this.end = end;
	}
	
	// End Setters
}
