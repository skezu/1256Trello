package Models;

import java.util.ArrayList;

public class MembreModel {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<EspaceTravailModel> sonEspaceTravail;
	private TableauModel sonTableauModel;
	private ArrayList<CarteModel> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	// Constructor
	public MembreModel(EspaceTravailModel sonEspaceTravail) {
		this.sonEspaceTravail = new ArrayList<EspaceTravailModel>();
		this.sonEspaceTravail.add(sonEspaceTravail);
		sonTableauModel = new TableauModel(sonEspaceTravail);
		sesCartes = new ArrayList<CarteModel>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
	}
	public MembreModel(ArrayList<EspaceTravailModel> sonEspaceTravail, TableauModel sonTableauModel, ArrayList<CarteModel> sesCartes, String nomMembre, String prenomMembre, String emailMembre, String imageProfile) {
		this.sonEspaceTravail = sonEspaceTravail;
		this.sonTableauModel = sonTableauModel;
		this.sesCartes = sesCartes;
		this.numMembre = compteurNum++;
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.emailMembre = emailMembre;
		this.imageProfile = imageProfile;
	}
	
	// Getter

	public ArrayList<EspaceTravailModel> getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	public TableauModel getSonTableau() {
		return sonTableauModel;
	}

	public ArrayList<CarteModel> getSesCartes() {
		return sesCartes;
	}

	public int getNumMembre() {
		return numMembre;
	}

	public String getNomMembre() {
		return nomMembre;
	}

	public String getPrenomMembre() {
		return prenomMembre;
	}

	public String getEmailMembre() {
		return emailMembre;
	}

	public String getImageProfile() {
		return imageProfile;
	}
	
	// Setter

	public void setSonTableau(TableauModel sonTableauModel) {
		this.sonTableauModel = sonTableauModel;
	}

	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
	}

	public void setPrenomMembre(String prenomMembre) {
		this.prenomMembre = prenomMembre;
	}

	public void setEmailMembre(String emailMembre) {
		this.emailMembre = emailMembre;
	}

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
	}

	// Methodes
	public void ajouterEspaceDeTravail(EspaceTravailModel EspaceTravailModel) {
		this.sonEspaceTravail.add(EspaceTravailModel);
	}
	public void retirerEspaceDeTravail(EspaceTravailModel EspaceTravailModel) {
		this.sonEspaceTravail.remove(EspaceTravailModel);
	}
	public void ajouterCarte(CarteModel CarteModel) {
		if (!this.sesCartes.contains(CarteModel)) {
			this.sesCartes.add(CarteModel);
			//CarteModel.ajouterMembre(this);
		}


	}
	public void retirerCarte(CarteModel CarteModel) {
		if (this.sesCartes.contains(CarteModel)) {
		this.sesCartes.remove(CarteModel);
		//CarteModel.retirerMembre(this);
	}
	}
	// ToString

	@Override
	public String toString() {
		return "Membre{" +
				"sonEspaceDeTravail=" + sonEspaceTravail +
				", sonTableau=" + sonTableauModel +
				", sesCartes=" + sesCartes +
				", numMembre=" + numMembre +
				", nomMembre='" + nomMembre + '\'' +
				", prenomMembre='" + prenomMembre + '\'' +
				", emailMembre='" + emailMembre + '\'' +
				", imageProfile='" + imageProfile + '\'' +
				'}';
	}
}
