package Models;


import java.util.ArrayList;

public class EspaceTravailModel {
	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	private ArrayList<TableauModel> sesTableaux;
	private ArrayList<MembreModel> sesMembres;
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
	public void ajouterTableau(TableauModel TableauModel) {
		this.sesTableaux.add(TableauModel);
	}
	// Retirer un tableau
	public void retirerTableau(TableauModel TableauModel) {
		this.sesTableaux.remove(TableauModel);
	}
	// Ajouter un membre
	public void ajouterMembre(MembreModel MembreModel) {
		this.sesMembres.add(MembreModel);
	}
	// Retirer un membre
	public void retirerMembre(MembreModel MembreModel) {
		this.sesMembres.remove(MembreModel);
	}

	// ToString

	@Override
	public String toString() {
		return "EspaceDeTravail{" +
				"sesTableaux=" + sesTableaux +
				", sesMembres=" + sesMembres +
				", saVisibilité=" + saVisibilité +
				", numEspaceDeTravail=" + numEspaceDeTravail +
				", nomEspaceDeTravail='" + nomEspaceDeTravail + '\'' +
				", logoEspaceDeTravail='" + logoEspaceDeTravail + '\'' +
				'}';
	}
}
