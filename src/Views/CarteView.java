package Views;

import EspaceDeTravail.Carte;
import EspaceDeTravail.EspaceTravail;
import EspaceDeTravail.Membre;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarteView extends JDialog {
    /**
     * -----------------------------
     * ||         Attributs       ||
     * -----------------------------
     */
    Carte _modele;

    // Label affichant les infos de la carte
    private JLabel lblTitre;
    private JLabel lblDescription;
    private JLabel lblSaListe;
    private JLabel lblDateDebut;
    private JLabel lblDateFin;
    private JList lstMembres;



    /**
     * Constructeur de la classe CarteView.
     *
     * @param  modele  Le modele de la carte a associer a la vue.
     * @return         None
     */

    public CarteView(Carte modele) {
        // Memorise le modele associe a la vue
        _modele = modele;
        // Cree la vue graphique sur ce modele
        lblTitre = new JLabel();
        JLabel lblHDescription = new JLabel("Description");
        lblDescription = new JLabel();
        lblSaListe = new JLabel();
        lblDateDebut = new JLabel();
        lblDateFin = new JLabel();
        lstMembres = new JList();
        // Ajout des elements graphiques
        add(lblTitre);
        add(lblSaListe);
        add(lblHDescription);
        add(lblDescription);
        add(lblDateDebut);
        add(lblDateFin);
        add(lstMembres);
        // Affichage du composant graphique
        // Définition de la taille du JDialog
        int dialogWidth = AppliTrelloLite.FRAME_WIDTH - 200;
        int dialogHeight = AppliTrelloLite.FRAME_HEIGHT - 100;
        int dialogMinWidth = 700;
        int dialogMinHeight = 600;
        Dimension cardSize = new Dimension(dialogWidth, dialogHeight);
        Dimension minCardSize = new Dimension(dialogMinWidth, dialogMinHeight);
        setSize(dialogWidth, dialogHeight);
        setMaximumSize(cardSize);
        setMinimumSize(minCardSize);
        //
        setLayout(new GridLayout(0, 1));
        setBackground(AppliTrelloLite.whitePanelColor);
        setVisible(false);
        redessiner();
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
        // Récupérer les données de la carte
        String titreEspaceDeTravail = _modele.getTitreCarte();
        String descriptionEspaceDeTravail = _modele.getDescription();
        String dateDebutEspaceDeTravail = _modele.getDateDebut();
        String dateFinEspaceDeTravail = _modele.getDateLimite();
        String saListe = _modele.getSaListe().getNomListe();
        ArrayList<Membre> membres = _modele.getSesMembres();

        // Afficher les données de la carte
        lblTitre.setText(titreEspaceDeTravail);
        lblSaListe.setText("Dans la liste "+saListe);
        lblDescription.setText(descriptionEspaceDeTravail);
        lblDateDebut.setText(dateDebutEspaceDeTravail);
        lblDateFin.setText(dateFinEspaceDeTravail);
        lstMembres.setListData(membres.toArray());
    }
}