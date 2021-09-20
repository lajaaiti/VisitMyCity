package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionBDD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SingInController implements Initializable {
	
		Connection cnx;
		public PreparedStatement st;
		public ResultSet result;
	
	   @FXML
	    private VBox vbox;

	  @FXML
	    private TextField txt_mail;

	    @FXML
	    private TextField txt_pass;

	    @FXML
	    private Button btn_passoublie;

	    @FXML
	    private Button btn_connec;
	    
	    private Parent fxml;

	    @FXML
	    void openHome() {

	    	String mail = txt_mail.getText();
	    	String pass = txt_pass.getText();
	    	String sql = "select * from utilisateurs ";
	    	
	    	try {
				st = cnx.prepareStatement(sql);
				
				result = st.executeQuery();
				
				if (result.next()) {
					
					if(mail.equals(result.getString("email_utilisateur"))&&pass.equals(result.getString("pass_utilisateur"))) {
						
			    		//System.out.println("bien joue!!!!");
						
			    		vbox.getScene().getWindow().hide();
			    		Stage home = new Stage();
			    		try {
							fxml = FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
							Scene scene = new Scene (fxml);
							home.setScene(scene);
							home.show();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
			    		
			    		
			    	}else {
			    		Alert alert = new Alert(AlertType.ERROR,"email ou mot de passe incorrect!!!!",javafx.scene.control.ButtonType.OK);
			    		
			    		alert.showAndWait();
			    	}
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
	    	
	    	
	    	
	    }

	    @FXML
	    void sendpass() {

	    }
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBDD.connexionDB();
		
	}



}
