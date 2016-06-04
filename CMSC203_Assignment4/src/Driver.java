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

import java.awt.*;

import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import java.awt.Color; /** Header allows access to Color class */
import java.awt.BorderLayout;/** Header allows access to BorderLayout class */
import java.awt.FlowLayout;/** Header allows access to FlowLayout class */
import java.awt.event.ActionEvent;/** Header allows access to ActionEvent class */
import java.awt.event.ActionListener;/** Header allows access to ActionListener class */

import javax.swing.JButton;/** Header allows access to JButton class */
import javax.swing.JLabel;/** Header allows access to JLabel class */
import javax.swing.JTextField;/** Header allows access to JTextField class */
import javax.swing.JOptionPane;/** Header allows access to JOptionPane class */

import java.awt.event.*;


/** 
 *  Driver GUI class:
 * 
 * Provide labels and textboxes for the user to put in the student name and the answers to the 20 Driver’s License Exam
 * Implements the ActionListener to listen for the Grade button.
 * Validate grades entered.  If not ‘A’, ‘B’, ‘C’ or ‘D’, display an error message using a dialog box.  
 * When the Grade button is clicked, the Student name and the 20 grades are extracted from the textboxes and the report method (and only the report method) of the DriverExam class will be called. 
 * Display the Student’s name with the report in a dialog box.
 * When the Read File button is clicked, the Student name and the 20 grades are read from a file and then displayed in the appropriate textboxes.  
 * Use a JFileChooser to allow the user to select the file to read from.  The file will contain the student name on the first line and then the second line will have 20 answers (A, B, C or D) separated by a space.  
 * 
 * @author Surtej
 *
 */

public class Driver extends JFrame
{
	//JLabel definition for headerLabel, driverNameLabel, driverTestAnsLabel, and l1 
	private JLabel headerLabel= new JLabel(), driverNameLabel = new JLabel(), 
			driverTestAnsLabel = new JLabel(), l1 = new JLabel();
	//JTextField definition for driverNameText
	private JTextField driverNameText = new JTextField();
	//JTextField array definition for driverTestAnsText
	private JTextField[] driverTestAnsText = new JTextField[20];
	//char array definition for letterChoice
	char[] letterChoice = new char[20];
	//JPanel definition for headerPanel,buttonsPanel,drivernamePanel,driverTestAnsPanel, driverTestAnsLayout
	private JPanel headerPanel = new JPanel(), buttonsPanel = new JPanel(), 
			driverNamePanel = new JPanel(), driverTestAnsPanel = new JPanel(), 
			driverTestAnsLayout = new JPanel();
	//JButton definition for gradeOptionButton, readFileButton and exitOptionButton
	private JButton gradeOptionButton = new JButton(), readFileButton = new JButton(), 
			exitOptionButton = new JButton();


	/**
	 * The Driver constructor sets up the entire GUI in this template. 
	 *Provide labels and textboxes for the user to put in the student name and the answers to the 20 Driver’s License Exam
	 *Implements the ActionListener to listen for the Grade button.
	 *Validate grades entered.  If not ‘A’, ‘B’, ‘C’ or ‘D’, display an error message using a dialog box.  
	 *When the Grade button is clicked, the Student name and the 20 grades are extracted from the textboxes and the report method (and only the report method) of the DriverExam class will be called. 
	 *Display the Student’s name with the report in a dialog box.
	 *When the Read File button is clicked, the Student name and the 20 grades are read from a file and then displayed in the appropriate textboxes.  
	 *Use a JFileChooser to allow the user to select the file to read from.  The file will contain the student name on the first line and then the second line will have 20 answers (A, B, C or D) separated by a space.  
	 *
	 * @author Surtej Sarin
	 */
	
	public Driver()
	{
		// Sets the dimensions of the Panel
		setPreferredSize(new Dimension(400, 300));
		// Sets the title of the Panel
		setTitle("Driver's License Exam Grader");
		// Sets the default close operation of the Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//Use JButton Class tasks with action listener------
		
		//Creates gradeOptionButton
		gradeOptionButton = new JButton("Grade");
		gradeOptionButton.addActionListener(new ButtonListener());
		//Creates readFileButton
		readFileButton = new JButton("Read File");
		readFileButton.addActionListener(new ButtonListener());
		//Creates exitOptionButton
		exitOptionButton = new JButton("Exit");
		exitOptionButton.addActionListener(new ButtonListener());
		
		
		// Using JTextField and JLabel class------
		
		//Creates headerLabel JLabel
		//sets layout BoxLayout.Y_AXIS and flow layout to center

		headerLabel = new JLabel("Driver's License Exam Grader");
		headerPanel.add(headerLabel);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(Color.YELLOW);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		
		//Creates driverNameLabel JLabel and driverNameText JTextField and set layout to center
		driverNameLabel = new JLabel("Driver Name:");
		driverNamePanel.add(driverNameLabel);
		driverNameText = new JTextField(15);
		driverNamePanel.add(driverNameText);
		driverNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		//Add driverNamePanel to headerLabel JLabel and sets layout to North
		//sets layout BoxLayout.Y_AXIS

		headerPanel.add(driverNamePanel);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
		add(headerPanel, BorderLayout.NORTH);		
		
		
		// Using JButton class-----
    	// Creates buttonsPanel instances for gradeOptionButton, readFileButton and exitOptionButton
   		//Sets layout to South
		buttonsPanel.add(gradeOptionButton);
		buttonsPanel.add(readFileButton);
		buttonsPanel.add(exitOptionButton);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(buttonsPanel, BorderLayout.SOUTH);
		
	
		
		//Creates driverTestAnsLabel JLabel and adds driverTestAnsLayout JTextField and driverTestAnsPanel
		//sets layout BoxLayout.Y_AXIS and border layout to center
		
		driverTestAnsLabel = new JLabel("Enter your answers");
		driverTestAnsLayout.add(driverTestAnsLabel);
		driverTestAnsLayout.add(driverTestAnsPanel);
		driverTestAnsLayout.setLayout(new BoxLayout(driverTestAnsLayout, BoxLayout.Y_AXIS));
		add(driverTestAnsLayout, BorderLayout.CENTER);
		
		//Create the numbers and driverTestAnsText in a 5x4 GridLayout 
		//adds the l1 number count and driverTestAnsText to driverTestAnsPanel
		
		for(int index = 0; index < driverTestAnsText.length; index ++)
		{
				l1 = new JLabel((index + 1) + ". ");
				driverTestAnsPanel.add(l1);
				l1.setHorizontalAlignment(SwingConstants.RIGHT);
				
				driverTestAnsText[index] = new JTextField();
				
				driverTestAnsPanel.add(driverTestAnsText[index]);
				driverTestAnsPanel.setLayout(new GridLayout(5,4));
		}

	}
	
	
	/**
	 * ButtonListener class method.
	 * It checks if grade, readfile or exit buttons are clicked.
	 * 
	 * @author Surtej Sarin
	 */

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			Object source = e.getSource();
			
