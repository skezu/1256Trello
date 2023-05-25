package Views;

import Controller.CarteController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Membre;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListeView extends JPanel {
    /**
     * -----------------------------
     * ||         Attributs       ||
     * -----------------------------
     */
    // Modele
    private Liste _modele;
    // Panel contenant les cartes
    private JPanel pnlCarte;
    // Model contenant la liste de cartes
    private DefaultListModel<CarteController> model;
    private JList<CarteController> lstCartes;
    // Labels
    private JLabel lblNomListe;
    private JPanel pnlTitre;

    /**
     * Constructeur de la classe ListeView.
     *
     * @param  modele  Le modele de la Liste a associer a la vue.
     * @return         None
     */
    public ListeView(Liste modele){
        // Memorise le modele associe a la vue
        _modele = modele;
        // Cree la vue graphique sur ce modele
        pnlCarte = new JPanel();
        lblNomListe = new JLabel();
        pnlTitre = new JPanel();

        // mise en page
        //pnlCarte.setLayout(new BoxLayout(pnlCarte, BoxLayout.Y_AXIS));
        pnlCarte.setLayout(new GridLayout(0,1));
        setLayout(new BorderLayout());
        // setup de la liste (ajout du panel pour le nom et pour les cartes)
        pnlTitre.add(lblNomListe);
        add(pnlTitre, BorderLayout.PAGE_START);
        add(pnlCarte, BorderLayout.CENTER);




        setBackground(AppliTrelloLite.greyPanelColor);
        setForeground(AppliTrelloLite.textPanelColor);

// Set the maximum size of pnlTitre to match the preferred size of lblNomListe


        redessiner();

    }

    ///////////////////////////////
    //          Methodes         //
    ///////////////////////////////
    public void ajouterCarte(Carte carte){
        CarteView carteView = new CarteView(carte, this);
        CarteController controller = new CarteController(carte, carteView);
        pnlCarte.add(controller);
    }

    // -----------------------------
    // ||    MAJ de l'affichage   ||

    /**
     * Redessines l'Espace de Travail avec le nom, logo, and visibilite de l'espace de travail du modele.
     *
     * @param
     * @return None
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
    }
    // -----------------------------
}