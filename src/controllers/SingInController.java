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
import javafx.scene.control.PasswordField;
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
	    private PasswordField txt_pass;

	    @FXML
	    private Button btn_passoublie;

	    @FXML
	    private Button btn_connec;
	    
	    private Parent fxml;

	    @FXML
	    void openHome() {

	    	String mail = txt_mail.getText();
	    	String pass = txt_pass.getText();
	    	String sql = "SELECT * FROM utilisateurs WHERE email_utilisateur = '" + mail + "'";
	    	String statut ="";
	    	
	    	if(!mail.equals("")&&!pass.equals("")) {
	    		
	    	try {
				st = cnx.prepareStatement(sql);
				
				result = st.executeQuery();
				
				if (result.next()) {
					
					if(mail.equals(result.getString("email_utilisateur")) && pass.equals(result.getString("pass_utilisateur"))) {
						
						String sql1 = "INSERT INTO users_connect(nom_utilisateur, prenom_utilisateur, email_utilisateur, pass_utilisateur, id_user) VALUES (?, ?, ?, ?, ?)";
						st = cnx.prepareStatement(sql1);
						st.setString(1, result.getString("nom_utilisateur"));
						st.setString(2, result.getString("prenom_utilisateur"));
						st.setString(3, result.getString("email_utilisateur"));
						st.setString(4, result.getString("pass_utilisateur"));
						st.setInt(5, result.getInt("id_utilisateur"));
			    		st.executeUpdate();						
			    		vbox.getScene().getWindow().hide();
			    		Stage home = new Stage();
			    		
			    		statut = result.getString("statut");
			    		if(statut.equals("admin")) {
			    			
			    			try {
								fxml = FXMLLoader.load(getClass().getResource("/interfaces/HomeAdmin.fxml"));
								Scene scene = new Scene (fxml);
								home.setScene(scene);
								home.show();
							} catch (IOException e) {
								
								e.printStackTrace();
							}
			    			
			    			
			    		}else {
			    			try {
								fxml = FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
								Scene scene = new Scene (fxml);
								home.setScene(scene);
								home.show();
							} catch (IOException e) {
								
								e.printStackTrace();
							}
			    			
			    		}
			    		
			    	}else {
			    		Alert alert = new Alert(AlertType.ERROR,"email ou mot de passe incorrect!!!!",javafx.scene.control.ButtonType.OK);
			    		
			    		alert.showAndWait();
			    		
			    		txt_mail.setText("");
				    	txt_pass.setText("");
			    	}
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
	    	
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR,"veuillez remplir tout les champs!!!!!",javafx.scene.control.ButtonType.OK);
	    		alert.showAndWait();
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
