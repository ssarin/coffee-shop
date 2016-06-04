import java.util.ArrayList;

import javax.swing.JOptionPane;

/** 
 * This program is a program for Hickory Hollow Elementary School. 
 * It is a GUI-driven program that enters room officers and their offices, to print a report, and to save that report to a file.
 * It utilizes key java methods on Dependency and Aggregation, JLabel, Enumerated types, Arraylists and Writing to a file
 * 
 * @author Surtej Sarin    Date: 04/08/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */

/**
 * Data Element – Officer class
 * Contains instance variables of type String for the first name and last name.  
 * And an instance variable of type Office for the office held.  
 * Also has a constructor and a toString method.
 * 
 * @author Surtej
 *
 */
public class Officer{

	//first name
	private String fName;
	//last name
	private String lName;
	//office instance
	private Office office;
	//officer instance
	private Officer officer;
	//office position
	private String officePos;

	/**
	 * Officer default constructor
	 * calls enum assigns to officePos
	 * 
	 * @param fName1
	 * @param lName2
	 * @param selectedJRadio
	 * @author Surtej
	 */
	public Officer(String fName1, String lName2, String selectedJRadio){

		//assign fName1 to fName
		this.fName = fName1;
		//assign lName1 to lName
		this.lName = lName2;
		
		//check if position  is president
		if (selectedJRadio == "president")
		{
			this.officePos = office.PRESIDENT.toString();
			//JOptionPane.showMessageDialog(null, selectedJRadio);
			//office.setName(selectedJRadio);
			//System.out.print(str);
		}
		//check if position  is secretary

		if (selectedJRadio == "secretary")
		{
			this.officePos = office.SECRETARY.toString();
			//office.setName(selectedJRadio);

		}
		
		//check if position is treasurer

		if (selectedJRadio == "treasurer")
		{
			this.officePos = office.TREASURER.toString();
			//office.setName(selectedJRadio);

		}
		
		//check if position is representative

		if (selectedJRadio == "representative")
		{
			this.officePos = office.REPRESENTATIVE.toString();
			//office.setName(selectedJRadio);
		}
	}
	
	/**
	 * Officer get office method
	 * @author Surtej
	 * @return
	 */
	public Officer getOfficer(){
		
		return officer;
	}
	
	/**
	 *  Override toString method
	 *  assigns firstname, lastname office position to str
	 *  @author Surtej
	 *  @return str
	 */
	public String toString(){
		String str = this.fName + " " + this.lName + " " + "Office:   " + officePos ;
		return str;
	}
}