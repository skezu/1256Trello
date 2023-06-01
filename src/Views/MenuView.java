package Views;

import Controller.MenuController;
import EspaceDeTravail.Menu;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
    //////////////////////////////
    //         Attributs        //
    //////////////////////////////
    private Menu _modele;
    JPanel pnlBody;
    JLabel lblNomMenu;
    MenuController menuController;

    ////////////////////////////////
    //         Constructeur       //
    ////////////////////////////////
    public MenuView(Menu modele) {
        _modele = modele;

        // creation des composantes graphiques
        pnlBody = new JPanel();
        lblNomMenu = new JLabel("Menu principal");
        MenuController menuController = new MenuController(_modele, this);

        // configuration de la page
        setLayout(new BorderLayout());
        // mise en page
        pnlBody.add(menuController);
        add (lblNomMenu, BorderLayout.PAGE_START);
        add(pnlBody, BorderLayout.CENTER);

        

    }
}
