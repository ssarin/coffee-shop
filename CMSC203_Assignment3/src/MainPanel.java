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

import java.awt.Color; /** Header allows access to Color class */
import java.awt.Dimension;/** Header allows access to Dimension class */
import java.awt.BorderLayout;/** Header allows access to BorderLayout class */
import java.awt.FlowLayout;/** Header allows access to FlowLayout class */

import javax.swing.BorderFactory;/** Header allows access to BorderFactory class */
import javax.swing.border.Border;/** Header allows access to Border class */

import java.awt.event.ActionEvent;/** Header allows access to ActionEvent class */
import java.awt.event.ActionListener;/** Header allows access to ActionListener class */

import javax.swing.BoxLayout;/** Header allows access to BoxLayout class */
import javax.swing.ButtonGroup;/** Header allows access to ButtonGroup class */
import javax.swing.JButton;/** Header allows access to JButton class */
import javax.swing.JRadioButton;/** Header allows access to JRadioButton class */
import javax.swing.JCheckBox;/** Header allows access to JCheckBox class */
import javax.swing.JPanel;/** Header allows access to JPanel class */
import javax.swing.JLabel;/** Header allows access to JLabel class */
import javax.swing.JTextField;/** Header allows access to JTextField class */
import javax.swing.JOptionPane;/** Header allows access to JOptionPane class */

/**
 * This is the MainPanel class.  
 * 
 * This class is a GUI driver, and in it I used java creating a frame, panel, doing event programming,
 * using Radio Buttons, Buttons, Check Boxes, Textfields, Labels, and JOptionPane.
 * It has five panels if size, condiments, ordertotal and action buttons. 
 * It has buttons for placing order, printing receipt and exiting the program.
 * It prints in curency form.
 * It then displays a receipt of the order using JOptionPane.
 * It displays the subtotal, tax and total due.
 * 
 * @author Surtej Sarin
 *
 */

public class MainPanel extends JPanel
{
		// Panels for header, condiments, burgers, button and order total	
	private static JPanel headerPanel, condimentsPanel, burgerPanel, buttonPanel, orderTotalPanel; 		
		// Label for subtotal, tax, and total due
	private JLabel subtotalLabel, taxLabel, totalDueLabel; 						
		// Text field for subtotal, tax, and total due
	private JTextField subtotalText, taxText, totalDueText; 
		// Radio button for burger choices: hamburger, cheeseburger and double cheeseburger
	private JRadioButton hamburgerButton, cheeseburgerButton, doubleCheeseburgerButton; 					
		// Check box for 5 condiment choices
	private JCheckBox lettuceCheckBox, tomatoCheckBox, onionCheckBox, mayonnaiseCheckBox, mustardCheckBox; 	
		// JButtons for placing order, printing receipt and exiting
	private JButton placeOrderButton, printReceiptButton, exitButton; 										
		// Initializing the 5 condiments to double 0.0
	private double burgerCost = 0.0, condimentCost = 0.0, subtotal = 0.0, tax = 0.0, totalDue = 0.0; 
		// Burger choice and receipt hold String value
	private String burgerChoice = "", receiptText = ""; 		
		// Create blackline border
	private Border blackline = BorderFactory.createLineBorder(Color.black);
		// Create empty border
	private Border empty = BorderFactory.createEmptyBorder();
	 
	
		// Creates the method instance of class BurgerOrder
	BurgerOrder burgerOrder = new BurgerOrder();

	/**
	 * The MainPanel constructor sets up the entire GUI in this template. 
	 * 
	 * @author Surtej Sarin
	 */
	
