/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**InvalidSequenceException
 * checks the string for a sequence of more than two characters
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class InvalidSequenceException extends Exception{
	/**InvalidSequenceException default no arg constructor
	 */
	public InvalidSequenceException(){
	}
	/**InvalidSequenceException parameterized constructor
	 * @param message
	 */
	public InvalidSequenceException(String message){
		//invalid sequence exception error message
		super(message);
	}
}