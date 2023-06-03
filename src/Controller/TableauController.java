package Controller;

import EspaceDeTravail.Liste;
import EspaceDeTravail.Tableau;
import Trello.AppliTrelloLite;
import Views.TableauView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * La classe TableauController est une extension de la classe JPanel et implémente l'interface ActionListener.
 * C'est un contrôleur de la vue TableauView pour la gestion des actions liées à un tableau.
 */
public class TableauController extends JPanel implements ActionListener {

    /////////////////////////////////
    //       Attributs             //
    /////////////////////////////////

    // Modèle associé et vue au contrôleur
    Tableau _modele;
    TableauView _vue;

    // Boutons
    private JButton btnAjouterListe, btnVisibilite, btnRefresh;

    //////////////////////////////////
    //       Constructeur           //
    //////////////////////////////////

    /**
     * Constructeur de la classe TableauController.
     *
     * @param modele Le modèle associé au contrôleur.
     * @param vue    La vue associée au contrôleur.
     */
    public TableauController(Tableau modele, TableauView vue) {
        // Référence vers le modèle et la vue
        _modele = modele;
        _vue = vue;

        // Composants graphiques
        btnAjouterListe = new JButton("Ajouter une liste");
        btnVisibilite = new JButton("V");
        btnRefresh = new JButton("Rafraichir");

        // Style les boutons
        btnAjouterListe.setBackground(Color.gray);
        btnVisibilite.setBackground(AppliTrelloLite.navBorderColor);

        // Prépare la gestion des clics sur les boutons
        btnAjouterListe.setActionCommand("AJOUTER_LISTE");
        btnVisibilite.setActionCommand("VISIBILITE");
        btnRefresh.setActionCommand("REFRESH");
        btnVisibilite.addActionListener(this);
        btnAjouterListe.addActionListener(this);
        btnRefresh.addActionListener(this);

        // Set preferred width
        Dimension txtBtnPreferredSize = new Dimension(300, btnAjouterListe.getPreferredSize().height);
        Dimension iconBtnPreferredSize = new Dimension(50, btnAjouterListe.getPreferredSize().height);
        btnAjouterListe.setPreferredSize(txtBtnPreferredSize);
        btnVisibilite.setPreferredSize(iconBtnPreferredSize);

        // Mise en page
        // Ajout des composants graphiques
        add(btnAjouterListe);
        add(btnVisibilite);
        add(btnRefresh);
    }

    /**
     * Méthode invoquée lorsqu'une action se produit.
     *
     * @param e L'événement à traiter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AJOUTER_LISTE")) {
            _vue.ajouterListe(new Liste(_modele));
            System.out.println("liste ajoutée");
        } else if (e.getActionCommand().equals("VISIBILITE")) {
            System.out.println("visibilité clic");
        } else {
            System.out.println("Rafraîchissement");
        }
        _vue.redessiner();
    }
}
