import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller2 extends JavaFx implements Initializable {
	@FXML
	Pane pane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Label[] lab = new Label[Theatre.location.size()];
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
		for(Label a:lab) {
			a.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(Theatre.type.equals("AMC")) {
						
					}
				}
			});


		}
	}

}
