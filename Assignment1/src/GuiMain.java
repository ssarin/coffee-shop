/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
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
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
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

	private Button passwordButton, fileButton, exitButton;
	private TextField passwordTextField, retypeTextField;
	private Label passwordLabel, retypeLabel;


	/** GuiMain default no-argument constructor
	 */
	GuiMain() {

		Insets inset = new Insets(10); //for setting margins
		passwordTextField = new TextField(); //textfield for password
		passwordTextField.setPrefColumnCount(8); //textfield space for password
		passwordLabel = new Label("Password"); //label for password
		retypeTextField = new TextField(); //textfield for re-typed password
		retypeTextField.setPrefColumnCount(8); //textfield space for re-typed password
		retypeLabel = new Label("Re-type Password"); //label for re-typed password
		HBox hbox1= new HBox(10); //hbox with stores label and textfield for password
		hbox1.getChildren().addAll(passwordLabel, passwordTextField);
		HBox hbox2= new HBox(10); //hbox with stores label and textfield for re-typed password
		hbox2.getChildren().addAll(retypeLabel, retypeTextField);

		//specific rules of creating a password 
		Label rule = new Label("Use the following rules when creating your passwords"
				+ "\n1. Length must be greater than 8"
				+ "\n2. Must contain at least one upper case alpha character"
				+ "\n3. Must contain at least one lower case alpha character"
				+ "\n4. Must contain at least one numeric character"
				+ "\n5. May not have more than 2  of the same character in sequence");

		//add the label and textfields
		VBox passwordInfo = new VBox(10);
		passwordInfo.getChildren().addAll(rule, hbox1, hbox2);
		setLeft(passwordInfo);


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

		//create the passwordButton button
		passwordButton = new Button("_Check Password");
		passwordButton.setTooltip(new Tooltip("Select this to check if the password is valid"));
		passwordButton.setMnemonicParsing(true);  

	
		//create an instance of PasswordChecker
		PasswordChecker pc = new PasswordChecker();

		//create a listener for the other button using a lambda expression
		passwordButton.setOnAction(event -> {
			//boolean passwordValidity = false;
			String pass1 = passwordTextField.getText();
			String pass2 = retypeTextField.getText();

			//if the passwords do not match
			if(!(pass1.equals(pass2))){
				try {
					throw new UnmatchedException("The passwords do not match");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					e.printStackTrace();
				}
				//if the passwords match
			} else {
				try {
					if(pc.isValidPassword(pass1) == true){
						JOptionPane.showMessageDialog(null, "Password is Valid");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);			
					e.printStackTrace();
				}
			}			
		});

		//create fileButton button
		fileButton = new Button("Check Passwo_rds in File");
		fileButton.setTooltip(new Tooltip("Select this to see if the list of passwords are valid"));
		fileButton.setMnemonicParsing(true);

		//create a listener for the other button using a lambda expression
		fileButton.setOnAction(event -> {

			/*FileChooser chooser = new FileChooser();
			 chooser.setTitle("Open Resource File");
			File selectedFile = chooser.showOpenDialog(mainStage);
			 if (selectedFile != null) {
			    mainStage.display(selectedFile);
			 }
		*/
			
			//scan file
			Scanner s = null;
			try {
				s = new Scanner(new File("passwords.txt"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//arraylist of passwords is populated
			ArrayList<String> passwordList = new ArrayList<String>();
			while (s.hasNext()){
				passwordList.add(s.next());
			}
			s.close();

			String invalidList = "";
			//arraylist of invalid passwords is populated
			ArrayList <String> invalidPasswordList = pc.validPasswords(passwordList);
			for(int i=0; i<invalidPasswordList.size(); i++){
				invalidList += invalidPasswordList.get(i) + "\n";
			}

			JOptionPane.showMessageDialog(null, invalidList);
		});

		//add passwordButton, fileButton, and exitButton
		HBox bottomBox = new HBox();
		HBox.setMargin(passwordButton, inset);
		HBox.setMargin(fileButton, inset);
		HBox.setMargin(exitButton, inset);
		bottomBox.getChildren().addAll(passwordButton, fileButton, exitButton);  
		setBottom(bottomBox);
		bottomBox.setAlignment(Pos.CENTER);

	}
}

