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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FavorisUserController implements Initializable  {
	

	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	@FXML
    private ImageView image_batiment;
	
	@FXML
    private TextField txt_infos;

    @FXML
    private Label lab_nbr;

    @FXML
    private TextField txt_batiment;

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_adresse;

    @FXML
    void showprecedent() {
    	String adr = txt_adresse.getText();
    	String sql3 = "SELECT id_batiment FROM batiments WHERE adr_batiment ='" + adr + "'";
    	int position = 0;
    	try {
			st = cnx.prepareStatement(sql3);
			result = st.executeQuery();
			
			if (result.next()) {
				position = result.getInt("id_batiment");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
    	
    	String sql4 = "SELECT nom_batiment, image, desc_batiment,adr_batiment, nom_ville FROM `batiments`, `villes` WHERE villes.id_ville=batiments.id_ville and id_batiment < '" + position + "'";

    	byte byteimg[];
    	Blob blob;
    	
    	try {
			st = cnx.prepareStatement(sql4);
			result = st.executeQuery();
			if (result.next()) {
				txt_batiment.setText(result.getString("nom_batiment"));
				txt_adresse.setText(result.getString("adr_batiment"));
				txt_ville.setText(result.getString("nom_ville"));
				txt_infos.setText(result.getString("desc_batiment"));
				
				
				blob = result.getBlob("image");
				byteimg = blob.getBytes(1, (int) blob.length());
				Image img =  new Image (new ByteArrayInputStream(byteimg),image_batiment.getFitWidth(),image_batiment.getFitHeight(),true,true);
				image_batiment.setImage(img);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }


    @FXML
    void showsuivant() {
    	String adr = txt_adresse.getText();
    	String sql3 = "SELECT id_batiment FROM batiments WHERE adr_batiment ='" + adr + "'";
    	int position = 0;
    	try {
			st = cnx.prepareStatement(sql3);
			result = st.executeQuery();
			
			if (result.next()) {
				position = result.getInt("id_batiment");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
    	
    	String sql4 = "SELECT nom_batiment, image, desc_batiment,adr_batiment, nom_ville FROM `batiments`, `villes` WHERE villes.id_ville=batiments.id_ville and id_batiment > '" + position + "'";

    	byte byteimg[];
    	Blob blob;
    	
    	try {
			st = cnx.prepareStatement(sql4);
			result = st.executeQuery();
			if (result.next()) {
				txt_batiment.setText(result.getString("nom_batiment"));
				txt_adresse.setText(result.getString("adr_batiment"));
				txt_ville.setText(result.getString("nom_ville"));
				txt_infos.setText(result.getString("desc_batiment"));
				
				
				blob = result.getBlob("image");
				byteimg = blob.getBytes(1, (int) blob.length());
				Image img =  new Image (new ByteArrayInputStream(byteimg),image_batiment.getFitWidth(),image_batiment.getFitHeight(),true,true);
				image_batiment.setImage(img);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

    }
    
    public void ShowBatiment() {
    	
    	
    	String sql2 = "SELECT nom_batiment, image, desc_batiment,adr_batiment, nom_ville FROM `batiments`, `villes` WHERE villes.id_ville=batiments.id_ville";
    	
    	byte byteimg[];
    	Blob blob;
    	
    	try {
			st = cnx.prepareStatement(sql2);
			result = st.executeQuery();
			if (result.next()) {
				txt_batiment.setText(result.getString("nom_batiment"));
				txt_adresse.setText(result.getString("adr_batiment"));
				txt_ville.setText(result.getString("nom_ville"));
				txt_infos.setText(result.getString("desc_batiment"));
				
				
				blob = result.getBlob("image");
				byteimg = blob.getBytes(1, (int) blob.length());
				Image img =  new Image (new ByteArrayInputStream(byteimg),image_batiment.getFitWidth(),image_batiment.getFitHeight(),true,true);
				image_batiment.setImage(img);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
    	
    	
    }

	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		cnx = ConnexionBDD.connexionDB();
		ShowBatiment();
	}

}
