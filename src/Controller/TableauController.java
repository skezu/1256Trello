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

public class TableauController extends JPanel implements ActionListener {

    /////////////////////////////////
    //       Attributs             //
    /////////////////////////////////
    // Modele associe et vue au controlleur
    Tableau _modele;
    TableauView _vue;

    // Boutons
    private JButton btnAjouterListe, btnVisibilite, btnRefresh;


    //////////////////////////////////
    //       Constructeur           //
    //////////////////////////////////

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public TableauController(Tableau modele, TableauView vue) {
        // reference vers le modele et la vue
        _modele = modele;
        _vue = vue;

        // Composants graphiques
        btnAjouterListe = new JButton("Ajouter une liste");
        btnVisibilite = new JButton("V");
        btnRefresh = new JButton("Rafraichir");

        // Style les boutons
        btnAjouterListe.setBackground(Color.gray);
        btnVisibilite.setBackground(AppliTrelloLite.navBorderColor);

        // Prepare la gestion des clics sur les boutons
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
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AJOUTER_LISTE")) {
            _vue.ajouterListe(new Liste(_modele));
            System.out.println("liste ajoutée");
        } else if (e.getActionCommand().equals("VISIBILITE")) {
            System.out.println("visibilite clic");
        } else {
            System.out.println("Rafraichissement");
        }
        _vue.redessiner();
    }
}
