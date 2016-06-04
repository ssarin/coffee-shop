/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**LengthException
 * checks the string to see if the length is less than 8
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class LengthException extends Exception{
	/**LengthException default no arg constructor
	 */
	public LengthException(){

	}
	/**LengthException parameterized constructor
	 * @param message
	 */
	public LengthException(String message){
		//length exception error message
		super(message);
	}
}