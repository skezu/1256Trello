package Controller;

import EspaceDeTravail.*;
import EspaceDeTravail.Menu;
import Views.EspaceTravailView;
import Views.MenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Trello.AppliTrelloLite.FRAME_HEIGHT;
import static Trello.AppliTrelloLite.FRAME_WIDTH;

public class MenuController extends JPanel implements ActionListener {
    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////
    private Menu _modele;
    private MenuView _vue;
    JButton btnCreerEspace;


    /////////////////////////////////
    //          Constructeur       //
    /////////////////////////////////
    public MenuController(Menu modele, MenuView vue) {
        _modele = modele;
        _vue = vue;

        // Mise en page
        setLayout(new GridLayout(0,1));


        // Raffraichir la page
        redessiner();
    }

    /////////////////////////////////
    //          Méthodes           //
    /////////////////////////////////
    private void dessinerEspace(Membre membre) {
        // creation des composantes graphiques
        JPanel pnlElement = new JPanel();
        JButton btnOuvrirEspace = new JButton(membre.getSesEspaceDeTravail().get(0).getNomEspaceDeTravail());
        JLabel nomProprio = new JLabel(membre.getNomMembre());
        // config du bouton
        btnOuvrirEspace.addActionListener(this);
        btnOuvrirEspace.setActionCommand("OUVRIR_ESPACE");
        // mise en page
        pnlElement.setLayout(new GridLayout(0,1));
        pnlElement.setMaximumSize(new Dimension(50, 50));
        // ajout des elements
        pnlElement.add(btnOuvrirEspace);
        pnlElement.add(nomProprio);
        add(pnlElement);
        //
    }

    public void redessiner() {
        ArrayList<Membre> membres = _modele.getListeMembres();
        for (Membre membre : membres) {
            //dessinerEspace(membre);
            System.out.println("nom ->>" + membre.getNomMembre());
        }

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OUVRIR_ESPACE")) {

        }
    }

}
//