package EspaceDeTravail;

import java.util.*;

public class Visibilite {

	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<EspaceDeTravail> sonEspaceDeTravail;
	private ArrayList<Tableau> sesTableau;
	private static int numVisibilite;
	private static String nom;
	
	// Constructeur
	public Visibilite() {
		sonEspaceDeTravail = new ArrayList<EspaceDeTravail>();
		sesTableau = new ArrayList<Tableau>();
		numVisibilite = compteurNum++;
		nom = "Public";
	}
	public Visibilite(ArrayList<EspaceDeTravail> sonEspaceDeTravail, ArrayList<Tableau> sesTableau, int numVisibilite, String nom) {
		this.sonEspaceDeTravail = sonEspaceDeTravail;
		this.sesTableau = sesTableau;
		this.numVisibilite = compteurNum++;
		this.nom = nom;
	}
	
	// Getter


	public ArrayList<EspaceDeTravail> getSonEspaceDeTravail() {
		return sonEspaceDeTravail;
	}

	public ArrayList<Tableau> getSesTableau() {
		return sesTableau;
	}

	public static int getNumVisibilite() {
		return numVisibilite;
	}

	public static String getNom() {
		return nom;
	}

	// Setter

	public static void setNom(String nom) {
		Visibilite.nom = nom;
	}

	// Methode
	public void ajouterEspaceDeTravail(EspaceDeTravail EspaceDeTravail) {
		this.sonEspaceDeTravail.add(EspaceDeTravail);
	}
	public void retirerEspaceDeTravail(EspaceDeTravail EspaceDeTravail) {
		this.sonEspaceDeTravail.remove(EspaceDeTravail);
	}
	public void ajouterTableau(Tableau Tableau) {
		this.sesTableau.add(Tableau);
	}
	public void retirerTableau(Tableau Tableau) {
		this.sesTableau.remove(Tableau);
	}
}