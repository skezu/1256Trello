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
    public MenuController(Menu modele, MenuView vue) {
        _modele = modele;
        _vue = vue;

        // Mise en page
        setLayout(new GridLayout(1,0));


        // Raffraichir la page
        redessiner();
    }

    /////////////////////////////////
    //          Méthodes           //
    /////////////////////////////////
    private void dessinerEspace(Membre membre) {
        // attribution des models
        Membre _membre = membre;
        EspaceTravail _espaceTravail = _membre.getSesEspaceDeTravail().get(0);
        // creation des composantes graphiques
        JPanel pnlElement = new JPanel();
        JButton btnOuvrirEspace = new JButton(_espaceTravail.getNomEspaceDeTravail());
        EditableLabel nomProprio = new EditableLabel(_membre.getNomMembre(), pnlElement, _membre);

        // config du bouton
        btnOuvrirEspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creer une fenetre pour l'application
                JDialog frame = new JDialog();

                // Header de la fenetre
                frame.setTitle("Lite+ de Trello");
                // Modeles
                //EspaceTravail EspaceDuMembre = _espaceTravail;
                Tableau TableauDuMembre = new Tableau(_espaceTravail);
                // Vues
                System.out.println("MenuController.java:71");
                System.out.println(_espaceTravail.getSonProprietaire());
                EspaceTravailView vueEspace = new EspaceTravailView(_espaceTravail);
                TableauView vueTableau = new TableauView(TableauDuMembre);
                // Controlleur
                EspaceTravailController controllerEspace = new EspaceTravailController(_espaceTravail, vueEspace);
                // Mise en page
                frame.add(vueEspace);
                frame.setSize (FRAME_WIDTH, FRAME_HEIGHT);
                // Afficher la fenetre
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
        // mise en page
        pnlElement.setLayout(new GridLayout(0,1));
        pnlElement.setMaximumSize(new Dimension(50, 50));
        // ajout des elements
        pnlElement.add(btnOuvrirEspace);
        pnlElement.add(nomProprio);
        add(pnlElement);
    }

    public void redessiner() {
        removeAll();
        ArrayList<Membre> membres = _modele.getListeMembres();
        for (Membre membre : membres) {
            dessinerEspace(membre);
            System.out.println("nom ->>" + membre.getNomMembre());
        }

    }

}
//