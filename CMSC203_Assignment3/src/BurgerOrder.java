/** 
 * This program is a menu program for Hartatak Hamburger.
 * It implements multiple aspects of Java programming including;
 * creating a worker class, creating a GUI driver, a frame, panel, doing event programming,
 * using Radio Buttons, Buttons, Check Boxes, Textfields, Labels, and JOptionPane.
 * It has 5 panels if size, condiments, ordertotal and action buttons.
 * It gives the user the option to order something off the menu and also performs calculations. 
 * It then displays a receipt of the order.
 * 
 * @author Surtej Sarin    Date: 3/5/15		Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */

import java.text.DecimalFormat; /**Header allows access to the DecimalFormat class*/

	/**
	 * This is the BurgerOrder worker class.
	 * It uses instance variables, constants, named constants,
	 * methods get/set, uses a method to calculate the subtotal, tax and total price of the order,
	 * and a method to return a string that could be used to print a receipt.
	 * 
	 * @author Surtej Sarin
	 *
	 */

public class BurgerOrder
{
		//Initializes variables burgerC, condimentC, subtotal, tax, and totalDue to 0.0
	private double burgerC = 0.0, condimentC = 0.0, subtotal = 0.0, tax = 0.0, totalDue = 0.0;
		//Creates String receiptText variable and initializes to empty string
	private String receiptText = "";
	
		/**
		 * Method for calculating the order price called setOrderPrice
		 * In this method I assign burgerCost and condimentCost Parameters to variables burgerC and condimentC.
		 * Also here I calculate subtotal, tax and totalDue.
		 * I implement decimal format here also.
		 * 
		 * @param burgerCost
		 * @param condimentCost
		 */
	
	public void setOrderPrice(double burgerCost, double condimentCost)
	{
			//assigns burgerCost to burgerC
		burgerC = burgerCost;
			//assigns condimentCost to condimentC
		condimentC = condimentCost;
		
			//calculates subtotal by adding burgerCost and condimentCost
		subtotal = (burgerCost + condimentCost);
			//Uses DecimalFormat formatSubtotal to round subtotal to two decimal places
		DecimalFormat formatSubtotal = new DecimalFormat("#.##");
		subtotal = Double.valueOf(formatSubtotal.format(subtotal));

			//calculates tax by multiplying subtotal and (7.85/100)
		tax = (subtotal*(7.85/100));
			//Uses DecimalFormat formatTax to round tax to two decimal places
		DecimalFormat formatTax = new DecimalFormat("#.##");
		tax = Double.valueOf(formatTax.format(tax));
		
			//calculates totalDue by adding subtotal and tax
		totalDue = (subtotal + tax);
			//Uses DecimalFormat formatTotalDue to round totalDue to two decimal places
		DecimalFormat formatTotalDue = new DecimalFormat("#.##");
		totalDue = Double.valueOf(formatTotalDue.format(totalDue));
	}
	
		/**
		 * Method for returning subtotal called getSubtotal
		 * @return subtotal
		 */
	public double getSubtotal()
	{
			//returns updated subtotal variable
		return subtotal;
	}
	
		/**
		 * Method for returning tax called getTax
		 * @return tax
		 */
	public double getTax()
	{
			//returns updated tax variable
		return tax;
	}
	
		/**
		 * Method for returning totalDue called getTotalDue
		 * @return totalDue
		 */
	public double getTotalDue()
	{
			//returns updated totalDue variable
		return totalDue;
	}
	
	
	
		/**
		* Method for creating receipt called setReceiptText
		* In this method I create a String receiptText and assign burgerChoice parameter inside,
		* as well as the number of condiments used, the subtotal, tax and total amount due.
		* 
	 	* @param burgerChoice
	 	*/
	public void setReceiptText(String burgerChoice)
	{
			//creates String receiptText
		receiptText = "Welcome to Hamburger Hamlet\n\nYour Order\n\n" + burgerChoice + ":  $" + burgerC
						+ "\n" + (int)(condimentC/.25) + " Condiment(s):  $" + condimentC + "\n\n"
						+ "Subtotal:  $" + subtotal + "\nTax:  $" + tax + "\nTotal Due:  $" + totalDue;
	}
	
		/**
		 * Method for returning receipt called getReceiptText
		 * @return receiptText
		 */
	public String getReceiptText()
	{
			//returns updated receiptText variable
		return receiptText;
	}
}
