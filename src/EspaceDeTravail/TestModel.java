package EspaceDeTravail;

public class TestModel {
    public static void main(String[] args){
        //création d'un espace de travail vide
        EspaceTravail e =new EspaceTravail();
        EspaceTravail e2 =new EspaceTravail();
        System.out.println("-----------affichage Espace de Tarvail vide------------");
        System.out.println(e);
        //création d'un tableau qui aprtien a l'espace de travail crée avent
        Tableau t =new Tableau(e);
        System.out.println("-----------affichage Tableau vide------------");
        System.out.println(t);
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
        //création d'un membre a qui appartien l'espace de travaille présédent
        Membre m = new Membre(e);
        System.out.println("-----------affichage Membre ------------");
        System.out.println(m);


        //ajout d'une carte a la liste
        System.out.println("---------ajout d'une carte a une liste-----------");
        l.ajouterCarte(c);
        if(l.nbCarte()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        //ajout d'une liste au tableau
        System.out.println("---------ajout d'une liste a un tableau-----------");
        t.ajouterListe(l);
        if(t.nbLsite()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        //ajout d'un tableau a un espace de travail
        System.out.println("---------ajout d'un tableau a un espace de travail-----------");
        e2.ajouterTableau(t);
        if(e2.nbTableau()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        //ajout d'un menbre a un espace de travail est il ajouter a la liste et son tableau verifion qu'il est bien ajouter a la carte aussi
        System.out.println("---------ajout d'un membre a un espace de travail-----------");
        e2.ajouterMembre(m);
        System.out.println("--------Membre ajouter a un espace de travail---------");
        if(e2.nbMembre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------espace de travail est il ajouter a membre---------");
        if (m.nbAutreEspaceTravail()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        System.out.println("--------Membre ajouter a la liste---------");
        if(l.nbMembre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");

        }
        System.out.println("--------liste est elle ajouter a membre---------");
        if (m.nbListe()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Membre ajouter a un Tableau---------");
        if(t.nbMembre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Tableau est il ajouter a membre---------");
        if (m.nbTableau()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        System.out.println("--------Membre ajouter a la carte---------");
        if(c.nbMembre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("-------- catre est elle ajouter a membre---------");
        if (m.nbCarte()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        //maintement verifin qu'on peut suprimer un menbre a un espace de travail et qu'il se suprime de la carte et de la liste et du tableau
        System.out.println("---------suprésion d'un membre a un espace de travail-----------");
        e2.retirerMembre(m);
        System.out.println("--------Membre suprimer a un espace de travail---------");
        if(e2.nbMembre()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Membre suprimer a un tableau---------");
        if(t.nbMembre()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Membre suprimer a la liste---------");
        if(l.nbMembre()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("--------Membre suprimer a la carte---------");
        if(c.nbMembre()==0){
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
        //supresion d'une liste a un Tableau
        System.out.println("---------supresion d'une liste a un Tableau-----------");
        t.retirerListe(l);
        if(t.nbLsite()==0){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        //test des methode supprimer
        System.out.println("---------test des methode supprimer------------");
        System.out.println("----------suprimer carte----------");
        if(c.supprimer()){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("----------suprimer liste----------");
        if(l.supprimer()){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("----------suprimer tableau----------");
        if(t.supprimer()){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("----------suprimer espace de travail----------");
        if(e2.supprimer()){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        //teste création d'un espace de travail a patir d'un menbre
        EspaceTravail espace =m.creeEspaceDetravail();
        EspaceTravail espacenom= m.creeEspaceDetravail("un nom");
        System.out.println("-----------l'espace de travail est il crée avec un membre-----------");
        if(espace.nbMembre()==1){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("-----------le menbre a tile bien l'espace de travail qui est ajouter -----------");
        if(m.nbEspaceDetravail()==3){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("------------l'espace de travail est il bien crée avec un nom------------");
        if(espacenom.getNomEspaceDeTravail()=="un nom"){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

        System.out.println("-----------destruction d'un espace de travail d'un menbre-----------");
        if (m.detruireEspaceDeTravail(espace)){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }
        System.out.println("-----------destruction d'un espace de travail imposible car il ne lui appartien pas-----------");
        if (!m.detruireEspaceDeTravail(e2)){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }


        System.out.println("----------suprimer eun membre----------");
        if(m.supprimer()){
            System.out.println("ok");
        }
        else {
            System.out.println("Erreur");
        }

    }
}
