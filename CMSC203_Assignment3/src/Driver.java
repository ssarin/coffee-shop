/** 
 * This program is a menu program for Hamburger Hamlet.
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

import java.awt.Container; /** Header allows access to Container class **/
import java.io.IOException; /** Header allows access to IOException class **/
import javax.swing.JFrame; /** Header allows access to JFrame class **/
import javax.swing.JPanel; /** Header allows access to JPanel class **/


	/**
	 * This is the Driver class.
	 * Its function is to provide the template for the GUI program.
	 * And also to add MainPanel to JFrame
	 * 
	 * @author Surtej Sarin
	 *
 */
public class Driver extends JFrame {
	JPanel MainPanel;

	/**
	 * Driver() is a constructor for the Driver GUI class.  
	 * Its function is to call the MainPanel constructor 
	 * and it adds MainPanel to the JFrame's content pane
	 * 
	 * @author Surtej Sarin
	 */
	public Driver() {
			//sets the title of the console
		setTitle("Hamburger Hamlet Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// Creates the method instance of class Container
		Container contentPane = getContentPane();
			// Creates the method instance of class MainPanel
		MainPanel = new MainPanel();
			//Adds ainPanel to the JFrame's content pane
	    contentPane.add(MainPanel);
	}
	
	/**
	 * The main method for the program
	 * @param args not used
	 * @throws IOException
	 * 
	 * @author Surtej Sarin
	 */
	public static void main(String[] args) throws IOException{
	      JFrame frame = new Driver();
	      frame.pack();
	      frame.setVisible(true);
	}

}