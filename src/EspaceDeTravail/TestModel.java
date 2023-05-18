package EspaceDeTravail;

public class TestModel {
    public static void main(String[] args){
        //création d'un espace de travail vide
        EspaceTravail e =new EspaceTravail();
        //création d'un tableau qui aprtien a l'espace de travail crée avent
        Tableau t =new Tableau(e);
        //création d'une liste qui apartien au tableau crée presedament
        Liste l= new Liste(t,"liste1");
        //teste de l'affichage de la liste vide sans carte en sans membre.
        System.out.println("-----------affichage liste vide------------");
        System.out.println(l);
        //création d'une cartee qui appatien a la liste crée présédament
        System.out.println("-----------affichage carte vide------------");
        Carte c =new Carte(l);
        //test de l'affichage d'une carte
        System.out.println(c);
        //création d'un membre a qui appartien l'spce de travaille présédent
        Membre m = new Membre(e);
        //ajout d'une carte a la liste
        System.out.println("---------ajout d'une carte a une liste-----------");
        l.ajouterCarte(c);
        if(l.nbCarte()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        //ajout d'un menbre a la liste verifion qu'il est bien ajouter a la carte aussi
        System.out.println("---------ajout d'un membre a une liste-----------");
        l.ajouterMembre(m);
        System.out.println("--------Menbre ajouter a la liste---------");
        if(l.nbMenbre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Menbre ajouter a la carte---------");
        if(c.nbMenbre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        //maintement verifin qu'on peut suprimer un menbre a la lsite et qu'il se suprime de la carte
        System.out.println("---------suprésion d'un membre a une liste-----------");
        l.retirerMembre(m);
        System.out.println("--------Menbre suprimer a la liste---------");
        if(l.nbMenbre()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Menbre suprimer a la carte---------");
        if(c.nbMenbre()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        //supresion d'une carte a la liste
        System.out.println("---------supresion d'une carte a une liste-----------");
        l.retirerCarte(c);
        if(l.nbCarte()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
    }
}
