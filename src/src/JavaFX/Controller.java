package JavaFX;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import JavaFX.io.FileTool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

public class Controller {
	
	
	    @FXML
	    private Button btn;
	    
	    @FXML
	    private BorderPane root;

	    
	    @FXML
	    private Circle c;
	    
	    @FXML
	    private AnchorPane a;
	    
	    @FXML
	    private TextArea textContent;
	    
	    @FXML
	    void OpenFile(ActionEvent event) {
	    	
	    	FileChooser chooser = new FileChooser();
	    	File f = chooser.showOpenDialog(null);
	    	try {
	    		
	    		
				String content = FileTool.readContent(f);
				textContent.setText(content);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    @FXML
	    // Center funktioniert nicht - 
	    void Follow(MouseEvent event) {    	
	    	
	    	
	    	a.setOnMouseMoved(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
				
					c.setCenterX(event.getX());
			    	c.setCenterY(event.getY());
					
				}
			});
	    	
	    	
	    	
	    }
	    
	    @FXML
	    void Print(MouseEvent event) {
	    	
	    	a.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					
					Circle c = new Circle(30);
					c.setCenterX(event.getX());
					c.setCenterX(event.getY());
					a.getChildren().add(c);
					
				}
			});

	    }

	    

	    @FXML
	    void pressButton(ActionEvent event) {

	    }
	

	
//	public Controller() {
//	System.out.println("Controller erzeugt");
//	
//		
//	}
//	
//	public void pressButton(ActionEvent event){
//		   Circle kreis1;
//		   kreis1 = new Circle(200, 200, 10, Color.BLACK);
//		   
//		   output.getChildren().add(kreis1);
//	
//	}
//
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		
	}
	
	
