package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionBDD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class AjoutBatimentController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	   @FXML
	    private TextField txt_type;

	    @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_anne;

	    @FXML
	    private TextField txt_adr;

	    @FXML
	    private TextField txt_ville;

	    @FXML
	    private TextField txt_architect;

	    @FXML
	    private TextField txt_fenetre;

	    @FXML
	    private TextField txt_toiture;

	    @FXML
	    private Label label_entrée;

	    @FXML
	    private ImageView imagebatiment;

	    @FXML
	    private Button btn_ajoute;

	    @FXML
	    private Button txt_importimage;

	    @FXML
	    private TextField txt_charpente;

	    @FXML
	    private TextArea txt_desc;

	    @FXML
	    private TextField txt_couleur;
	    
	    private FileInputStream fs;

	    @FXML
	    void ajouterbatiment() throws SQLException {
	    	
	
	    	String type = txt_type.getText();
	    	String nom = txt_nom.getText();
	    	String anne = txt_anne.getText();
	    	String adresse = txt_adr.getText();
	    	String ville = txt_ville.getText();
	    	String architecte = txt_architect.getText();
	    	String desc = txt_desc.getText();
	    	String fenetre = txt_fenetre.getText();
	    	String couleur = txt_couleur.getText();
	    	String toiture = txt_toiture.getText();
	    	String charpente = txt_charpente.getText();
	    	int user = 0;
			String sql1 = "SELECT * FROM users_connect WHERE id_utilisateur = (SELECT MAX(id_utilisateur) FROM users_connect)";
		
				st = cnx.prepareStatement(sql1);
					result = st.executeQuery();
					if(result.next()) {
						user = result.getInt("id_user");
							
					}
		
	    	
	    	File image = new File(label_entrée.getText());
	    	
	    	String sql ="INSERT INTO batiments (type_batiment, nom_batiment, anne_construction, adr_batiment, ville, architect_batiment, desc_batiment, fenetre_batiment, toiture_batiment, charpente_batiment, couleur_batiment, image, id_utilisateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	
			
	    	try {
				st = cnx.prepareStatement(sql);
				st.setString(1, type);
				st.setString(2, nom);
				st.setString(3, anne);
				st.setString(4, adresse);
				st.setString(5, ville);
				st.setString(6, architecte);
				st.setString(7, desc);
				st.setString(8, fenetre);
				st.setString(9, toiture);
				st.setString(10, charpente);
				st.setString(11, couleur);
				
				try {
					fs = new FileInputStream(image);
					st.setBinaryStream(12, fs, image.length());
					st.setInt(13, user);
			    	st.executeUpdate();
				
	    			txt_type.setText("");
	    	    	txt_nom.setText("");
	    	    	txt_anne.setText("");
	    	    	txt_adr.setText("");
	    	    	txt_ville.setText("");
	    	    	txt_architect.setText("");
	    	    	txt_desc.setText("");
	    	    	txt_fenetre.setText("");
	    	    	txt_couleur.setText("");
	    	    	txt_toiture.setText("");
	    	    	txt_charpente.setText("");
	    			imagebatiment.setImage(null);
	    			label_entrée.setText("aucune entrée!");
	    			
	    			Alert alert = new Alert(AlertType.CONFIRMATION, "batiment ajouté avec succès !!!", javafx.scene.control.ButtonType.OK);
	    			alert.showAndWait();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	    	
	    }

	    

	    @FXML
	    void importimage() {

	    	FileChooser fc  = new FileChooser();
	    	fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg"));
	    	File f = fc.showOpenDialog(null);
	    	if(f != null) {
	    		label_entrée.setText(f.getAbsolutePath());
	    		Image image = new Image (f.toURI().toString(), imagebatiment.getFitWidth(), imagebatiment.getFitHeight(), true, true);
	    		 imagebatiment.setImage(image);
	    	}

	    }
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cnx = ConnexionBDD.connexionDB();

		
	}

}
