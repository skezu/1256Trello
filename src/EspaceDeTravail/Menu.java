package EspaceDeTravail;

import java.util.ArrayList;

/**
 * La classe Menu représente le menu principal de l'application.
 */
public class Menu {
    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////

    /**
     * La liste des membres du menu.
     */
    private ArrayList<Membre> listeMembres;

    /////////////////////////////////
    //          Constructeur       //
    /////////////////////////////////

    /**
     * Constructeur de la classe Menu.
     * Crée un nouveau menu avec un membre par défaut.
     */
    public Menu() {
        EspaceTravail sonEspaceTravail = new EspaceTravail();
        Membre membre = new Membre(sonEspaceTravail);
        listeMembres = new ArrayList<Membre>();
        // Ajout d'un membre par défaut
        listeMembres.add(membre);
        System.out.println(listeMembres);
    }

    /////////////////////////////////
    //           Getter            //
    /////////////////////////////////

    /**
     * Retourne la liste des membres du menu.
     *
     * @return La liste des membres.
     */
    public ArrayList<Membre> getListeMembres() {
        return listeMembres;
    }

    //////////////////////////////////
    //           Methodes           //
    //////////////////////////////////

    /**
     * Ajoute un nouveau membre à la liste des membres du menu.
     * Crée également un nouvel espace de travail associé au membre.
     */
    public void ajouterMembre() {
        EspaceTravail sonEspaceTravail = new EspaceTravail();
        Membre membre = new Membre(sonEspaceTravail);
        sonEspaceTravail.setSonProprietaire(membre);
        listeMembres.add(membre);
    }

    /**
     * Retire un membre de la liste des membres du menu.
     * Détruit également l'espace de travail associé au membre.
     *
     * @param membre Le membre à retirer.
     */
    public void retirerMembre(Membre membre) {
        listeMembres.remove(membre);
        membre.detruireEspaceDeTravail(membre.getSesEspaceDeTravail().get(0));
    }

    //////////////////////////////////
    //           ToString           //
    //////////////////////////////////

    /**
     * Retourne une représentation sous forme de chaîne de caractères du menu.
     *
     * @return La représentation du menu.
     */
    @Override
    public String toString() {
        return "Menu [listeMembres=" + listeMembres + "]";
    }

}
