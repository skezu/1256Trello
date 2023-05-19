package EspaceDeTravail;

import java.util.*;

public class EspaceTravail {
	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<Tableau> sesTableaux;
	private ArrayList<Membre> sesMembres;
	private Visibilite saVisibilité;
	private int numEspaceDeTravail;
	private String nomEspaceDeTravail;
	private String logoEspaceDeTravail;

	// Constructeur
	public EspaceTravail() {
		sesTableaux = new ArrayList<Tableau>();
		sesMembres = new ArrayList<Membre>();
		saVisibilité = new Visibilite();
		numEspaceDeTravail = compteurNum++;
		nomEspaceDeTravail = "Espace de";
		logoEspaceDeTravail = "";
	}

	public EspaceTravail(ArrayList<Tableau> sesTableaux, ArrayList<Membre> sesMembres, Visibilite saVisibilité, String nomEspaceDeTravail, String logoEspaceDeTravail) {
		this.sesTableaux = sesTableaux;
		this.sesMembres = sesMembres;
		this.saVisibilité = saVisibilité;
		this.numEspaceDeTravail = compteurNum++;
		this.nomEspaceDeTravail = nomEspaceDeTravail;
		this.logoEspaceDeTravail = logoEspaceDeTravail;
	}
	
	// Getters 

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
	}

	public void setLogoEspaceDeTravail(String logoEspaceDeTravail) {
		this.logoEspaceDeTravail = logoEspaceDeTravail;
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
		sesMembres.add(m);
		for (Tableau t:sesTableaux) {
			t.ajouterMembre(m);
		}
	}

	public void retirerMembre(Membre m){
		sesMembres.remove(m);
		for (Tableau t:sesTableaux) {
			t.retireMembre(m);
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
		return true;
	}

	// ToString

	@Override
	public String toString() {
		return "EspaceDeTravail\n{\n" +
				"\t-  sesTableaux = " + sesTableaux +"\n"+
				"\t-  sesMembres = " + sesMembres +"\n"+
				"\t-  saVisibilité = " + saVisibilité +"\n"+
				"\t-  numEspaceDeTravail = " + numEspaceDeTravail +"\n"+
				"\t-  nomEspaceDeTravail = " + nomEspaceDeTravail + '\n' +
				"\t-  logoEspaceDeTravail = " + logoEspaceDeTravail + '\n' +
				'}';
	}
}
