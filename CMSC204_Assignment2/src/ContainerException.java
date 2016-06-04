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

/**ContainerException
 * If the user attempts to add new Donation Package and the Container line is full (5 packages).
 * @author Surtej
 *
 */
public class ContainerException extends Exception {
	/**ContainerException default no arg constructor
	 */
	public ContainerException(){
	}
	/**ContainerException parameterized constructor
	 * If the user attempts to add new Donation Package and the Container line is full (5 packages).
	 * 
	 * @param message
	 */
	public ContainerException(String message){
		//ContainerException error message
		super(message);
	}
}
