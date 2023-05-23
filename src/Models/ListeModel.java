package Models;

import java.util.*;

public class ListeModel {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private TableauModel sonTableau;
	private ArrayList<CarteModel> sesCartes;
	private int numListe;
	private String nomListe;
	private ArrayList<MembreModel> sesMenbre;

	// Constructeur
	public ListeModel(TableauModel sonTableau) {
		this.sonTableau = sonTableau;
		sesCartes = new ArrayList<CarteModel>();
		sesMenbre= new ArrayList<MembreModel>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
	}
	public ListeModel(TableauModel sonTableau, ArrayList<CarteModel> sesCartes, String nomListe, ArrayList<MembreModel> sesMenbre) {
		this.sonTableau = sonTableau;
		this.sesCartes = sesCartes;
		this.sesMenbre = sesMenbre;
		this.numListe = compteurNum++;
		this.nomListe = nomListe;
	}

	public ListeModel ( TableauModel sonTableau,String nomListe){
		this.sonTableau = sonTableau;
		sesCartes = new ArrayList<CarteModel>();
		sesMenbre= new ArrayList<MembreModel>();
		numListe = compteurNum++;
		this.nomListe = nomListe;
	}


	// Getter

	public TableauModel getSonTableau() {
		return sonTableau;
	}

	public ArrayList<CarteModel> getSesCartes() {
		return sesCartes;
	}

	public int getNumListe() {
		return numListe;
	}

	public String getNomListe() {
		return nomListe;
	}

	// Setter

	public void setSonTableau(TableauModel sonTableau) {
		this.sonTableau = sonTableau;
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
	}

	public void ajouterMembre(MembreModel m){
		if(! this.sesMenbre.contains(m)) {
			this.sesMenbre.add(m);
			for (CarteModel c : sesCartes) {
				c.ajouterMembre(m);
			}
			m.ajouterListe(this);
		}
	}

	public void retirerMembre(MembreModel m){
		if(this.sesMenbre.contains(m)) {
			this.sesMenbre.remove(m);
			for (CarteModel c : sesCartes) {
				c.retirerMembre(m);
			}
			m.retirerListe(this);
		}
	}

	// Methode
	public void ajouterCarte(CarteModel Carte) {
		this.sesCartes.add(Carte);
	}
	public void retirerCarte(CarteModel Carte) {
		this.sesCartes.remove(Carte);
	}

	public int nbCarte(){
		//returne le nombre de carte dans la liste
		return sesCartes.size();
	}

	public int nbMembre(){
		//returne le nombre de menbre de la liste
		return sesMenbre.size();
	}


	public boolean supprimer(){
		//suprime la liste et tout les carte assosier
		sonTableau.retirerListe(this);
		for (CarteModel c:sesCartes) {
			c.supprimer();
		}
		for (MembreModel m:sesMenbre) {
			m.retirerListe(this);
		}

		return true;
	}
	// ToString
	@Override
	public String toString() {
		return "Liste\n{\n" +
				"\t-  sonTableau = " + sonTableau.getNomTableau() +"\n"+
				"\t-  nombre de carte = " + this.nbCarte() +"\n"+
				"\t-  numListe = " + numListe +"\n"+
				"\t-  nomListe = " + nomListe + '\n' +
				'}';
	}
}
