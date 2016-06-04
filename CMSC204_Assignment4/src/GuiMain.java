/**Assignment 4
 * 
 * Write a program that creates a concordance.
 * There will be two ways to create a concordance.
 * The first requires a document to be read from an input file, and the concordance data is written to an output file.
 * The second reads the input from a string and returns an ArrayList of strings that represent the concordance of the string.
 * 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 03/16/2016
 * 
 * @author	Surtej
 * 
 */

import java.io.File;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**GuiMain
 * 
 * Do not allow the user to create a concordance file until they have entered an input file and an output file
 * Show the text area only when the option to create from text is chosen.
 * Use a FileChooser for the user to select the input and output files.
 * Inform the user if there is an error with the input file or the output file
 * Use exception handling (try/catch) for the validity of the files.
 * If creating a concordance from text, make sure the user has entered some text in the text area.  Inform user if text area is empty.
 * Display the concordance from the text in the text area.
 * Provide a way for the user to “clear” the text area.
 * 
 * @author Surtej
 *
 */
public class GuiMain extends BorderPane {

	//Buttons for createConcordance, inputFile, outputFile, clearButton, and exitButton
	private Button createConcordance, inputFile, outputFile, clearButton, exitButton;
	//RadioButton for concordanceFile, concordanceText
	private RadioButton concordanceFile, concordanceText;
	//TextArea textArea
	private TextArea textArea;

	//Uses an object that implements ConcordanceDataManagerInterface
	ConcordanceDataManager cdm = new ConcordanceDataManager();

	//Initializes a FileChooser object fc
	FileChooser fc = new FileChooser();
	//File used for input file
	File inFile;
	//File used for output file
	File outFile;

	/** GuiMain default no-argument constructor
	 */
	GuiMain() {

		//Creates the RadioButtons used to allow the user
		//to enter input from a TextArea or a Text File
		ToggleGroup g = new ToggleGroup();
		concordanceFile = new RadioButton("Create concordance from File");
		concordanceFile.setToggleGroup(g);
		concordanceText = new RadioButton("Create concordance from Text");
		concordanceText.setToggleGroup(g);
		concordanceText.setSelected(true);


		//Creates the exitButton used to close the application
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

		//Creates the Concordance button used to create concordance
		createConcordance = new Button("Create _Concordance");
		createConcordance.setTooltip(new Tooltip("Select to create concordance"));
		createConcordance.setMnemonicParsing(true);  

		//create a listener for the createConcordance button using a lambda expression
		createConcordance.setOnAction(event -> {
			//Initializes String ArrayList cText
			ArrayList <String> cText = new ArrayList <String> ();
			//Sends the text area to createConcordanceArray through cdm object
			//Assigns the return value to cText
			cText = cdm.createConcordanceArray(textArea.getText());
			//Updates the TextArea to cText, the concordance Text
			textArea.setText(cText.toString());
		});

		//Creates input File button used to input a file
		inputFile = new Button("Select _Input File");
		inputFile.setTooltip(new Tooltip("Select to input a file"));
		inputFile.setMnemonicParsing(true);

		//create a listener for the inputFile button using a lambda expression
		inputFile.setOnAction(event -> {

			//Allows user to select the input File
			inFile = fc.showOpenDialog(null);
			//Disable the output File
			outputFile.setDisable(false);
		});

		//Creates the outputFile button used to output to a file
		outputFile = new Button("Select _Output File");
		outputFile.setTooltip(new Tooltip("Select to output to a file"));
		outputFile.setMnemonicParsing(true);

		//create a listener for the outputFile using a lambda expression
		outputFile.setOnAction(event -> {
			
			//Allows user to select the output File
			outFile = fc.showOpenDialog(null);

			//Sends the inFile and outFile to createConcordanceFile through cdm object
			try {
				cdm.createConcordanceFile(inFile, outFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		//Create the clearButton button used to clear the text area
		clearButton = new Button("C_lear");
		clearButton.setTooltip(new Tooltip("Select to clear the text area"));
		clearButton.setMnemonicParsing(true);

		//create a listener for the clearButton using a lambda expression
		clearButton.setOnAction(event -> {
			//Clears the text area
			cdm = new ConcordanceDataManager();
			textArea.clear();
		});

		//Adds a vbox containing an hbox of buttons
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);

		//Adds an hbox containing the radio buttons
		HBox radioButton = new HBox(10);
		//Adds the radio buttons
		radioButton.getChildren().addAll(concordanceFile, concordanceText);
		//Adds the radioButton to vbox
		vbox.getChildren().addAll(radioButton);


		//Sets the text area using gridpane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		textArea = new TextArea();
		textArea.setEditable(true);
		gridpane.add(textArea, 0, 1);
		//Sets vbox for the gridpane
		VBox text = new VBox(10);
		text.getChildren().addAll(gridpane);
		HBox h = new HBox(10);
		h.getChildren().addAll(text);
		vbox.getChildren().addAll(h);

		//Initialize the setDisable for the createConcordance,inputFile, and outputFile buttons
		createConcordance.setDisable(false);
		inputFile.setDisable(true);
		outputFile.setDisable(true);

		//create a listener for the concordanceText radio button using a lambda expression
		concordanceText.setOnAction(event -> {
			//Initialize the setDisable for the createConcordance,inputFile, and outputFile buttons
			createConcordance.setDisable(false);
			inputFile.setDisable(true);
			outputFile.setDisable(true);
			//Sets the text area to be visible
			h.setVisible(true);
		});	

		//create a listener for the concordanceFile radio button using a lambda expression
		concordanceFile.setOnAction(event -> {
			//Initialize the setDisable for the createConcordance,inputFile, and outputFile buttons
			createConcordance.setDisable(true);
			inputFile.setDisable(false);
			outputFile.setDisable(true);
			//Sets the text area to not be visible
			h.setVisible(false);
		});	
		
		//hbox containing the all of the buttons
		HBox buttons = new HBox(10);
		/*volunteers.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 3;"
                + "-fx-border-color: white");*/
		buttons.getChildren().addAll(createConcordance, inputFile, outputFile, clearButton, exitButton);
		//vbox containing the buttons
		vbox.getChildren().addAll(buttons);

		//Assign vbox to top
		setTop(vbox);
	}
}