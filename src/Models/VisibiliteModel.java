package Models;

import EspaceDeTravail.Tableau;

import java.util.ArrayList;

public class VisibiliteModel {

	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<EspaceTravailModel> sonEspaceTravailModel;
	private ArrayList<Tableau> sesTableau;
	private static int numVisibilite;
	private static String nom;
	
	// Constructeur
	public VisibiliteModel() {
		sonEspaceTravailModel = new ArrayList<EspaceTravailModel>();
		sesTableau = new ArrayList<Tableau>();
		numVisibilite = compteurNum++;
		nom = "Public";
	}
	public VisibiliteModel(ArrayList<EspaceTravailModel> sonEspaceTravailModel, ArrayList<Tableau> sesTableau, int numVisibilite, String nom) {
		this.sonEspaceTravailModel = sonEspaceTravailModel;
		this.sesTableau = sesTableau;
		this.numVisibilite = compteurNum++;
		this.nom = nom;
	}
	
	// Getter


	public ArrayList<EspaceTravailModel> getSonEspaceDeTravail() {
		return sonEspaceTravailModel;
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
		VisibiliteModel.nom = nom;
	}

	// Methode
	public void ajouterEspaceDeTravail(EspaceTravailModel EspaceTravailModel) {
		this.sonEspaceTravailModel.add(EspaceTravailModel);
	}
	public void retirerEspaceDeTravail(EspaceTravailModel EspaceTravailModel) {
		this.sonEspaceTravailModel.remove(EspaceTravailModel);
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
				"sonEspaceDeTravail=" + sonEspaceTravailModel +
				", sesTableau=" + sesTableau +
				'}';
	}
}