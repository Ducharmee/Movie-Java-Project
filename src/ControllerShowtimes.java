import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControllerShowtimes extends JavaFx implements Initializable {
	@FXML
	Pane pane;
	@FXML
	ImageView bckrd;
	public static String imgUrl;
	ArrayList<String> sortedTimes = new ArrayList<>();
	boolean greatest = true;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println(imgUrl);
		bckrd = new ImageView(imgUrl);
		pane.getChildren().add(bckrd);
		ArrayList<Integer> check = new ArrayList<>();
		sortedTimes.add(Movie.showtimes.get(0));
		int length =Movie.showtimes.size()-1;
		int prev = Integer.valueOf(Movie.showtimes.get(0).split(":")[0]);
		for(int x=0;x<length-1;x++){
			if(prev>Integer.valueOf(Movie.showtimes.get(x+1).split(":")[0])||(Movie.showtimes.get(x+1).split(":")[1].contains("am")&&Movie.showtimes.get(x).split(":")[1].contains("pm"))) {
			
				break;
			}
			prev =Integer.valueOf(Movie.showtimes.get(x+1).split(":")[0]); 
			sortedTimes.add(Movie.showtimes.get(x+1));
		}
		sortedTimes.add(Movie.showtimes.get(0));
		
		Label[] times = new Label[Movie.showtimes.size()];
		int count = 0;
		int offset = 450;
		for(Label l:times) { //int x=0;x<times.length;x++
			l = new Label(Movie.showtimes.get(count));
			l.setLayoutX(offset);
			l.setLayoutY(20);
			l.setTextFill(Color.WHITE);
			l.setFont(Font.font("Cambria", 24));
			offset+=150;
		
			count++;
			
			pane.getChildren().add(l);
			l.setOnMousePressed(new EventHandler<MouseEvent>() {
			
				@Override
				public void handle(MouseEvent event) {
					//ControllerMovieBrowser.labelnum = 
					
					loader = new FXMLLoader(getClass().getResource("moviebrowser.fxml"));
					Pane p = null;
					try {
						p = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//	System.out.println(count);
					
					//ControllerMovieBrowser.url = 
					//Parent tableview = FXMLLoader.load(getClass().getResource("new.fxml"));
					//Scene tableviewScene = new Scene(tableview);
					
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(new Scene(p));
					window.show();
					
					
					
				}	
				});
			
		}
	}
	public void back(ActionEvent event) throws IOException{
		Movie.movielist.clear();
		Movie.showtimeurls.clear();
		Movie.showtimeclick.clear();
		Movie.showtimes.clear();
		Movie.urls.clear();
		Pane p = null;
		
		loader = new FXMLLoader(getClass().getResource("select movie.fxml"));
		p = loader.load();
	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(p));
		window.show();
	}	
}
