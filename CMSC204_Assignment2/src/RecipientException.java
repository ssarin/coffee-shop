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

/**RecipientException
 * If the user attempts to add new Recipient and the recipient line is full (5 recipients).
 * 
 * @author Surtej
 *
 */
public class RecipientException extends Exception{
	/**RecipientException default no arg constructor
	 */
	public RecipientException(){

	}
	/**RecipientException parameterized constructor
	 * If the user attempts to add new Recipient and the recipient line is full (5 recipients).
	 * 
	 * @param message
	 */
	public RecipientException(String message){
		//RecipientException error message
		super(message);
	}
}
