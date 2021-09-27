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

public class MonumentVilleController implements Initializable {
	
	private Parent fxml;
	
	   @FXML
	    private AnchorPane root;

	    @FXML
	    private ImageView img_det1;

	    @FXML
	    private Label lab_det1;

	    @FXML
	    private ImageView img_det2;

	    @FXML
	    private Label lab_det2;

	    @FXML
	    private ImageView img_det3;

	    @FXML
	    private Label lab_det3;

	    @FXML
	    private ImageView img_det4;

	    @FXML
	    private Label lab_det4;

	    @FXML
	    private ImageView img_ddet5;

	    @FXML
	    private Label lab_det5;

	    @FXML
	    private ImageView img_det6;

	    @FXML
	    private Label lab_det6;

	    @FXML
	    void detailMonument(MouseEvent event) {
	    	
	    	 try {
	 			fxml = FXMLLoader.load(getClass().getResource("/interfaces/detailsbatiment.fxml"));
	 			root.getChildren().removeAll();
	 			root.getChildren().setAll(fxml);
	 			
	 		} catch (IOException e) {
	 			
	 			e.printStackTrace();
	 		}

	    	
	    	

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
