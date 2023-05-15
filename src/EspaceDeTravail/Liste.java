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

	// Constructeur
	public Liste(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		sesCartes = new ArrayList<Carte>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
	}
	public Liste(Tableau sonTableau, ArrayList<Carte> sesCartes, String nomListe) {
		this.sonTableau = sonTableau;
		this.sesCartes = sesCartes;
		this.numListe = compteurNum++;
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

	// Methode
	public void ajouterCarte(Carte Carte) {
		this.sesCartes.add(Carte);
	}
	public void retirerCarte(Carte Carte) {
		this.sesCartes.remove(Carte);
	}

	// ToString

	@Override
	public String toString() {
		return "Liste{" +
				"sonTableau=" + sonTableau +
				", sesCartes=" + sesCartes +
				", numListe=" + numListe +
				", nomListe='" + nomListe + '\'' +
				'}';
	}
}
