package EspaceDeTravail;

import java.util.*;

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

	public Membre getSonProprietaire() {
		return sonProprietaire;
	}
	public void setSonProprietaire(Membre m){
		sonProprietaire= m;
		sesMembres.add(m);
		log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" ajouté dans l'espace de travail"+numEspaceDeTravail+"-"+nomEspaceDeTravail);
	}

	public ArrayList<Tableau> getSesTableaux() {
		return sesTableaux;
	}

	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}

	public Visibilite getSaVisibilité() {
		return saVisibilité;
	}

	public int getNumEspaceDeTravail() {
		return numEspaceDeTravail;
	}

	public String getNomEspaceDeTravail() {
		return nomEspaceDeTravail;
	}

	public String getLogoEspaceDeTravail() {
		return logoEspaceDeTravail;
	}
	
	// Setters

	public void setSaVisibilité(Visibilite saVisibilité) {
		this.saVisibilité = saVisibilité;
	}

	public void setNomEspaceDeTravail(String nomEspaceDeTravail) {
		this.nomEspaceDeTravail = nomEspaceDeTravail;
		log.addActivity("Nom de l'Espace de Travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" modifie");
	}

	public void setLogoEspaceDeTravail(String logoEspaceDeTravail) {
		this.logoEspaceDeTravail = logoEspaceDeTravail;
		log.addActivity("Logo de l'Espace de Travail "+numEspaceDeTravail+"-"+nomEspaceDeTravail+" modifie");
	}

	// Methodes

	// Ajouter un tableau
	public void ajouterTableau(Tableau Tableau) {
		this.sesTableaux.add(Tableau);
	}
	// Retirer un tableau
	public void retirerTableau(Tableau Tableau) {
		this.sesTableaux.remove(Tableau);
	}
	// Ajouter un membre

	public void ajouterMembre(Membre m){
		if(!this.sesMembres.contains(m)) {
			sesMembres.add(m);
			for (Tableau t : sesTableaux) {
				t.ajouterMembre(m);
			}
			m.ajouterEspaceDeTravail(this);
		}
		
	}

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

	public int nbTableau(){
		//retourne le nombre de tableau
		return sesTableaux.size();
	}

	public int nbMembre(){
		//retourne le nombre de menbre
		return sesMembres.size();
	}

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
