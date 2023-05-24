package Trello;


import Controller.*;
import EspaceDeTravail.*;
import Views.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppliTrelloLite {

    // STATIC DIMENTIONS
    public static int FRAME_WIDTH = 1200;
    public static int FRAME_HEIGHT = 600;

    // STATIC COLORS
    public static Color transparentColor = new Color(0,0,0,0);
    public static Color navBorderColor = new Color(49, 134, 188);
    public static Color navTextColor = new Color(225, 225, 225);
    public static Color greyPanelColor = new Color(237,238,240);
    public static Color whitePanelColor = new Color(244, 245, 247);
    public static Color textPanelColor = new Color(7,14,25);
    public static Color mainTrelloColor = new Color(28,90,128);
    public static void main(String[] args) {
        // Creer une fenetre pour l'application
        JFrame frame = new JFrame();

        //frame.setBackground(mainTrelloColor);
        // Header de la fenetre
        frame.setTitle("Lite+ de Trello");
        // Modeles
        EspaceTravail espace1 = new EspaceTravail();
        Tableau tableau1 = new Tableau(espace1);
        Liste liste1 = new Liste(tableau1);
        Liste liste2 = new Liste(tableau1);
        Liste liste3 = new Liste(tableau1);
        Liste liste4 = new Liste(tableau1);
        Liste liste5 = new Liste(tableau1);
        Carte carte1 = new Carte(liste1);
        Carte carte2 = new Carte(liste1);
        Carte carte3 = new Carte(liste1);
        Carte carte4 = new Carte(liste2);
        Carte carte5 = new Carte(liste2);
        Carte carte6 = new Carte(liste3);
        // Vues
        EspaceTravailView viewEspace1 = new EspaceTravailView(espace1);
        // Controlleur
        EspaceTravailController controllerEspace1 = new EspaceTravailController(espace1, viewEspace1);
        //
        viewEspace1.ajouterHeader(controllerEspace1);

        // Ajout de l'espace de travail sur la fenetre
        frame.add(viewEspace1);

        // Afficher la fenetre
        frame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
