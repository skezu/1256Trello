package EspaceDeTravail;

import java.util.*;
/**
 * La classe VisibiliteModel représente le modèle de visibilité d'un espace de travail ou d'un tableau.
 * Elle permet de gérer les espaces de travail et les tableaux associés à une visibilité.
 */

public class Visibilite {

	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<EspaceTravail> sonEspaceTravail;
	private ArrayList<Tableau> sesTableau;
	private static int numVisibilite;
	private static String nom;
	
	// Constructeur
	/**
	 * Constructeur par défaut de la classe Visibilite.
	 * Il crée une visibilité publique par défaut.
	 */

	public Visibilite() {
		sonEspaceTravail = new ArrayList<EspaceTravail>();
		sesTableau = new ArrayList<Tableau>();
		numVisibilite = compteurNum++;
		nom = "Public";
	}
	/**
	 * Constructeur de la classe Visibilite.
	 * Permet de créer une visibilité avec les espaces de travail et les tableaux spécifiés.
	 *
	 * @param sonEspaceTravail La liste des espaces de travail associés à la visibilité.
	 * @param sesTableau            La liste des tableaux associés à la visibilité.
	 * @param numVisibilite         Le numéro de visibilité.
	 * @param nom                   Le nom de la visibilité.
	 */

	public Visibilite(ArrayList<EspaceTravail> sonEspaceTravail, ArrayList<Tableau> sesTableau, int numVisibilite, String nom) {
		this.sonEspaceTravail = sonEspaceTravail;
		this.sesTableau = sesTableau;
		this.numVisibilite = compteurNum++;
		this.nom = nom;
	}
	
	// Getter

	/**
	 * Obtient la liste des espaces de travail associés à la visibilité.
	 *
	 * @return La liste des espaces de travail.
	 */

	public ArrayList<EspaceTravail> getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}
	/**
	 * Obtient la liste des tableaux associés à la visibilité.
	 *
	 * @return La liste des tableaux.
	 */

	public ArrayList<Tableau> getSesTableau() {
		return sesTableau;
	}
	/**
	 * Obtient le numéro de visibilité.
	 *
	 * @return Le numéro de visibilité.
	 */

	public static int getNumVisibilite() {
		return numVisibilite;
	}
	/**
	 * Obtient le nom de la visibilité.
	 *
	 * @return Le nom de la visibilité.
	 */

	public static String getNom() {
		return nom;
	}

	// Setter
	/**
	 * Modifie le nom de la visibilité.
	 *
	 * @param nom Le nouveau nom de la visibilité.
	 */

	public static void setNom(String nom) {
		Visibilite.nom = nom;
	}

	// Methode
	/**
	 * Ajoute un espace de travail à la visibilité.
	 *
	 * @param EspaceTravail L'espace de travail à ajouter.
	 */

	public void ajouterEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.add(EspaceTravail);
	}
	/**
	 * Retire un espace de travail de la visibilité.
	 *
	 * @param EspaceTravail L'espace de travail à retirer.
	 */

	public void retirerEspaceDeTravail(EspaceTravail EspaceTravail) {
		this.sonEspaceTravail.remove(EspaceTravail);
	}
	/**
	 * Ajoute un tableau à la visibilité.
	 *
	 * @param Tableau Le tableau à ajouter.
	 */

	public void ajouterTableau(Tableau Tableau) {
		this.sesTableau.add(Tableau);
	}
	/**
	 * Retire un tableau de la visibilité.
	 *
	 * @param Tableau Le tableau à retirer.
	 */

	public void retirerTableau(Tableau Tableau) {
		this.sesTableau.remove(Tableau);
	}

	// ToString
	/**
	 * Retourne une représentation sous forme de chaîne de caractères de la visibilité.
	 *
	 * @return La représentation de la visibilité.
	 */

	@Override
	public String toString() {
		return "Visibilite{" +
				"sonEspaceDeTravail=" + sonEspaceTravail +
				", sesTableau=" + sesTableau +
				'}';
	}
}