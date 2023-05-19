package Controller;

import EspaceDeTravail.EspaceTravail;
import Views.EspaceTravailView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public EspaceTravailController(EspaceTravail modele, EspaceTravailView vue) {
        // Memorise le modele associe au controleur
        _modele = modele;
        // Memorise la vue associee au controleur
        _vue = vue;
        // Cree les boutons
        _btnMembres = new JButton("Membres");
        _btnTableaux = new JButton("Tableaux");
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
        pnlBoutons.setLayout(new GridLayout(2,1));
        // Ajout du panel des boutons
        add(pnlBoutons);





    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Trouve le bouton qui a declanche l'evenement
        if (e.getActionCommand().equals(ACTION_EDIT_MEMBRES)) {
            // Affiche la vue de gestion des membres
            // TODO ouvrire la fenetre de gestion des membres
        } else if (e.getActionCommand().equals(ACTION_EDIT_TABLEAUX)) {
            // Affiche la vue de gestion des tableaux
            // TODO ouvrire la fenetre de gestion des tableaux
        }

        // Rafraichir la vue
        _vue.redessiner();
    }
}



