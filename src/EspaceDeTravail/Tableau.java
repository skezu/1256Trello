package EspaceDeTravail;

import java.util.*;
/**
 * Cette classe représente un tableau dans un système de gestion de tâches.
 */

public class Tableau {
	///////////////////////////////
	// 		Attribut de classe	 //
	///////////////////////////////
	private static int compteurNum = 0;
	
	// Attribut d'instance
	Log log = Log.getInstance();
	private ArrayList<Liste> sesListes;
	private EspaceTravail sonEspaceTravail;
	private ArrayList<Membre> sesMembres;
	private Visibilite saVisibilite;
	private int numTableau;
	private String nomTableau;
	private String categorieTableau;
	private String imageTableau;
	
	/////////////////////////////
	// 		Constructeur	   //
	/////////////////////////////
	/**
	 * Constructeur de la classe TableauModel.
	 * @param sonEspaceTravail L'espace de travail auquel le tableau est associé.
	 */

	public Tableau(EspaceTravail sonEspaceTravail) {
		sesListes = new ArrayList<Liste>();
		sesMembres = new ArrayList<Membre>();
		this.sonEspaceTravail = sonEspaceTravail;
		sonEspaceTravail.ajouterTableau(this);
		saVisibilite = new Visibilite();
		numTableau = compteurNum++;
		nomTableau = "Nouveau Tableau";
		categorieTableau = "";
		imageTableau = "";
		log.addActivity("Tableau vide créé");
	}

	/**
	 * Constructeur de la classe TableauModel.
	 * @param sesListes La liste des listes du tableau.
	 * @param sonEspaceTravail L'espace de travail auquel le tableau est associé.
	 * @param sesMembres La liste des membres associés au tableau.
	 * @param saVisibilite La visibilité du tableau.
	 * @param nomTableau Le nom du tableau.
	 * @param categorieTableau La catégorie du tableau.
	 * @param imageTableau L'image du tableau.
	 */

	public Tableau(ArrayList<Liste> sesListes, EspaceTravail sonEspaceTravail, ArrayList<Membre> sesMembres, Visibilite saVisibilite, String nomTableau, String categorieTableau, String imageTableau) {
		this.sesListes = sesListes;
		this.sonEspaceTravail = sonEspaceTravail;
		sonEspaceTravail.ajouterTableau(this);
		this.sesMembres = sesMembres;
		this.saVisibilite = saVisibilite;
		this.numTableau = compteurNum++;
		this.nomTableau = nomTableau;
		this.categorieTableau = categorieTableau;
		this.imageTableau = imageTableau;
		log.addActivity("Tableau "+numTableau+"-"+nomTableau+" créé");
	}
	
	///////////////////////////////
	// 			Getter			 //
	///////////////////////////////

	/**
	 *Obtient sesListe
	 * @return sesListes
	 */
	public ArrayList<Liste> getSesListes() {
		return sesListes;
	}

	/**
	 * Obtion une liste selon son nom
	 * @param nom de la liste que l'on cherche
	 * @return la liste si elle exite sinon rien
	 */
	public Liste getListe(String nom) {
		for (Liste l : sesListes) {
			if(l.getNomListe().equals(nom)) {
				return l;
			}
		}
		return null;
	}

