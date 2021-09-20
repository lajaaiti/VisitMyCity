package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class HomeController implements Initializable {
	
		private Parent fxml;
	
		@FXML
		private AnchorPane root;
		
		
	
	
	  @FXML
	    void accueil(MouseEvent event) {
		  
		  try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	    }

	    @FXML
	    void batiments(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Batiments.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	    @FXML
	    void favoris(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Favoris.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	    @FXML
	    void utilisateurs(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Utilisateurs.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
