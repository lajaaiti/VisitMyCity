package controllers;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;


public class SingUpController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_prenom;

	    @FXML
	    private TextField txt_email;

	    @FXML
	    private TextField txt_ville;

	    @FXML
	    private TextField txt_cp;

	    @FXML
	    private TextField txt_statut;

	    @FXML
	    private TextField txt_pass;
	    
	    @FXML
	    private VBox vbox;
	    
	    private Parent fxml;

	    @FXML
	    void inscription() {
	    	

	    	String nom = txt_nom.getText();
	    	String prenom = txt_prenom.getText();
	    	String email = txt_email.getText();
	    	String ville = txt_ville.getText();
	    	String statut = "";
	    	String cp = txt_cp.getText();
	    	String motdepasse = txt_pass.getText();
	    	
	    	String sql = "INSERT INTO `utilisateurs`(nom_utilisateur, prenom_utilisateur, email_utilisateur, ville_utilisateur, cp_utilisateur, pass_utilisateur, statut) VALUES (?,?,?,?,?,?,?)";
	    	
	    	if(!nom.equals("")&&!prenom.equals("")&&!email.equals("")&&!ville.equals("")&&!cp.equals("")&&!motdepasse.equals("")) {
	    		try {
				st = cnx.prepareStatement(sql);
				st.setString(1, nom);
				st.setString(2, prenom);
				st.setString(3, email);
				st.setString(4, ville);
				st.setString(5, cp);
				st.setString(6, motdepasse);
				st.setString(7, statut);
				st.executeUpdate();
				
				txt_nom.setText("");
				txt_prenom.setText("");
				txt_email.setText("");
				txt_ville.setText("");
				txt_cp.setText("");
				txt_pass.setText("");
				
				Alert alert = new Alert(AlertType.CONFIRMATION, "inscription avec succès !!!", javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
				
				try {
					fxml = FXMLLoader.load(getClass().getResource("/interfaces/SingIn.fxml"));
					vbox.getChildren().removeAll();
					vbox.getChildren().setAll(fxml);
							
				} catch (Exception el) {
					
					el.printStackTrace();
					
				}
				
			
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	    	}else {
	    		Alert alert = new Alert(AlertType.WARNING, "veuillez remplir tout les champs!", javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
	    	}
	    

	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cnx = ConnexionBDD.connexionDB();
	
		
	}

	

}
