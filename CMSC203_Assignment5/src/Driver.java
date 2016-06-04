/** 
 * This program is a program for Hickory Hollow Elementary School. 
 * It is a GUI-driven program that enters room officers and their offices, to print a report, and to save that report to a file.
 * It utilizes key java methods on Dependency and Aggregation, JLabel, Enumerated types, Arraylists and Writing to a file
 * 
 * @author Surtej Sarin    Date: 04/08/15	Professor: Ida Justh	Course/section: CMSC203/30963
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;



/**
 * GUI driver – frame and panel classes
 * Creates a driver class with an ActionListener class.  
 * Use Layout Managers and borders to make the panel look more professional.  
 * Displays the school logo image to the screen.  
 * The panel will have an instance variable of type Room.  
 * Uses the addOfficer and printRoom methods from the Room class.  
 * Uses a dialog boxs to alert the user when there is an error with officer.  
 * The New Room button prompts the user for the room number and grade, 
 * create a new variable of type Room, and display the new room in box. 
 * 
 * @author Surtej
 *
 */
public class Driver extends JFrame
{
	//JLabel for roomAndClassGrade, firstName and lastName
	private JLabel roomAndClassGrade = new JLabel(), firstName = new JLabel(), lastName = new JLabel();
	//JTextField for roomAndClassGradeText, firstNameText and lastNameText
	private JTextField roomAndClassGradeText = new JTextField(),
			firstNameText = new JTextField(), lastNameText = new JTextField();
	//JPanel for buttonsPanel,roomAndClassGradePanel, pictureLeftPanel, rightPanel and radioButtonsPanel
	private JPanel buttonsPanel = new JPanel(), roomAndClassGradePanel = new JPanel(), 
			pictureLeftPanel = new JPanel(), rightPanel = new JPanel(), radioButtonsPanel = new JPanel();
	//JRadioButton for presidentRButton, secretaryRButton, treasurerRButton, representativeRButton; 			
	private JRadioButton presidentRButton, secretaryRButton, treasurerRButton, representativeRButton; 	
	//JButton for newRoomJButton, addOfficerJButton,printRoomJButton , saveRoomJButton and, exitOptionJButton
	private JButton newRoomJButton = new JButton(), addOfficerJButton = new JButton(),
			printRoomJButton = new JButton(), saveRoomJButton = new JButton(), exitOptionJButton = new JButton();
	
	//String roomAndClassGrade String
	String roomAndClassGradeStr = "";
	//String room
	String strRoom = "";
	//selected jradiobutton String
	String selectedJRadio;
	
	//room an instance of Room class
	Room room = new Room();
	

	//Driver constructor
	public Driver()
	{
		// Sets the dimensions of the Panel
		setPreferredSize(new Dimension(600, 500));
		// Sets the title of the Panel
		setTitle("Hickory Hollow Elementary School");
		// Sets the default close operation of the Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//Use JButton Class tasks with action listener------
		
		//Creates newRoomJButton
		newRoomJButton = new JButton("New Room");
		newRoomJButton.addActionListener(new ButtonListener());
		//add officer
		addOfficerJButton = new JButton("Add Officer");
		addOfficerJButton.addActionListener(new ButtonListener());
		//print room
		printRoomJButton = new JButton("Print Room");
		printRoomJButton.addActionListener(new ButtonListener());
		//Creates saveRoomJButton
		saveRoomJButton = new JButton("Save Room");
		saveRoomJButton.addActionListener(new ButtonListener());
		//Creates exitOptionJButton
		exitOptionJButton = new JButton("Exit");
		exitOptionJButton.addActionListener(new ButtonListener());
		
		//add button panel----------------
		buttonsPanel.add(newRoomJButton);
		buttonsPanel.add(addOfficerJButton);
		buttonsPanel.add(printRoomJButton);
		buttonsPanel.add(saveRoomJButton);
		buttonsPanel.add(exitOptionJButton);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		add(buttonsPanel, BorderLayout.SOUTH);
		
		
		//header----------------
		roomAndClassGradePanel.setPreferredSize(new Dimension(400,70));
		roomAndClassGrade = new JLabel("Room and Class Grade: ");
		roomAndClassGradePanel.add(roomAndClassGrade);
		roomAndClassGradeText = new JTextField(20);
		roomAndClassGradePanel.add(roomAndClassGradeText);
		roomAndClassGradePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(roomAndClassGradePanel, BorderLayout.NORTH);

		//rightPanel----------------
		rightPanel.setPreferredSize(new Dimension(400,200));
		firstName = new JLabel("First Name: ");
		rightPanel.add(firstName);
		firstNameText = new JTextField(10);
		rightPanel.add(firstNameText);
		
		rightPanel.setPreferredSize(new Dimension(200,200));
		lastName = new JLabel("Last Name: ");
		rightPanel.add(lastName);
		lastNameText = new JTextField(10);
		rightPanel.add(lastNameText);
		
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(rightPanel, BorderLayout.EAST);

		//radio button
		presidentRButton = new JRadioButton("President");
		secretaryRButton = new JRadioButton("Secretary");
		treasurerRButton = new JRadioButton("Treasurer");
		representativeRButton = new JRadioButton("Representative");
		// Creates a group to make the three radio buttons mutually exclusive
		ButtonGroup radioButtonGroup = new ButtonGroup();
		
		// add radiobuttonPanel to right panel
		radioButtonsPanel.setPreferredSize(new Dimension(150,200));
		radioButtonsPanel.setBorder(BorderFactory.createTitledBorder(" Office "));

		radioButtonsPanel.add(presidentRButton);
		radioButtonsPanel.add(secretaryRButton);
		radioButtonsPanel.add(treasurerRButton);
		radioButtonsPanel.add(representativeRButton);
		
		rightPanel.add(radioButtonsPanel);
		
		//addradiobuttons
		radioButtonGroup.add(presidentRButton);
		radioButtonGroup.add(secretaryRButton);
		radioButtonGroup.add(treasurerRButton);
		radioButtonGroup.add(representativeRButton);
		// Creates method instance of class RadioButtonListener
		RadioButtonListener radioButtonListener = new RadioButtonListener();
		// Adds the action listener to the three radioButtons
		presidentRButton.addActionListener(radioButtonListener);
		secretaryRButton.addActionListener(radioButtonListener);
		treasurerRButton.addActionListener(radioButtonListener);	
		representativeRButton.addActionListener(radioButtonListener);	

		
		//picture panel-----------------
		
		//pictureLeftPanel.setPreferredSize(new Dimension(200,200));
		
		
		ImageIcon image = new ImageIcon("school.jpg");
		JLabel label = new JLabel(image);
		//label.setIcon(image);
		pictureLeftPanel.add(label);
		pictureLeftPanel.setVisible(true);
		//pictureLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(pictureLeftPanel, BorderLayout.WEST);

	}
	
