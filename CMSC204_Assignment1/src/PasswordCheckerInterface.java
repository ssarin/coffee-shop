/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

import java.util.ArrayList;

/**PasswordCheckerInterface
 * 
 * @author Surtej
 *
 */
public interface PasswordCheckerInterface {

	/**isValidPassword
	 * interface that checks the rules or exceptions of passwords
	 * It has the parameter of password and throws the exceptions
	 * It returns true if the password is valid
	 * Performs checks on the string to detect any of the exceptions
	 * 
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 */
	public boolean isValidPassword (String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException;

	/**validPasswords
	 * interface that checks the rules or exceptions of a list of passwords
	 * It has the parameter of a list of password
	 * Loops through the list and calls the method isValidPassword, passing each element of the arraylist
	 * Returns an arraylist containing the invalid passwords and their error message
	 * 
	 * @param passwords
	 * @return
	 */
	public ArrayList<String> validPasswords (ArrayList<String> passwords);

}