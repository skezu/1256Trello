package EspaceDeTravail;

import java.util.*;

public class Visibilite {

	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<EspaceTravail> sonEspaceTravail;
	private ArrayList<Tableau> sesTableau;
	private static int numVisibilite;
	private static String nom;
	
	// Constructeur
	public Visibilite() {
		sonEspaceTravail = new ArrayList<EspaceTravail>();
		sesTableau = new ArrayList<Tableau>();
		numVisibilite = compteurNum++;
		nom = "Public";
	}
	public Visibilite(ArrayList<EspaceTravail> sonEspaceTravail, ArrayList<Tableau> sesTableau, int numVisibilite, String nom) {
		this.sonEspaceTravail = sonEspaceTravail;
		this.sesTableau = sesTableau;
		this.numVisibilite = compteurNum++;
		this.nom = nom;
	}
	
	// Getter


	public ArrayList<EspaceTravail> getSonEspaceDeTravail() {
		return sonEspaceTravail;
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
	public void ajouterEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.add(EspaceTravail);
	}
	public void retirerEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.remove(EspaceTravail);
	}
	public void ajouterTableau(Tableau Tableau) {
		this.sesTableau.add(Tableau);
	}
	public void retirerTableau(Tableau Tableau) {
		this.sesTableau.remove(Tableau);
	}

	// ToString

	@Override
	public String toString() {
		return "Visibilite{" +
				"sonEspaceDeTravail=" + sonEspaceTravail +
				", sesTableau=" + sesTableau +
				'}';
	}
}