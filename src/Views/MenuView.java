package Views;

import Controller.MenuController;
import EspaceDeTravail.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JPanel {
    //////////////////////////////
    //         Attributs        //
    //////////////////////////////
    private Menu _modele;
    private JPanel pnlBody;
    private JLabel lblNomMenu;
    private JButton btnAjouterMembreCarte;
    private MenuController menuController;

    ////////////////////////////////
    //         Constructeur       //
    ////////////////////////////////
    public MenuView(Menu modele) {
        _modele = modele;

        // creation des composantes graphiques
        pnlBody = new JPanel();
        btnAjouterMembreCarte = new JButton("+");
        lblNomMenu = new JLabel("Menu principal");
        menuController = new MenuController(_modele, this);
        // config des boutons
        btnAjouterMembreCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _modele.ajouterMembre();
                redessiner();
            }
        });
        // configuration de la page
        setLayout(new BorderLayout());
        // mise en page
        pnlBody.add(menuController);
        pnlBody.add(btnAjouterMembreCarte);
        add (lblNomMenu, BorderLayout.PAGE_START);
        add(pnlBody, BorderLayout.CENTER);

    }

    /////////////////////////////////
    //          Méthodes           //
    /////////////////////////////////
    public void redessiner() {
        System.out.println(_modele.getListeMembres().size());
        menuController.redessiner();
        pnlBody.revalidate();
        pnlBody.repaint();
    }
}
