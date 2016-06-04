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

/**Volunteer
 * Holds the relevant information for a Volunteer:  name.
 * 
 * @author Surtej
 *
 */
public class Volunteer {

	String volunteer = "";

	/**Volunteer
	 * Holds the relevant information for a Volunteer:  name
	 * @param v
	 */
	public Volunteer (String v) {
		volunteer = v;
	}
	/**getVolunteer
	 * gets the Volunteer name
	 * @return volunteer
	 */
	public String getVolunteer(){
		return volunteer;
	}
	/**setVolunteer
	 * sets the Volunteer name
	 * @param v
	 */
	public void setVolunteer(String v){
		volunteer = v;
	}
	/**toString
	 * returns the Volunteer name
	 */
	public String toString(){
		return "Volunteer: " + volunteer;
	}
}
