package EspaceDeTravail;

import java.util.*;

public class Carte {
	// Attribut de classe
	private static int compteurNum = 0;
	
	// Attribut d'instance
	Log log = Log.getInstance();
	private Liste saListe;
	private ArrayList<Membre> sesMembres;
	private int numCarte;
	private String titreCarte;
	private String description;
	private String dateDebut;
	private String dateLimite;
	
	// Constructor 
	public Carte(Liste saListe){
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		titreCarte = "Carte Vide";
		description = "";
		dateDebut = "01/01/2023";
		dateLimite = "28/05/2023";
		log.addActivity("Carte vide créée");
	}
	public Carte(Liste saListe, String titreCarte){
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		sesMembres = new ArrayList<Membre>();
		numCarte = compteurNum++;
		this.titreCarte = titreCarte;
		description = "";
		dateDebut = "01/01/2023";
		dateLimite = "28/05/2023";
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" créée");
	}
	public Carte(Liste saListe,String titreCarte, ArrayList<Membre> sesMembres, int numCarte, String description, String dateDebut, String dateLimite) {
		this.saListe = saListe;
		saListe.ajouterCarte(this);
		this.sesMembres = sesMembres;
		this.numCarte = numCarte;
		this.titreCarte = titreCarte;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateLimite = dateLimite;
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" créée");
	}

	// Getters

	public Liste getSaListe() {
		return saListe;
	}

	public ArrayList<Membre> getSesMembres() {
		return sesMembres;
	}

	public int getNumCarte() {
		return numCarte;
	}

	public String getTitreCarte() {
		return titreCarte;
	}

	public String getDescription() {
		return description;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public String getDateLimite() {
		return dateLimite;
	}
	
	// Setters


	public void setSaListe(Liste saListe) {
		this.saListe = saListe;
		log.addActivity("Liste "+saListe.getNomListe()+" ajoutée à la carte "+numCarte+"-"+titreCarte);
	}

	public void setTitreCarte(String titreCarte) {
		this.titreCarte = titreCarte;
		log.addActivity("Titre de la Carte "+numCarte+"-"+titreCarte+" renommée");
	}

	public void setDescription(String description) {
		this.description = description;
		log.addActivity("Description de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
		log.addActivity("Date de début de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
		log.addActivity("Date de fin de la Carte "+numCarte+"-"+titreCarte+" modifiée");
	}

	// Methodes
	public void ajouterMembre(Membre Membre) {
		if (!Membre.getSesCartes().contains(this)) {
			this.sesMembres.add(Membre);
			Membre.ajouterCarte(this);
			log.addActivity("Membre "+Membre.getNumMembre()+"-"+Membre.getNomMembre()+" "+Membre.getPrenomMembre()+" ajouté à la carte "+numCarte+"-"+titreCarte);
		}
	}
	public void retirerMembre(Membre Membre){
		if (Membre.getSesCartes().contains(this)) {
			this.sesMembres.remove(Membre);
			Membre.retirerCarte(this);
			log.addActivity("Membre "+Membre.getNumMembre()+"-"+Membre.getNomMembre()+" "+Membre.getPrenomMembre()+" retiré de la carte "+numCarte+"-"+titreCarte);
		}
	}
	public int nbMembre(){
		//returne le nombre de menbre de la carte
		return sesMembres.size();
	}

	public boolean supprimer(){
		//supprime la carte de tout les endroit ou elle se trouve
		saListe.retirerCarte(this);
		for (Membre m:sesMembres) {
			m.retirerCarte(this);
		}
		log.addActivity("Carte "+numCarte+"-"+titreCarte+" supprimée");
		return true;
	}

	public void ajouterListe(Liste liste){
		this.saListe = liste;
		// on suppose que le sens est Liste.ajouterCarte
	}

	// ToString
	@Override
	public String toString() {
		return "Carte\n{\n" +
				"\t-  saListe = " + saListe.getNomListe() +"\n"+
				"\t-   nombre de membre = " + this.nbMembre() +"\n"+
				"\t-   numCarte = " + numCarte +"\n"+
				"\t-   titreCarte = " + titreCarte + '\n' +
				"\t-   description =" + description + '\n' +
				"\t-   dateDebut = " + dateDebut + '\n' +
				"\t-   dateLimite = " + dateLimite + '\n' +
				'}';
	}
}
