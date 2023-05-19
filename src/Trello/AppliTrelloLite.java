package Trello;

import Controller.EspaceTravailController;
import EspaceDeTravail.EspaceTravail;
import Views.EspaceTravailView;

import javax.swing.*;
import java.awt.*;

public class AppliTrelloLite {
    public static Color transparentColor = new Color(0,0,0,0);
    public static Color navBorderColor = new Color(49, 134, 188);
    public static Color navTextColor = new Color(225, 225, 225);
    public static Color mainTrelloColor = new Color(28,90,128);
    public static void main(String[] args) {
        // Creer une fenetre pour l'application
        JFrame frame = new JFrame();
        //frame.setBackground(mainTrelloColor);

        // Header de la fenetre
        frame.setTitle("Lite+ de Trello");

        // Modele espace de travail
        EspaceTravail espace1 = new EspaceTravail();

        // Vue espace de travail
        EspaceTravailView view1 = new EspaceTravailView(espace1);

        // Controlleur espace de travail
        EspaceTravailController controller1 = new EspaceTravailController(espace1, view1);


        //---- Bordure gauche de navigation
        // Panel de la partie vue et la partie controlleur
        JPanel panel1 = new JPanel();
        panel1.add(view1);
        panel1.add(controller1, BorderLayout.LINE_START);
        // Display en colonne
        panel1.setLayout(new GridLayout(2, 1));
        // Ajout du panel a la fenetre
        frame.add(panel1, BorderLayout.LINE_START);
        //----


        // Afficher la fenetre
        frame.setSize (1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
