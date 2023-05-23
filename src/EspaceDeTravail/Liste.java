package EspaceDeTravail;

import java.util.*;

public class Liste {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private Tableau sonTableau;
	private ArrayList<Carte> sesCartes;
	private int numListe;
	private String nomListe;
	private ArrayList<Membre> sesMenbre;

	// Constructeur
	public Liste(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
	}
	public Liste(Tableau sonTableau, ArrayList<Carte> sesCartes, String nomListe, ArrayList<Membre> sesMenbre) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		this.sesCartes = sesCartes;
		this.sesMenbre = sesMenbre;
		this.numListe = compteurNum++;
		this.nomListe = nomListe;
	}

	public Liste ( Tableau sonTableau,String nomListe){
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		this.nomListe = nomListe;
	}

	
	// Getter

	public Tableau getSonTableau() {
		return sonTableau;
	}

	public ArrayList<Carte> getSesCartes() {
		return sesCartes;
	}

	public int getNumListe() {
		return numListe;
	}

	public String getNomListe() {
		return nomListe;
	}
	
	// Setter

	public void setSonTableau(Tableau sonTableau) {
		this.sonTableau = sonTableau;
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
	}

	public void ajouterMembre(Membre m){
		if(! this.sesMenbre.contains(m)) {
			this.sesMenbre.add(m);
			for (Carte c : sesCartes) {
				c.ajouterMembre(m);
			}
			m.ajouterListe(this);
		}
	}

	public void retirerMembre(Membre m){
		if(this.sesMenbre.contains(m)) {
			this.sesMenbre.remove(m);
			for (Carte c : sesCartes) {
				c.retirerMembre(m);
			}
			m.retirerListe(this);
		}
	}

	// Methode
	public void ajouterCarte(Carte Carte) {
		this.sesCartes.add(Carte);
	}
	public void retirerCarte(Carte Carte) {
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
		for (Carte c:sesCartes) {
			c.supprimer();
		}
		for (Membre m:sesMenbre) {
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
