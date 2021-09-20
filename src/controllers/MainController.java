package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class MainController implements Initializable {
	
	@FXML
    private Button btn_connexion;

    @FXML
    private Button btn_inscription;

    @FXML
    private VBox vbox;
    
    private Parent fxml;

    @FXML
    void openSingIn() {
    	TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
		t.setToX(vbox.getLayoutX() * 20);
		t.play();
		t.setOnFinished(e->{
			try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SingIn.fxml"));
				vbox.getChildren().removeAll();
				vbox.getChildren().setAll(fxml);
						
			} catch (Exception el) {
				
				el.printStackTrace();
				
			}
		});
    }

    @FXML
    void openSingUp() {
    	TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
    	t.setToX(20);
		t.play();
		t.setOnFinished(e->{
			try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/SingUp.fxml"));
				vbox.getChildren().removeAll();
				vbox.getChildren().setAll(fxml);
						
			} catch (Exception el) {
				
				el.printStackTrace();
				
			}
		});
    	
    }


	@Override
	public void initialize(URL location, ResourceBundle ressources) {
		TranslateTransition t = new TranslateTransition(Duration.seconds(1),vbox);
		t.setToX(vbox.getLayoutX() * 20);
		t.play();
	}

	

}
