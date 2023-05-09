package EspaceDeTravail;

import javax.swing.*;
public class Vue {
    public static void afficher (EspaceDeTravail e) {
        // Declarer une reference vers une fenetre independante
        JFrame frame ;

        // Creer un objet de type fenetre independante
        frame = new JFrame ("espace de travail");//il faut chnager le nom de l'espace de travail

        // Declarer une reference vers une etiquette
        JLabel labelTest ;
        labelTest =new JLabel("test");


        // Ajouter l'etiquette dans la frame

        frame.add(labelTest);
        // Fixer la taille de la fenetre
        frame.setSize (300, 200);

        // Afficher la fenetre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible (true);
    }
    public static void afficher (Carte e) {

        // Declarer une reference vers une fenetre independante
        JFrame frame ;

        // Creer un objet de type fenetre independante
        frame = new JFrame ("carte");

        // Declarer une reference vers une etiquette
        JLabel labelTest ;
        labelTest =new JLabel("test");


        // Ajouter l'etiquette dans la frame

        frame.add(labelTest);
        // Fixer la taille de la fenetre
        frame.setSize (300, 200);

        // Afficher la fenetre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible (true);
    }
    public static void afficher (Liste e) {

        // Declarer une reference vers une fenetre independante
        JFrame frame ;

        // Creer un objet de type fenetre independante
        frame = new JFrame ("liste");//changer avec le nom de la lite

        // Declarer une reference vers une etiquette
        JLabel labelTest ;
        labelTest =new JLabel("test");


        // Ajouter l'etiquette dans la frame

        frame.add(labelTest);
        // Fixer la taille de la fenetre
        frame.setSize (300, 200);

        // Afficher la fenetre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible (true);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EspaceDeTravail e1 = new EspaceDeTravail();
        Vue ed1 =new Vue();
        ed1.afficher(e1);
    }
}
