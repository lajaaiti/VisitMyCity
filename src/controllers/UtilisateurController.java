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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Users;


public class UtilisateurController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	@FXML
    private TextField txt_emailrecherche;
	
    @FXML
    private TextField txt_nom;
    
    @FXML
    private TextField txt_statut;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_motdepasse;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_cp;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_edit;

    @FXML
    private TextField txt_ville;

   

    @FXML
    private TableView<Users> txt_table;

    @FXML
    private TableColumn<Users, String> cln_nom;

    @FXML
    private TableColumn<Users, String> cln_prenom;

    @FXML
    private TableColumn<Users, String> cln_email;

    @FXML
    private TableColumn<Users, String> cln_ville;
    
    public ObservableList<Users> data = FXCollections.observableArrayList();


    @FXML
    void adduser() {
    	
    	String nom = txt_nom.getText();
    	String prenom = txt_prenom.getText();
    	String email = txt_email.getText();
    	String ville = txt_ville.getText();
    	String statut = txt_statut.getText();
    	String cp = txt_cp.getText();
    	String motdepasse = txt_motdepasse.getText();
    	
    	String sql = "INSERT INTO `utilisateurs`(`nom_utilisateur`, `prenom_utilisateur`, `email_utilisateur`, `ville_utilisateur`, `cp_utilisateur`, `pass_utilisateur`, ``statut`) VALUES (?,?,?,?,?,?,?)";
    	
    	if(!nom.equals("")&&!nom.equals("")&&!prenom.equals("")&&!email.equals("")&&!ville.equals("")&&!cp.equals("")&&!statut.equals("")&&!motdepasse.equals("")) {
    		try {
			st = cnx.prepareStatement(sql);
			st.setString(1, nom);
			st.setString(2, prenom);
			st.setString(3, email);
			st.setString(4, ville);
			st.setString(5, cp);
			st.setString(6, statut);
			st.setString(7, motdepasse);
			st.execute();
			
			txt_nom.setText("");
			txt_prenom.setText("");
			txt_email.setText("");
			txt_ville.setText("");
			txt_cp.setText("");
			txt_statut.setText("");
			txt_motdepasse.setText("");
			
			Alert alert = new Alert(AlertType.CONFIRMATION, "utilisateur ajouté avec succès !!!", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
			
			showUsers();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	}else {
    		Alert alert = new Alert(AlertType.WARNING, "veuillez remplir tout les champs!", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
    	}
    
    }

    @FXML
    void deleteuser() {
    	String sql = "DELETE FROM `utilisateurs` WHERE email_utilisateur = '" + txt_email.getText() +"'";
    	
    	try {
			st = cnx.prepareStatement(sql);
			st.executeUpdate();
			

			txt_nom.setText("");
			txt_prenom.setText("");
			txt_email.setText("");
			txt_ville.setText("");
			txt_cp.setText("");
			txt_statut.setText("");
			txt_motdepasse.setText("");
			
			Alert alert = new Alert(AlertType.CONFIRMATION, "utilisateur supprimé avec succès !!!", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
			showUsers();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	

    }

    @FXML
    void edituser() {
    	
    	String nom = txt_nom.getText();
    	String prenom = txt_prenom.getText();
    	String email = txt_email.getText();
    	String statut = txt_statut.getText();
    	String ville = txt_ville.getText();
    	String cp = txt_cp.getText();
    	String motdepasse = txt_motdepasse.getText();
    	
    	String sql = "UPDATE `utilisateurs` SET `nom_utilisateur`=?,`prenom_utilisateur`=?,`email_utilisateur`=?,`ville_utilisateur`=?,`cp_utilisateur`=?,`pass_utilisateur`=?, `statut`=? WHERE email_utilisateur = '" + txt_email.getText()+"'";
    	if(!nom.equals("")&&!nom.equals("")&&!prenom.equals("")&&!email.equals("")&&!ville.equals("")&&!cp.equals("")&&!statut.equals("")&&!motdepasse.equals("")) {
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
    			txt_statut.setText("");
    			txt_motdepasse.setText("");
    			
    			Alert alert = new Alert(AlertType.CONFIRMATION, "utilisateur modifié avec succès !!!", javafx.scene.control.ButtonType.OK);
    			alert.showAndWait();
    			
    			showUsers();
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    		
    	}else {
    		Alert alert = new Alert(AlertType.WARNING, "veuillez remplir tout les champs!", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
    	}
    	

    }

    @FXML
    void searchUser() {
    	
    	//il faut penser a mettre un systeme de recherche qui prendra en charge l'email comme base de recherche//////
    	String sql = "SELECT  nom_utilisateur, prenom_utilisateur, email_utilisateur, ville_utilisateur, cp_utilisateur, statut, pass_utilisateur FROM utilisateurs WHERE email_utilisateur = '"+ txt_emailrecherche.getText() +"'";
    	int m = 0;
    	try {
			st = cnx.prepareStatement(sql);
			result = st.executeQuery();
			if(result.next()) {
				
				txt_nom.setText(result.getString("nom_utilisateur"));
    			txt_prenom.setText(result.getString("prenom_utilisateur"));
    			txt_email.setText(result.getString("email_utilisateur"));
    			txt_ville.setText(result.getString("ville_utilisateur"));
    			txt_cp.setText(result.getString("cp_utilisateur"));
    			txt_statut.setText(result.getString("statut"));
    			txt_motdepasse.setText(result.getString("pass_utilisateur"));
    			m=1;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	if(m==0) {
    		Alert alert = new Alert(AlertType.WARNING, "aucun utilisateur trouvé avec l'email = " +txt_emailrecherche.getText()+" ", javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
    	}
    	

    }


    public void showUsers() {
    	txt_table.getItems().clear();
    	
    	String sql = "SELECT * FROM utilisateurs";
    	
    	try {
			st = cnx.prepareStatement(sql);
			result = st.executeQuery();
			while(result.next()) {
				data.add(new Users(result.getInt("id_utilisateur"),result.getString("nom_utilisateur"), result.getString("prenom_utilisateur"), result.getString("email_utilisateur"), result.getString("ville_utilisateur"), result.getString("statut"), result.getString("pass_utilisateur")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	cln_nom.setCellValueFactory(new PropertyValueFactory<Users, String>("nom_utilisateur"));
    	cln_prenom.setCellValueFactory(new PropertyValueFactory<Users, String>("prenom_utilisateur"));
    	cln_email.setCellValueFactory(new PropertyValueFactory<Users, String>("email_utilisateur"));
    	cln_ville.setCellValueFactory(new PropertyValueFactory<Users, String>("ville_utilisateur"));
    	txt_table.setItems(data);
    	
    }
    
    @FXML
    void tableUsersEvent() {
    	
    	Users users = txt_table.getSelectionModel().getSelectedItem();
    	String sql = "SELECT * FROM utilisateurs WHERE email_utilisateur = ?";
    	try {
			st = cnx.prepareStatement(sql);
			st.setString(1, users.getEmail_utilisateur());
			result = st.executeQuery();
			if(result.next()) {
				
				txt_nom.setText(result.getString("nom_utilisateur"));
    			txt_prenom.setText(result.getString("prenom_utilisateur"));
    			txt_email.setText(result.getString("email_utilisateur"));
    			txt_ville.setText(result.getString("ville_utilisateur"));
    			txt_cp.setText(result.getString("cp_utilisateur"));
    			txt_statut.setText(result.getString("statut"));
    			txt_motdepasse.setText(result.getString("pass_utilisateur"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnexionBDD.connexionDB();
		showUsers();
		
	}



}
