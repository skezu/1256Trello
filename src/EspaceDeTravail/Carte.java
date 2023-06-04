package EspaceDeTravail;

import java.util.*;

/**
 * Modèle représentant une carte dans l'application.
 */

public class Carte {
	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	Log log = Log.getInstance();
	private Liste saListe;
	private ArrayList<Membre> sesMembres;
	private int numCarte;
	private String titreCarte;
	private String description;
	private String dateDebut;
	private String dateLimite;

	/**
	 * Constructeur pour la création d'une nouvelle carte.
	 *
	 * @param saListe La liste à laquelle la carte appartient.
	 */


	// Constructor 
	public Carte(Liste saListe){
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		titreCarte = "Carte Vide";
		description = "";
		dateDebut = "01/01/2023";
		dateLimite = "28/05/2023";
		log.addActivity("Carte vide créée");
	}
	/**
	 * Constructeur pour la création d'une nouvelle carte avec un titre spécifié.
	 *
	 * @param saListe    La liste à laquelle la carte appartient.
	 * @param titreCarte Le titre de la carte.
	 */

	public Carte(Liste saListe, String titreCarte){
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		this.titreCarte = titreCarte;
		description = "";
		dateDebut = "01/01/2023";
		dateLimite = "28/05/2023";
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" créée");
	}
	/**
	 * Constructeur pour la création d'une carte avec tous les détails spécifiés.
	 *
	 * @param saListe      La liste à laquelle la carte appartient.
	 * @param sesMembres   Les membres associés à la carte.
	 * @param numCarte     Le numéro de la carte.
	 * @param titreCarte   Le titre de la carte.
	 * @param description  La description de la carte.
	 * @param dateDebut    La date de début de la carte.
	 * @param dateLimite   La date limite de la carte.
	 */

	public Carte(Liste saListe,String titreCarte, ArrayList<Membre> sesMembres, int numCarte, String description, String dateDebut, String dateLimite) {
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		this.sesMembres = sesMembres;
		this.numCarte = numCarte;
		this.titreCarte = titreCarte;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateLimite = dateLimite;
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" créée");
	}

	// Getters
	/**
	 * Obtient la liste à laquelle la carte appartient.
	 *
	 * @return La liste à laquelle la carte appartient.
	 */
	public Liste getSaListe() {
		return saListe;
	}
	/**
	 * Obtient les membres associés à la carte.
	 *
	 * @return La liste des membres associés à la carte.
	 */
	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}
	/**
	 * Obtient le numéro de la carte.
	 *
	 * @return Le numéro de la carte.
	 */
	public int getNumCarte() {
		return numCarte;
	}
	/**
	 * Obtient le titre de la carte.
	 *
	 * @return Le titre de la carte.
	 */
	public String getTitreCarte() {
		return titreCarte;
	}
	/**
	 * Obtient la description de la carte.
	 *
	 * @return La description de la carte.
	 */

	public String getDescription() {
		return description;
	}
	/**
	 * Obtient la date de début de la carte.
	 *
	 * @return La date de début de la carte.
	 */

	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * Obtient la date limite de la carte.
	 *
	 * @return La date limite de la carte.
	 */

	public String getDateLimite() {
		return dateLimite;
	}
	
	// Setters

	/**
	 * Définit la liste à laquelle la carte appartient.
	 *
	 * @param saListe La liste à laquelle la carte appartient.
	 */

	public void setSaListe(Liste saListe) {
		this.saListe = saListe;
		log.addActivity("Liste "+saListe.getNomListe()+" ajoutée à la carte "+numCarte+"-"+titreCarte);
	}
	/**
	 * Définit le titre de la carte.
	 *
	 * @param titreCarte Le titre de la carte.
	 */

	public void setTitreCarte(String titreCarte) {
		this.titreCarte = titreCarte;
		log.addActivity("Titre de la Carte "+numCarte+"-"+titreCarte+" renommée");
	}
	/**
	 * Définit la description de la carte.
	 *
	 * @param description La description de la carte.
	 */

	public void setDescription(String description) {
		this.description = description;
		log.addActivity("Description de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}
	/**
	 * Définit la date de début de la carte.
	 *
	 * @param dateDebut La date de début de la carte.
	 */

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
		log.addActivity("Date de début de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}
	/**
	 * Définit la date limite de la carte.
	 *
	 * @param dateLimite La date limite de la carte.
	 */

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
		log.addActivity("Date de fin de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}

	// Methodes
	/**
	 * Ajoute un membre à la carte.
	 *
	 * @param Membre Le membre à ajouter.
	 */

	public void ajouterMembre(Membre Membre) {
		if (!Membre.getSesCartes().contains(this)) {
			this.sesMembres.add(Membre);
			Membre.ajouterCarte(this);
			log.addActivity("Membre "+Membre.getNumMembre()+"-"+Membre.getNomMembre()+" "+Membre.getPrenomMembre()+" ajouté à la carte "+numCarte+"-"+titreCarte);
		}
	}
	/**
	 * Retire un membre de la carte.
	 *
	 * @param Membre Le membre à retirer.
	 */


	public void retirerMembre(Membre Membre){
		if (Membre.getSesCartes().contains(this)) {
			this.sesMembres.remove(Membre);
			Membre.retirerCarte(this);
			log.addActivity("Membre "+Membre.getNumMembre()+"-"+Membre.getNomMembre()+" "+Membre.getPrenomMembre()+" retiré de la carte "+numCarte+"-"+titreCarte);
		}
	}
	/**
	 * Obtient le nombre de membres associés à la carte.
	 *
	 * @return Le nombre de membres associés à la carte.
	 */

	public int nbMembre(){
		//returne le nombre de menbre de la carte
		return sesMembres.size();
	}
	/**
	 * Supprime la carte de tous les endroits où elle se trouve.
	 *
	 * @return `true` si la carte a été supprimée avec succès, sinon il y a eu une erreur pendant l'execution.
	 */
	public boolean supprimer(){
		//supprime la carte de tout les endroit ou elle se trouve
		saListe.retirerCarte(this);
		for (Membre m:sesMembres) {
			m.retirerCarte(this);
		}
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" supprimée");
		return true;
	}

	/**
	 * modifie la liste a laquell apartien la carte
	 *
	 * @param liste la liste qui remplace.
	 */
	public void ajouterListe(Liste liste){
		this.saListe = liste;
		// on suppose que le sens est Liste.ajouterCarte
	}

	// ToString
	/**
	 * Retourne une représentation sous forme de chaîne de caractères de la carte.
	 *
	 * @return Une représentation de la carte sous forme de chaîne de caractères.
	 */

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
