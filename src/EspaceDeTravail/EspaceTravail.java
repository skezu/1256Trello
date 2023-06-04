package EspaceDeTravail;

import java.util.*;
/**
 * Modèle représentant un espace de travail.
 */

public class EspaceTravail {
	//////////////////////////
	//        Attributs     //
	//////////////////////////

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	Log log = Log.getInstance();
	private ArrayList<Tableau> sesTableaux;
	private ArrayList<Membre> sesMembres;
	private Membre sonProprietaire;
	private Visibilite saVisibilité;
	private int numEspaceDeTravail;
	private String nomEspaceDeTravail;
	private String logoEspaceDeTravail;

	////////////////////////////
	//		 Constructeur	  //
	////////////////////////////
	/**
	 * Constructeur par défaut de la classe EspaceTravailModel.
	 * Initialise les attributs avec des valeurs par défaut.
	 */

	public EspaceTravail() {
		sesTableaux = new ArrayList<Tableau>();
		sesMembres = new ArrayList<Membre>();
		saVisibilité = new Visibilite();
		numEspaceDeTravail = compteurNum++;
		nomEspaceDeTravail = "Espace de";
		logoEspaceDeTravail = "";
		sonProprietaire = null;
		log.addActivity("Espace de Travail vide créé");
	}
	/**
	 * Constructeur de la classe EspaceTravailModel.
	 *
	 * @param sesTableaux         Les tableaux associés à l'espace de travail.
	 * @param sesMembres          Les membres associés à l'espace de travail.
	 * @param saVisibilité        La visibilité de l'espace de travail.
	 * @param nomEspaceDeTravail  Le nom de l'espace de travail.
	 * @param logoEspaceDeTravail Le logo de l'espace de travail.
	 */

	public EspaceTravail(ArrayList<Tableau> sesTableaux, ArrayList<Membre> sesMembres, Visibilite saVisibilité, String nomEspaceDeTravail, String logoEspaceDeTravail) {
		this.sesTableaux = sesTableaux;
		this.sesMembres = sesMembres;
		this.saVisibilité = saVisibilité;
		this.numEspaceDeTravail = compteurNum++;
		this.nomEspaceDeTravail = nomEspaceDeTravail;
		this.logoEspaceDeTravail = logoEspaceDeTravail;
		log.addActivity("Espace de Travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" créé");
	}
	
	/////////////////////////////
	// 			Getters		   //
	/////////////////////////////
	/**
	 * Obtient le propriétaire de l'espace de travail.
	 *
	 * @return Le propriétaire de l'espace de travail.
	 */

	public Membre getSonProprietaire() {
		return sonProprietaire;
	}
	/**
	 * Définit le propriétaire de l'espace de travail.
	 *
	 * @param m Le propriétaire de l'espace de travail.
	 */

	public void setSonProprietaire(Membre m){
		sonProprietaire= m;
		sesMembres.add(m);
		log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" ajouté dans l'espace de travail"+numEspaceDeTravail+"-"+nomEspaceDeTravail);
	}
	/**
	 * Obtient les tableaux associés à l'espace de travail.
	 *
	 * @return Les tableaux associés à l'espace de travail.
	 */

