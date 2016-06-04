/**Assignment 2
 * Office Depo is an office supply retailing company donates its surpluses to colleges at the end of each year.
 * In the program volunteers will help deliver packages of supplies to representative of colleges (Recipient of supplies).
 * This application simulates delivering packages from the container of packages by the volunteers to recipients.  
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/18/2016
 * 
 * @author	Surtej
 * 
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**GuiMain
 * Prompts user to enter a password and re-type the password
 * It is where the password, file, exit buttons, textfields and labels are created,
 * exceptions are thrown, and PasswordChecker class is called 
 * 
 * @author Surtej
 *
 */
public class GuiMain extends BorderPane {

	//buttons for newPackage, newVolunteer, newRecipient, donatePackage, and exitButton
	private Button newPackage, newVolunteer, newRecipient, donatePackage, exitButton;
	//textfield for volunteers, recipients, and packages
	private TextField volTextField1, volTextField2, volTextField3, volTextField4, volTextField5, 
	recTextField1, recTextField2, recTextField3, recTextField4, recTextField5,
	package1, package2, package3, package4, package5;
	//labels for volunteer and recipient queue and container package stack
	private Label volunteerQ, recipientQ, containerPackage;
	//text area
	private TextArea textArea;

	//for the packages
	private ArrayList<String> pString = new ArrayList<String>();
	private ArrayList<TextField> pTf = new ArrayList<TextField>();
	//for the volunteer
	private ArrayList<String> vString = new ArrayList<String>();
	private ArrayList<TextField> vTf = new ArrayList<TextField>();
	//for the recipient
	private ArrayList<String> rString = new ArrayList<String>();
	private ArrayList<TextField> rTf = new ArrayList<TextField>();

	//instance of objects
	DonationManager dm = new DonationManager();
	DonationPackage dp;
	Container c;
	Volunteer v;
	VolunteerLine vl;
	Recipient r;
	RecipientLine rl;

