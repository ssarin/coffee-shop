/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**NoUpperAlphaException
 * checks the string to see if there is no uppercase
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class NoUpperAlphaException extends Exception{
	/**NoUpperAlphaException default no arg constructor
	 */
	public NoUpperAlphaException(){

	}
	/**NoUpperAlphaException parameterized constructor
	 * @param message
	 */
	public NoUpperAlphaException(String message){
		//no upper alpha exception error message
		super(message);
	}
}

