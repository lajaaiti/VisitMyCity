package models;

public class monument {
	int id_utilisateur;
	String type_batiment, nom_batiment, adr_batiment, architect_batiment, fenetre_batiment, couleur_batiment, toiture_batiment, charpente_batiment, desc_batiment;

	public monument(){
		
		super();
	}
	
	public monument(String type_batiment, String nom_batiment, String adr_batiment, String architect_batiment, String fenetre_batiment, String couleur_batiment, String toiture_batiment, String charpente_batiment, String desc_batiment, int id_utilisateur) {
		this.type_batiment = type_batiment;
		this.nom_batiment = nom_batiment;
		this.adr_batiment = adr_batiment;
		this.architect_batiment = architect_batiment;
		this.fenetre_batiment = fenetre_batiment;
		this.couleur_batiment = couleur_batiment;
		this.toiture_batiment = toiture_batiment;
		this.charpente_batiment = charpente_batiment;
		this.desc_batiment = desc_batiment;
		this.id_utilisateur = id_utilisateur;
		
		
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getArchitect_batiment() {
		return architect_batiment;
	}

	public void setArchitect_batiment(String architect_batiment) {
		this.architect_batiment = architect_batiment;
	}

	public String getDesc_batiment() {
		return desc_batiment;
	}

	public void setDesc_batiment(String desc_batiment) {
		this.desc_batiment = desc_batiment;
	}

	public String getType_batiment() {
		return type_batiment;
	}

	public void setType_batiment(String type_batiment) {
		this.type_batiment = type_batiment;
	}

	public String getNom_batiment() {
		return nom_batiment;
	}

	public void setNom_batiment(String nom_batiment) {
		this.nom_batiment = nom_batiment;
	}

	public String getAdr_batiment() {
		return adr_batiment;
	}

	public void setAdr_batiment(String adr_batiment) {
		this.adr_batiment = adr_batiment;
	}

	public String getArchitecte_batiment() {
		return architect_batiment;
	}

	public void setArchitecte_batiment(String architecte_batiment) {
		this.architect_batiment = architecte_batiment;
	}

	public String getFenetre_batiment() {
		return fenetre_batiment;
	}

	public void setFenetre_batiment(String fenetre_batiment) {
		this.fenetre_batiment = fenetre_batiment;
	}

	public String getCouleur_batiment() {
		return couleur_batiment;
	}

	public void setCouleur_batiment(String couleur_batiment) {
		this.couleur_batiment = couleur_batiment;
	}

	public String getToiture_batiment() {
		return toiture_batiment;
	}

	public void setToiture_batiment(String toiture_batiment) {
		this.toiture_batiment = toiture_batiment;
	}

	public String getCharpente_batiment() {
		return charpente_batiment;
	}

	public void setCharpente_batiment(String charpente_batiment) {
		this.charpente_batiment = charpente_batiment;
	}
	
	
}
