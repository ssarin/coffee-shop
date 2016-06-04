/** This Ch12 program demonstrates using GUI 
 * 
 * @author Surtej Sarin    Date: 2/21/15	Professor: Ida Justh	Course/section: CMSC203/30963
 */

import javax.swing.*;    // Header for Swing classes
import java.awt.*;       // Header for Color class
import java.awt.event.*; // Header for Event listener class


/**
   The class ColorFactory implements GUI to set the background color 
   of a panel, foreground color, and uses options of buttons and radio buttons
   
   @author Surtej Sarin
*/

public class ColorFactory extends JFrame
{
   private JButton redButton;		// Change color to red
   private JButton OrangeButton;    // Change color to orange
   private JButton yellowButton;    // Change color to yellow
   private JLabel messageLabel;		// To display a message to screen
   private JRadioButton green;		// Change color to green
   private JRadioButton blue;		// Change color to blue
   private JRadioButton cyan;		// Change color to cyan
   private JPanel panel;            // First panel holds buttons
   private JPanel panel2;		    // Second panel holds messageLabel
   private JPanel panel3;		    // Third panel holds radio buttons
   private final int WINDOW_WIDTH = 500;	// Windows width
   private final int WINDOW_HEIGHT = 300;	// Windows height

   /**
      Constructor
   */

   public ColorFactory()
   {
      // Set the window title
      setTitle("Color Factory");

      // Set the size of the window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a label
      messageLabel = new JLabel("Top buttons change the pannel color and botton radio bottons change the text color");
      
      // Create the three buttons
      redButton = new JButton("Red");
      redButton.setBackground (Color.RED);
      OrangeButton = new JButton("Orange");
      OrangeButton.setBackground (Color.ORANGE);
      yellowButton = new JButton("Yellow");
      yellowButton.setBackground (Color.YELLOW);
      
      // Add action listener with 3 buttons
      redButton.addActionListener(new RedButtonListener());
      OrangeButton.addActionListener(new OrangeButtonListener());
      yellowButton.addActionListener(new YellowButtonListener());
      
      // Create the three radio-buttons
      green = new JRadioButton("green");
      green.setForeground(Color.GREEN);
      blue = new JRadioButton("blue");
      blue.setForeground (Color.BLUE);
      cyan = new JRadioButton("cyan");
      cyan.setForeground (Color.CYAN);
      
      // Add action listener with 3 radio buttons
      green.addActionListener(new GreenButtonListener());
      blue.addActionListener(new BlueButtonListener());
      cyan.addActionListener(new CyanButtonListener());
      
      //group the three radio buttons together
      ButtonGroup group = new ButtonGroup();
      group.add(green);
      group.add(blue);
      group.add(cyan);

      // Panel1 adds the three buttons component color options
      panel = new JPanel();
      panel.add(redButton);
      panel.add(OrangeButton);
      panel.add(yellowButton);
      panel.setBackground (Color.white);

      // Panel2 adds the messageLabel component
      panel2 = new JPanel();
      panel2.add(messageLabel);
      
      // Panel3 adds the three radio buttons component color options
      panel3 = new JPanel();
      panel3.add(green);
      panel3.add(blue);
      panel3.add(cyan);
      panel3.setBackground (Color.white);
      
      // This adds the three panels to the display pane
      add(panel, BorderLayout.NORTH);
      add(panel2, BorderLayout.CENTER);
      add(panel3, BorderLayout.SOUTH);

      // Displays the window to the screen
      setVisible(true);
   }

   /**
      Private class RedButtonListener 
      used when the user clicks the Red button.
   */

   private class RedButtonListener implements ActionListener
   {
	   /**
	      Action performed method executes when the user
	      clicks on the Calculate button
	      @param e the Event object
	   */
	   
      public void actionPerformed(ActionEvent e)
      {
         // Set background to red
         panel2.setBackground(Color.RED);
         
      }
   }

   /**
      Private class OrangeButtonListener
      used when the user clicks the Orange button.
   */

   private class OrangeButtonListener implements ActionListener
   {
	   /**
	      Action performed method executes when the user
	      clicks on the Calculate button
	      @param e the Event object
	   */
	   
      public void actionPerformed(ActionEvent e)
      {
         // Set background to orange
    	  panel2.setBackground(Color.ORANGE);
      }
   }

   /**
      Private class YellowButtonListener
      used when the user clicks the Yellow button.
   */

   private class YellowButtonListener implements ActionListener
   {
	   /**
	      Action performed method executes when the user
	      clicks on the Calculate button
	      @param e the Event object
	   */
      public void actionPerformed(ActionEvent e)
      {

         // Set background to yellow
    	  panel2.setBackground(Color.YELLOW);
      }
   }
   
   /**
   Private inner class that handles the event when
   the user clicks the Red button.
    */

	private class GreenButtonListener implements ActionListener
	{
		
		/**
	      Action performed method executes when the user
	      clicks on the Calculate button
	      @param e the Event object
	   */
	   public void actionPerformed(ActionEvent e)
	   {

	      // Set the foreground to green
		   messageLabel.setForeground(Color.GREEN);
	      
	   }
	}

	/**
	Private inner class that handles the event when
	the user clicks the Red button.
	*/
	
	private class BlueButtonListener implements ActionListener
	{
		/**
    	Action performed method executes when the user
    	clicks on the Calculate button
    	@param e the Event object
		 */
		public void actionPerformed(ActionEvent e)
		{
			// Set foreground to blue
			messageLabel.setForeground(Color.BLUE);
		}
	}
	
	/**
	Private inner class that handles the event when
	the user clicks the Red button.
	*/
	
	private class CyanButtonListener implements ActionListener
	{
		/**
	    Action performed method executes when the user
	    clicks on the Calculate button
	    @param e the Event object
		 */
		
		public void actionPerformed(ActionEvent e)
		{
			// Set foreground to cyan
			messageLabel.setForeground(Color.CYAN);
	   
		}
	}
	   
	/**
	   The main function
	*/
	   
	public static void main(String[] args)
	{
		new ColorFactory();
		//System.exit(0);
	}
	
}