			/**
			 * When the Read File button is clicked, the Student name and the 20 grades 
			 *are read from a file and then displayed in the appropriate textboxes.  
			 *I then Use a JFileChooser to allow the user to select the file to read from.  
			 *The file will contain the student name on the first line and then the second 
			 *line will have 20 answers (A, B, C or D) separated by a space.  
			 */
						
			if(source == readFileButton)
			{
					//define JFileChooser method and select file
					JFileChooser fileChooser = new JFileChooser();
					int status = fileChooser.showOpenDialog(null);
					File selectedFile;
					
					//initialize and declare char letter
					char letter = ' ';
					//initialize and declare String filename
					String filename = "";
					
					//Check if file has been selected
					if(status == JFileChooser.APPROVE_OPTION)
					{
						selectedFile = fileChooser.getSelectedFile();
						filename = selectedFile.getPath();
					}
					
					//Try Catch for text area
					JTextArea textArea = new JTextArea();
					BufferedReader read = null;
					try {
						//filename reader
						read = new BufferedReader(new FileReader(filename));
					} catch (FileNotFoundException exc1) {
						exc1.printStackTrace();
					}
					String strln = null;
					try {
						//read in line
						strln = read.readLine();
						// set string to jtextfield
						driverNameText.setText(strln);

						new JTextField(strln);
					} catch (IOException exc1) {
						exc1.printStackTrace();
					}
					//while the next line is not blank
					while(strln != null)
					{
					  textArea.append(strln + "\n");
					  try {
						//read in line
						strln = read.readLine();
						//take out the spaces
						strln = strln.replaceAll("\\s+","");
						//assign line to letterChoice
						letterChoice = strln.toCharArray();
	
						
						//loop checks letterChoice
						for (int i = 0; i < letterChoice.length; i++) {
							
							//assign letterChoice index to letter
							letter = letterChoice[i];
								
							//change letter to uppercase
							letter= Character.toUpperCase(letter);
								
							//check if letters match A B C D char
								   if (letter == 'A' || letter == 'B' || letter == 'C' || letter == 'D') 
								    {
									   //set driverTestAnsText and to driverTestAnsPanel
								    	driverTestAnsText[i].setText(Character.toString(letter));
										driverTestAnsPanel.add(driverTestAnsText[i]);
	
								    }
							//check if letters do not match A B C D char

								    else
								    {
								    	//Give error message of 1st wrong question
								    	JOptionPane.showMessageDialog(null, "Question " + (i+1) + " has an invalid answer. "
												+ "Only A, B, C, or D are valid.");
								    }
						}
						//try-catch
					} catch (IOException exc1) {
						exc1.printStackTrace();
					}
				}
			}

			//gradeOptionButton check 
			//Extracts the Student name and the 20 grades from the textboxes
			//report method of the DriverExam class will be called.
			//Display the Student’s name with the report in a dialog box.
			if(source == gradeOptionButton)
			{
				
				//Extracts the Student name and the 20 grades from the textboxes				
				String studentName=driverNameText.getText();
				
				//creates DriverExam class object driverExam
				DriverExam driverExam = new DriverExam(letterChoice);
				
				//report method of the DriverExam class will be called.
				String studentReport = driverExam.report(studentName, letterChoice);
				
				//Display the Student’s name with the report in a dialog box.
				JOptionPane.showMessageDialog(null, studentReport);
				
			}
			
			//exitOptionButton
			if(source == exitOptionButton)
			{
				//exit program
				System.exit(0);
			}
			
			
		}
	}

	/**
	 * The main method for the program
	 * @param args not used
	 * @throws IOException
	 * 
	 * @author Surtej Sarin
	 */
	public static void main(String[] args)
	{
		JFrame jFrame = new Driver();
	    jFrame.pack();
	    jFrame.setVisible(true);
	}		
}


