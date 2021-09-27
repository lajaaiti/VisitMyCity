package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class VillesController implements Initializable  {
	
	private Parent fxml;
	
	  @FXML
	    private AnchorPane root;
	

    @FXML
    private GridPane grille;

    @FXML
    private ImageView img_stras;

    @FXML
    private Label lab_stras;

    @FXML
    private ImageView img_paris;

    @FXML
    private Label lab_paris;

    @FXML
    private ImageView img_nice;

    @FXML
    private Label lab_nice;

    @FXML
    private ImageView img_colmar;

    @FXML
    private Label lab_colmar;

    @FXML
    private ImageView img_sete;

    @FXML
    private Label lab_sete;

    @FXML
    private ImageView img_bordeaux;

    @FXML
    private Label lab_bordeaux;

    @FXML
    void detail(MouseEvent event) {
    	
    	  
		  try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/monumentsVilles.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
