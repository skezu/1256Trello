package EspaceDeTravail;

import java.util.*;

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
	public ArrayList<Liste> getSesListes() {
		return sesListes;
	}
	public Liste getListe(String nom) {
		for (Liste l : sesListes) {
			if(l.getNomListe().equals(nom)) {
				return l;
			}
		}
		return null;
	}

	public EspaceTravail getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}

	public Visibilite getSaVisibilite() {
		return saVisibilite;
	}

	public int getNumTableau() {
		return numTableau;
	}

	public String getNomTableau() {
		return nomTableau;
	}

	public String getCategorieTableau() {
		return categorieTableau;
	}

	public String getImageTableau() {
		return imageTableau;
	}
	
	////////////////////////////////
	// 			Setter			  //
	////////////////////////////////
	public void setSonEspaceDeTravail(EspaceTravail sonEspaceTravail) {
		this.sonEspaceTravail = sonEspaceTravail;
		log.addActivity("Espace de travail attribué au Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	public void setSaVisibilite(Visibilite saVisibilite) {
		this.saVisibilite = saVisibilite;
		log.addActivity("Visibilite attribuée au Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
		log.addActivity("Nom du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	public void setCategorieTableau(String categorieTableau) {
		this.categorieTableau = categorieTableau;
		log.addActivity("Catégorie du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}

	public void setImageTableau(String imageTableau) {
		this.imageTableau = imageTableau;
		log.addActivity("Image du Tableau "+numTableau+"-"+nomTableau+" modifié");
	}
	
	// Methodes
	public void ajouterListe(Liste liste) {
		sesListes.add(liste);
	}
	public void retirerListe(Liste liste) {
		sesListes.remove(liste);
	}

	// Ajouter un espace de travail et tous les membres de cet espace au Tableau
	public void ajouterEspaceTravail(EspaceTravail e){
		this.sonEspaceTravail=e;
		e.ajouterTableau(this);
		for (Membre m : e.getSesMembres()){
			this.ajouterMembre(m);
		}
		log.addActivity("Espace de travail "+e.getNumEspaceDeTravail()+"-"+e.getNomEspaceDeTravail()+" créé");
	}

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

	public int nbLsite(){
		//retourne le nombre de liste
		return sesListes.size();
	}

	public int nbMembre(){
		//retoune le noubre de membre
		return sesMembres.size();
	}

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