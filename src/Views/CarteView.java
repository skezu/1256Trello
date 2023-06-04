package Views;

import Controller.CarteController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Membre;
import EspaceDeTravail.Tableau;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarteView extends JDialog {

    ////////////////////////////////
    //   Class privées            //
    ////////////////////////////////
    private class CarteListener implements ActionListener {
        /**
         * Invoqué dès qu'une action se produit
         * Permet d'enregistrer la description, et le titre de la carte
         * Et d'annuler ou modifier la modification de la description
         *
         * @param e l'evenement a traiter
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Enregistrer"))
                handleDescriptionModification();
                pnlEditDescription.setVisible(false);
                lblDescription.setVisible(true);
            if (e.getActionCommand().equals("Annuler")) {
                pnlEditDescription.setVisible(false);
                lblDescription.setVisible(true);
            }
            if (e.getActionCommand().equals("Modifier")) {
                pnlEditDescription.setVisible(true);
                lblDescription.setVisible(false);
            }
            if (e.getActionCommand().equals("Supprimer")){
                // supprime la carte definitivement
                _modele.supprimer();
                // fermer la page
                dispose();
            }
            handleTitreModification();
            redessiner();
            _liste.get_vueTableau().redessiner();
        }
    }

    private class SwitchListe extends JPanel {
        private JComboBox cbxListes;

        public SwitchListe() {
            Liste listeModel = _liste.get_modele();
            Tableau tableau = listeModel.getSonTableau();
            cbxListes = new JComboBox();
            for (Liste liste : tableau.getSesListes()) {
                cbxListes.addItem(liste.getNomListe());
            }
            cbxListes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String stringListe = cbxListes.getSelectedItem().toString();
                    Liste nouvelleListe = tableau.getListe(stringListe);
                    // Positionne la carte dans la nouvelle liste
                    listeModel.retirerCarte(_modele);
                    nouvelleListe.ajouterCarte(_modele);
                    redessiner();
                    _liste.redessiner();
                }
            });

            // ajout de la combo box
            add(cbxListes);

            pack();
            //setVisible(false);
        }
    }

    /* -----------------------------
     * ||         Attributs       ||
     * -----------------------------
     */
    Carte _modele;
    ListeView _liste;
    // Label affichant les infos de la carte
    private JTextField txtTitre;
    //-- description
    private JPanel pnlDates, pnlDescription, pnlEditDescription, pnlDescHeader, pnlDescFooter ;
    private JLabel lblDescription;
    private JTextArea txtDescription;
    private JButton btnEnregistrerDescription, btnAnnulerDescription, btnModifierDescription, btnSupprimerCarte;
    // -- fin description
    private JLabel lblSaListe, lblTitreDateDebut, lblTitreDateFin, lblDateDebut, lblDateFin;
    private JList lstMembres;
    // combo box
    private SwitchListe switchListe;



    /**
     * Constructeur de la classe CarteView.
     *
     * @param  modele  Le modele de la carte a associer a la vue.
     * @return         None
     */

    public CarteView(Carte modele, ListeView liste) {
        // Memorise le modele et la liste associe a la vue
        _modele = modele;
        _liste = liste;

        // Creation de l'ecouteur de clic
        CarteListener ecouteur = new CarteListener();

        // Creation de l'ecouteur de la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleDialogClosing();
            }
        });

        // Cree la vue graphique sur ce modele
        txtTitre = new JTextField();
        pnlDates = new JPanel();
        pnlDescription = new JPanel();
        pnlEditDescription = new JPanel();
        pnlDescHeader = new JPanel();
        pnlDescFooter = new JPanel();
        JLabel lblHDescription = new JLabel("Description"); // titre de la partie desc
        txtDescription = new JTextArea();
        lblDescription = new JLabel();
        btnAnnulerDescription = new JButton("Annuler");
        btnEnregistrerDescription = new JButton("Enregistrer");
        btnModifierDescription = new JButton("Modifier");
        btnSupprimerCarte = new JButton("Supprimer");
        lblSaListe = new JLabel();
        lblTitreDateDebut = new JLabel("Date de début :");
        lblTitreDateFin = new JLabel("Date limite :");
        lblDateDebut = new JLabel();
        lblDateFin = new JLabel();
        lstMembres = new JList();
        switchListe = new SwitchListe();

        /// Parametrage de la vue graphique
        //mise en forme de la vue dates
        pnlDates.setLayout(new GridLayout(2,2));
        //mise en forme de la vue description
        pnlDescription.setLayout(new BorderLayout());
        pnlEditDescription.setLayout(new BorderLayout());
        pnlDescHeader.setLayout(new GridLayout(1,2));
        pnlDescFooter.setLayout(new GridLayout(1,2));
        //ajout des sous elements
        pnlDescHeader.add(lblHDescription);
        pnlDescHeader.add(btnModifierDescription);
        pnlDescription.add(pnlDescHeader, BorderLayout.PAGE_START);
        pnlDescription.add(lblDescription, BorderLayout.CENTER);
        pnlEditDescription.add(txtDescription, BorderLayout.CENTER);
        pnlDescFooter.add(btnEnregistrerDescription);
        pnlDescFooter.add(btnAnnulerDescription);
        pnlEditDescription.add(pnlDescFooter, BorderLayout.PAGE_END);
        pnlDescription.add(pnlEditDescription, BorderLayout.PAGE_END);
        pnlEditDescription.setVisible(false);
        pnlDates.add(lblTitreDateDebut);
        pnlDates.add(lblDateDebut);
        pnlDates.add(lblTitreDateFin);
        pnlDates.add(lblDateFin);

        // Attribution de.s ecouteurs
        btnEnregistrerDescription.addActionListener(ecouteur);
        btnAnnulerDescription.addActionListener(ecouteur);
        btnModifierDescription.addActionListener(ecouteur);
        btnSupprimerCarte.addActionListener(ecouteur);

        // Styles des elements graphiques
        lblHDescription.setFont(new Font("Arial", Font.BOLD, 17));
        lblTitreDateDebut.setFont(new Font("Arial", Font.BOLD, 17));
        lblTitreDateFin.setFont(new Font("Arial", Font.BOLD, 17));
        btnSupprimerCarte.setBackground(Color.RED);
        btnSupprimerCarte.setForeground(AppliTrelloLite.navTextColor);
        btnSupprimerCarte.setFont(new Font("Arial", Font.BOLD, 13));

        // Ajout des elements graphiques
        add(txtTitre);
        add(lblSaListe);
        add(switchListe);
        add(pnlDescription);
        add(pnlDates);
        add(lstMembres);
        add(btnSupprimerCarte);


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
        String titreCarte = _modele.getTitreCarte();
        String descriptionCarte = _modele.getDescription();
        String dateDebutCarte = _modele.getDateDebut();
        String dateFinCarte = _modele.getDateLimite();
        String saListe = _modele.getSaListe().getNomListe();
        ArrayList<Membre> membres = _modele.getSesMembres();


        txtTitre.setText(titreCarte);
        txtDescription.setText(descriptionCarte);
        lblDescription.setText(descriptionCarte);

        lblSaListe.setText("Dans la liste " + saListe);

        lblDateDebut.setText(dateDebutCarte);
        lblDateFin.setText(dateFinCarte);
        lstMembres.setListData(membres.toArray());

        // animation date fin proche d'un jour

    }

    // Custom method to handle modification of the txtTitre field
    private void handleTitreModification() {
        String titre = txtTitre.getText();
        System.out.println("titre modif");
        // maj du titre
        _modele.setTitreCarte(titre);
    }

    // Custom method to handle modification of the txtDescription field
    private void handleDescriptionModification() {
        String description = txtDescription.getText();
        System.out.println("desc modif");
        // maj de la description
        _modele.setDescription(description);

    }

    // Custom method to handle the closing of the JDialog
    private void handleDialogClosing() {
        // Enregistre le titre et la description
        handleTitreModification();
        // Rafraichit la vue de la liste et de son tableau
        _liste.redessiner();
        _liste.get_vueTableau().redessiner();
    }

}