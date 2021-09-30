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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HomeController implements Initializable {
	
	Connection cnx;
	public PreparedStatement st;
	public ResultSet result;
	
	 @FXML
	    private Label lbl_user;
	
		private Parent fxml;
	
		@FXML
		private AnchorPane root;
		
		
	
	
	  @FXML
	    void accueil(MouseEvent event) {
		  
		  try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/Accueil.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			

	    }

	    @FXML
	    void batiments(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Batiments.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}

	    }

	    @FXML
	    void favoris(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Favoris.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

	    @FXML
	    void utilisateurs(MouseEvent event) {
	    	try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Utilisateurs.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    @FXML
	    void villes(MouseEvent event) {
		 try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/villes.fxml"));
				root.getChildren().removeAll();
				root.getChildren().setAll(fxml);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	    }
	    
	    @FXML
	    void deconnexion(MouseEvent event) {
	    	
	    	root.getScene().getWindow().hide();
    		Stage main = new Stage();
	    	
    		try {
				fxml = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
				
				Scene scene = new Scene (fxml);
				main.setScene(scene);
				main.show();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	    }
	    
	    @FXML
	    void ajouterbatiments(MouseEvent event) {
	    	 try {
					fxml = FXMLLoader.load(getClass().getResource("/interfaces/ajoutBatiment.fxml"));
					root.getChildren().removeAll();
					root.getChildren().setAll(fxml);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    }


	    @FXML
	    void listefavoris(MouseEvent event) {
	    	
	    	 try {
					fxml = FXMLLoader.load(getClass().getResource("/interfaces/FavorisUser.fxml"));
					root.getChildren().removeAll();
					root.getChildren().setAll(fxml);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    }

	    @FXML
	    void monument(MouseEvent event) {
	    	
	    	 try {
					fxml = FXMLLoader.load(getClass().getResource("/interfaces/monumentsvilles.fxml"));
					root.getChildren().removeAll();
					root.getChildren().setAll(fxml);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cnx = ConnexionBDD.connexionDB();
		String sql = "SELECT email_utilisateur FROM users_connect WHERE id_utilisateur = (SELECT MAX(id_utilisateur) FROM users_connect)";
		try {
			st = cnx.prepareStatement(sql);
			result = st.executeQuery();
			if(result.next()) {
				lbl_user.setText(result.getString("email_utilisateur"));
			}
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		 try {
			fxml = FXMLLoader.load(getClass().getResource("/interfaces/villes.fxml"));
			root.getChildren().removeAll();
			root.getChildren().setAll(fxml);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
