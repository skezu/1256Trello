package EspaceDeTravail;

import java.util.*;
/**
 * La classe Liste représente une liste dans un tableau.
 */

public class Liste {
	//////////////////////////////////
	//          Attributs           //
	//////////////////////////////////

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	Log log = Log.getInstance();
	private Tableau sonTableau;
	private ArrayList<Carte> sesCartes;
	private int numListe;
	private String nomListe;
	private ArrayList<Membre> sesMenbre;

	//////////////////////////////
	// 		  Constructeur		//
	//////////////////////////////
	/**
	 * Constructeur de la classe ListeModel.
	 *
	 * @param sonTableau Le tableau auquel la liste appartient.
	 */

	public Liste(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
		log.addActivity("Liste vide créée");
	}
	/**
	 * Constructeur de la classe ListeModel avec des paramètres.
	 *
	 * @param sonTableau Le tableau auquel la liste appartient.
	 * @param sesCartes  La liste des cartes de la liste.
	 * @param nomListe   Le nom de la liste.
	 * @param sesMenbre  La liste des membres de la liste.
	 */

	public Liste(Tableau sonTableau, ArrayList<Carte> sesCartes, String nomListe, ArrayList<Membre> sesMenbre) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		this.sesCartes = sesCartes;
		this.sesMenbre = sesMenbre;
		this.numListe = compteurNum++;
		this.nomListe = nomListe;
		log.addActivity("Liste "+numListe+"-"+nomListe+" créée");
	}
	/**
	 * Constructeur de la classe ListeModel avec un nom de liste spécifié.
	 *
	 * @param sonTableau Le tableau auquel la liste appartient.
	 * @param nomListe   Le nom de la liste.
	 */

	public Liste ( Tableau sonTableau,String nomListe){
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		this.nomListe = nomListe;
		log.addActivity("Liste "+numListe+"-"+nomListe+" créée");
	}

	
	/////////////////////////////////
	//  		  Getter		   //
	/////////////////////////////////
	/**
	 * Obtient le tableau auquel la liste appartient.
	 *
	 * @return Le tableau auquel la liste appartient.
	 */

	public Tableau getSonTableau() {
		return sonTableau;
	}
	/**
	 * Obtient la liste des cartes de la liste.
	 *
	 * @return La liste des cartes de la liste.
	 */

	public ArrayList<Carte> getSesCartes() {
		return (sesCartes);
	}
	/**
	 * Obtient le numéro de la liste.
	 *
	 * @return Le numéro de la liste.
	 */

	public int getNumListe() {
		return numListe;
	}
	/**
	 * Obtient le nom de la liste.
	 *
	 * @return Le nom de la liste.
	 */

	public String getNomListe() {
		return nomListe;
	}
	
	// Setter
	/**
	 * Définit le tableau auquel la liste appartient.
	 *
	 * @param sonTableau Le tableau auquel la liste appartient.
	 */
	public void setSonTableau(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		log.addActivity("Tableau contenant la liste modifié");
	}
	/**
	 * Définit le nom de la liste.
	 *
	 * @param nomListe Le nom de la liste.
	 */

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
		log.addActivity("Nom de la Liste "+numListe+"-"+nomListe+" modifiée");
	}
	///////////////////////////////////
	//  		  Methodes		     //
	///////////////////////////////////
	/**
	 * Ajoute un membre à la liste.
	 * Le membre est ajouté à la liste des membres de la liste et à toutes les cartes de la liste.
	 *
	 * @param m Le membre à ajouter.
	 */

	public void ajouterMembre(Membre m){
		if(! this.sesMenbre.contains(m)) {
			this.sesMenbre.add(m);
			for (Carte c : sesCartes) {
				c.ajouterMembre(m);
			}
			m.ajouterListe(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" ajouté à la liste "+numListe+"-"+nomListe);
		}
	}
	/**
	 * Retire un membre de la liste.
	 * Le membre est retiré de la liste des membres de la liste et de toutes les cartes de la liste.
	 *
	 * @param m Le membre à retirer.
	 */

	public void retirerMembre(Membre m){
		if(this.sesMenbre.contains(m)) {
			this.sesMenbre.remove(m);
			for (Carte c : sesCartes) {
				c.retirerMembre(m);
			}
			m.retirerListe(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" retiré de la liste "+numListe+"-"+nomListe);
		}
	}
	/**
	 * Ajoute une carte à la liste.
	 *
	 * @param Carte La carte à ajouter.
	 */

	public void ajouterCarte(Carte Carte) {
		this.sesCartes.add(Carte);
		Carte.ajouterListe(this);
		log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" ajouté à la liste "+numListe+"-"+nomListe);
	}
	/**
	 * Retire une carte de la liste.
	 *
	 * @param Carte La carte à retirer.
	 */

	public void retirerCarte(Carte Carte) {
		this.sesCartes.remove(Carte);
		log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" retiré de la liste "+numListe+"-"+nomListe);

	}
	/**
	 * Obtient le nombre de cartes dans la liste.
	 *
	 * @return Le nombre de cartes dans la liste.
	 */

	public int nbCarte(){
		//returne le nombre de carte dans la liste
		return sesCartes.size();
	}
	/**
	 * Obtient le nombre de membres dans la liste.
	 *
	 * @return Le nombre de membres dans la liste.
	 */

	public int nbMembre(){
		//returne le nombre de menbre de la liste
		return sesMenbre.size();
	}

	/**
	 * Supprime la liste et toutes les cartes associées.
	 * Retire également les membres de la liste.
	 *
	 * @return true si la liste a été supprimée avec succès, sinon erreur lors de l'exécution.
	 */

	public boolean supprimer(){
		//suprime la liste et tout les carte assosier
		sonTableau.retirerListe(this);
		for (Carte c:sesCartes) {
			c.supprimer();
		}
		for (Membre m:sesMenbre) {
			m.retirerListe(this);
		}
		log.addActivity("Liste "+numListe+"-"+nomListe+" supprimée");
		return true;
	}
	// ToString
	/**
	 * Supprime la liste et toutes les cartes associées.
	 * Retire également les membres de la liste.
	 *
	 * @return true si la liste a été supprimée avec succès, false sinon.
	 */

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
