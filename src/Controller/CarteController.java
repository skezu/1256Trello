package Controller;

import EspaceDeTravail.Carte;
import EspaceDeTravail.EspaceTravail;
import Trello.AppliTrelloLite;
import Views.CarteView;
import Views.EspaceTravailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarteController extends JPanel implements ActionListener {
    //-----------------------------
    // Constantes ACTION pour la gestion des evenements
    // (plus general que d'utiliser le nom du bouton :
    // plusieurs boutons peuvent declencher la meme action)
    //-----------------------------
    private static final String ACTION_EDIT_CARTE = "EDIT_CARTE";

    //-----------------------------
    //         Attributs         ||
    //-----------------------------

    // Reference vers modele et vue
    private Carte _modele;
    private CarteView _vue;

    // Composante graphique de la partie controleur de l'interface
    JButton _btnCarte;

    //-----------------------------
    //         Constructeur      ||
    //-----------------------------

    public CarteController(Carte modele, CarteView vue) {
        // Memorise le modele associe au controleur
        _modele = modele;
        // Memorise la vue associe au controleur
        _vue = vue;
        // Cree les boutons
        _btnCarte = new JButton(_modele.getTitreCarte());
        // Style les boutons
        _btnCarte.setBackground(AppliTrelloLite.whitePanelColor);
        _btnCarte.setForeground(AppliTrelloLite.textPanelColor);
        //_btnCarte.setBorderPainted(false);

        // Set preferred width
        Dimension preferredSize = new Dimension(300, _btnCarte.getPreferredSize().height);
        _btnCarte.setPreferredSize(preferredSize);
        // Prepare la gestion des clics sur les boutons
        _btnCarte.setActionCommand(ACTION_EDIT_CARTE);
        // C'est CE controlleur qui va ecouter ces boutons
        _btnCarte.addActionListener(this);
        // Ajout du bouton
        add(_btnCarte);
        setBackground(AppliTrelloLite.transparentColor);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Trouve le bouton qui a declanche l'evenement
        if (e.getActionCommand().equals(ACTION_EDIT_CARTE)) {
            // Affiche la vue de la carte
            _vue.setVisible(!_vue.isVisible());
        }

        // Rafraichir la vue
        _vue.redessiner();
    }
}