
/** 
 * This program is a Driver’s License exam program for a Local Driver’s License Office.


 * It uses concepts such as Arrays, ArrayLists, 
 * Create a Data Element/Worker class Instance variables and Getters and setters
 * Create a Data Manager class, Methods to access the data	
 * Create a GUI driver class, with Frame, Panel, Event programming, Textfields, Labels, Buttons, JOptionPane. showMessageDialog
 * Read from a file
 * 
 * @author Surtej Sarin    Date: 3/22/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */


/** 
 * StudentExam class:
 * 
 * Uses getter and setter methods to set and get both the driver name and array of test answers
 * 
 * 
 *  @author Surtej Sarin
 *
 */


public class StudentExam {
	
	//string variable of student name
	String name2 = ""; 
	//char array of student test answers
	char[] driverTestAns2 = new char [20]; 
	
	
	/**
	 * setStudentName method sets the students name1 to equal to name2 string
	 * 
	 * @param name1
	 *  @author Surtej Sarin
	 */
	public void setStudentName(String name1)
	{
		name2 = name1;
	}
	/**
	 * getStudentName method returns the name2 string
	 * 
	 * @return name2
	 *  @author Surtej Sarin
	 */
	public String getStudentName()
	{
		return name2;
	}
	/**
	 * setStudentAns method assigns contents of array driverTestAns1 to driverTestAns2
	 * 
	 * @param driverTestAns
	 *  @author Surtej Sarin
	 */
	public void setStudentAns(char[] driverTestAns1)
	{
		for (int index = 0; index < driverTestAns1.length; index ++)
		{	
			driverTestAns2[index] = driverTestAns1[index];
		}
	}
	/**
	 * getStudentAns method returns driverTestAns2 array
	 * 
	 * @return driverTestAns2
	 *  @author Surtej Sarin
	 */
	public char[] getStudentAns()
	{
		return driverTestAns2;
	}
}
