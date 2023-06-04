package Views;

import Controller.CarteController;
import Controller.EditableLabel;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Membre;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListeView extends JPanel {

    ///////////////////////////////
    //         Attributs         //
    ///////////////////////////////

    // Vue de son tableau
    private TableauView _vueTableau;
    // Modele
    private Liste _modele;
    // Panel contenant les cartes
    private JPanel pnlCarte;
    // Model contenant la liste de cartes
    private DefaultListModel<CarteController> model;
    private JList<CarteController> lstCartes;
    // Labels
    private EditableLabel lblNomListe;
    private JButton btnRetirerListe;
    private JPanel pnlTitre;

    ///////////////////////////////////
    //          Constructeur         //
    ///////////////////////////////////
    /**
     * Constructeur de la classe ListeView.
     *
     * @param  modele  Le modele de la Liste a associer a la vue.
     * @param  vueTableau La vue du tableau
     * @return         None
     */
    public ListeView(Liste modele, TableauView vueTableau){
        // Memorise la vue du tableau
        _vueTableau = vueTableau;
        // Memorise le modele associe a la vue
        _modele = modele;
        // Cree la vue graphique sur ce modele
        pnlCarte = new JPanel();
        pnlTitre = new JPanel();
        lblNomListe = new EditableLabel("", pnlTitre, _modele);
        btnRetirerListe = new JButton("X");

        // configuration rapide du bouton
        btnRetirerListe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer la liste
                boolean supprime = _modele.supprimer();
                if (supprime) _vueTableau.redessiner();
                redessiner();
            }
        });
        // mise en page
        //pnlCarte.setLayout(new BoxLayout(pnlCarte, BoxLayout.Y_AXIS));
        pnlCarte.setLayout(new GridLayout(0,1));
        setLayout(new BorderLayout());
        // setup de la liste (ajout du panel pour le nom et pour les cartes)
        pnlTitre.add(lblNomListe);
        pnlTitre.add(btnRetirerListe);
        add(pnlTitre, BorderLayout.PAGE_START);
        add(pnlCarte, BorderLayout.CENTER);




        setBackground(AppliTrelloLite.greyPanelColor);
        setForeground(AppliTrelloLite.textPanelColor);

// Set the maximum size of pnlTitre to match the preferred size of lblNomListe


        redessiner();

    }

    ///////////////////////////////
    //          Getters          //
    ///////////////////////////////
    public Liste get_modele() {
        return _modele;
    }
    public TableauView get_vueTableau() {
        return _vueTableau;
    }

    ///////////////////////////////
    //          Methodes         //
    ///////////////////////////////
    public void ajouterCarte(Carte carte){
        CarteView carteView = new CarteView(carte, this);
        CarteController controller = new CarteController(carte, carteView);
        pnlCarte.add(controller);
    }

    ////////////////////////////////
    //     MAJ de l'affichage     //
    ////////////////////////////////
    /**
     * Redessines la liste avec le nom et les cartes du modele.
     */
    public void redessiner() {
        // Recuperer les donnees
        String nomListe = _modele.getNomListe();
        // Afficher le nom de l'espace de travail
        lblNomListe.setText(nomListe);
        // Rafraichir le panel des cartes
        pnlCarte.removeAll();
        // Ajouter les cartes dans la liste
        for (Carte carte : _modele.getSesCartes()){
            ajouterCarte(carte);
        }
        pnlCarte.revalidate();
        pnlCarte.repaint();
    }

    // -----------------------------
}