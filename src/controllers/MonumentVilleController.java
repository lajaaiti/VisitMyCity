package controllers;

import java.io.ByteArrayInputStream;

import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionBDD;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;

public class MonumentVilleController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	
	 @FXML
	    private AnchorPane root;

	    @FXML
	    private TextField txt_search;

	    @FXML
	    private ImageView txt_img;

	    @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_type;

	    @FXML
	    private TextField txt_adresse;

	    @FXML
	    private TextField txt_ville;

	    @FXML
	    private TextField txt_desc;

	    @FXML
	    private ImageView btn_search;
	    

	    @FXML
	    private TextField txt_search1;

	    @FXML
	    private TextField txt_search2;

	    @FXML
	    void ajouterFavoris() {
	    	String sql = "SELECT id_batiment, id_utilisateur FROM batiments WHERE nom_batiment ='" + txt_search.getText()+ "'";
	    	int id_user, id_bat;
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				if(result.next()) {
					id_user = result.getInt("id_utilisateur");
					id_bat = result.getInt("id_batiment");
					
			String sql1 = "INSERT INTO favoris(id_batiment, id_utilisateur) VALUES (?, ?)";		
			st = cnx.prepareStatement(sql1);
			st.setInt(1, id_bat);
			st.setInt(2, id_user);
			
			Alert alert = new Alert(AlertType.CONFIRMATION, "batiment ajouté avec succès !!!", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.CONFIRMATION, "oups y'a un probleme !!!", javafx.scene.control.ButtonType.OK);
	    			alert.showAndWait();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	    }

	    @FXML
	    void searchBatiment() {
	    	
	 String sql2 = "SELECT nom_batiment, type_batiment, image, desc_batiment, adr_batiment, ville FROM batiments WHERE nom_batiment = '"+ txt_search.getText() + "' OR type_batiment = '"+ txt_search1.getText() + "' OR architect_batiment = '" + txt_search2.getText() + "'";
	    	
	    	byte byteimg[];
	    	Blob blob;
	    	int m = 0;
	    	
	    	try {
				st = cnx.prepareStatement(sql2);
				result = st.executeQuery();
				if (result.next()) {
					txt_nom.setText(result.getString("nom_batiment"));
					txt_adresse.setText(result.getString("adr_batiment"));
					txt_ville.setText(result.getString("ville"));
					txt_type.setText(result.getString("type_batiment"));
					txt_desc.setText(result.getString("desc_batiment"));
					
					
					blob = result.getBlob("image");
					byteimg = blob.getBytes(1, (int) blob.length());
					Image img =  new Image (new ByteArrayInputStream(byteimg),txt_img.getFitWidth(),txt_img.getFitHeight(),true,true);
					txt_img.setImage(img);
					m=1;
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			

	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cnx = ConnexionBDD.connexionDB();
	}

}
