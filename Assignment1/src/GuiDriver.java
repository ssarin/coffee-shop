/**Program on password entry with exception handling 
 * Surtej Sarin, Professor Alexander, CMSC204-30941, 2/3/2016
 * ----
 * @author	Surtej
 * 
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**GuiDriver class is the Gui driver
 * This is where the Gui stage is set up and creates a new Gui Main
 * @author Surtej
 */
public class GuiDriver extends Application {

	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}

	@Override
	public void start(Stage stage) throws Exception {
		//call the main scene which is a BorderPane
		GuiMain root = new GuiMain();
		stage.setScene(new Scene(root, 500, 350));
		// Set stage title and show the stage.
		stage.setTitle("...<Passwords - Assignment1>...");
		stage.show();
		
	}
}
