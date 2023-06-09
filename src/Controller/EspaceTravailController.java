package Controller;

import EspaceDeTravail.EspaceTravail;
import Trello.AppliTrelloLite;
import Views.EspaceTravailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe EspaceTravailController est une extension de la classe JPanel et implémente l'interface ActionListener.
 * C'est un contrôleur de la vue EspaceTravailView pour la gestion des actions liées à un espace de travail.
 */
public class EspaceTravailController extends JPanel implements ActionListener {
    //-----------------------------
    // Constantes ACTION pour la gestion des evenements
    // (plus general que d'utiliser le nom du bouton :
    // plusieurs boutons peuvent declencher la meme action)
    //-----------------------------
    private static final String ACTION_EDIT_TABLEAUX = "EDIT_TABLEAUX";
    private static final String ACTION_EDIT_MEMBRES = "EDIT_MEMBRES";

    //-----------------------------
    //         Attributs         ||
    //-----------------------------

    // Reference vers modele et vue
    private EspaceTravail _modele;
    private EspaceTravailView _vue;

    // Composante graphique de la partie controleur de l'interface
    JButton _btnMembres;
    JButton _btnTableaux;

    //-----------------------------
    //         Constructeur      ||
    //-----------------------------
    /**
     * Constructeur de la classe EspaceTravailController.
     *
     * @param modele Le modèle associé au contrôleur.
     * @param vue    La vue associée au contrôleur.
     */
    public EspaceTravailController(EspaceTravail modele, EspaceTravailView vue) {
        // Memorise le modele associe au controleur
        _modele = modele;
        // Memorise la vue associee au controleur
        _vue = vue;
        // Cree les boutons
        _btnMembres = new JButton("Membres");
        _btnTableaux = new JButton("Tableaux");
        // Style les boutons
        _btnMembres.setBackground(AppliTrelloLite.navBorderColor);
        _btnTableaux.setBackground(AppliTrelloLite.navBorderColor);
        _btnMembres.setForeground(AppliTrelloLite.navTextColor);
        _btnTableaux.setForeground(AppliTrelloLite.navTextColor);
        _btnMembres.setBorderPainted(false);
        _btnTableaux.setBorderPainted(false);
        

        // Set preferred width
        Dimension preferredSize = new Dimension(300, _btnMembres.getPreferredSize().height);
        _btnMembres.setPreferredSize(preferredSize);
        _btnTableaux.setPreferredSize(preferredSize);
        // Prepare la gestion des clics sur les boutons
        _btnMembres.setActionCommand(ACTION_EDIT_MEMBRES);
        _btnTableaux.setActionCommand(ACTION_EDIT_TABLEAUX);
        // C'est ce controlleur qui va ecouter ces boutons
        _btnMembres.addActionListener(this);
        _btnTableaux.addActionListener(this);
        // Ajout d'un panel des deux boutons
        JPanel pnlBoutons = new JPanel();
        pnlBoutons.add(_btnMembres);
        pnlBoutons.add(_btnTableaux);
        // Met un bouton en dessous de l'autre
        pnlBoutons.setLayout(new GridLayout(1,2));
        // Ajout du panel des boutons
        add(pnlBoutons);
        setBackground(AppliTrelloLite.navBorderColor);





    }


    /**
     * Méthode invoquée lorsqu'une action se produit.
     *
     * @param e L'événement à traiter.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Trouve le bouton qui a declanche l'evenement
        switch (e.getActionCommand()) {
            case ACTION_EDIT_MEMBRES:
                System.out.println("ACTION_EDIT_MEMBRES");
                // Affiche la vue de gestion des membres
                // TODO ouvrire la fenetre de gestion des membres
                break;
            case ACTION_EDIT_TABLEAUX:
                System.out.println("ACTION_EDIT_TABLEAUX");
                // Affiche la vue de gestion des tableaux
                JPanel pnlTabs = new JPanel();
                JLabel lblTabs = new JLabel("Tabs");
                pnlTabs.add(lblTabs);
                // TODO ouvrire la fenetre de gestion des tableaux
                //_vue.setPage(pnlTabs);
                //_vue.clearPage();
                break;
            default:
                break;
        }
        // Rafraichir la vue
        _vue.redessiner();
    }
}



