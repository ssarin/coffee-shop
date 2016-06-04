/**Assignment 2
 * Office Depo is an office supply retailing company donates its surpluses to colleges at the end of each year.
 * In the program volunteers will help deliver packages of supplies to representative of colleges (Recipient of supplies).
 * This application simulates delivering packages from the container of packages by the volunteers to recipients.  
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/18/2016
 * 
 * @author	Surtej
 * 
 */

/**VolunteerException
 * If the user attempts to add new Volunteer and the volunteer line is full (5 volunteers).
 * 
 * @author Surtej
 *
 */
public class VolunteerException extends Exception{
	/**VolunteerException default no arg constructor
	 */
	public VolunteerException(){

	}
	/**VolunteerException parameterized constructor
	 * If the user attempts to add new Volunteer and the volunteer line is full (5 volunteers).
	 * 
	 * @param message
	 */
	public VolunteerException(String message){
		//VolunteerException error message
		super(message);
	}
}
