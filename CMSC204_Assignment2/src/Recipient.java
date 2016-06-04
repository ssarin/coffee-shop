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

/**Recipient
 * Holds the information of the recipients: name
 * 
 * @author Surtej
 *
 */
public class Recipient {
	String recipient = "";

	/**Recipient
	 * Holds the information of the recipients: name
	 * @param r
	 */
	public Recipient (String r) {
		recipient = r;
	}
	/**getRecipient
	 * gets the Recipient name
	 * @return recipient
	 */
	public String getRecipient(){
		return recipient;
	}
	/**setRecipient
	 * sets the Recipient name
	 * @param r
	 */
	public void setRecipient(String r){
		recipient = r;
	}
	/**toString
	 * returns the Recipient name
	 */
	public String toString(){
		return "Recipient: " + recipient;
	}
}
