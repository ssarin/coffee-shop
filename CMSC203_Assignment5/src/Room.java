/** 
 * This program is a program for Hickory Hollow Elementary School. 
 * It is a GUI-driven program that enters room officers and their offices, to print a report, and to save that report to a file.
 * It utilizes key java methods on Dependency and Aggregation, JLabel, Enumerated types, Arraylists and Writing to a file
 * 
 * @author Surtej Sarin    Date: 04/08/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */
import java.util.ArrayList;
import java.lang.Object;

import javax.swing.JOptionPane;

/**
 * Data Manager – Room class
 * The room class conains an ArrayList of Officer Objects.
 * It has a static variable that keeps track of the number of rooms  added to the room total.  
 * It has  constructor and a method to addOfficer, a method to printRoom and a toString method.  
 * The addOfficer method check if there is 1 president, 1 secretary, 1 treasurer, and 2 representatives, and 5 officer members.  
 * And returns a String of the error or a null if the officer was added.   
 * 
 * @author Surtej
 *
 */

public class Room extends Object {

	//class Name
	private String className;
	//officer position
	private String position;
	//first name
	private String firstName;
	//last name
	private String lastName;
	//number classes
	private static int numClasses;
	//number of officers
	private int numOfficers;
	//number of presidents
	private int numPresidents;
	//number of numRepresentatives
	private int numRepresentatives;
	//number of numSecretaries
	private int numSecretaries;
	//number of numTreasurers
	private int numTreasurers;
	//String total
	String total="";
	//Arraylist string of Officer
	private ArrayList<String> Officers = new ArrayList<String>();

	/**
	 * default constructor room class
	 * @author Surtej
	 */
	public Room(){
		numClasses++;
		numOfficers = 0;
		numPresidents =0; 
		numSecretaries = 0; 
		numTreasurers = 0;
		numRepresentatives = 0;
		ArrayList<String> Officers = new ArrayList<String>();
		
	}
	/**
	 * constructor room class
	 * @author Surtej
	 */
	public Room(java.lang.String cn){
		
		numClasses++;
		numOfficers = 0;
		numPresidents =0; 
		numSecretaries = 0; 
		numTreasurers = 0;
		numRepresentatives = 0;
		ArrayList<String> Officers = new ArrayList<String>();

	}
	/**
	 * getNumClasses method return number of classes
	 * 
	 * @return numClasses
	 * @author Surtej
	 */
	public static int getNumClasses(){
		return numClasses;
	}
	/**
	 * getNumOfficers method returns number of officers
	 * 
	 * @return numOfficers
	 * @author Surtej
	 */
	public int getNumOfficers(){
		return numOfficers;
	}

	/**addOfficer class method
	 * Checks if there is only 1 president, 1 secretary, 1 treasurer, and 2 representatives at a time.
	 * Also if 5 members.  
	 * Returns a String indicating an error for instance “There is already a president from this room”) 
	 * or a null if the officer was added.   
	 * 
	 * @param fName
	 * @param lName
	 * @param pos
	 * @return
	 * @author Surtej
	 */
	public java.lang.String addOfficer(java.lang.String fName, java.lang.String lName, java.lang.String pos){

		//check if position  is president
		if (pos.equals("president"))
		{
			//counter number presidents
			numPresidents++;
			//counter number of officers
			numOfficers++;
			
			//checks if more the one president is added and displays error message
			//subtracts number of officers
			//returns a string value
			if(numPresidents>1){
				JOptionPane.showMessageDialog(null, "There is already a president in this class\nPerson not added", "Officer", JOptionPane.PLAIN_MESSAGE);
				
				numOfficers--;
				
				return "There is already a president in this school class\nPerson not added";
			}
		}
		
		//check if position  is secretary
		if (pos.equals("secretary"))
		{
			//counter number secretary
			numSecretaries ++; 
			//counter number of officers
			numOfficers++;
			
			//checks if more the one Secretaries is added and displays error message
			//subtracts number of officers
			//returns a string value
			if(numSecretaries>1){
				JOptionPane.showMessageDialog(null, "There is already a secretary in this class\nPerson not added", "Officer", JOptionPane.PLAIN_MESSAGE);
				numOfficers--;

				return "There is already a secretary in this school class\nPerson not added";
			}
		}
		//check if position is treasurer

		if (pos.equals("treasurer"))
		{
			//counter number treasurer
			numTreasurers++;
			//counter number of officers
			numOfficers++;
			
			//checks if more the one Treasurers is added and displays error message
			//subtracts number of officers
			//returns a string value
			if(numTreasurers>1){
				JOptionPane.showMessageDialog(null, "There is already a treasurer in this class\nPerson not added", "Officer", JOptionPane.PLAIN_MESSAGE);
				numOfficers--;

				return "There is already a treasurer in this class\nPerson not added";
			}
		}
		
		//check if position is representative
		if (pos.equals("representative"))
		{
			//counter number representative
			numRepresentatives++;
			//counter number of officers
			numOfficers++;
			
			//checks if more the two Representatives is added and displays error message
			//subtracts number of officers
			//returns a string value
			if(numRepresentatives>2){
				JOptionPane.showMessageDialog(null, "There are already 2 representatives in this class\nPerson not added", "Officer", JOptionPane.PLAIN_MESSAGE);
				numOfficers--;

				return "There are already 2 representatives in this class\nPerson not added";
			}
		}
		
		//check if numOfficers is greater than 5
		//displays error message
		//subtracts number of officers
		//returns a string value
		if(numOfficers>5){
				JOptionPane.showMessageDialog(null, "There are already 5 officers in this school class\nPerson not added", "Officer", JOptionPane.PLAIN_MESSAGE);
				numOfficers--;

				return "There are already 5 officers in this school class\nPerson not added";
		
		}
			
		//this area below is if the officer is allowed to be added-------
		
		//assigns first name to firstName variable
		firstName=fName;
		//assigns last name to lastName variable
		lastName=lName;
		//assigns position to pos variable
		position=pos;
				
		//returns null meaning officer can be added
		return null;
	}
	
	/**
	 * addStrOfficer method class
	 * assigns string toString method 
	 * Adds str to Officers array
	 * 
	 * @author Surtej
	 */
	public void addStrOfficer()
	{
		String str= toString();
		Officers.add(str + "\n");
	}
	
	/**
	 * printRoom method
	 * assign Officers array to str1 using toString method
	 * returns updated officer list string to driver class
	 * @author Surtej
	 * @return str1
	 */
	public java.lang.String printRoom()		
	{
		String str1 = Officers.toString();
		return str1;
		
	}
	/**
	 *  Override toString method
	 *  assigns firstname, lastname office position to str
	 *  @author Surtej
	 *  @return str
	 */
	public java.lang.String toString(){
		String str = this.firstName + " " + this.lastName + " " + "Office: " + position ;

		return str;
	}
}