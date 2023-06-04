package EspaceDeTravail;

import java.util.*;
/**
 * Cette classe représente un membre dans un système de gestion de tâches.
 */
public class Membre {
	///////////////////////////////////
	//          Attributs            //
	///////////////////////////////////

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	Log log = Log.getInstance();
	private ArrayList<EspaceTravail> sesEspaceTravail;
	private ArrayList<EspaceTravail> EspaceTravailAutre;
	private ArrayList<Tableau> sesTableau;
	private ArrayList<Liste> sesListe;
	private ArrayList<Carte> sesCartes;
	private int numMembre;
	private String nomMembre;
	private String prenomMembre;
	private String emailMembre;
	private String imageProfile;

	//////////////////////////////////
	// 			Constructor			//
	//////////////////////////////////
	/**
	 * Constructeur de la classe MembreModel.
	 * @param sonEspaceTravail L'espace de travail du membre.
	 */
	public Membre(EspaceTravail sonEspaceTravail) {
		this.EspaceTravailAutre = new ArrayList<EspaceTravail>();
		this.sesEspaceTravail =new ArrayList<EspaceTravail>();
		this.sesEspaceTravail.add(sonEspaceTravail);
		sesTableau = new ArrayList<Tableau>();
		sesListe = new ArrayList<Liste>();
		sesCartes = new ArrayList<Carte>();
		numMembre = compteurNum++;
		nomMembre = "user";
		prenomMembre = "user";
		emailMembre = "";
		imageProfile = "";
		sonEspaceTravail.setSonProprietaire(this);
		log.addActivity("Membre "+numMembre+"-"+nomMembre+" créé");
	}

	///////////////////////////////////
	// 			   Getter			 //
	///////////////////////////////////
	/**
	 * Renvoie les espaces de travail du membre.
	 * @return Les espaces de travail du membre.
	 */

	public ArrayList<EspaceTravail> getSesEspaceDeTravail() {
		return sesEspaceTravail;
	}
	/**
	 * Renvoie les autres espaces(ceux partager avec lui) de travail du membre.
	 * @return Les autres espaces de travail du membre.
	 */

	public ArrayList<EspaceTravail> getSesAutreEspaceTravail(){ return  EspaceTravailAutre;}
	/**
	 * Renvoie les tableaux du membre.
	 * @return Les tableaux du membre.
	 */

	public ArrayList<Tableau> getSesTableau() {
		return sesTableau;
	}
	/**
	 * Renvoie les listes du membre.
	 * @return Les listes du membre.
	 */

	public ArrayList<Liste> getSesListe() { return sesListe;}
	/**
	 * Renvoie les cartes du membre.
	 * @return Les cartes du membre.
	 */

	public ArrayList<Carte> getSesCartes() {
		return sesCartes;
	}
	/**
	 * Renvoie le numéro du membre.
	 * @return Le numéro du membre.
	 */

	public int getNumMembre() {
		return numMembre;
	}
	/**
	 * Renvoie le nom du membre.
	 * @return Le nom du membre.
	 */

	public String getNomMembre() {
		return nomMembre;
	}
	/**
	 * Renvoie le prénom du membre.
	 * @return Le prénom du membre.
	 */

	public String getPrenomMembre() {
		return prenomMembre;
	}
	/**
	 * Renvoie l'email du membre.
	 * @return L'email du membre.
	 */

	public String getEmailMembre() {
		return emailMembre;
	}
	/**
	 * Renvoie l'image de profil du membre.
	 * @return L'image de profil du membre.
	 */

	public String getImageProfile() {
		return imageProfile;
	}
	
