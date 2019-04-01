import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
	@FXML
	Stage stage;
	Stage stage2;
	Scene scene1;
	Scene scene2;
	
	FXMLLoader loader;
	static String[] primaryStage;
	public static void main(String[] args) {
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage; 
		Pane p = null;
		
		loader = new FXMLLoader(getClass().getResource("moviefxml.fxml"));
		p = loader.load();
		

	
		
		stage.setScene(new Scene(p));
		
		
		stage.show();
		stage = primaryStage; 
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoice.setItems(FXCollections.observableArrayList("AMC", "Regal Cinemas","Cinemark Theatres","Marcus Theatres","Landmark Theatres"));
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	//First Button onAction Method
	public void button1Click(ActionEvent event) throws IOException{
		Theatre t = new Theatre();
		t.type = myChoice.getSelectionModel().getSelectedItem().toString();
		
		Pane p = null;
		
		loader = new FXMLLoader(getClass().getResource("locations.fxml"));
		p = loader.load();
		
		//Parent tableview = FXMLLoader.load(getClass().getResource("new.fxml"));
		//Scene tableviewScene = new Scene(tableview);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(p));
		window.show();
	//	loader = new FXMLLoader(getClass().getResource("locations.fxml"));
	//	Pane p = loader.load();
		
		//stage.setScene(new Scene(p));
	//	stage.show();
		
	
			
	
	}

}
