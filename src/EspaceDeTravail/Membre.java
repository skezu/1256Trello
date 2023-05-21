package EspaceDeTravail;

import java.util.*;

public class Membre {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<EspaceTravail> sesEspaceTravail;
	private ArrayList<EspaceTravail> EspaceTravailAutre;
	private ArrayList<Tableau> sesTableau;
	private ArrayList<Liste> sesListe;
	private ArrayList<Carte> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	// Constructor
	public Membre(EspaceTravail sonEspaceTravail) {
		this.EspaceTravailAutre = new ArrayList<EspaceTravail>();
		this.sesEspaceTravail =new ArrayList<EspaceTravail>();
		this.sesEspaceTravail.add(sonEspaceTravail);
		sesTableau = new ArrayList<Tableau>();
		sesListe = new ArrayList<Liste>();
		sesCartes = new ArrayList<Carte>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
		sonEspaceTravail.setSonProprietaire(this);
	}

	// Getter

	public ArrayList<EspaceTravail> getSesEspaceDeTravail() {
		return sesEspaceTravail;
	}
	public ArrayList<EspaceTravail> getSesAutreEspaceTravail(){ return  EspaceTravailAutre;}
	public ArrayList<Tableau> getSesTableau() {
		return sesTableau;
	}

	public ArrayList<Liste> getSesListe() { return sesListe;}

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

	public EspaceTravail creeEspaceDetravail(String nomEspaceDeTravail ){
		EspaceTravail e =new EspaceTravail();
		e.setSonProprietaire(this);
		e.setNomEspaceDeTravail(nomEspaceDeTravail);
		sesEspaceTravail.add(e);
		return e;
	}
	public EspaceTravail creeEspaceDetravail(){
		EspaceTravail e =new EspaceTravail();
		e.setSonProprietaire(this);
		sesEspaceTravail.add(e);
		return e;
	}

	public boolean detruireEspaceDeTravail(EspaceTravail e){
		if (this.sesEspaceTravail.contains(e)){
			e.supprimer();
			sesEspaceTravail.remove(e);
			return true;
		}
		else {
			return false;
		}
	}
	public void ajouterEspaceDeTravail(EspaceTravail E) {
		if(!this.EspaceTravailAutre.contains(E)){
			this.EspaceTravailAutre.add(E);
			E.ajouterMembre(this);
		}
	}
	public void retirerEspaceDeTravail(EspaceTravail E) {
		if(!this.EspaceTravailAutre.contains(E)) {
			this.EspaceTravailAutre.remove(E);
			E.retirerMembre(this);
		}
	}
	public void ajouterCarte(Carte Carte) {
		if (!this.sesCartes.contains(Carte)) {
			this.sesCartes.add(Carte);
			Carte.ajouterMembre(this);
		}


	}
	public void retirerCarte(Carte Carte) {
		if (this.sesCartes.contains(Carte)) {
			this.sesCartes.remove(Carte);
			Carte.retirerMembre(this);
		}
	}

	public void ajouterTableau(Tableau t){
		if (!this.sesTableau.contains(t)){
			this.sesTableau.add(t);
			t.ajouterMembre(this);
		}
	}

	public void retirerTableau(Tableau t){
		if(this.sesTableau.contains(t)){
			this.sesTableau.remove(t);
			t.retireMembre(this);
		}
	}

	public void ajouterListe(Liste l){
		if(!this.sesListe.contains(l)){
			this.sesListe.add(l);
			l.ajouterMembre(this);
		}
	}

	public void retirerListe(Liste l){
		if (this.sesListe.contains(l)){
			this.sesListe.remove(l);
			l.retirerMembre(this);
		}
	}

	public int nbAutreEspaceTravail(){
		//retourne le nombre d'espace de travail autre que le sien
		return EspaceTravailAutre.size();
	}

	public int nbTableau(){
		//retourne le nombre de tableau
		return sesTableau.size();
	}
	public int nbListe(){
		//retoune le nombre de liste
		return sesListe.size();
	}

	public int nbCarte(){
		//retourne le nombre de carte
		return sesCartes.size();
	}
	public int nbEspaceDetravail(){
		//retourne son nombre d'espace de travail qui lui appartienne
		return sesEspaceTravail.size();
	}

	public boolean supprimer(){

		for (Tableau t:sesTableau) {
			t.retireMembre(this);
		}
		for (Liste l:sesListe) {
			l.retirerMembre(this);
		}
		for (Carte c:sesCartes) {
			c.retirerMembre(this);
		}
		for (EspaceTravail se:sesEspaceTravail) {
			se.supprimer();
		}
		for (EspaceTravail e:EspaceTravailAutre) {
			e.retirerMembre(this);
		}
		return true;
	}

	// ToString
		@Override
	public String toString() {
		return "Membre\n{\n" +
				"\t-  nombre d'espace de travail = " + this.nbEspaceDetravail() +"\n"+
				"\t-  son nombre d'autre espace de travail = " + this.nbAutreEspaceTravail() +"\n"+
				"\t-  son nombre de tableau = " + this.nbTableau() +"\n"+
				"\t-  son nombre de liste = " + this.nbListe() +"\n"+
				"\t-  son nombre de carte = " + this.nbCarte() +"\n"+
				"\t-  numMembre = " + numMembre +"\n"+
				"\t-  nomMembre = " + nomMembre + "\n"+
				"\t-  prenomMembre = " + prenomMembre +"\n"+
				"\t-  emailMembre = " + emailMembre + "\n"+
				"\t-  imageProfile = " + imageProfile + "\n"+
				'}';
	}
}
