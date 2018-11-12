package JavaFX;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	
		primaryStage.setScene(new Scene(FXMLLoader.load(new File("View.fxml").toURI().toURL())));
		
		
		
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
