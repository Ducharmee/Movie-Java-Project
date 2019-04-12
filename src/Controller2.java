import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller2 extends JavaFx implements Initializable {
	public static String src;
	@FXML
	Pane pane;
	@FXML
	ImageView img;

	public void back(ActionEvent event) throws IOException{
		Pane p = null;
		
		loader = new FXMLLoader(getClass().getResource("moviefxml.fxml"));
		p = loader.load();
	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(p));
		window.show();
		Theatre.location.clear();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	     File file = new File("imgs/"+src+".jpg");
	    Image image = new Image(file.toURI().toString());
		img.setImage(image);
		Button[] lab = new Button[Theatre.location.size()];
		int x = 0;
		int valueX = 0;
		int offsetX = 0;
		int valueY = 0;
		
		int greatest = 0;
		for(String a:Theatre.location) {
			offsetX = a.length()*7;
			if(offsetX>greatest) {
				greatest=offsetX;
			}
		}
		offsetX = greatest;
		for(String a:Theatre.location) {
			
			lab[x] = new Button(a);
			lab[x].setLayoutX(valueX);
			lab[x].setLayoutY(valueY);
			pane.getChildren().add(lab[x]);
			x++;
			valueY += 50;
			
			if(valueY>750) {
				valueX += offsetX;
				valueY = 0;
			}
		}
		for(Button a:lab) {
			a.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(Theatre.type.equals("AMC")) {
						String s = a.getText();
						s= s.replaceAll(" ", "-");
						
						String link = "https://www.amctheatres.com/movie-theatres/boston/"+s;
						Movie.url = link;
						JavaFx a = new JavaFx();
						loader = new FXMLLoader(getClass().getResource("select movie.fxml"));
						Pane p = null;
						try {
							p = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Parent tableview = FXMLLoader.load(getClass().getResource("new.fxml"));
						//Scene tableviewScene = new Scene(tableview);
						
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
						window.setScene(new Scene(p));
						window.show();
						
			
					}
					else if(Theatre.type.equals("REGAL")) {
						String s = a.getText();
						s= s.replaceFirst(" ", "");
						s= s.replaceAll(" ", "-");
						s=s.split(",")[1];
						System.out.println(s);
						String link = "https://www.regmovies.com/theatres/"+s;
						Movie.url = link;
						JavaFx a = new JavaFx();
						loader = new FXMLLoader(getClass().getResource("select movie.fxml"));
						Pane p = null;
						try {
							p = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Parent tableview = FXMLLoader.load(getClass().getResource("new.fxml"));
						//Scene tableviewScene = new Scene(tableview);
						
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
						window.setScene(new Scene(p));
						window.show();
						
			
					}
					else if(Theatre.type.equals("CINEMARK")) {
						String s = a.getText();
						
						s= s.replaceAll(" ", "-");

						System.out.println(s);
						String link = "https://www.cinemark.com/massachusetts/"+s;
						Movie.url = link;
						JavaFx a = new JavaFx();
						loader = new FXMLLoader(getClass().getResource("select movie.fxml"));
						Pane p = null;
						try {
							p = loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//Parent tableview = FXMLLoader.load(getClass().getResource("new.fxml"));
						//Scene tableviewScene = new Scene(tableview);
						
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
						window.setScene(new Scene(p));
						window.show();
					}
				}
			});


		}
	}

}
