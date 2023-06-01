package Trello;


import Controller.*;
import EspaceDeTravail.*;
import EspaceDeTravail.Menu;
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

        //Menu menu1 = new Menu();
        // Vues
        EspaceTravailView viewEspace1 = new EspaceTravailView(espace1);
        //MenuView menuView1 = new MenuView(menu1);

        // Controlleur
        EspaceTravailController controllerEspace1 = new EspaceTravailController(espace1, viewEspace1);
        //
        viewEspace1.ajouterHeader(controllerEspace1);

        // Ajout de l'espace de travail sur la fenetre
        frame.add(viewEspace1);
        //frame.add(menuView1);
        // Afficher la fenetre
        frame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        //frame.setSize (700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
