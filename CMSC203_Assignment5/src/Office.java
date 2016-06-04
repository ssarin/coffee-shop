/** 
 * This program is a program for Hickory Hollow Elementary School. 
 * It is a GUI-driven program that enters room officers and their offices, to print a report, and to save that report to a file.
 * It utilizes key java methods on Dependency and Aggregation, JLabel, Enumerated types, Arraylists and Writing to a file
 * 
 * @author Surtej Sarin    Date: 04/08/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */

//import javax.swing.JOptionPane;

/**
 * Enumerated Class - Office
 * Creates an enumerated type called Office.
 * The values will be PRESIDENT, SECRETARY, TREASURER, REPRESENTATIVE.  
 * It has an instance variable of type String to hold the valid value.  
 * It has a constructor and a toString method.
 * 
 * @author Surtej
 *
 */

public enum Office {

		//office enum officers
		PRESIDENT ("president"),
		SECRETARY ("secretary"),
		TREASURER ("treasurer"),
		REPRESENTATIVE("representative");
		
		//String name variable
		private String name;  
		
		//Office name1; 
		
		/**
		 * Constructor, constructor can have either private access modifier or nothing
		 * @author Surtej
		 */
		Office (String name1)
		{
			this.name = name1;
		}

		/*
		public void setName(String name1)
		{
			this.name = name1;
			//JOptionPane.showMessageDialog(null, name);

		}*/
		
		/**getName class office
		 * @author Surtej
		 * @return
		 */
		public String getName()
		{
			//JOptionPane.showMessageDialog(null, name);

			return this.name;
			
		}
		
		/**
		 *  Override toString method
		 *  @author Surtej
		 */
		public String toString()
		{
			return (this.name);
		}
	}