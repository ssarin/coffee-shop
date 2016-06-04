/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

/**NoLowerAlphaException
 * checks the string to see if there is no lowercase
 * Passes error message to the super class exception
 * @author Surtej
 *
 */
public class NoLowerAlphaException extends Exception{
	/**NoLowerAlphaException default no arg constructor
	 */
	public NoLowerAlphaException(){

	}
	/**NoLowerAlphaException parameterized constructor
	 * @param message
	 */
	public NoLowerAlphaException(String message){
		//no lower alpha exception error message
		super(message);
	}
}