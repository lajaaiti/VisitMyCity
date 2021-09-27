package models;

public class Favoris {
		
	int id_utilisateur;
	String nom_batiment, adr_batiment, ville, architec_batiment, desc_batiment;
	
	
	
	public Favoris() {
		super();
	}
	
	public Favoris (int id_utilisateur, String nom_batiment,String adr_batiment,String ville,String architect_batiment,String desc_batiment ) {
		
		this.id_utilisateur = id_utilisateur;
		this.nom_batiment = nom_batiment;
		this.adr_batiment = adr_batiment;
		this.ville = ville;
		this.desc_batiment = desc_batiment;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getArchitec_batiment() {
		return architec_batiment;
	}

	public void setArchitec_batiment(String architec_batiment) {
		this.architec_batiment = architec_batiment;
	}

	public String getDesc_batiment() {
		return desc_batiment;
	}

	public void setDesc_batiment(String desc_batiment) {
		this.desc_batiment = desc_batiment;
	}

	
	

}
