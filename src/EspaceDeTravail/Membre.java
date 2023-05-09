package EspaceDeTravail;

import java.util.*;

public class Membre {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<EspaceDeTravail> sonEspaceDeTravail;
	private Tableau sonTableau;
	private ArrayList<Carte> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	// Constructor
	public Membre() {
		sonEspaceDeTravail = new ArrayList<EspaceDeTravail>();
		sonTableau = new Tableau();
		sesCartes = new ArrayList<Carte>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
	}
	public Membre(ArrayList<EspaceDeTravail> sonEspaceDeTravail, Tableau sonTableau, ArrayList<Carte> sesCartes, String nomMembre, String prenomMembre, String emailMembre, String imageProfile) {
		this.sonEspaceDeTravail = sonEspaceDeTravail;
		this.sonTableau = sonTableau;
		this.sesCartes = sesCartes;
		this.numMembre = compteurNum++;
		this.nomMembre = nomMembre;
		this.prenomMembre = prenomMembre;
		this.emailMembre = emailMembre;
		this.imageProfile = imageProfile;
	}
	
	// Getter

	public ArrayList<EspaceDeTravail> getSonEspaceDeTravail() {
		return sonEspaceDeTravail;
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
	public void ajouterEspaceDeTravail(EspaceDeTravail EspaceDeTravail) {
		this.sonEspaceDeTravail.add(EspaceDeTravail);
	}
	public void retirerEspaceDeTravail(EspaceDeTravail EspaceDeTravail) {
		this.sonEspaceDeTravail.remove(EspaceDeTravail);
	}
	public void ajouterCarte(Carte Carte) {
		this.sesCartes.add(Carte);
	}
}