	public MainPanel()
	{
		
			// Sets the dimensions of the Panel
		setPreferredSize(new Dimension(450,350));
		
		
			// Using JButton class------
			// Creates the placeOrderButton
	    placeOrderButton = new JButton("Place Order");
	    placeOrderButton.addActionListener(new ButtonListener());
	    
	    	// Creates the printReceiptButton
	    printReceiptButton = new JButton("Print Receipt");
	    printReceiptButton.addActionListener(new ButtonListener());
	    
	    	// Creates the exitButton
	    exitButton = new JButton("Exit");
	    exitButton.addActionListener(new ButtonListener());
	    
	    
	    	// Using JTextField and JLabel class------
	    	// Creates an subtotalText JTextField and subtotalLabel JLabel
	    subtotalLabel = new JLabel("Subtotal: ");
	    subtotalText = new JTextField(8);
	    subtotalText.setEditable(false);
	    
	    	// Creates an taxText JTextField and taxLabel JLabel
	    taxText = new JTextField(8);
	    taxText.setEditable(false);
	    taxLabel = new JLabel("Tax(7.85%): ");
	    
	    	// Creates an totalDueText JTextField and totalDueText JLabel
	    totalDueText = new JTextField(8);
	    totalDueText.setEditable(false);
	    totalDueLabel = new JLabel("Total Due: ");
	   
	    
	    	// Using JRadioButton class-----
	    	// Creates radio button instances for hamburger, cheeseburger and double cheeseburger
	    hamburgerButton = new JRadioButton("Hamburger - $4.95");
	    cheeseburgerButton = new JRadioButton("Cheeseburger - $5.95");
	    doubleCheeseburgerButton = new JRadioButton("Double Cheeseburger - $6.95");
	    
	    	// Creates a group to make the three radio buttons mutually exclusive
	    ButtonGroup radioButtonGroup = new ButtonGroup();
	    radioButtonGroup.add(hamburgerButton);
	    radioButtonGroup.add(cheeseburgerButton);
	    radioButtonGroup.add(doubleCheeseburgerButton);
	    
			// Creates method instance of class RadioButtonListener
	    RadioButtonListener radioButtonListener = new RadioButtonListener();
	    
	    	// Adds the action listener to the three radioButtons
	    hamburgerButton.addActionListener(radioButtonListener);
	    cheeseburgerButton.addActionListener(radioButtonListener);
	    doubleCheeseburgerButton.addActionListener(radioButtonListener);
	    
	    	// Selects hamburger radio button
	    hamburgerButton.setSelected(true);
	    	// Initializes selection of hamburger radio button to $4.95
	  	burgerCost = 4.95;
	  		// Assigns "Hamburger" to burgerChoice variable
	  	burgerChoice = "Hamburger";
	    
	  	
	  		// Using JCheckBox class----
	  		// Creates check box instances for lettuce, tomato, onion, mayonnaise and mustard condiments
	    lettuceCheckBox = new JCheckBox("Lettuce");
	    tomatoCheckBox = new JCheckBox("Tomatoes");
	    onionCheckBox = new JCheckBox("Onion");
		mayonnaiseCheckBox = new JCheckBox("Mayonnaise");
	    mustardCheckBox = new JCheckBox("Mustard");
	    
	    
	    
	    	// Using JPanel, BorderLayout, BorderFactory, BoxLayout, FlowLayout and Dimensions classes----
	    
	    	// Creates the headerPanel instance
	    headerPanel = new JPanel();
	    	// Sets dimensions of headerPanel
	    headerPanel.setPreferredSize(new Dimension(450,60));
	    	// Creates headerPanel empty border and title
		headerPanel.setBorder(BorderFactory.createTitledBorder(empty, "Welcome to Hamburger Hamlet"));
			// Adds headerPanel to North border justification
	    add(headerPanel, BorderLayout.NORTH);
	    
	    
	    	// Creates the burgerPanel instance
	    burgerPanel = new JPanel();
	    	// Sets dimensions of burgerPanel
	    burgerPanel.setPreferredSize(new Dimension(200,110));
	    	// Creates burgerPanel black border and title
	    burgerPanel.setBorder(BorderFactory.createTitledBorder(blackline, " Select Size "));
	    
	    	// Adds the radio buttons to the burgerPanel
	    burgerPanel.add(hamburgerButton);
	    burgerPanel.add(cheeseburgerButton);
	    burgerPanel.add(doubleCheeseburgerButton);
	    	// Sets box layout of burgerPanel
	    burgerPanel.setLayout(new BoxLayout (burgerPanel, BoxLayout.Y_AXIS));
	    	// Adds burgerPanel to West border justification
	    add(burgerPanel, BorderLayout.WEST);

	    
	    	// Creates the condimentsPanel instance
	    condimentsPanel = new JPanel();
	    	// Sets dimensions of condimentsPanel
	    condimentsPanel.setPreferredSize(new Dimension(180,110));
	    	// Creates condimentsPanel black border and title
	    condimentsPanel.setBorder(BorderFactory.createTitledBorder(blackline, " Condiments($.25/each)"));
	  
	    	// Adds the check boxes to the condimentsPanel
	    condimentsPanel.add(lettuceCheckBox);
	    condimentsPanel.add(tomatoCheckBox);
	    condimentsPanel.add(onionCheckBox);
	    condimentsPanel.add(mayonnaiseCheckBox);
	    condimentsPanel.add(mustardCheckBox);
	    	// Sets box layout of condimentsPanel
	    condimentsPanel.setLayout(new FlowLayout (FlowLayout.LEFT));
	    	// Adds condimentsPanel to East border justification
	    add(condimentsPanel, BorderLayout.EAST);
		   
	    
	    	// Creates the orderTotalPanel instance
	    orderTotalPanel = new JPanel();
	    	// Sets dimensions of orderTotalPanel
	    orderTotalPanel.setPreferredSize(new Dimension(180,110));
	    	// Creates orderTotalPanel black border and title
	    orderTotalPanel.setBorder(BorderFactory.createTitledBorder(blackline, " Order Total "));
	    
	    	// Adds the JLabel and Text Field of subtotal to the orderTotalPanel
	    orderTotalPanel.add(subtotalLabel);
	    orderTotalPanel.add(subtotalText);
	    	// Adds the JLabel and Text Field of tax to the orderTotalPanel
	    orderTotalPanel.add(taxLabel);
	    orderTotalPanel.add(taxText);
	    	// Adds the JLabel and Text Field of total due to the orderTotalPanel
	    orderTotalPanel.add(totalDueLabel);
	    orderTotalPanel.add(totalDueText);
	    	// Adds orderTotalPanel to South border justification
	    add(orderTotalPanel, BorderLayout.SOUTH);
	    
	  
	    	// Creates the buttonPanel instance
	  	buttonPanel = new JPanel();
	  		// Sets dimensions of buttonPanel
	  	buttonPanel.setPreferredSize(new Dimension(160,100));
	    
	  		// Adds the three buttons to the buttonPanel
	    buttonPanel.add(placeOrderButton);
	    buttonPanel.add(printReceiptButton);
	    buttonPanel.add(exitButton);
	    	// Adds buttonPanel to South border justification
	    add(buttonPanel, BorderLayout.SOUTH);
	    
	}
	
	
		/**
		 * RadioButtonListener class method.
		 * It checks if hamburger, cheeseburger or double cheese burger are clicked.
		 * It assigns price to burgerCost
		 * It assigns the burger name to burgerChoice
		 * 
		 * @author Surtej Sarin
		 */
	
