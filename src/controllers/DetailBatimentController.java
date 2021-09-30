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

public class DetailBatimentController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	  @FXML
	    private ImageView txt_img;

	    @FXML
	    private Label txt_lbl;

	    @FXML
	    private TextField txt_nombtm;

	    @FXML
	    private TextField txt_type;

	    @FXML
	    private TextField txt_adreville;

	    @FXML
	    private TextField txt_architect;

	    @FXML
	    private TextField tkt_desc;

	    @FXML
	    void ajoutfavoris() {

	    }
	    public void show() {
	    	
	    	String sql2 = "SELECT nom_batiment, type_batiment, image, desc_batiment, adr_batiment, architect_batiment FROM batiments WHERE nom_batiment = '"+ txt_nombtm.getText() + "'";
	    	
	    	byte byteimg[];
	    	Blob blob;
	    	int m = 0;
	    	
	    	try {
				st = cnx.prepareStatement(sql2);
				result = st.executeQuery();
				if (result.next()) {
					txt_nombtm.setText(result.getString("nom_batiment"));
					txt_adreville.setText(result.getString("adr_batiment"));
					txt_architect.setText(result.getString("architect_batiment"));
					txt_type.setText(result.getString("type_batiment"));
					tkt_desc.setText(result.getString("desc_batiment"));
					
					
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
