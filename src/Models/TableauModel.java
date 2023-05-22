package Models;

import java.util.*;

public class TableauModel {
	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<ListeModel> sesListes;
	private EspaceTravailModel sonEspaceTravail;
	private ArrayList<MembreModel> sesMembres;
	private VisibiliteModel saVisibilite;
	private int numTableau;
	private String nomTableau;
	private String categorieTableau;
	private String imageTableau;

	// Constructeur
	public TableauModel(EspaceTravailModel sonEspaceTravail) {
		sesListes = new ArrayList<ListeModel>();
		sesMembres = new ArrayList<MembreModel>();
		this.sonEspaceTravail = sonEspaceTravail;
		saVisibilite = new VisibiliteModel();
		numTableau = compteurNum++;
		nomTableau = "Nouveau Tableau";
		categorieTableau = "";
		imageTableau = "";
	}

	// Ajouter un espace de travail et tous les membres de cet espace au Tableau
	public void ajouterEspaceTravail(EspaceTravailModel e){
		this.sonEspaceTravail=e;
		e.ajouterTableau(this);
		for (MembreModel m : e.getSesMembres()){
			this.ajouterMembre(m);
		}
	}
	public TableauModel(ArrayList<ListeModel> sesListes, EspaceTravailModel sonEspaceTravail, ArrayList<MembreModel> sesMembres, VisibiliteModel saVisibilite, String nomTableau, String categorieTableau, String imageTableau) {
		this.sesListes = sesListes;
		this.sonEspaceTravail = sonEspaceTravail;
		this.sesMembres = sesMembres;
		this.saVisibilite = saVisibilite;
		this.numTableau = compteurNum++;
		this.nomTableau = nomTableau;
		this.categorieTableau = categorieTableau;
		this.imageTableau = imageTableau;
	}

	// Getter


	public ArrayList<ListeModel> getSesListes() {
		return sesListes;
	}

	public EspaceTravailModel getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	public ArrayList<MembreModel> getSesMembres() {
		return sesMembres;
	}

	public VisibiliteModel getSaVisibilite() {
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

	// Setter

	public void setSonEspaceDeTravail(EspaceTravailModel sonEspaceTravail) {
		this.sonEspaceTravail = sonEspaceTravail;
	}

	public void setSaVisibilite(VisibiliteModel saVisibilite) {
		this.saVisibilite = saVisibilite;
	}

	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
	}

	public void setCategorieTableau(String categorieTableau) {
		this.categorieTableau = categorieTableau;
	}

	public void setImageTableau(String imageTableau) {
		this.imageTableau = imageTableau;
	}

	// Methodes
	public void ajouterListe(ListeModel liste) {
		sesListes.add(liste);
	}
	public void retirerListe(ListeModel liste) {
		sesListes.remove(liste);
	}

	public void ajouterMembre(MembreModel m){
		if(!this.sesMembres.contains(m)) {
			sesMembres.add(m);
			for (ListeModel l : sesListes) {
				l.ajouterMembre(m);
			}
			m.ajouterTableau(this);
		}
	}

	public void retireMembre(MembreModel m){
		if(this.sesMembres.contains(m)) {
			sesMembres.remove(m);
			for (ListeModel l : sesListes) {
				l.retirerMembre(m);
			}
			m.retirerTableau(this);
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
		for (ListeModel l:sesListes) {
			l.supprimer();
		}
		for (MembreModel m:sesMembres) {
			m.retirerTableau(this);
		}
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