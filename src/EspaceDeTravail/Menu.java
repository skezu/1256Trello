package EspaceDeTravail;

import java.util.ArrayList;

public class Menu {
    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////
    private ArrayList<Membre> listeMembres;

    /////////////////////////////////
    //          Constructeur       //
    /////////////////////////////////
    public Menu(){
        EspaceTravail sonEspaceTravail = new EspaceTravail();
        Membre membre = new Membre(sonEspaceTravail);
        listeMembres = new ArrayList<Membre>();
        // Ajout d'un membre par defaut
        listeMembres.add(membre);
        System.out.println(listeMembres);
    }

    /////////////////////////////////
    //           Getter            //
    /////////////////////////////////
    public ArrayList<Membre> getListeMembres() {
        return listeMembres;
    }

    //////////////////////////////////
    //           Methodes           //
    //////////////////////////////////
    public void ajouterMembre(){
        EspaceTravail sonEspaceTravail = new EspaceTravail();
        Membre membre = new Membre(sonEspaceTravail);
        sonEspaceTravail.setSonProprietaire(membre);
        listeMembres.add(membre);
    }
    public void retirerMembre(Membre membre){
        listeMembres.remove(membre);
        membre.detruireEspaceDeTravail(membre.getSesEspaceDeTravail().get(0));
    }


    //////////////////////////////////
    //           ToString           //
    //////////////////////////////////
    @Override
    public String toString() {
        return "Menu [listeMembres=" + listeMembres + "]";
    }
    
}
