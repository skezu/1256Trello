package Models;

import java.util.*;

public class MembreModel {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<EspaceTravailModel> sesEspaceTravail;
	private ArrayList<EspaceTravailModel> EspaceTravailAutre;
	private ArrayList<TableauModel> sesTableau;
	private ArrayList<ListeModel> sesListe;
	private ArrayList<CarteModel> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	// Constructor
	public MembreModel(EspaceTravailModel sonEspaceTravail) {
		this.EspaceTravailAutre = new ArrayList<EspaceTravailModel>();
		this.sesEspaceTravail =new ArrayList<EspaceTravailModel>();
		this.sesEspaceTravail.add(sonEspaceTravail);
		sesTableau = new ArrayList<TableauModel>();
		sesListe = new ArrayList<ListeModel>();
		sesCartes = new ArrayList<CarteModel>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
		sonEspaceTravail.setSonProprietaire(this);
	}

	// Getter

	public ArrayList<EspaceTravailModel> getSesEspaceDeTravail() {
		return sesEspaceTravail;
	}
	public ArrayList<EspaceTravailModel> getSesAutreEspaceTravail(){ return  EspaceTravailAutre;}
	public ArrayList<TableauModel> getSesTableau() {
		return sesTableau;
	}

	public ArrayList<ListeModel> getSesListe() { return sesListe;}

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

	public EspaceTravailModel creeEspaceDetravail(String nomEspaceDeTravail ){
		EspaceTravailModel e =new EspaceTravailModel();
		e.setSonProprietaire(this);
		e.setNomEspaceDeTravail(nomEspaceDeTravail);
		sesEspaceTravail.add(e);
		return e;
	}
	public EspaceTravailModel creeEspaceDetravail(){
		EspaceTravailModel e =new EspaceTravailModel();
		e.setSonProprietaire(this);
		sesEspaceTravail.add(e);
		return e;
	}

	public boolean detruireEspaceDeTravail(EspaceTravailModel e){
		if (this.sesEspaceTravail.contains(e)){
			e.supprimer();
			sesEspaceTravail.remove(e);
			return true;
		}
		else {
			return false;
		}
	}
	public void ajouterEspaceDeTravail(EspaceTravailModel E) {
		if(!this.EspaceTravailAutre.contains(E)){
			this.EspaceTravailAutre.add(E);
			E.ajouterMembre(this);
		}
	}
	public void retirerEspaceDeTravail(EspaceTravailModel E) {
		if(!this.EspaceTravailAutre.contains(E)) {
			this.EspaceTravailAutre.remove(E);
			E.retirerMembre(this);
		}
	}
	public void ajouterCarte(CarteModel Carte) {
		if (!this.sesCartes.contains(Carte)) {
			this.sesCartes.add(Carte);
			Carte.ajouterMembre(this);
		}


	}
	public void retirerCarte(CarteModel Carte) {
		if (this.sesCartes.contains(Carte)) {
			this.sesCartes.remove(Carte);
			Carte.retirerMembre(this);
		}
	}

	public void ajouterTableau(TableauModel t){
		if (!this.sesTableau.contains(t)){
			this.sesTableau.add(t);
			t.ajouterMembre(this);
		}
	}

	public void retirerTableau(TableauModel t){
		if(this.sesTableau.contains(t)){
			this.sesTableau.remove(t);
			t.retireMembre(this);
		}
	}

	public void ajouterListe(ListeModel l){
		if(!this.sesListe.contains(l)){
			this.sesListe.add(l);
			l.ajouterMembre(this);
		}
	}

	public void retirerListe(ListeModel l){
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

		for (TableauModel t:sesTableau) {
			t.retireMembre(this);
		}
		for (ListeModel l:sesListe) {
			l.retirerMembre(this);
		}
		for (CarteModel c:sesCartes) {
			c.retirerMembre(this);
		}
		for (EspaceTravailModel se:sesEspaceTravail) {
			se.supprimer();
		}
		for (EspaceTravailModel e:EspaceTravailAutre) {
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