	/////////////////////////////////////
	// 				Setters			   //
	/////////////////////////////////////
	/**
	 * Modifie le nom du membre.
	 * @param nomMembre Le nouveau nom du membre.
	 */

	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
		log.addActivity("Nom du Membre "+numMembre+"-"+nomMembre+" modifié");
	}
	/**
	 * Modifie le prénom du membre.
	 * @param prenomMembre Le nouveau prénom du membre.
	 */

	public void setPrenomMembre(String prenomMembre) {
		this.prenomMembre = prenomMembre;
		log.addActivity("Prénom du Membre "+numMembre+"-"+prenomMembre+" modifié");
	}
	/**
	 * Modifie l'email du membre.
	 * @param emailMembre Le nouvel email du membre.
	 */

	public void setEmailMembre(String emailMembre) {
		this.emailMembre = emailMembre;
		log.addActivity("Email du Membre "+numMembre+"-"+emailMembre+" modifié");
	}
	/**
	 * Modifie l'image de profil du membre.
	 * @param imageProfile La nouvelle image de profil du membre.
	 */

	public void setImageProfile(String imageProfile) {
		this.imageProfile = imageProfile;
		log.addActivity("Image du Membre "+numMembre+"-"+imageProfile+" modifié");
	}

	/////////////////////////////////////
	// 				Methodes		   //
	/////////////////////////////////////
	/**
	 * Crée un nouvel espace de travail avec le nom spécifié et l'ajoute au membre.
	 * @param nomEspaceDeTravail Le nom de l'espace de travail à créer.
	 * @return Le nouvel espace de travail créé.
	 */

	public EspaceTravail creeEspaceDetravail(String nomEspaceDeTravail ){
		EspaceTravail e =new EspaceTravail();
		e.setSonProprietaire(this);
		e.setNomEspaceDeTravail(nomEspaceDeTravail);
		sesEspaceTravail.add(e);
		return e;
	}
	/**
	 * Crée un nouvel espace de travail et l'ajoute au membre.
	 * @return Le nouvel espace de travail créé.
	 */

	public EspaceTravail creeEspaceDetravail(){
		EspaceTravail e =new EspaceTravail();
		e.setSonProprietaire(this);
		sesEspaceTravail.add(e);
		return e;
	}
	/**
	 * Supprime un espace de travail du membre.
	 * @param e L'espace de travail à supprimer.
	 * @return True si la suppression a réussi et surtout posible, False sinon.
	 */

	public boolean detruireEspaceDeTravail(EspaceTravail e){
		if (this.sesEspaceTravail.contains(e)){
			e.supprimer();
			sesEspaceTravail.remove(e);
			log.addActivity("Espace de travail "+e.getNomEspaceDeTravail()+" supprimé");
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Ajoute un espace de travail au membre.
	 * @param E L'espace de travail à ajouter.
	 */

	public void ajouterEspaceDeTravail(EspaceTravail E) {
		if(!this.EspaceTravailAutre.contains(E)){
			this.EspaceTravailAutre.add(E);
			E.ajouterMembre(this);
		}
	}
	/**
	 * Retire un espace de travail du membre.
	 * @param E L'espace de travail à retirer.
	 */

	public void retirerEspaceDeTravail(EspaceTravail E) {
		if(!this.EspaceTravailAutre.contains(E)) {
			this.EspaceTravailAutre.remove(E);
			E.retirerMembre(this);
		}
	}
	/**
	 * Ajoute une carte au membre.
	 * @param Carte La carte à ajouter.
	 */

	public void ajouterCarte(Carte Carte) {
		if (!this.sesCartes.contains(Carte)) {
			this.sesCartes.add(Carte);
			Carte.ajouterMembre(this);
			log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" ajoutée au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Retire une carte du membre.
	 * @param Carte La carte à retirer.
	 */

	public void retirerCarte(Carte Carte) {
		if (this.sesCartes.contains(Carte)) {
			this.sesCartes.remove(Carte);
			Carte.retirerMembre(this);
			log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" retirée au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Ajoute un tableau au membre.
	 * @param t Le tableau à ajouter.
	 */

	public void ajouterTableau(Tableau t){
		if (!this.sesTableau.contains(t)){
			this.sesTableau.add(t);
			t.ajouterMembre(this);
			log.addActivity("Tableau "+t.getNumTableau()+"-"+t.getNomTableau()+" ajouté au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Retire un tableau du membre.
	 * @param t Le tableau à retirer.
	 */

	public void retirerTableau(Tableau t){
		if(this.sesTableau.contains(t)){
			this.sesTableau.remove(t);
			t.retireMembre(this);
			log.addActivity("Tableau "+t.getNumTableau()+"-"+t.getNomTableau()+" retiré au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Ajoute une liste au membre.
	 * @param l La liste à ajouter.
	 */

	public void ajouterListe(Liste l){
		if(!this.sesListe.contains(l)){
			this.sesListe.add(l);
			l.ajouterMembre(this);
			log.addActivity("Liste "+l.getNumListe()+"-"+l.getNomListe()+" ajoutée au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Retire une liste du membre.
	 * @param l La liste à retirer.
	 */

	public void retirerListe(Liste l){
		if (this.sesListe.contains(l)){
			this.sesListe.remove(l);
			l.retirerMembre(this);
			log.addActivity("Liste "+l.getNumListe()+"-"+l.getNomListe()+" retirée au membre "+numMembre+"-"+nomMembre);
		}
	}
	/**
	 * Renvoie le nombre d'autres espaces de travail du membre.
	 * @return Le nombre d'autres espaces de travail du membre.
	 */

	public int nbAutreEspaceTravail(){
		//retourne le nombre d'espace de travail autre que le sien
		return EspaceTravailAutre.size();
	}
	/**
	 * Renvoie le nombre de tableaux du membre.
	 * @return Le nombre de tableaux du membre.
	 */

	public int nbTableau(){
		//retourne le nombre de tableau
		return sesTableau.size();
	}
	/**
	 * Renvoie le nombre de listes du membre.
	 * @return Le nombre de listes du membre.
	 */

	public int nbListe(){
		//retoune le nombre de liste
		return sesListe.size();
	}
	/**
	 * Renvoie le nombre de cartes du membre.
	 * @return Le nombre de cartes du membre.
	 */

	public int nbCarte(){
		//retourne le nombre de carte
		return sesCartes.size();
	}
	/**
	 * Renvoie le nombre d'espaces de travail appartenant au membre.
	 * @return Le nombre d'espaces de travail appartenant au membre.
	 */

	public int nbEspaceDetravail(){
		//retourne son nombre d'espace de travail qui lui appartienne
		return sesEspaceTravail.size();
	}
	/**
	 * Supprime toutes les références du membre dans le modèle.
	 * @return true si supresion réussite sinon erreur lors de l'exécution.
	 */

	public boolean supprimer(){

		for (Tableau t:sesTableau) {
			t.retireMembre(this);
		}
		for (Liste l:sesListe) {
			l.retirerMembre(this);
		}
		for (Carte c:sesCartes) {
			c.retirerMembre(this);
		}
		for (EspaceTravail se:sesEspaceTravail) {
			se.supprimer();
		}
		for (EspaceTravail e:EspaceTravailAutre) {
			e.retirerMembre(this);
		}
		log.addActivity("Membre "+numMembre+"-"+nomMembre+" supprimé");
		return true;
	}
	/**
	 * Renvoie une représentation sous forme de chaîne de caractères du membre.
	 * @return Une représentation sous forme de chaîne de caractères du membre.
	 */

	// ToString
		@Override
	public String toString() {
		return "Membre\n{\n" +
				"\t-  nombre d'espace de travail = " + this.nbEspaceDetravail() +"\n"+
				"\t-  son nombre d'autre espace de travail = " + this.nbAutreEspaceTravail() +"\n"+
				"\t-  son nombre de tableau = " + this.nbTableau() +"\n"+
				"\t-  son nombre de liste = " + this.nbListe() +"\n"+
				"\t-  son nombre de carte = " + this.nbCarte() +"\n"+
				"\t-  numMembre = " + numMembre +"\n"+
				"\t-  nomMembre = " + nomMembre + "\n"+
				"\t-  prenomMembre = " + prenomMembre +"\n"+
				"\t-  emailMembre = " + emailMembre + "\n"+
				"\t-  imageProfile = " + imageProfile + "\n"+
				'}';
	}
}