	/**
	 * Obtient son espace de travail
	 * @return son espace de travail
	 */
	public EspaceTravail getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	/**
	 * obtient la liste des membre
	 * @return la liste des membre
	 */
	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}

	/**
	 *obtient sa visibilité
	 * @return sa visibiliter
	 */
	public Visibilite getSaVisibilite() {
		return saVisibilite;
	}

	/**
	 *obtient le numéro du tableau
	 * @return le numéro du tableau
	 */
	public int getNumTableau() {
		return numTableau;
	}

	/**
	 * obtient le nom du tableau
	 * @return le nom du tableau
	 */
	public String getNomTableau() {
		return nomTableau;
	}

	/**
	 * obtient la catégorie du tableau
	 * @return la catégorie du tableau
	 */
	public String getCategorieTableau() {
		return categorieTableau;
	}

	/**
	 *obtient l'image dfu tableau
	 * @return l'image dfu tableau
	 */
	public String getImageTableau() {
		return imageTableau;
	}
	
	////////////////////////////////
	// 			Setter			  //
	////////////////////////////////

	/**
	 *change son espace de travail
	 * @param sonEspaceTravail le nouvelle espace de travail
	 */
	public void setSonEspaceDeTravail(EspaceTravail sonEspaceTravail) {
		this.sonEspaceTravail = sonEspaceTravail;
		log.addActivity("Espace de travail attribué au Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	/**
	 * change sa visibilité
	 * @param saVisibilite la nouvelle visibilité
	 */
	public void setSaVisibilite(Visibilite saVisibilite) {
		this.saVisibilite = saVisibilite;
		log.addActivity("Visibilite attribuée au Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	/**
	 * change les nom du tableau
	 * @param nomTableau le nouveau nom
	 */
	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
		log.addActivity("Nom du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	/**
	 *change la categorie du tableau
	 * @param categorieTableau la nouvelle catégorie
	 */
	public void setCategorieTableau(String categorieTableau) {
		this.categorieTableau = categorieTableau;
		log.addActivity("Catégorie du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	/**
	 * change l'image du tableau
	 * @param imageTableau la nouvelle image
	 */
	public void setImageTableau(String imageTableau) {
		this.imageTableau = imageTableau;
		log.addActivity("Image du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}
	
	// Methodes
	/**
	 * Ajoute une liste au tableau.
	 * @param liste La liste à ajouter.
	 */

	public void ajouterListe(Liste liste) {
		sesListes.add(liste);
	}
	/**
	 * Retire une liste du tableau.
	 * @param liste La liste à retirer.
	 */

	public void retirerListe(Liste liste) {
		sesListes.remove(liste);
	}

	// Ajouter un espace de travail et tous les membres de cet espace au Tableau
	/**
	 * Ajoute un espace de travail au tableau et tous les membres de cet espace de travail.
	 * @param e L'espace de travail à ajouter.
	 */

	public void ajouterEspaceTravail(EspaceTravail e){
		this.sonEspaceTravail=e;
		e.ajouterTableau(this);
		for (Membre m : e.getSesMembres()){
			this.ajouterMembre(m);
		}
		log.addActivity("Espace de travail "+e.getNumEspaceDeTravail()+"-"+e.getNomEspaceDeTravail()+" créé");
	}
	/**
	 * Ajoute un membre au tableau.
	 * @param m Le membre à ajouter.
	 */

	public void ajouterMembre(Membre m){
		if(!this.sesMembres.contains(m)) {
			sesMembres.add(m);
			for (Liste l : sesListes) {
				l.ajouterMembre(m);
			}
			m.ajouterTableau(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" ajouté au Tableau "+numTableau+"-"+nomTableau);
		}
	}
	/**
	 * Retire un membre du tableau.
	 * @param m Le membre à retirer.
	 */

	public void retireMembre(Membre m){
		if(this.sesMembres.contains(m)) {
			sesMembres.remove(m);
			for (Liste l : sesListes) {
				l.retirerMembre(m);
			}
			m.retirerTableau(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" retiré du Tableau "+numTableau+"-"+nomTableau);
		}
	}
	/**
	 * Retourne le nombre de listes dans le tableau.
	 * @return Le nombre de listes.
	 */

	public int nbLsite(){
		//retourne le nombre de liste
		return sesListes.size();
	}
	/**
	 * Retourne le nombre de membres dans le tableau.
	 * @return Le nombre de membres.
	 */

	public int nbMembre(){
		//retoune le noubre de membre
		return sesMembres.size();
	}
	/**
	 * Supprime le tableau en le retirant de l'espace de travail et en supprimant toutes les listes associées.
	 * @return True si la suppression a réussi, sinon erreur lors de l'exécution.
	 */

	public boolean supprimer(){
		sonEspaceTravail.retirerTableau(this);
		for (Liste l:sesListes) {
			l.supprimer();
		}
		for (Membre m:sesMembres) {
			m.retirerTableau(this);
		}
		log.addActivity("Tableau "+numTableau+"-"+nomTableau+" supprimé");
		return true;
	}
	// ToString
	/**
	 * Renvoie une représentation sous forme de chaîne de caractères du tableau.
	 * @return Une représentation sous forme de chaîne de caractères du tableau.
	 */

	@Override
	public String toString() {
		return "Tableau\n{\n" +
				"\t-  nombre de liste = " + this.nbLsite() +"\n"+
				"\t-  SonEspaceDeTravail = " + sonEspaceTravail.getNomEspaceDeTravail() +"\n"+
				"\t-  nombre de membre = " + this.nbMembre() +"\n"+
				"\t-  saVisibilite = " + saVisibilite +"\n"+
				"\t-  numTableau = " + numTableau +"\n"+
				"\t-  nomTableau = " + nomTableau + '\n' +
				"\t-  categorieTableau = " + categorieTableau + '\n' +
				"\t-  imageTableau = " + imageTableau + '\n' +
				'}';
	}
}