	public ArrayList<Tableau> getSesTableaux() {
		return sesTableaux;
	}
	/**
	 * Obtient les membres associés à l'espace de travail.
	 *
	 * @return Les membres associés à l'espace de travail.
	 */

	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}
	/**
	 * Obtient la visibilité de l'espace de travail.
	 *
	 * @return La visibilité de l'espace de travail.
	 */

	public Visibilite getSaVisibilité() {
		return saVisibilité;
	}
	/**
	 * Obtient le numéro de l'espace de travail.
	 *
	 * @return Le numéro de l'espace de travail.
	 */

	public int getNumEspaceDeTravail() {
		return numEspaceDeTravail;
	}
	/**
	 * Obtient le nom de l'espace de travail.
	 *
	 * @return Le nom de l'espace de travail.
	 */

	public String getNomEspaceDeTravail() {
		return nomEspaceDeTravail;
	}
	/**
	 * Obtient le logo de l'espace de travail.
	 *
	 * @return Le logo de l'espace de travail.
	 */

	public String getLogoEspaceDeTravail() {
		return logoEspaceDeTravail;
	}
	
	// Setters
	/**
	 * Définit la visibilité de l'espace de travail.
	 *
	 * @param saVisibilité La visibilité de l'espace de travail.
	 */
	public void setSaVisibilité(Visibilite saVisibilité) {
		this.saVisibilité = saVisibilité;
	}
	/**
	 * Définit le nom de l'espace de travail.
	 *
	 * @param nomEspaceDeTravail Le nom de l'espace de travail.
	 */

	public void setNomEspaceDeTravail(String nomEspaceDeTravail) {
		this.nomEspaceDeTravail = nomEspaceDeTravail;
		log.addActivity("Nom de l'Espace de Travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" modifie");
	}
	/**
	 * Définit le logo de l'espace de travail.
	 *
	 * @param logoEspaceDeTravail Le logo de l'espace de travail.
	 */

	public void setLogoEspaceDeTravail(String logoEspaceDeTravail) {
		this.logoEspaceDeTravail = logoEspaceDeTravail;
		log.addActivity("Logo de l'Espace de Travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" modifie");
	}

	// Methodes

	// Ajouter un tableau
	/**
	 * Ajoute un tableau à l'espace de travail.
	 *
	 * @param Tableau Le tableau à ajouter.
	 */

	public void ajouterTableau(Tableau Tableau) {
		this.sesTableaux.add(Tableau);
	}
	// Retirer un tableau
	/**
	 * Retire un tableau de l'espace de travail.
	 *
	 * @param Tableau Le tableau à retirer.
	 */

	public void retirerTableau(Tableau Tableau) {
		this.sesTableaux.remove(Tableau);
	}
	// Ajouter un membre
	/**
	 * Ajoute un membre à l'espace de travail.
	 *
	 * @param m Le membre à ajouter.
	 */

	public void ajouterMembre(Membre m){
		if(!this.sesMembres.contains(m)) {
			sesMembres.add(m);
			for (Tableau t : sesTableaux) {
				t.ajouterMembre(m);
			}
			m.ajouterEspaceDeTravail(this);
		}
		
	}
	/**
	 * Retire un membre de l'espace de travail.
	 *
	 * @param m Le membre à retirer.
	 */

	public void retirerMembre(Membre m){
		if(this.sesMembres.contains(m)) {
			sesMembres.remove(m);
			for (Tableau t : sesTableaux) {
				t.retireMembre(m);
			}
			m.retirerEspaceDeTravail(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" retiré de l'espace de travail"+numEspaceDeTravail+"-"+nomEspaceDeTravail);
		}
	}
	/**
	 * Obtient le nombre de tableaux dans l'espace de travail.
	 *
	 * @return Le nombre de tableaux.
	 */

	public int nbTableau(){
		//retourne le nombre de tableau
		return sesTableaux.size();
	}
	/**
	 * Obtient le nombre de membres dans l'espace de travail.
	 *
	 * @return Le nombre de membres.
	 */

	public int nbMembre(){
		//retourne le nombre de menbre
		return sesMembres.size();
	}
	/**
	 * Supprime l'espace de travail.
	 * Supprime également tous les tableaux associés et retire les membres de l'espace de travail.
	 *
	 * @return true si l'espace de travail a été supprimé avec succès, sinon erreur lors de l'execution.
	 */
	public  boolean supprimer(){
		for (Tableau t:sesTableaux) {
			t.supprimer();
		}
		for (Membre m:sesMembres) {
			if(m!=sonProprietaire) {
				//car sinon on ne peut pas retire l'espace de travail car il ne fait pas partie de l'ArrayList
				m.retirerEspaceDeTravail(this);
			}
		}
		log.addActivity("Espace de travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" supprimé");
		return true;
	}

	// ToString
	/**
	 * Retourne une représentation sous forme de chaîne de caractères de l'espace de travail.
	 *
	 * @return La représentation de l'espace de travail.
	 */

	@Override
	public String toString() {
		return "EspaceDeTravail\n{\n" +
				"\t-  nombre de tableau = " + this.nbTableau() +"\n"+
				"\t-  nombre de membre = " + this.nbMembre() +"\n"+
				"\t-  saVisibilité = " + saVisibilité +"\n"+
				"\t-  numEspaceDeTravail = " + numEspaceDeTravail +"\n"+
				"\t-  nomEspaceDeTravail = " + nomEspaceDeTravail + '\n' +
				"\t-  logoEspaceDeTravail = " + logoEspaceDeTravail + '\n' +
				'}';
	}
}