	/** GuiMain default no-argument constructor
	 */
	GuiMain() {

		/*Insets inset = new Insets(10); //for setting margins
		passwordTextField = new TextField(); //textfield for password
		passwordTextField.setPrefColumnCount(8); //textfield space for password
		passwordLabel = new Label("Password"); //label for password
		retypeTextField = new TextField(); //textfield for re-typed password
		retypeTextField.setPrefColumnCount(8); //textfield space for re-typed password
		retypeLabel = new Label("Re-type Password"); //label for re-typed password

		hbox2.getChildren().addAll(retypeLabel, retypeTextField);
		 */


		//create the exitButton
		exitButton = new Button("_Exit");
		exitButton.setTooltip(new Tooltip("Select to close the application"));
		exitButton.setMnemonicParsing(true);


		//use a lambda expression for the EventHandler class for exitButton
		exitButton.setOnAction(
				event -> {
					Platform.exit();
					System.exit(0);
				}
				);

		//create the newPackage button
		newPackage = new Button("_Stack a New Package");
		newPackage.setTooltip(new Tooltip("Select to stack a new package"));
		newPackage.setMnemonicParsing(true);  


		//create a listener for the other button using a lambda expression
		newPackage.setOnAction(event -> {
			//textArea.setText("hello");
			int counter = 0;
			//package weight
			String w;
			//package name
			String packageName;
			//String p2 = package2.getText();
			//String p3 = package3.getText();
			//String p4 = package4.getText();
			//String p5 = package5.getText();

			//prompts user to enter the package name
			packageName = JOptionPane.showInputDialog(null, "Enter package in container");
			//sets the text of the package
			//package1.setText(packageName);


			//String p1 = package1.getText();

			//prompts user to enter the package weight
			do{
				w = JOptionPane.showInputDialog(null, "Enter package weight (< 20 lbs)");
			}while(Integer.parseInt(w) < 0 || Integer.parseInt(w) > 20);

			//dp = new DonationPackage(p1, Integer.parseInt(w));
			
			if(pString.size() < 5){

				//sets the text of the package
				pString.add(packageName);

				for(int i=0; i<pString.size(); i++){
					pTf.addAll(i, new ArrayList<TextField>());
					pTf.get(4-i).setText(pString.get(i));
				}
			}
			
			try{
				dp = new DonationPackage(packageName,Integer.parseInt(w));
				//dm = new DonationManager();
				dm.ManagerLoadcontainer(dp);

				//package1.setText(packageName);
			} catch (Exception e) {
				textArea.setText(e.toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		//create newVolunteer button
		newVolunteer = new Button("New _Volunteer");
		newVolunteer.setTooltip(new Tooltip("Select add a new volunteer"));
		newVolunteer.setMnemonicParsing(true);

		//create a listener for the other button using a lambda expression
		newVolunteer.setOnAction(event -> {
			//volunteer name
			String volunteerName;
			//prompts user to enter the volunteer name
			volunteerName = JOptionPane.showInputDialog(null, "Enter volunteer name");
			//sets the text of the volunteer

			if(vString.size() < 5){
				vString.add(volunteerName);
				/*for(int i=0; i<vString.size(); i++){
					vTf.addAll(i, new ArrayList<TextField>());
					vTf.get(i).setText(vString.get(i));
				}*/
				
				for(int i=5; i>5-vString.size(); i--){
					vTf.addAll(i, new ArrayList<TextField>());
					vTf.get(i-1).setText(vString.get(4-(i-1)));
				}
				
				
				
				//volTextField1.setText(volunteerName);
				//String volunteerName = volTextField1.getText();
				// create a new volunteer object				//add volunteer to the volunteer queue
			}
			
			try {
				v = new Volunteer(volunteerName);
				dm.ManagerQueueVolunteer(v);
			} catch (Exception e) {
				textArea.setText(e.toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//vl.addNewVolunteer(v);
		});

		//create newRecipient button
		newRecipient = new Button("New _Recipient");
		newRecipient.setTooltip(new Tooltip("Select to add a new recipient"));
		newRecipient.setMnemonicParsing(true);

		//create a listener for the other button using a lambda expression
		newRecipient.setOnAction(event -> {
			//the recipient name
			String recipientName;
			//String recipientName = volTextField1.getText();
			//prompt the user to enter the recipient name
			recipientName = JOptionPane.showInputDialog(null, "Enter recipient name");
			//set the recipient text

			if(rString.size() < 5){

				rString.add(recipientName);
				
				/*for(int i=0; i<rString.size(); i++){
					rTf.addAll(i, new ArrayList<TextField>());
					rTf.get(i).setText(rString.get(i));
				}*/
				
				for(int i=5; i>5-rString.size(); i--){
					rTf.addAll(i, new ArrayList<TextField>());
					rTf.get(i-1).setText(rString.get(4-(i-1)));
				}

				//recTextField1.setText(recipientName);
				//create a new recipient object
				//rl.addNewRecipient(r);
			}
			//add the recipient to the recipient queue
			try {
				r = new Recipient(recipientName);
				dm.ManagerQueueRecipient(r);
			} catch (Exception e) {
				textArea.setText(e.toString());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		
		//***Please note the textFields do not Clear
		//However, if you add a new element it will write over the textfield
		
		
		
		//create donatePackage button
		donatePackage = new Button("_Donate Package");
		donatePackage.setTooltip(new Tooltip("Select to donate a package"));
		donatePackage.setMnemonicParsing(true);

		//create a listener for the other button using a lambda expression
		donatePackage.setOnAction(event -> {
			
			//textArea.setText(c.toArrayPackage().toString());
			Recipient[] rec = dm.managerArrayRecipient();
			Volunteer[] vol = dm.managerArrayVolunteer();
			DonationPackage[] pac = dm.managerArrayPackage();
 
			String recipient = rec[rec.length-1].getRecipient();
			String volunteer = vol[vol.length-1].getVolunteer();
			String packages = pac[pac.length-1].getDescription();

			//set the textArea
			//if the package is donated
			if(dm.donatePackage() == 0){
				//textArea.setText(v.toString() + " delivered " + dp.toString() + " to " + r.toString());
				textArea.setText(volunteer + " delivered " + packages + " to " + recipient);
				rString.remove(recipient);
				vString.remove(volunteer);
				pString.remove(packages);
				
				rTf.remove(rString);
				vTf.remove(vString);
				pTf.remove(pString);
				
				//rTf.clear();
				for(int i=0; i<rec.length; i++){
					//rTf.get(i).setText(value);
					rTf.get(4-i).setText(rec[i].getRecipient());
				}
				
				//vTf.clear();
				for(int i=0; i<vol.length; i++){
					//vTf.get(i).setText("");
					vTf.get(4-i).setText(vol[i].getVolunteer());
				}
				
				//pTf.clear();
				for(int i=0; i<pac.length; i++){
					//pTf.get(i).setText("");
					pTf.get(4-i).setText(pac[i].getDescription());
				}
				
			//if there are no volunteers in the queue
			} else if(dm.donatePackage() == 1){
				textArea.setText("There are no volunteers in the queue");
			//if there are no recipients in the queue
			} else if(dm.donatePackage() == 2){
				textArea.setText("There are no recipients in the queue");
			//if there are no packages in the container
			} else if(dm.donatePackage() == 3){
				textArea.setText("There are no packages in the container");
			}
			//vl.volunteerTurn();
			//rl.recipientTurn();
			//c.removePackageFromContainer();			
		});

		//add a vbox containing an hbox of buttons
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);

		//add an hbox containing the buttons
		HBox button = new HBox(10);
		button.getChildren().addAll(newPackage, newVolunteer, newRecipient, donatePackage, exitButton);
		//vbox.getChildren().add(button);
		vbox.getChildren().addAll(button);

		//set the volunteer textfields
		volTextField1 = new TextField(); //textfield for volTextField1
		volTextField1.setPrefColumnCount(8); //textfield space for volTextField1
		volTextField2 = new TextField(); //textfield for volTextField2
		volTextField2.setPrefColumnCount(8); //textfield space for volTextField2
		volTextField3 = new TextField(); //textfield for volTextField3
		volTextField3.setPrefColumnCount(8); //textfield space for volTextField3
		volTextField4 = new TextField(); //textfield for volTextField4
		volTextField4.setPrefColumnCount(8); //textfield space for volTextField4
		volTextField5 = new TextField(); //textfield for volTextField5
		volTextField5.setPrefColumnCount(8); //textfield space for volTextField5
		volunteerQ = new Label("Queue for Volunteers"); //label for volunteerQ

		vTf.add(0, volTextField1);
		vTf.add(1, volTextField2);
		vTf.add(1, volTextField3);
		vTf.add(1, volTextField4);
		vTf.add(1, volTextField5);

		//hbox containing the volunteer title
		HBox volunteerTitle = new HBox(10);
		volunteerTitle.setStyle("-fx-border-style: solid;"
				+ "-fx-border-width: 1;"
				+ "-fx-border-color: white");
		volunteerTitle.getChildren().addAll(volunteerQ);
		vbox.getChildren().addAll(volunteerTitle);

		//hbox containing the volunteer textfields
		HBox volunteers = new HBox(10);
		/*volunteers.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: white");*/
		volunteers.getChildren().addAll(vTf.get(0), vTf.get(1), vTf.get(2), vTf.get(3), vTf.get(4));
		//vbox containing the volunteers
		vbox.getChildren().addAll(volunteers);

		//sets the recipient textfields
		recTextField1 = new TextField(); //textfield for recTextField1
		recTextField1.setPrefColumnCount(8); //textfield space for recTextField1
		recTextField2 = new TextField(); //textfield for recTextField2
		recTextField2.setPrefColumnCount(8); //textfield space for recTextField2
		recTextField3 = new TextField(); //textfield for recTextField3
		recTextField3.setPrefColumnCount(8); //textfield space for recTextField3
		recTextField4 = new TextField(); //textfield for recTextField4
		recTextField4.setPrefColumnCount(8); //textfield space for recTextField4
		recTextField5 = new TextField(); //textfield for recTextField5
		recTextField5.setPrefColumnCount(8); //textfield space for recTextField5
		recipientQ = new Label("Queue for recipients"); //label for recipientQ

		rTf.add(0, recTextField1);
		rTf.add(1, recTextField2);
		rTf.add(1, recTextField3);
		rTf.add(1, recTextField4);
		rTf.add(1, recTextField5);


		//hbox containing the recipient title
		HBox recipientTitle = new HBox(10);
		recipientTitle.setStyle("-fx-border-style: solid;"
				+ "-fx-border-width: 1;"
				+ "-fx-border-color: white");
		recipientTitle.getChildren().add(recipientQ);
		vbox.getChildren().add(recipientTitle);

		//hbox contaning the recipient textfields
		HBox recipients = new HBox(10);
		/*recipients.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: white");*/
		recipients.getChildren().addAll(rTf.get(0),rTf.get(1),rTf.get(2),rTf.get(3),rTf.get(4));
		//vbox contaning the hbox contaning recipient textfields
		vbox.getChildren().add(recipients);

		//sets the packages textfields
		package1 = new TextField(); //textfield for package1
		package1.setPrefColumnCount(8); //textfield space for package1
		package2 = new TextField(); //textfield for package2
		package2.setPrefColumnCount(8); //textfield space for package2
		package3 = new TextField(); //textfield for package3
		package3.setPrefColumnCount(8); //textfield space for package3
		package4 = new TextField(); //textfield for package4
		package4.setPrefColumnCount(8); //textfield space for package4
		package5 = new TextField(); //textfield for package5
		package5.setPrefColumnCount(8); //textfield space for package5
		containerPackage = new Label("Packages in the container"); //label for containerPackage

		pTf.add(0, package1);
		pTf.add(1, package2);
		pTf.add(1, package3);
		pTf.add(1, package4);
		pTf.add(1, package5);

		/*for(int i = 0; i < tf.size(); i ++){
			tf.set(i, new TextField());
			tf.get(i).setPrefColumnCount(8);
		}*/

		//hbox containing packages
		HBox packages = new HBox(10);
		packages.getChildren().add(containerPackage);

		//vbox containing the hbox of packaages
		VBox packageText = new VBox(10);
		packageText.setStyle("-fx-border-style: solid;"
				+ "-fx-border-width: 1;"
				+ "-fx-border-color: white");
		packageText.setPadding(new Insets(10));
		packageText.setSpacing(8);
		//packageText.getChildren().addAll(packages, package1, package2, package3, package4, package5);
		packageText.getChildren().addAll(packages, pTf.get(0), pTf.get(1), pTf.get(2), pTf.get(3), pTf.get(4));

		//sets the text area using gridpane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		textArea = new TextArea();
		textArea.setEditable(false);
		gridpane.add(textArea, 0, 1);

		//sets vbox for the gridpane
		VBox text = new VBox(10);
		text.getChildren().addAll(gridpane);
		HBox h = new HBox(10);
		h.getChildren().addAll(packageText, text);
		vbox.getChildren().addAll(h);

		//assign vbox to top
		setTop(vbox);
	}
}

