package models;

public class Users {
	
	String nom_utilisateur, prenom_utilisateur, email_utilisateur, ville_utilisateur, tel_utilisateur, pass_utilisateur;
	
	public Users() {
		super();
		
	}
	public Users (String nom_utilisateur, String prenom_utilisateur, String email_utilisateur, String ville_utilisateur, String tel_utilisateur, String pass_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
		this.prenom_utilisateur = prenom_utilisateur;
		this.email_utilisateur = email_utilisateur;
		this.ville_utilisateur = ville_utilisateur;
		this.tel_utilisateur = tel_utilisateur;
		this.pass_utilisateur = pass_utilisateur;
	}
	public String getNom_utilisateur() {
		return nom_utilisateur;
	}
	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}
	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}
	public String getEmail_utilisateur() {
		return email_utilisateur;
	}
	public void setEmail_utilisateur(String email_utilisateur) {
		this.email_utilisateur = email_utilisateur;
	}
	public String getVille_utilisateur() {
		return ville_utilisateur;
	}
	public void setVille_utilisateur(String ville_utilisateur) {
		this.ville_utilisateur = ville_utilisateur;
	}
	public String getTel_utilisateur() {
		return tel_utilisateur;
	}
	public void setTel_utilisateur(String tel_utilisateur) {
		this.tel_utilisateur = tel_utilisateur;
	}
	public String getPass_utilisateur() {
		return pass_utilisateur;
	}
	public void setPass_utilisateur(String pass_utilisateur) {
		this.pass_utilisateur = pass_utilisateur;
	}
	
}
