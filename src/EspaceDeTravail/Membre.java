package EspaceDeTravail;

import java.util.*;

public class Membre {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<EspaceTravail> sonEspaceTravail;
	private Tableau sonTableau;
	private ArrayList<Carte> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	// Constructor
	public Membre(EspaceTravail sonEspaceTravail) {
		this.sonEspaceTravail = new ArrayList<EspaceTravail>();
		this.sonEspaceTravail.add(sonEspaceTravail);
		sonTableau = new Tableau(sonEspaceTravail);
		sesCartes = new ArrayList<Carte>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
	}
	public Membre(ArrayList<EspaceTravail> sonEspaceTravail, Tableau sonTableau, ArrayList<Carte> sesCartes, String nomMembre, String prenomMembre, String emailMembre, String imageProfile) {
		this.sonEspaceTravail = sonEspaceTravail;
		this.sonTableau = sonTableau;
		this.sesCartes = sesCartes;
		this.numMembre = compteurNum++;
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.emailMembre = emailMembre;
		this.imageProfile = imageProfile;
	}
	
	// Getter

	public ArrayList<EspaceTravail> getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	public Tableau getSonTableau() {
		return sonTableau;
	}

	public ArrayList<Carte> getSesCartes() {
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

	public void setSonTableau(Tableau sonTableau) {
		this.sonTableau = sonTableau;
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
	public void ajouterEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.add(EspaceTravail);
	}
	public void retirerEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.remove(EspaceTravail);
	}
	public void ajouterCarte(Carte Carte) {
		if (!this.sesCartes.contains(Carte)) {
			this.sesCartes.add(Carte);
			//Carte.ajouterMembre(this);
		}


	}
	public void retirerCarte(Carte Carte) {
		if (this.sesCartes.contains(Carte)) {
		this.sesCartes.remove(Carte);
		//Carte.retirerMembre(this);
	}
	}
	// ToString

	@Override
	public String toString() {
		return "Membre{" +
				"sonEspaceDeTravail=" + sonEspaceTravail +
				", sonTableau=" + sonTableau +
				", sesCartes=" + sesCartes +
				", numMembre=" + numMembre +
				", nomMembre='" + nomMembre + '\'' +
				", prenomMembre='" + prenomMembre + '\'' +
				", emailMembre='" + emailMembre + '\'' +
				", imageProfile='" + imageProfile + '\'' +
				'}';
	}
}
