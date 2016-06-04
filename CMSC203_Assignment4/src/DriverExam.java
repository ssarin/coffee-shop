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

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


/** 
 *  DriverExam class:
 * 
 * Uses getter and setter methods to set and get both the driver name and array of test answers
 * Contains instance variables of an array of char with the correct answers to the questions and a StudentExam object.
 * Uses Method passedTest , numQuestionsCorrect ,numQuestionsIncorrect, whichQuestionsMissed and report 
 * 
 *  @author Surtej Sarin
 *
 */

class DriverExam
{
	//char array correctTestAns is initialized to the correct char test answers
	private char[] correctTestAns = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
	//char array driverTestAns of student test anwsers
	private char[] driverTestAns;
	
	//creates StudentExam class object studentDriver
	StudentExam studentDriver = new StudentExam();

	/**
	 * Method DriverExam:
	 * passes char anwsers from driver to driverTestAns
	 * 
	 * @param answers
	 *  @author Surtej Sarin
	 */
	public DriverExam(char[] answers)
	{
		driverTestAns = answers;
	}
	 
	/**
	 *Method passedTest:
	 *returns true if the student passed the exam, or false if the student failed the exam
	 *
	 * @return true or false
	 *  @author Surtej Sarin
	 */
	public boolean passedTest()
	{
		int numCorrect=0;
		numCorrect = numQuestionsCorrect();
		
		if (numCorrect>= 15)
		{
			return true;
		}
		return false;
	}
	
	/**
	 *	Method numQuestionsCorrect:
	 *	returns the total number of correctly answered questions
	 *
	 * @return numCorrect
	 *  @author Surtej Sarin
	 */
	public int numQuestionsCorrect()
	{
		int numCorrect = 0;
		for (int index = 0; index < correctTestAns.length; index ++)
		{
			
			if (correctTestAns[index] == driverTestAns[index])
			{
				numCorrect++;
			}
		}
		return numCorrect;
	}
	
	/**
	 *	Method numQuestionsIncorrect:
	 *	returns the total number of incorrectly answered questions

	 * @return numIncorrect
	 *  @author Surtej Sarin
	 */
	public int numQuestionsIncorrect()
	{
		int numIncorrect = 0;
		
		for (int index = 0; index < correctTestAns.length; index ++)
		{
			
			if (correctTestAns[index] != driverTestAns[index])
			{
				numIncorrect++;
			}
		}
		return numIncorrect;
	}
	
	/**
	 *	Method whichQuestionsMissed:
	 *	returns an ArrayList<Integer> 
	 *	containing the question numbers of the questions that the student missed
	 * 
	 * @return missList
	 *  @author Surtej Sarin
	 */
	public int[] whichQuestionsMissed()
	{
		
		
		int numWrong = 0;
		numWrong=numQuestionsIncorrect();

		int [] missList = new int [20];// 20 should be numWrong

		for (int index = 0; index < correctTestAns.length; index ++)
		{
			if (driverTestAns[index] != correctTestAns[index])
			{
				missList[index] = (index + 1);
			}

		}
		
		return missList;	
 }
	
	/**
	 *	Method report:
	 *	pass in a student name and char[] of answers, returns a String with the exam report.  
	 *	Creates a StudentExam object.  
	 *	Creates and returns a string with a report.
	 *
	 * @param driverName
	 * @param driverTestAns
	 * @return strReport
	 *  @author Surtej Sarin
	 */

	public String report(String driverName, char[] driverTestAns)
	{
		//set student driver name method called
		studentDriver.setStudentName(driverName);
		//get student driver name method called
		String driverName1 = studentDriver.getStudentName();
		//set student ans method called
		studentDriver.setStudentAns(driverTestAns);
		//get student ans method called
		char[] driverTestAns1 = studentDriver.getStudentAns();
		
		//strreport string
		String strReport="";
		//pass or fail
		boolean passOrFail = false;
		//pass or fail string
		String strPassOrFail = "";
		//number correct or incorrect
		int correct = 0 , incorrect = 0;
		//number wrong return numQuestionsIncorrect
		int numWrong = numQuestionsIncorrect();	
		//assign numwrong
		int[] missed = new int [numWrong];
		//missed questions
		String missedQ = "";
		
		//return numQuestionsCorrect
		correct=numQuestionsCorrect();
		//return numQuestionsIncorrect
		incorrect=numQuestionsIncorrect();
		//return whichQuestionsMissed
		missed=whichQuestionsMissed();
		
		//check if missed is empty
		if(missed == null)
		{
			missedQ = "NONE";
		}
		else
		{
			missedQ = missed.toString();
		}
		
		//return passedTest 
		passOrFail=passedTest();
		
		//if true = passed else failed
		if(passOrFail == true)
		{
			strPassOrFail = "PASSED";
		}
		else
		{
			strPassOrFail = "FAILED";
		}

		//creates the strReport String
		strReport= driverName1 + " " + strPassOrFail + "\nCorrect: " + correct 
				+ " Incorrect: " + incorrect + " Question(s) Missed: " + missedQ;	
		
		return strReport;
	}
}

