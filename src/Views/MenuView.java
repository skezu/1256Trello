package Views;

import Controller.MenuController;
import EspaceDeTravail.Log;
import EspaceDeTravail.Menu;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La classe MenuView représente la vue du menu principal de l'application.
 * Elle affiche les membres du menu et permet d'ajouter de nouveaux membres.
 */
public class MenuView extends JPanel {
    //////////////////////////////
    //         Attributs        //
    //////////////////////////////
    Log log = Log.getInstance();
    private LogView logView;
    private Menu _modele;
    private JPanel pnlBody;
    private JLabel lblNomMenu;
    private JButton btnAjouterMembreCarte, btnAfficherLogs;
    private MenuController menuController;


    ////////////////////////////////
    //         Constructeur       //
    ////////////////////////////////

    /**
     * Constructeur de la classe MenuView.
     * Crée une nouvelle vue pour le menu principal.
     *
     * @param modele Le modèle de menu à associer à la vue.
     */
    public MenuView(Menu modele) {
        _modele = modele;
        logView = new LogView(log);

        // Création des composantes graphiques
        pnlBody = new JPanel();
        btnAjouterMembreCarte = new JButton("+");
        btnAfficherLogs = new JButton("Logs");
        lblNomMenu = new JLabel("Menu principal");
        menuController = new MenuController(_modele, this);

        // Styles des composantes
        lblNomMenu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lblNomMenu.setForeground(AppliTrelloLite.textPanelColor);
        lblNomMenu.setHorizontalAlignment(SwingConstants.CENTER);

        // Configuration des boutons
        btnAjouterMembreCarte.addActionListener(new ActionListener() {
            /**
             * Ajoute un membre et raffraichit la vue
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                _modele.ajouterMembre();
                redessiner();
            }
        });

        btnAfficherLogs.addActionListener(new ActionListener() {
            /**
             * Ouvre la page des logs
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setVue(logView);
               logView.setVisible(true);
            }
        });

        // Configuration de la page
        setLayout(new BorderLayout());

        // Mise en page
        pnlBody.add(menuController);
        pnlBody.add(btnAjouterMembreCarte);
        add(lblNomMenu, BorderLayout.PAGE_START);
        add(pnlBody, BorderLayout.CENTER);
        add(btnAfficherLogs, BorderLayout.PAGE_END);
    }

    /////////////////////////////////
    //          Méthodes           //
    /////////////////////////////////

    /**
     * Redessine la vue du menu.
     */
    public void redessiner() {
        System.out.println(_modele.getListeMembres().size());
        menuController.redessiner();
        pnlBody.revalidate();
        pnlBody.repaint();
    }
}
