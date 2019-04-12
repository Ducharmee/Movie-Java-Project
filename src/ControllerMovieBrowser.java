import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ControllerMovieBrowser extends JavaFx implements Initializable{
	public static String url;
	public static int labelnum;
	@FXML
	WebView web;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	//	url = Movie.showtimeclick.get();
		System.out.println(url);
		WebEngine webload = web.getEngine();
		webload.load(url);
	}

}
