/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**PasswordChecker
 * This class is used to check if the password is valid
 * If it is invalid the proper exception will be thrown in the conditional statements
 * @author Surtej
 *
 */
public class PasswordChecker implements PasswordCheckerInterface{

	@Override
	public boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
	NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException {

		//check if string contains at least 8 characters
		boolean eightCharacters = passwordString.length() >= 8;
		//counter for uppercase alpha characters
		int charUpperCounter = 0;
		//counter for lowercase alpha characters
		int charLowerCounter = 0;

		//loop through passwordString and iterates char values
		for(int i=0; i<passwordString.length(); i++){
			char c = passwordString.charAt(i);
			if(Character.isUpperCase(c) == true){
				charUpperCounter++;
			}
			if(Character.isLowerCase(c) == true){
				charLowerCounter++;
			}
		}

		//check if there are less than eight characters
		if(!eightCharacters) {
			throw new LengthException("The password must be at least 8 characters long.");
		}
		//check if there are no digits
		if(!(passwordString.matches(".*\\d.*"))){
			throw new NoDigitException("The password must contain at least one digit.");
		}

		//counter for letters in a string
		int digitCounter =0;
		//loop through passwordString and iterates digits
		for(int i=0; i<passwordString.length(); i++){
			char c = passwordString.charAt(i);
			if(Character.isDigit(c) == true){
				digitCounter++;
			}
		}

		//check if there are no lower case characters or if the string is all digits
		if(charLowerCounter == 0 || digitCounter == passwordString.length()){
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character.");
		}
		//check if there are no upper case characters
		if(charUpperCounter == 0){
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character.");
		}
		//check if more than two of the same character in sequence
		//loop through passwordString and check character sequences
		for(int i=0; i<passwordString.length()-2; i++){

			if((passwordString.charAt(i) == passwordString.charAt(i+1))
					&& (passwordString.charAt(i+1) == passwordString.charAt(i+2))){
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
			}
		}

		//return true if the password is valid
		return true;
	}

	@Override
	public ArrayList<String> validPasswords(ArrayList<String> passwords) {

		//arralist of invalid or illegal passwords
		ArrayList <String> illegalPasswords = new ArrayList <String>();

		//loop through passwordString
		for(int i=0; i<passwords.size(); i++){

			String passwordIndex = passwords.get(i);

			//check if password at the index is valid by calling isValidPassword
			try {
				isValidPassword(passwordIndex);

			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException e) {
				illegalPasswords.add(passwordIndex + " " + e.getMessage());
				e.printStackTrace();
			}
		}

		return illegalPasswords;
	}
}
