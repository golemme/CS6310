package main;

/**
 * LoginEvent class. Represents a Login Event from a Person object
 * @author Mark Arita
 *
 */
public class LoginEvent 
{
	private boolean success;	//Whether login was successful or not
	private TimeSlot time;		//To track the login time		
	
	/**
	 * LoginEvent constructor
	 */
	LoginEvent(boolean loginSuccessful)
	{
		success = loginSuccessful;
		time = new TimeSlot();
	}
	
	// Getters
	
	/**
	 * Gets value of whether login was successful or not
	 * @return: Boolean of whether login was successful or not
	 */
	public boolean GetLoginState()
	{
		return this.success;
	}
	
	/**
	 * Gets the TimeSlot
	 * @return: String value
	 */
	public TimeSlot GetTime()
	{
		return this.time;
	}
	
	// End Getters
	
	// Setters
	
	/**
	 * Sets the TimeSlot for the LoginEvent
	 * @param time: Time to assign for the TimeSlot
	 */
	public void SetTimeSlot(TimeSlot time)
	{
		this.time = time;
	}
	
	// End Setters
}
