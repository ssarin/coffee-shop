/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * 
 * @author	Surtej
 * 
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods of PasswordChecker
 * @author Professor Wisniewski
 *
 */
public class PasswordCheckerTest {
	ArrayList<String> passwords;
	String password1, password2;
	PasswordChecker passwordChecker;

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB", "Im2cool4U", "george2ZZZ", "4sale", "bertha22", "4wardMarch", 
				"august30", "abcdef", "Applesxx", "aa11b", "pilotProject", "myPassword", 
				"myPassword2"};
		passwordChecker = new PasswordChecker();
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
		/* ************* STUDENT  ***************
		   Create another Arraylist of String to
		   use for the testValidPasswordsSTUDENT test
		*/
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("abcABC12"));
			passwordChecker.isValidPassword("abc12");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("1234567aA"));
			passwordChecker.isValidPassword("1234567a");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("1234567Aa"));
			passwordChecker.isValidPassword("1234567A");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,passwordChecker.isValidPassword("1234aaAA"));
			passwordChecker.isValidPassword("1234aAAA");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * One test should throw a NoUpperAlphaException
	 * TO BE IMPLEMENTED BY STUDENT
	 */
	@Test
	public void testIsValidPasswordNoUpperSTUDENT()
	{
		try{
			assertTrue(passwordChecker.isValidPassword("1234567Aa"));
			passwordChecker.isValidPassword("1234567a");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * TO BE IMPLEMENTED BY STUDENT
	 */
	@Test
	public void testIsValidPasswordSuccessfulSTUDENT()
	{
		try {
			assertTrue(passwordChecker.isValidPassword("AaaBB123"));
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(passwordChecker.isValidPassword("1234567Aa"));
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = passwordChecker.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "334455BB");
		assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "george2ZZZ");
		assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "bertha22");
		assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "abcdef");
		assertEquals(scan.nextLine(), " The password must be at least 8 characters long.");
		scan = new Scanner(results.get(6)); //
		assertEquals(scan.next(), "Applesxx");
		assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
	
	/**
	 * Test the validPasswords method
	 * TO BE IMPLEMENTED BY STUDENT
	 * Additional tests with different data than testValidPasswords()
	 */
	@Test
	public void testValidPasswordsSTUDENT()
	{
		ArrayList<String> validPasswords = new ArrayList<String>();
		
		String[] p = {"AAbbCC123","112233aA","Surtej16","iijjkkL1","keyboardA1",
				"mrRobot1010","Skynet123",};
		
		validPasswords.addAll(Arrays.asList(p));
		
		
		for(int i=0; i<validPasswords.size(); i++){
			try {
				assertTrue(passwordChecker.isValidPassword(validPasswords.get(i)));
			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try {
			assertFalse(passwordChecker.isValidPassword("aabbccdd"));
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertFalse(passwordChecker.isValidPassword("aaaBB123"));
		} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
				| InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}