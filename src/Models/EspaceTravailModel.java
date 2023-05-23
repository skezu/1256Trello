package Models;

import java.util.*;

public class EspaceTravailModel {
	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<TableauModel> sesTableaux;
	private ArrayList<MembreModel> sesMembres;
	private MembreModel sonProprietaire;
	private VisibiliteModel saVisibilité;
	private int numEspaceDeTravail;
	private String nomEspaceDeTravail;
	private String logoEspaceDeTravail;

	// Constructeur
	public EspaceTravailModel() {
		sesTableaux = new ArrayList<TableauModel>();
		sesMembres = new ArrayList<MembreModel>();
		saVisibilité = new VisibiliteModel();
		numEspaceDeTravail = compteurNum++;
		nomEspaceDeTravail = "Espace de";
		logoEspaceDeTravail = "";
	}

	public EspaceTravailModel(ArrayList<TableauModel> sesTableaux, ArrayList<MembreModel> sesMembres, VisibiliteModel saVisibilité, String nomEspaceDeTravail, String logoEspaceDeTravail) {
		this.sesTableaux = sesTableaux;
		this.sesMembres = sesMembres;
		this.saVisibilité = saVisibilité;
		this.numEspaceDeTravail = compteurNum++;
		this.nomEspaceDeTravail = nomEspaceDeTravail;
		this.logoEspaceDeTravail = logoEspaceDeTravail;
	}

	// Getters

	public MembreModel getSonProprietaire() {
		return sonProprietaire;
	}
	public void setSonProprietaire(MembreModel m){
		sonProprietaire= m;
		sesMembres.add(m);
	}

	public ArrayList<TableauModel> getSesTableaux() {
		return sesTableaux;
	}

	public ArrayList<MembreModel> getSesMembres() {
		return sesMembres;
	}

	public VisibiliteModel getSaVisibilité() {
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

	public void setSaVisibilité(VisibiliteModel saVisibilité) {
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
	public void ajouterTableau(TableauModel Tableau) {
		this.sesTableaux.add(Tableau);
	}
	// Retirer un tableau
	public void retirerTableau(TableauModel Tableau) {
		this.sesTableaux.remove(Tableau);
	}
	// Ajouter un membre

	public void ajouterMembre(MembreModel m){
		if(!this.sesMembres.contains(m)) {
			sesMembres.add(m);
			for (TableauModel t : sesTableaux) {
				t.ajouterMembre(m);
			}
			m.ajouterEspaceDeTravail(this);
		}
	}

	public void retirerMembre(MembreModel m){
		if(this.sesMembres.contains(m)) {
			sesMembres.remove(m);
			for (TableauModel t : sesTableaux) {
				t.retireMembre(m);
			}
			m.retirerEspaceDeTravail(this);
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
		for (TableauModel t:sesTableaux) {
			t.supprimer();
		}
		for (MembreModel m:sesMembres) {
			if(m!=sonProprietaire) {
				//car sinon on ne peut pas retire l'espace de travail car il ne fait pas partie de l'ArrayList
				m.retirerEspaceDeTravail(this);
			}
		}

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
