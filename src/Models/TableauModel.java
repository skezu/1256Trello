package Models;



import java.util.ArrayList;

public class TableauModel {
	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	private ArrayList<ListeModel> sesListeModels;
	private EspaceTravailModel sonEspaceTravail;
	private ArrayList<MembreModel> sesMembreModels;
	private VisibiliteModel saVisibilite;
	private int numTableau;
	private String nomTableau;
	private String categorieTableau;
	private String imageTableau;
	
	// Constructeur
	public TableauModel(EspaceTravailModel sonEspaceTravail) {
		sesListeModels = new ArrayList<ListeModel>();
		sesMembreModels = new ArrayList<MembreModel>();
		ajouterEspaceTravail(sonEspaceTravail);
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
	public TableauModel(ArrayList<ListeModel> sesListeModels, EspaceTravailModel sonEspaceTravail, ArrayList<MembreModel> sesMembreModels, VisibiliteModel saVisibilite, String nomTableau, String categorieTableau, String imageTableau) {
		this.sesListeModels = sesListeModels;
		this.sonEspaceTravail = sonEspaceTravail;
		this.sesMembreModels = sesMembreModels;
		this.saVisibilite = saVisibilite;
		this.numTableau = compteurNum++;
		this.nomTableau = nomTableau;
		this.categorieTableau = categorieTableau;
		this.imageTableau = imageTableau;
	}
	
	// Getter


	public ArrayList<ListeModel> getSesListes() {
		return sesListeModels;
	}

	public EspaceTravailModel getSonEspaceDeTravail() {
		return sonEspaceTravail;
	}

	public ArrayList<MembreModel> getSesMembres() {
		return sesMembreModels;
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
	public void ajouterListe(ListeModel listeModel) {
		sesListeModels.add(listeModel);
	}
	public void retirerListe(ListeModel listeModel) {
		sesListeModels.remove(listeModel);
	}
	public void ajouterMembre(MembreModel membreModel) {
		sesMembreModels.add(membreModel);
	}
	public void retirerMembre(MembreModel membreModel) {
		sesMembreModels.remove(membreModel);
	}

	// ToString

	@Override
	public String toString() {
		return "Tableau{" +
				"sesListes=" + sesListeModels +
				", SonEspaceDeTravail=" + sonEspaceTravail +
				", sesMembres=" + sesMembreModels +
				", saVisibilite=" + saVisibilite +
				", numTableau=" + numTableau +
				", nomTableau='" + nomTableau + '\'' +
				", categorieTableau='" + categorieTableau + '\'' +
				", imageTableau='" + imageTableau + '\'' +
				'}';
	}
}