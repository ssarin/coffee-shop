/** This program deals with painting and carpeting estimates using a driver class, DriverEstimate, and worker class, Estimate. 
 *  The point of the program is to determine total cost of a task.  
 *  In the program I use JOptionPane class get inputs from the user including: 
 *  which task, paint or carpet, square yards needed to be painted or carpeted (0 and 500), and price of gallon of paint or square yard of carpet.
 *  I perform input validations, use proper format of US currency, and use the Estimate class to perform calculations provided by the instructor.
 *  
 *	Name: Surtej Sarin	Date: 2/19/15	Professor: Ida Justh	Course/section: CMSC203/30963
 */


	/** To be able to read from the keyboard */
import java.util.Scanner;

/** Allows access to JOptionPane class */
import javax.swing.JOptionPane;


	/** DriverEstimate driver class:
	 *  This class is a driver class that utilizes the worker class, Estimate, to perform calculations and determine the total cost of task estimate.  
	 *  In the class I create a method e of Estimate worker class which I can use instances of the Estimate class in my DriverEstimate class.
	 * 	The DriverEstimate class utilizes the JOptionPane class to obtain inputs from the user on which task they would like to do, paint or carpet, 
	 * 	how many square yards they need to be painted or carpeted (0 and 500), and the price of a gallon of paint or square yard of carpet.
	 *  The class uses while loop as a method of input validation, uses decimal format to display total cost in US currency.
	 *  
	 *  @author Surtej Sarin
	 */
public class DriverEstimate {
	
