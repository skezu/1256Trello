package Models;

import java.util.ArrayList;

public class ListeModel {

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private TableauModel sonTableauModel;
	private ArrayList<CarteModel> sesCartes;
	private int numListe;
	private String nomListe;

	// Constructeur
	public ListeModel(TableauModel sonTableauModel) {
		this.sonTableauModel = sonTableauModel;
		sesCartes = new ArrayList<CarteModel>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
	}
	public ListeModel(TableauModel sonTableauModel, ArrayList<CarteModel> sesCartes, String nomListe) {
		this.sonTableauModel = sonTableauModel;
		this.sesCartes = sesCartes;
		this.numListe = compteurNum++;
		this.nomListe = nomListe;
	}
	
	// Getter

	public TableauModel getSonTableau() {
		return sonTableauModel;
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

	public void setSonTableau(TableauModel sonTableauModel) {
		this.sonTableauModel = sonTableauModel;
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
	}

	// Methode
	public void ajouterCarte(CarteModel CarteModel) {
		this.sesCartes.add(CarteModel);
	}
	public void retirerCarte(CarteModel CarteModel) {
		this.sesCartes.remove(CarteModel);
	}

	// ToString

	@Override
	public String toString() {
		return "Liste{" +
				"sonTableau=" + sonTableauModel +
				", sesCartes=" + sesCartes +
				", numListe=" + numListe +
				", nomListe='" + nomListe + '\'' +
				'}';
	}
}