	private class RadioButtonListener implements ActionListener
	{
		/**
		 * When a radio button is selected, the actionPerformed method is called.  Determine
		 * which radio button was selected using e.getSource()
		 * @author Surtej Sarin
		 *
		 */
		public void actionPerformed(ActionEvent e)
		{			
			Object source = e.getSource();
			
				// Checks if source is hamburgerButton
			if (source == hamburgerButton)
			{
					// assigns 4.95 to burgerCost
				burgerCost = 4.95;
					// assigns "Hamburger" to burgerChoice
				burgerChoice = "Hamburger";
			}
			
				// Otherwise checks if source is cheeseburgerButton
			else if(source == cheeseburgerButton)
			{
					// assigns 5.95 to burgerCost
				burgerCost = 5.95;
					// assigns "Cheeseburger" to burgerChoice
				burgerChoice = "Cheeseburger";
			}
			
				// Otherwise checks if source is doubleCheeseburgerButton
			else if(source == doubleCheeseburgerButton)
			{
					// assigns 6.95 to burgerCost
				burgerCost = 6.95;
					// assigns "Double Cheeseburger" to burgerChoice
				burgerChoice = "Double Cheeseburger";
			}
		}
	}
	
	
		/**
		 * ButtonListener class method.
		 * It checkes if place order, print receipt or exit button are pressed.
		 * In place order button if check, it increments the condimentCost
		 * and calls the methods from BurgerOrder Class for the subtotal, tax and total due.
		 * It gets back the calculated value and displays to screen.
		 * In the print receipt button it sends burger Cost to method and retrieves back the receipt,
		 *  and prints this to the screen.
		 * In the exit button, it terminates the program.
		 * 
		 * @author Surtej Sarin
		 */
		
	private class ButtonListener implements ActionListener
	{
		/**
		 * When a button is selected, the actionPerformed method is called.  Determine
		 * which button was selected using e.getSource()
		 * @author Surtej Sarin
		 *
		 */
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			
				// Checks if source is placeOrderButton
			if (source == placeOrderButton)
			{
				
					// Checks which condiment is selected
					// Increments condimentCost by .25
				if (lettuceCheckBox.isSelected())
					condimentCost += .25;
				if(tomatoCheckBox.isSelected())
					condimentCost += .25;
				if(onionCheckBox.isSelected())
					condimentCost += .25;
				if(mayonnaiseCheckBox.isSelected())
					condimentCost += .25;
				if(mustardCheckBox.isSelected())
					condimentCost += .25;
				
					// Calls setOrderPrice method from burgerOrder class
					// Passes parameters burgerCost and condimentCost
				burgerOrder.setOrderPrice(burgerCost, condimentCost);	
				
					// Initializes and resets condimentCost to 0.0
				condimentCost = 0.0;
				
				
					// Calls getSubtotal method from burgerOrder class
					// Assigns the value to subtotal
				subtotal = burgerOrder.getSubtotal();
					// Sets subtotal to subtotalText 
				subtotalText.setText(Double.toString(subtotal));
				
					// Calls getTax method from burgerOrder class
					// Assigns the value to tax
				tax = burgerOrder.getTax();
					// Sets tax to taxText 	
				taxText.setText(Double.toString(tax));	
				
					// Calls getTotalDue method from burgerOrder class
					// Assigns the value to totalDue
				totalDue = burgerOrder.getTotalDue();
					// Sets totalDue to totalDueText 
				totalDueText.setText(Double.toString(totalDue));	
				
			}
					
				// Otherwise checks if source is printReceiptButton
			else if (source == printReceiptButton)
			{	
					// Calls setReceiptText method from burgerOrder class
				burgerOrder.setReceiptText(burgerChoice);
					// Assigns the value to receiptText
				receiptText = burgerOrder.getReceiptText();
					// Prints receiptText to display screen
				JOptionPane.showMessageDialog(null, receiptText);
			}
			
				// Otherwise checks if source is exitButton
			else if (source == exitButton)
			{
					// exits the program
				System.exit(0);
			}
			
		}
	}
}