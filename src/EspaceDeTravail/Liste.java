package EspaceDeTravail;

import java.util.*;

public class Liste {
	//////////////////////////////////
	//          Attributs           //
	//////////////////////////////////

	// Attribut de classe
	private static int compteurNum = 0;

	// Attribut d'instance
	Log log = Log.getInstance();
	private Tableau sonTableau;
	private ArrayList<Carte> sesCartes;
	private int numListe;
	private String nomListe;
	private ArrayList<Membre> sesMenbre;

	//////////////////////////////
	// 		  Constructeur		//
	//////////////////////////////
	public Liste(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		nomListe = "Nouvelle Liste";
		log.addActivity("Liste vide créée");
	}
	public Liste(Tableau sonTableau, ArrayList<Carte> sesCartes, String nomListe, ArrayList<Membre> sesMenbre) {
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		this.sesCartes = sesCartes;
		this.sesMenbre = sesMenbre;
		this.numListe = compteurNum++;
		this.nomListe = nomListe;
		log.addActivity("Liste "+numListe+"-"+nomListe+" créée");
	}

	public Liste ( Tableau sonTableau,String nomListe){
		this.sonTableau = sonTableau;
		sonTableau.ajouterListe(this);
		sesCartes = new ArrayList<Carte>();
		sesMenbre= new ArrayList<Membre>();
		numListe = compteurNum++;
		this.nomListe = nomListe;
		log.addActivity("Liste "+numListe+"-"+nomListe+" créée");
	}

	
	/////////////////////////////////
	//  		  Getter		   //
	/////////////////////////////////
	public Tableau getSonTableau() {
		return sonTableau;
	}

	public ArrayList<Carte> getSesCartes() {
		return (sesCartes);
	}

	public int getNumListe() {
		return numListe;
	}

	public String getNomListe() {
		return nomListe;
	}
	
	// Setter

	public void setSonTableau(Tableau sonTableau) {
		this.sonTableau = sonTableau;
		log.addActivity("Tableau contenant la liste modifié");
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
		log.addActivity("Nom de la Liste "+numListe+"-"+nomListe+" modifiée");
	}
	///////////////////////////////////
	//  		  Methodes		     //
	///////////////////////////////////
	public void ajouterMembre(Membre m){
		if(! this.sesMenbre.contains(m)) {
			this.sesMenbre.add(m);
			for (Carte c : sesCartes) {
				c.ajouterMembre(m);
			}
			m.ajouterListe(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" ajouté à la liste "+numListe+"-"+nomListe);
		}
	}

	public void retirerMembre(Membre m){
		if(this.sesMenbre.contains(m)) {
			this.sesMenbre.remove(m);
			for (Carte c : sesCartes) {
				c.retirerMembre(m);
			}
			m.retirerListe(this);
			log.addActivity("Membre "+m.getNumMembre()+"-"+m.getNomMembre()+" retiré de la liste "+numListe+"-"+nomListe);
		}
	}

	public void ajouterCarte(Carte Carte) {
		this.sesCartes.add(Carte);
		Carte.ajouterListe(this);
		log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" ajouté à la liste "+numListe+"-"+nomListe);
	}
	public void retirerCarte(Carte Carte) {
		this.sesCartes.remove(Carte);
		log.addActivity("Carte "+Carte.getNumCarte()+"-"+Carte.getTitreCarte()+" retiré de la liste "+numListe+"-"+nomListe);

	}

	public int nbCarte(){
		//returne le nombre de carte dans la liste
		return sesCartes.size();
	}

	public int nbMembre(){
		//returne le nombre de menbre de la liste
		return sesMenbre.size();
	}


	public boolean supprimer(){
		//suprime la liste et tout les carte assosier
		sonTableau.retirerListe(this);
		for (Carte c:sesCartes) {
			c.supprimer();
		}
		for (Membre m:sesMenbre) {
			m.retirerListe(this);
		}
		log.addActivity("Liste "+numListe+"-"+nomListe+" supprimée");
		return true;
	}
	// ToString
		@Override
	public String toString() {
		return "Liste\n{\n" +
				"\t-  sonTableau = " + sonTableau.getNomTableau() +"\n"+
				"\t-  nombre de carte = " + this.nbCarte() +"\n"+
				"\t-  numListe = " + numListe +"\n"+
				"\t-  nomListe = " + nomListe + '\n' +
				'}';
	}
}
