package Controller;

import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import Trello.AppliTrelloLite;
import Views.CarteView;
import Views.ListeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe ListeController est une extension de la classe JPanel et implémente l'interface ActionListener.
 * C'est un contrôleur de la vue ListeView pour la gestion des actions liées à une liste.
 */
public class ListeController extends JPanel implements ActionListener {
    //-----------------------------
    // Constantes ACTION pour la gestion des événements
    //-----------------------------
    private static final String ACTION_ADD_CARTE = "ADD_CARTE";

    //-----------------------------
    //         Attributs         ||
    //-----------------------------

    // Référence vers modèle et vue
    private Liste _modele;
    private ListeView _vue;

    // Composante graphique de la partie contrôleur de l'interface
    JButton _btnAjouterCarte;

    ///////////////////////////////
    //         Constructeur      //
    ///////////////////////////////

    /**
     * Constructeur de la classe ListeController.
     *
     * @param modele Le modèle associé au contrôleur.
     * @param vue    La vue associée au contrôleur.
     */
    public ListeController(Liste modele, ListeView vue) {
        // Référence vers modèle et vue
        _modele = modele;
        _vue = vue;

        // Composante graphique de la partie contrôleur de l'interface
        _btnAjouterCarte = new JButton("Ajouter une carte");
        _btnAjouterCarte.setBackground(AppliTrelloLite.greyPanelColor);
        _btnAjouterCarte.setForeground(AppliTrelloLite.textPanelColor);
        _btnAjouterCarte.setBorderPainted(false);

        // Gestion des dimensions
        Dimension preferredSize = new Dimension(300, _btnAjouterCarte.getPreferredSize().height);
        _btnAjouterCarte.setPreferredSize(preferredSize);

        // Prépare la gestion des clics sur les boutons
        _btnAjouterCarte.setActionCommand(ACTION_ADD_CARTE);

        // C'est CE contrôleur qui va écouter ces boutons
        _btnAjouterCarte.addActionListener(this);

        add(_btnAjouterCarte);
    }

    /////////////////////////////////
    //          Methodes           //
    /////////////////////////////////
    /**
     * Méthode invoquée lorsqu'une action se produit.
     *
     * @param e L'événement à traiter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_ADD_CARTE)) {
            Carte nouvelleCarte = new Carte(_modele);
        }

        // Rafraîchir la vue de la liste et du tableau
        _vue.redessiner();
        _vue.get_vueTableau().redessiner();
    }
}
