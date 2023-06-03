package Controller;

import EspaceDeTravail.*;
import EspaceDeTravail.Menu;
import Views.EspaceTravailView;
import Views.MenuView;
import Views.TableauView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static Trello.AppliTrelloLite.FRAME_HEIGHT;
import static Trello.AppliTrelloLite.FRAME_WIDTH;

/**
 * La classe MenuController est le contrôleur associé à la vue MenuView.
 * Il gère les actions et les interactions avec le menu principal de l'application.
 */
public class MenuController extends JPanel {
    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////

    private Menu _modele;
    private MenuView _vue;
    private JButton btnCreerEspace;


    /////////////////////////////////
    //          Constructeur       //
    /////////////////////////////////

    /**
     * Constructeur de la classe MenuController.
     * Crée un nouveau contrôleur pour le menu principal.
     *
     * @param modele Le modèle de menu associé au contrôleur.
     * @param vue    La vue de menu associée au contrôleur.
     */
    public MenuController(Menu modele, MenuView vue) {
        _modele = modele;
        _vue = vue;

        // Mise en page
        setLayout(new GridLayout(1, 0));

        // Rafraîchir la page
        redessiner();
    }

    /////////////////////////////////
    //          Méthodes           //
    /////////////////////////////////

    /**
     * Dessine l'espace de travail pour un membre donné.
     *
     * @param membre Le membre associé à l'espace de travail à dessiner.
     */
    private void dessinerEspace(Membre membre) {
        // Attribution des modèles
        Membre _membre = membre;
        EspaceTravail _espaceTravail = _membre.getSesEspaceDeTravail().get(0);

        // Création des composantes graphiques
        JPanel pnlElement = new JPanel();
        JButton btnOuvrirEspace = new JButton(_espaceTravail.getNomEspaceDeTravail());
        EditableLabel nomProprio = new EditableLabel(_membre.getNomMembre(), pnlElement, _membre);

        // Configuration du bouton
        btnOuvrirEspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Créer une fenêtre pour l'application
                JDialog frame = new JDialog();

                // Header de la fenêtre
                frame.setTitle("Lite+ de Trello");

                // Modèles
                Tableau TableauDuMembre = new Tableau(_espaceTravail);

                // Vues
                EspaceTravailView vueEspace = new EspaceTravailView(_espaceTravail);
                TableauView vueTableau = new TableauView(TableauDuMembre);

                // Contrôleur
                EspaceTravailController controllerEspace = new EspaceTravailController(_espaceTravail, vueEspace);

                // Mise en page
                frame.add(vueEspace);
                frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

                // Afficher la fenêtre
                frame.setVisible(true);
            }
        });

        // Mise en page
        pnlElement.setLayout(new GridLayout(0, 1));
        pnlElement.setMaximumSize(new Dimension(50, 50));

        // Ajout des éléments
        pnlElement.add(btnOuvrirEspace);
        pnlElement.add(nomProprio);
        add(pnlElement);
    }

    /**
     * Redessine la vue du menu en affichant les espaces de travail des membres.
     */
    public void redessiner() {
        removeAll();
        ArrayList<Membre> membres = _modele.getListeMembres();
        for (Membre membre : membres) {
            dessinerEspace(membre);
            System.out.println("nom ->>" + membre.getNomMembre());
        }
    }
}
