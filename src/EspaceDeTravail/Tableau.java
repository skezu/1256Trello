package EspaceDeTravail;

import java.util.*;

public class Tableau {
	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<Liste> sesListes;
	private EspaceDeTravail SonEspaceDeTravail;
	private ArrayList<Membre> sesMembres;
	private Visibilite saVisibilite;
	private int numTableau;
	private String nomTableau;
	private String categorieTableau;
	private String imageTableau;
	
	// Constructeur
	public Tableau(){
		sesListes = new ArrayList<Liste>();
		SonEspaceDeTravail = new EspaceDeTravail();
		sesMembres = new ArrayList<Membre>();
		saVisibilite = new Visibilite();
		numTableau = compteurNum++;
		nomTableau = "Nouveau Tableau";
		categorieTableau = "";
		imageTableau = "";
	}
	
	public Tableau(ArrayList<Liste> sesListes, EspaceDeTravail SonEspaceDeTravail, ArrayList<Membre> sesMembres, Visibilite saVisibilite, String nomTableau, String categorieTableau, String imageTableau) {
		this.sesListes = sesListes;
		this.SonEspaceDeTravail = SonEspaceDeTravail;
		this.sesMembres = sesMembres;
		this.saVisibilite = saVisibilite;
		this.numTableau = compteurNum++;
		this.nomTableau = nomTableau;
		this.categorieTableau = categorieTableau;
		this.imageTableau = imageTableau;
	}
	
	// Getter


	public ArrayList<Liste> getSesListes() {
		return sesListes;
	}

	public EspaceDeTravail getSonEspaceDeTravail() {
		return SonEspaceDeTravail;
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
	
	// Setter

	public void setSonEspaceDeTravail(EspaceDeTravail sonEspaceDeTravail) {
		SonEspaceDeTravail = sonEspaceDeTravail;
	}

	public void setSaVisibilite(Visibilite saVisibilite) {
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
	public void ajouterListe(Liste liste) {
		sesListes.add(liste);
	}
	public void retirerListe(Liste liste) {
		sesListes.remove(liste);
	}
	public void ajouterMembre(Membre membre) {
		sesMembres.add(membre);
	}
	public void retirerMembre(Membre membre) {
		sesMembres.remove(membre);
	}

	// ToString

	@Override
	public String toString() {
		return "Tableau{" +
				"sesListes=" + sesListes +
				", SonEspaceDeTravail=" + SonEspaceDeTravail +
				", sesMembres=" + sesMembres +
				", saVisibilite=" + saVisibilite +
				", numTableau=" + numTableau +
				", nomTableau='" + nomTableau + '\'' +
				", categorieTableau='" + categorieTableau + '\'' +
				", imageTableau='" + imageTableau + '\'' +
				'}';
	}
}