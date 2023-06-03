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

/**
 * La classe CarteController est une extension de la classe JPanel et implémente l'interface ActionListener.
 * C'est un contrôleur de la vue CarteView pour la gestion des actions liées à une carte.
 */
public class CarteController extends JPanel implements ActionListener {

    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////
    private static final String ACTION_EDIT_CARTE = "EDIT_CARTE";

    private Carte _modele;
    private CarteView _vue;
    private JButton _btnCarte;

    ///////////////////////////////////
    //          Constructeur         //
    ///////////////////////////////////

    /**
     * Constructeur de la classe CarteController.
     *
     * @param modele Le modèle associé au contrôleur.
     * @param vue    La vue associée au contrôleur.
     */
    public CarteController(Carte modele, CarteView vue) {
        _modele = modele;
        _vue = vue;
        _btnCarte = new JButton(_modele.getTitreCarte());
        _btnCarte.setBackground(AppliTrelloLite.whitePanelColor);
        _btnCarte.setForeground(AppliTrelloLite.textPanelColor);
        Dimension preferredSize = new Dimension(300, _btnCarte.getPreferredSize().height);
        _btnCarte.setPreferredSize(preferredSize);
        _btnCarte.setActionCommand(ACTION_EDIT_CARTE);
        _btnCarte.addActionListener(this);
        add(_btnCarte);
        setBackground(AppliTrelloLite.transparentColor);
    }

    //////////////////////////////////////
    //             Methodes             //
    //////////////////////////////////////

    /**
     * Méthode invoquée lorsqu'une action se produit.
     *
     * @param e L'événement à traiter.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_EDIT_CARTE)) {
            _vue.setVisible(!_vue.isVisible());
        }
        _vue.redessiner();
    }
}
