package EspaceDeTravail;

import java.util.*;

public class Carte {
	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private Liste saListe;
	private ArrayList<Membre> sesMembres;
	private int numCarte;
	private String titreCarte;
	private String description;
	private String dateDebut;
	private String dateLimite;
	
	// Constructor 
	public Carte(Liste saListe){
		this.saListe = saListe;
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		titreCarte = "Nouvelle Carte";
		description = "";
		dateDebut = "";
		dateLimite = "";
	}
	public Carte(Liste saListe, String titreCarte){
		this.saListe = saListe;
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		this.titreCarte = titreCarte;
		description = "";
		dateDebut = "";
		dateLimite = "";
	}
	public Carte(Liste saListe, ArrayList<Membre> sesMembres, int numCarte, String titreCarte, String description, String dateDebut, String dateLimite) {
		this.saListe = saListe;
		this.sesMembres = sesMembres;
		this.numCarte = numCarte;
		this.titreCarte = titreCarte;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateLimite = dateLimite;
	}

	// Getters 


	public Liste getSaListe() {
		return saListe;
	}

	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}

	public int getNumCarte() {
		return numCarte;
	}

	public String getTitreCarte() {
		return titreCarte;
	}

	public String getDescription() {
		return description;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public String getDateLimite() {
		return dateLimite;
	}
	
	// Setters


	public void setSaListe(Liste saListe) {
		this.saListe = saListe;
	}

	public void setTitreCarte(String titreCarte) {
		this.titreCarte = titreCarte;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
	}

	// Methodes
	public void ajouterMembre(Membre Membre) {
		if (!Membre.getSesCartes().contains(this)) {
			this.sesMembres.add(Membre);
			Membre.ajouterCarte(this);
		}
	}
	public void retirerMembre(Membre Membre){
		if (Membre.getSesCartes().contains(this)) {
			this.sesMembres.remove(Membre);
			Membre.retirerCarte(this);
		}
	}
	public int nbMembre(){
		//returne le nombre de menbre de la carte
		return sesMembres.size();
	}


	public boolean supprimer(){
		//supprime la carte de tout les endroit ou elle se trouve
		saListe.retirerCarte(this);
		for (Membre m:sesMembres) {
			m.retirerCarte(this);
		}
		return true;
	}

	// ToString
	@Override
	public String toString() {
		return "Carte\n{\n" +
				"\t-  saListe = " + saListe.getNomListe() +"\n"+
				"\t-   nombre de membre = " + this.nbMembre() +"\n"+
				"\t-   numCarte = " + numCarte +"\n"+
				"\t-   titreCarte = " + titreCarte + '\n' +
				"\t-   description =" + description + '\n' +
				"\t-   dateDebut = " + dateDebut + '\n' +
				"\t-   dateLimite = " + dateLimite + '\n' +
				'}';
	}
}