	public static void main (String [] args){
		
			/** job user inputed variable (carpet, paint or etc.) */
		String job = "";
			/** task stored carpet, paint, or etc. to estimate worker class */
		String t = "";
			/** user inputed data to continue the program n is to quit */
		String again = "";
		/** square yards of carpet or paint String variable for JOptionPane */
		String yds = "";	
			/** cost of carpet or paint String variable for JOptionPane */
		String prc = "";	
			/** square yards of carpet or paint Double variable stored to estimate worker class */
		double yards = 0.0;	
			/** cost of carpet or paint Double variable stored to estimate worker class */
		double price = 0.0;	
			/** total estimated cost of task retrieved by estimate worker class */
		double cost = 0.0;	
		
			/** create a method e of Estimate worker class */
		Estimate e = new Estimate(); 

		
			/** do-while loop in which the   */
		do{
			
				/** prompts user to enter paint or carpet and stores into job variable */
			job = JOptionPane.showInputDialog("PAINT OR CARPET JOB ESTIMATOR\n"
					+ "Do you want to paint or carpet your room?");
			
				/** use setTask instance with variable job to method e from estimate worker class */
			e.setTask(job);
				/** use getTask instance to method e from estimate worker class to assign return value to variable t*/
			t = e.getTask();
			
				/** if statement checks if t equals paint */
			if(t.equals("paint"))
			{
					/** prompts user to enter square yards needed to be painted */
				yds = JOptionPane.showInputDialog("How many square yards need to be painted?");
					/** parses and assigns String yds to double yards */
				yards = Double.parseDouble(yds);
				
					/** while loop validates yards and checks if yards are out of bounds (less than 0 or greater than 500) */
				while(yards < 0 || yards > 500)
				{
						/** Gives error message that square yards must be between 0 and 500 */
					JOptionPane.showMessageDialog(null, "The square yards must be between 0 and 500");
						/** prompts user to enter square yards needed to be painted */
					yds = JOptionPane.showInputDialog("How many square yards need to be painted?");
						/** parses and assigns String yds to double yards */
					yards = Double.parseDouble(yds);
				}
				
					/** use setSize instance with variable yards to method e from estimate worker class */
				e.setSize(yards);
					/** use getTask instance to method e from estimate worker class to assign return value to variable yards */
				yards = e.getSize();
				
					/** prompts user to enter how much one gallon of paint costs and assigns to String prc variable */
				prc = JOptionPane.showInputDialog("How much does one gallon of paint cost?");
					/** parses and assigns String prc to double price */
				price = Double.parseDouble(prc);
				
					/** while loop validates price and checks if price is out of bounds (less than or equal to 0) */
				while(price <= 0)
				{
						/** Gives error message that one gallon of paint must be greater than $0.00 */
					JOptionPane.showMessageDialog(null, "The price of one gallon of paint must be greater than $0.00");
						/** prompts user to enter how much one gallon of paint costs and assigns to String prc variable */
					prc = JOptionPane.showInputDialog("How much does one gallon of paint cost?");
						/** parses and assigns String prc to double price */
					price = Double.parseDouble(prc);
				}
				
					/** use setCost instance with variable price to method e from estimate worker class */
				e.setCost(price);
					/** use getCost instance to method e from estimate worker class to assign return value to variable price*/
				price = e.getCost();
				
					/** use getTotal instance to method e from estimate worker class to assign return value to variable cost*/
				cost = e.getTotal(); // use t to refer any method of class 
								
					/** display the total estimated cost of task paint */
				JOptionPane.showMessageDialog(null, String.format("The total estimated cost is: $%.2f", cost));
			}
			
				/** else if statement checks if t equals carpet */
			else if(t.equals("carpet"))
			{
				
					/** prompts user to enter square yards needed to be carpeted */
				yds = JOptionPane.showInputDialog("How many square yards need to be carpeted?");
					/** parses and assigns String yds to double yards */
				yards = Double.parseDouble(yds);
				
					/** while loop validates yards and checks if yards are out of bounds (less than 0 or greater than 500) */
				while(yards < 0 || yards > 500)
				{
						/** Gives error message that square yards must be between 0 and 500 */
					JOptionPane.showMessageDialog(null, "The square yards must be between 0 and 500");
						/** prompts user to enter square yards needed to be painted */
					yds = JOptionPane.showInputDialog("How many square yards need to be carpeted?");
						/** parses and assigns String yds to double yards */
					yards = Double.parseDouble(yds);
				}
					/** use setSize instance with variable yards to method e from estimate worker class */
				e.setSize(yards);
					/** use getTask instance to method e from estimate worker class to assign return value to variable yards */
				yards = e.getSize();
				
					/** prompts user to enter how much one square yard of carpet cost and assigns to String prc variable */
				prc = JOptionPane.showInputDialog("How much does one square yard of carpet cost?");
					/** parses and assigns String prc to double price */
				price = Double.parseDouble(prc);
				
					/** while loop validates price and checks if price is out of bounds (less than or equal to 0) */
				while(price <= 0)
				{
					/** Gives error message that one square yard of carpet must be greater than $0.00 */
					JOptionPane.showMessageDialog(null, "The price of one square yard of carpet must be greater than $0.00");
						/** prompts user to enter how much one square yard of carpet cost and assigns to String prc variable */
					prc = JOptionPane.showInputDialog("How much does one square yard of carpet cost?");
						/** parses and assigns String prc to double price */
					price = Double.parseDouble(prc);
				}
				
				/** use setCost instance with variable price to method e from estimate worker class */
				e.setCost(price);
					/** use getCost instance to method e from estimate worker class to assign return value to variable price*/
				price = e.getCost();
				
					/** use getTotal instance to method e from estimate worker class to assign return value to variable cost*/
				cost = e.getTotal(); 
								
					/** display the total estimated cost of task carpet */					
				JOptionPane.showMessageDialog(null, String.format("The total estimated cost is: $%.2f", cost));
			}
			
				/** else statement when t equals anything except paint or carpet */
			else
			{
					/** error message that user did not enter paint or carpet */
				JOptionPane.showMessageDialog(null, "Error! I don't know that task");
			}
			
				/** ask user for another estimate and assigns user entry to again variable  */
			again = JOptionPane.showInputDialog("Do you want another estimate? (enter n to quit)");
			
			/** do-while loop ends when user enters n for the again variable to quit the program */
		}while(!again.equals("n")); 
		
			/** end of the program */
		System.exit(0);
	}
}
