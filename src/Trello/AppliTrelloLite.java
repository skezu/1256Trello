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
        Carte carte1 = new Carte(liste1);
        Carte carte2 = new Carte(liste1);
        Carte carte3 = new Carte(liste1);
        Carte carte4 = new Carte(liste2);
        Carte carte5 = new Carte(liste2);
        Carte carte6 = new Carte(liste2);
        // Vues
        EspaceTravailView viewEspace1 = new EspaceTravailView(espace1);
        TableauView viewTableau1 = new TableauView(tableau1);
        /*ListeView viewListe1 = new ListeView(liste1);
        ListeView viewListe2 = new ListeView(liste2);
        ListeView viewListe3 = new ListeView(liste3);
        CarteView viewCarte1 = new CarteView(carte1);
        CarteView viewCarte2 = new CarteView(carte2);
        CarteView viewCarte3 = new CarteView(carte3);
        CarteView viewCarte4 = new CarteView(carte4);
        CarteView viewCarte5 = new CarteView(carte5);
        CarteView viewCarte6 = new CarteView(carte6);*/
        // Controlleur
        EspaceTravailController controllerEspace1 = new EspaceTravailController(espace1, viewEspace1);
        TableauController controllerTableau1 = new TableauController(tableau1, viewTableau1);
/*        ListeController controllerListe1 = new ListeController(liste1, viewListe1);
        ListeController controllerListe2 = new ListeController(liste2, viewListe2);
        ListeController controllerListe3 = new ListeController(liste3, viewListe3);
        CarteController controllerCarte1 = new CarteController(carte1, viewCarte1);
        CarteController controllerCarte2 = new CarteController(carte2, viewCarte2);
        CarteController controllerCarte3 = new CarteController(carte3, viewCarte3);
        CarteController controllerCarte4 = new CarteController(carte4, viewCarte4);
        CarteController controllerCarte5 = new CarteController(carte5, viewCarte5);
        CarteController controllerCarte6 = new CarteController(carte6, viewCarte6);*/


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
