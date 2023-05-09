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
	public Carte(){
		saListe = new Liste();
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		titreCarte = "Nouvelle Carte";
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
		sesMembres.add(Membre);
	}
}
