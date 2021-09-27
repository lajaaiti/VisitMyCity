package controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConnexionBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import models.monument;


public class BatimentController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 @FXML
	    private TextField id_user;
	
	 @FXML
	    private TextField txt_type;

	    @FXML
	    private TextField txt_nom;

	    @FXML
	    private TextField txt_adresse;

	    @FXML
	    private TextField txt_architecte;

	    @FXML
	    private TextField txt_fenetre;

	    @FXML
	    private TextField txt_couleur;

	    @FXML
	    private TextField txt_toiture;

	    @FXML
	    private TextField txt_charpente;

	    @FXML
	    private Label label_entrée;

	    @FXML
	    private ImageView imagebatiment;

	    @FXML
	    private TableView<monument> table_batiment;

	    @FXML
	    private TableColumn<monument, String> cln_batiment;

	    @FXML
	    private TableColumn<monument, String> cln_type;

	    @FXML
	    private TableColumn<monument, String> cln_adresse;

	    @FXML
	    private TableColumn<monument, String> cln_desc;

	    @FXML
	    private Button btn_ajoute;

	    @FXML
	    private Button btn_supprimer;

	    @FXML
	    private Button btn_modifier;
	    
	    private FileInputStream fs;
	    
	    @FXML
	    private Button txt_importimage;

	    @FXML
	    private TextField txt_monumentserche;

	    @FXML
	    void ajouterbatiment() {
	    	
	    	String type = txt_type.getText();
	    	String nom = txt_nom.getText();
	    	String adresse = txt_adresse.getText();
	    	String architecte = txt_architecte.getText();
	    	String fenetre = txt_fenetre.getText();
	    	String couleur = txt_couleur.getText();
	    	String toiture = txt_toiture.getText();
	    	String charpente = txt_charpente.getText();
	    	String id_utilisateur = id_user.getText();
	    	
		
	    	
	    	
	    	File image = new File(label_entrée.getText());
	    	
	    	String sql ="INSERT INTO `batiments`( `type_batiment`, `nom_batiment`, `adr_batiment`, `architect_batiment`,  `fenetre_batiment`, `toiture_batiment`, `charpente_batiment`, `couleur_batiment`, `image`, `id_utilisateur`  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    	try {
				st = cnx.prepareStatement(sql);
				st.setString(1, type);
				st.setString(2, nom);
				st.setString(3, adresse);
				st.setString(4, architecte);
				st.setString(5, fenetre);
				st.setString(6, toiture);
				st.setString(7, charpente);
				st.setString(8, couleur);
				
				try {
					fs = new FileInputStream(image);
					st.setBinaryStream(9, fs, image.length());
					st.setString(10, id_utilisateur);
					st.executeUpdate();
					showbatiment();

					txt_type.setText("");
	    			txt_nom.setText("");
	    			txt_adresse.setText("");
	    			txt_architecte.setText("");
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

	    @FXML
	    void modifierbatiment() {
	    	
	    	String type = txt_type.getText();
	    	String nom = txt_nom.getText();
	    	String adresse = txt_adresse.getText();
	    	String architecte = txt_architecte.getText();
	    	String fenetre = txt_fenetre.getText();
	    	String couleur = txt_couleur.getText();
	    	String toiture = txt_toiture.getText();
	    	String charpente = txt_charpente.getText();
	    	
	    	File image = new File(label_entrée.getText());
	    	
	    	String sql ="UPDATE `batiments` SET`type_batiment`=?,`nom_batiment`=?,`adr_batiment`=?,`architect_batiment`=?,`fenetre_batiment`=?,`toiture_batiment`=?,`charpente_batiment`=?,`couleur_batiment`=?,`image`= WHERE nom_batiment = '" + txt_nom.getText()+"'";

	    	try {
				st = cnx.prepareStatement(sql);
				st.setString(1, type);
				st.setString(2, nom);
				st.setString(3, adresse);
				st.setString(4, architecte);
				st.setString(5, fenetre);
				st.setString(6, toiture);
				st.setString(7, charpente);
				st.setString(8, couleur);
				
				try {
					fs = new FileInputStream(image);
					st.setBinaryStream(9, fs, image.length());
					st.executeUpdate();
					showbatiment();

					txt_type.setText("");
	    			txt_nom.setText("");
	    			txt_adresse.setText("");
	    			txt_architecte.setText("");
	    			txt_fenetre.setText("");
	    			txt_couleur.setText("");
	    			txt_toiture.setText("");
	    			txt_charpente.setText("");
	    			imagebatiment.setImage(null);
	    			label_entrée.setText("aucune entrée!");
	    			
	    			Alert alert = new Alert(AlertType.CONFIRMATION, "batiment modifié avec succès !!!", javafx.scene.control.ButtonType.OK);
	    			alert.showAndWait();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	    	

	    }

	    @FXML
	    void searchbatiment() {
	    	
	    	String sql = " SELECT  type_batiment, nom_batiment, adr_batiment, architect_batiment, fenetre_batiment, toiture_batiment, charpente_batiment, couleur_batiment, image FROM batiments WHERE nom_batiment = '"+ txt_monumentserche.getText() +"'";
	    	byte byteimg[];
	    	Blob blob;
	    	int m = 0;
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				if(result.next()) {
					
					txt_type.setText(result.getString("type_batiment"));
	    			txt_nom.setText(result.getString("nom_batiment"));
	    			txt_adresse.setText(result.getString("adr_batiment"));
	    			txt_architecte.setText(result.getString("architect_batiment"));
	    			txt_fenetre.setText(result.getString("fenetre_batiment"));
	    			txt_couleur.setText(result.getString("couleur_batiment"));
	    			txt_toiture.setText(result.getString("toiture_batiment"));
	    			txt_charpente.setText(result.getString("charpente_batiment"));
	    			
	    			blob = result.getBlob("image");
					byteimg = blob.getBytes(1, (int) blob.length());
					Image img =  new Image (new ByteArrayInputStream(byteimg),imagebatiment.getFitWidth(),imagebatiment.getFitHeight(),true,true);
					imagebatiment.setImage(img);
	    			
	    			m=1;
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
	    	if(m==0) {
	    		Alert alert = new Alert(AlertType.WARNING, "aucun utilisateur trouvé avec le nom du batiment : = " +txt_monumentserche.getText()+" ", javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
	    	}

	    }

	    @FXML
	    void supprimerbatiment() {
	    	
	    	String sql ="DELETE FROM `batiments` WHERE nom_batiment ='" + txt_nom.getText()+"'";
	    	try {
				st = cnx.prepareStatement(sql);
				
				st.executeUpdate();
				showbatiment();

				txt_type.setText("");
    			txt_nom.setText("");
    			txt_adresse.setText("");
    			txt_architecte.setText("");
    			txt_fenetre.setText("");
    			txt_couleur.setText("");
    			txt_toiture.setText("");
    			txt_charpente.setText("");
    			imagebatiment.setImage(null);
    			label_entrée.setText("aucune entrée!");
    			
    			Alert alert = new Alert(AlertType.CONFIRMATION, "batiment supprimer avec succès !!!", javafx.scene.control.ButtonType.OK);
    			alert.showAndWait();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	    }
	    
	    @FXML
	    void tablebatimentEvent() {
	    	
	    	monument mon = table_batiment.getSelectionModel().getSelectedItem();
	    	String sql = "SELECT * FROM batiments WHERE nom_batiment = ?";
	    	byte byteimg[];
	    	Blob blob;
	    	
	    	try {
				st = cnx.prepareStatement(sql);
				st.setString(1, mon.getNom_batiment());
				result = st.executeQuery();
				if(result.next()) {
					
					txt_type.setText(result.getString("type_batiment"));
	    			txt_nom.setText(result.getString("nom_batiment"));
	    			txt_adresse.setText(result.getString("adr_batiment"));
	    			txt_architecte.setText(result.getString("architect_batiment"));
	    			txt_fenetre.setText(result.getString("fenetre_batiment"));
	    			txt_couleur.setText(result.getString("couleur_batiment"));
	    			txt_toiture.setText(result.getString("toiture_batiment"));
	    			txt_charpente.setText(result.getString("charpente_batiment"));
	    			
	    			blob = result.getBlob("image");
					byteimg = blob.getBytes(1, (int) blob.length());
					Image img =  new Image (new ByteArrayInputStream(byteimg),imagebatiment.getFitWidth(),imagebatiment.getFitHeight(),true,true);
					imagebatiment.setImage(img);
	    			
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	

	    }
	    
	    ObservableList<monument> listbatiment = FXCollections.observableArrayList();
	    public void showbatiment() {
	    	table_batiment.getItems().clear();
	    	
	    	String sql = "SELECT * FROM batiments";
	    	
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				while(result.next()) {
					listbatiment.add(new monument(result.getString("type_batiment"), result.getString("nom_batiment"), result.getString("adr_batiment"), result.getString("architect_batiment"), result.getString("fenetre_batiment"), result.getString("couleur_batiment"), result.getString("toiture_batiment"), result.getString("charpente_batiment"), result.getString("desc_batiment"), result.getInt("id_utilisateur")));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
	    	cln_batiment.setCellValueFactory(new PropertyValueFactory<monument, String>("nom_batiment"));
	    	cln_type.setCellValueFactory(new PropertyValueFactory<monument, String>("type_batiment"));
	    	cln_adresse.setCellValueFactory(new PropertyValueFactory<monument, String>("adr_batiment"));
	    	cln_desc.setCellValueFactory(new PropertyValueFactory<monument, String>("desc_batiment"));
	    	table_batiment.setItems(listbatiment);
	    	
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBDD.connexionDB();
		showbatiment();
	}

	

}
