import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFx extends Application implements Initializable{
	@FXML
	Button myButton;
	
	@FXML
	ChoiceBox myChoice;
	
	public static void main(String[] args) {
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("moviefxml.fxml"));
		final Pane p = loader.load();
		
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoice.setItems(FXCollections.observableArrayList("AMC", "Regal Cinemas","Cinemark Theatres","Marcus Theatres","Landmark Theatres"));
		
		
		
		// TODO Auto-generated method stub
		
	}

}
