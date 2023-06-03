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

public class ListeController extends JPanel implements ActionListener {
    //-----------------------------
    // Constantes ACTION pour la gestion des evenements
    // (plus general que d'utiliser le nom du bouton :
    // plusieurs boutons peuvent declencher la meme action)
    //-----------------------------
    private static final String ACTION_ADD_CARTE = "ADD_CARTE";

    //-----------------------------
    //         Attributs         ||
    //-----------------------------

    // Reference vers modele et vue
    private Liste _modele;
    private ListeView _vue;

    // Composante graphique de la partie controleur de l'interface
    JButton _btnAjouterCarte;

    //-----------------------------
    //         Constructeur      ||
    //-----------------------------
    public ListeController(Liste modele, ListeView vue) {
        // Reference vers modele et vue
        _modele = modele;
        _vue = vue;
        // Composante graphique de la partie controleur de l'interface
        _btnAjouterCarte = new JButton("Ajouter une carte");
        _btnAjouterCarte.setBackground(AppliTrelloLite.greyPanelColor);
        _btnAjouterCarte.setForeground(AppliTrelloLite.textPanelColor);
        _btnAjouterCarte.setBorderPainted(false);
         // Gestion des dimensions
        Dimension preferredSize = new Dimension(300, _btnAjouterCarte.getPreferredSize().height);
        _btnAjouterCarte.setPreferredSize(preferredSize);
        // Prepare la gestion des clics sur les boutons
        _btnAjouterCarte.setActionCommand(ACTION_ADD_CARTE);
        // C'est CE controlleur qui va ecouter ces boutons
        _btnAjouterCarte.addActionListener(this);
        add(_btnAjouterCarte);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_ADD_CARTE)) {
            Carte nouvelleCarte = new Carte(_modele);
        }
        // Rafraichir la vue de la liste et du tableau
        _vue.redessiner();
        _vue.get_vueTableau().redessiner();
    }
}
