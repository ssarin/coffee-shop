/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**NoDigitException
 * checks the string to see if there is no digit
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class NoDigitException extends Exception{
	/**NoDigitException default no arg constructor
	 */
	public NoDigitException(){

	}
	/**NoDigitException parameterized constructor
	 * @param message
	 */
	public NoDigitException(String message){
		//no digit exception error message
		super(message);
	}
}