	//radiobutton action listener
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
			
				// Checks if source is presidentRButton
			if (source == presidentRButton)
			{
				//assigns president to selectedJRadio
				selectedJRadio="president";
			}
			// Checks if source is secretaryRButton
			if (source == secretaryRButton)
			{
				//assigns secretary to selectedJRadio
				selectedJRadio="secretary";
			}
			// Checks if source is treasurerRButton
			if (source == treasurerRButton)
			{
				//assigns treasurer to selectedJRadio
				selectedJRadio="treasurer";
			}
			// Checks if source is representativeRButton
			if (source == representativeRButton)
			{
				//assigns treasurer to representative
				selectedJRadio="representative";
			}
		}
	}
	
	//button listener implemets actionlistener
	private class ButtonListener implements ActionListener
	{
		/**
		 * ButtonListener class method.
		 * It checks if newroom, print room, newroom or exit buttons are clicked.
		 * 
		 * @author Surtej Sarin
		 */

		public void actionPerformed(ActionEvent e) 
		{
			Object source = e.getSource();
			
			//checks if new room button was clicked
			//displays showInputDialog
			if(source == newRoomJButton)
			{
				roomAndClassGradeStr=JOptionPane.showInputDialog(null, "What is the Room and Grade: ", "Room/Grade", JOptionPane.PLAIN_MESSAGE);
				roomAndClassGradeText.setText(roomAndClassGradeStr);
				roomAndClassGradeText.setEditable(false);
			}

			//checks if add officer button was clicked
			if(source == addOfficerJButton)
			{
				//assign return value of instance room addOfficer method and passes firstname, lastname and position
				String str = room.addOfficer(firstNameText.getText(), lastNameText.getText(), selectedJRadio);
				
				//check if string is null meaning if officer is allowed to be added
				if(str == null)
				{
					//creates officer instance officer and passes firstname, lastname and position
					Officer officer = new Officer(firstNameText.getText(), lastNameText.getText(), selectedJRadio);
					
					//calls instance room method addStrOfficer
					room.addStrOfficer();
				}
			}

			//checks if print room button was clicked
			//displays showInputDialog
			if(source == printRoomJButton)
			{
				//assigns room and class grade string and officers to strRoom
				strRoom=roomAndClassGradeStr + "\nOfficers\n";
				//assigns room instance and method printRoom return value containing array to strRoom
				strRoom+=room.printRoom();
				//display officers to screen
				JOptionPane.showMessageDialog(null, strRoom, "Officers", JOptionPane.PLAIN_MESSAGE);
			}

			//checks if save room button was clicked
			if(source == saveRoomJButton)
			{
				//process of saving the string strRoom to a word file 
				
				JFrame jframe = new JFrame();
				 
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose file");   
				 
				int choice = fileChooser.showSaveDialog(jframe);
				 
				if (choice == JFileChooser.APPROVE_OPTION) {
				    try{
					    File file = fileChooser.getSelectedFile();
					    System.out.println("Save file: " + file.getAbsolutePath());
					    if (!file.exists()) {
					        file.createNewFile();
					    }
					    PrintWriter pw = new PrintWriter(file.getAbsolutePath());
					    pw.write(strRoom);
					    pw.close();
			 
						System.out.println("Done");
			 
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			
			//checks if exitOptionJButton is clicked
			if(source == exitOptionJButton)
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
