package Models;


import java.util.*;

public class CarteModel {
    // Attribut de classe
    private static int compteurNum = 0;

    // Attribut d'instance
    private ListeModel saListe;
    private ArrayList<MembreModel> sesMembres;
    private int numCarte;
    private String titreCarte;
    private String description;
    private String dateDebut;
    private String dateLimite;

    // Constructor
    public CarteModel(ListeModel saListe){
        this.saListe = saListe;
        sesMembres = new ArrayList<MembreModel>();
        numCarte = compteurNum++;
        titreCarte = "Nouvelle Carte";
        description = "";
        dateDebut = "";
        dateLimite = "";
    }
    public CarteModel(ListeModel saListe, ArrayList<MembreModel> sesMembres, int numCarte, String titreCarte, String description, String dateDebut, String dateLimite) {
        this.saListe = saListe;
        this.sesMembres = sesMembres;
        this.numCarte = numCarte;
        this.titreCarte = titreCarte;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateLimite = dateLimite;
    }

    // Getters


    public ListeModel getSaListe() {
        return saListe;
    }

    public ArrayList<MembreModel> getSesMembres() {
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


    public void setSaListe(ListeModel saListe) {
        this.saListe = saListe;
    }

    public void setTitreCarte(String titreCarte) {
        this.titreCarte = titreCarte;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }

    // Methodes
    public void ajouterMembre(MembreModel MembreModel) {
        if (!MembreModel.getSesCartes().contains(this)) {
            this.sesMembres.add(MembreModel);
            MembreModel.ajouterCarte(this);
        }
    }
    public void retirerMembre(MembreModel MembreModel){
        if (MembreModel.getSesCartes().contains(this)) {
            this.sesMembres.remove(MembreModel);
            MembreModel.retirerCarte(this);
        }
    }

    // ToString

    @Override
    public String toString() {
        return "Carte{" +
                "saListe=" + saListe +
                ", sesMembres=" + sesMembres +
                ", numCarte=" + numCarte +
                ", titreCarte='" + titreCarte + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateLimite='" + dateLimite + '\'' +
                '}';
    }
}
