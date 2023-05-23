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
    Liste _modele;
    // Panel contenant les cartes
    JPanel pnlCarte;

    // Labels
    JLabel lblNomListe;

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
        pnlCarte.setBackground(Color.green);
        pnlCarte.setLayout(new GridLayout(6,1));
        lblNomListe = new JLabel();
        add(lblNomListe);
        add(pnlCarte);
        setLayout(new GridLayout(6,1));
        setBackground(AppliTrelloLite.greyPanelColor);
        setForeground(AppliTrelloLite.textPanelColor);
        redessiner();
    }

    ///////////////////////////////
    //          Methodes         //
    ///////////////////////////////
    public void ajouterCarte(Carte carte){
        CarteView carteView = new CarteView(carte);
        pnlCarte.add(carteView);
    }

    // -----------------------------
    // ||    MAJ de l'affichage   ||
    // -----------------------------

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

        Carte c = new Carte(_modele);
        // Met a jour la liste de carte
        pnlCarte.removeAll();
        for (Carte carte : _modele.getSesCartes()) {
            CarteView vue = new CarteView(carte);
            CarteController controller = new CarteController(carte, vue);
            add(controller);
        }
    }
}