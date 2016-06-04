/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**UnmatchedException
 * checks the string to see if it matches the re-type password
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class UnmatchedException extends Exception{
	/**UnmatchedException default no arg constructor
	 */
	public UnmatchedException(){

	}
	/**UnmatchedException parameterized constructor
	 * @param message
	 */
	public UnmatchedException(String message){
		//unmatched exception error message
		super(message);
	}
}

