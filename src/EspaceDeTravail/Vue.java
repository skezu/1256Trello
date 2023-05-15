package EspaceDeTravail;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.GridLayout;

public class Vue {

    public void afficher (EspaceTravail e) {
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
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EspaceTravail e1 = new EspaceTravail();
        ArrayList<Tableau> t1 = new ArrayList<Tableau>();
        Vue ed1 =new Vue();
        ed1.afficher(e1);
    }
}
