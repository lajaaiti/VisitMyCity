package controllers;

import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Favoris;




public class FavorisController  implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 

	    @FXML
	    private TextField txt_batiment;

	    @FXML
	    private TextField txt_adresse;

	    @FXML
	    private TextField txt_ville;

	    @FXML
	    private TextField txt_architecte;


	    @FXML
	    private TextArea txt_desc;

	    @FXML
	    private Button favoris;
	    
	    @FXML
	    private TableView<Favoris> table_favoris;

	    @FXML
	    private TableColumn<Favoris, Integer> cln_nom;

	    @FXML
	    private TableColumn<Favoris, String> cln_batiment;

	    @FXML
	    private TableColumn<Favoris, String> cln_ville;

	    @FXML
	    private TableColumn<Favoris, String> cln_adresse;
	    
	    public ObservableList<Favoris> data = FXCollections.observableArrayList();
	    public ObservableList<Favoris> data2 = FXCollections.observableArrayList();

	    @FXML
	    void FavorisSearch() {
	    	
	    	table_favoris.getItems().clear();
	    	
	    	cln_nom.setCellValueFactory(new PropertyValueFactory<Favoris, Integer>("id_utilisateur"));
	    	cln_batiment.setCellValueFactory(new PropertyValueFactory<Favoris, String>("nom_batiment"));
	    	cln_ville.setCellValueFactory(new PropertyValueFactory<Favoris, String>("ville"));
	    	cln_adresse.setCellValueFactory(new PropertyValueFactory<Favoris, String>("adr_batiment"));
	    	
	    	int j = 0;
	    	String sql = "SELECT * FROM batiments WHERE nom_batiment = '" + txt_batiment.getText() + "'";
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				while(result.next()) {
					data2.add(new Favoris(result.getInt("id_utilisateur"), result.getString("nom_batiment"), result.getString("adr_batiment"), result.getString("ville"), result.getString("architect_batiment"), result.getString("desc_batiment")));
					j=1;	
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
	    	if(j==1) {
	    		table_favoris.setItems(data2);
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR, "ce batiment n'est pas dans la liste des favoris !!!", javafx.scene.control.ButtonType.OK);
    			alert.showAndWait();
	    	}
			
	    	

	    }

	    @FXML
	    void TableEvent() {
	    	Favoris favoris = table_favoris.getSelectionModel().getSelectedItem();
	    	
	    	String sql = "SELECT * FROM batiments WHERE id_utilisateur = '" + favoris.getId_utilisateur()+"'";
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				while(result.next()) {
					txt_batiment.setText(result.getString("nom_batiment"));
					txt_ville.setText(result.getString("ville"));
					txt_adresse.setText(result.getString("adr_batiment"));
					txt_architecte.setText(result.getString("architect_batiment"));
					txt_desc.setText(result.getString("desc_batiment"));
					
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
	    }
	    
	    public void remplirTable() {
	    	table_favoris.getItems().clear();
	    	
	    	String sql = "SELECT * FROM batiments";
	    	
	    	try {
				st = cnx.prepareStatement(sql);
				result = st.executeQuery();
				while(result.next()) {
					data.add(new Favoris(result.getInt("id_utilisateur"), result.getString("nom_batiment"), result.getString("adr_batiment"), result.getString("ville"), result.getString("architect_batiment"), result.getString("desc_batiment")));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	
	    	cln_nom.setCellValueFactory(new PropertyValueFactory<Favoris, Integer>("id_utilisateur"));
	    	cln_batiment.setCellValueFactory(new PropertyValueFactory<Favoris, String>("nom_batiment"));
	    	cln_ville.setCellValueFactory(new PropertyValueFactory<Favoris, String>("ville"));
	    	cln_adresse.setCellValueFactory(new PropertyValueFactory<Favoris, String>("adr_batiment"));
	    	table_favoris.setItems(data);
	    }
	    
	    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBDD.connexionDB();
		remplirTable(); 
		
		
	}

	

}
