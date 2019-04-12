import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControllerMovieSelect extends JavaFx implements Initializable {
	@FXML
	Pane pane;
	
//	@FXML
//	WebView web;
	@Override
	public void initialize(URL location, ResourceBundle resources)  {
		// TODO Auto-generated method stub
//		String url = "https://www.amctheatres.com/movie-theatres/boston/AMC-DINE-IN-Framingham-16/showtimes/all/2019-04-09/AMC-DINE-IN-Framingham-16/all";
//		WebEngine webLoad = web.getEngine();
//		webLoad.load(url);
		try {
			Movie.scraperMovies();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageView[] img = new ImageView[Movie.urls.size()];
		Rectangle[] r = new Rectangle[Movie.urls.size()];
		Label[] lab = new Label[Movie.movielist.size()];
		
		
		
		int x = 0;
		int valueX = 0;
		int offsetX = 0;
		int valueY = 0;
		
		int greatest = 200;
	/*	for(String a:Movie.movielist) {
			offsetX = a.length()*7;
			if(offsetX>greatest) {
				greatest=offsetX;
			}
		}
		offsetX = greatest;
		for(String a:Movie.movielist) {
			
			lab[x] = new Label(a);
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
		
		//Image Placement
		x = 0;
		 valueX = 0;
		 offsetX = 0;
		 valueY = 0;
		
		 greatest = 200;
	/*	for(String a:Movie.urls) {
			offsetX = a.length()*7;
			if(offsetX>greatest) {
				greatest=offsetX;
			}
		}*/
		offsetX = greatest;
		for(String a:Movie.urls) {
			
			img[x] = new ImageView(a);
			img[x].setPreserveRatio(false);
			img[x].maxHeight(300);
			img[x].maxWidth(200);
			img[x].setFitWidth(150);
			img[x].setFitHeight(200);
			r[x] = new Rectangle();
			r[x].setWidth(150);
			r[x].setHeight(200);
			r[x].setLayoutX(valueX);
			r[x].setLayoutY(valueY);
			 r[x].setArcHeight(15);
			 r[x].setArcWidth(15);
			 r[x].setFill(Color.TRANSPARENT);
			r[x].setStroke(Color.RED);
			r[x].toFront();
			img[x].setLayoutX(valueX);
			img[x].setLayoutY(valueY);
			lab[x] = new Label(Movie.movielist.get(x));
			lab[x].setLayoutX(valueX);
			lab[x].setLayoutY(valueY+200);
			lab[x].setTextFill(Color.WHITE);
			lab[x].setFont(Font.font("Cambria", 15));
			lab[x].toFront();
			img[x].toFront();
		/*	String[] s = Movie.movielist.get(x).split(" ");
	
			int y = 0;
			int space = 10;
			int addyoffset = 0;
			for(String b:s) {
			lab[x][y] = new Label(b);
			lab[x][y].setLayoutX(valueX+space);
			lab[x][y].setLayoutY(valueY+200+addyoffset);
			lab[x][y].setTextFill(Color.WHITE);
			lab[x][y].setFont(Font.font("Cambria", 14));
			lab[x][y].toFront();
			y++;
			if(y>2) {
				addyoffset =20;
			}
			}
			for(Label l:lab[x]) {
				pane.getChildren().add(l);
			}*/
			int z = x;
			
			pane.getChildren().addAll(r[x],img[x],lab[x]);
	
			x++;
			valueY += 250;
			
			if(valueY>700) {
				valueX += offsetX;
				valueY = 0;
			}
		}
		int z = 0;
		for(ImageView a:img) {
			int xa = z;
			a.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					//Scrape Showtimes
					ControllerShowtimes.imgUrl = Movie.urls.get(xa);
					try {
						Movie.scraperShowtimes(Movie.showtimeurls.get(xa));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//GOTO SHOWTIMES
					loader = new FXMLLoader(getClass().getResource("showtimes.fxml"));
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
				});
		z++;
		}
	}

	
	public void back(ActionEvent event) throws IOException{
		Movie.movielist.clear();
		Movie.showtimeurls.clear();
		Movie.showtimeclick.clear();
		Movie.showtimes.clear();
		Movie.urls.clear();
		Pane p = null;
		
		loader = new FXMLLoader(getClass().getResource("locations.fxml"));
		p = loader.load();
	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(p));
		window.show();
	}	
	
}
