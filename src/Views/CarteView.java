package Views;

import Controller.CarteController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Membre;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CarteView extends JDialog {

    ////////////////////////////////
    //   Class privée (ecouteur)  //
    ////////////////////////////////
    private class CarteListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
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
            handleTitreModification();
            redessiner();
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
    private JPanel pnlDescription, pnlEditDescription, pnlDescHeader, pnlDescFooter ;
    private JLabel lblDescription;
    private JTextArea txtDescription;
    private JButton btnEnregistrerDescription, btnAnnulerDescription, btnModifierDescription;
    // -- fin description
    private JLabel lblSaListe, lblDateDebut, lblDateFin;
    private JList lstMembres;
    



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
        lblSaListe = new JLabel();
        lblDateDebut = new JLabel();
        lblDateFin = new JLabel();
        lstMembres = new JList();

        /// Parametrage de la vue graphique
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

        // Attribution de.s ecouteurs
        btnEnregistrerDescription.addActionListener(ecouteur);
        btnAnnulerDescription.addActionListener(ecouteur);
        btnModifierDescription.addActionListener(ecouteur);

        // Ajout des elements graphiques
        add(txtTitre);
        add(lblSaListe);
        add(pnlDescription);
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
        String titreCarte = _modele.getTitreCarte();
        String descriptionCarte = _modele.getDescription();
        String dateDebutCarte = _modele.getDateDebut();
        String dateFinCarte = _modele.getDateLimite();
        String saListe = _modele.getSaListe().getNomListe();
        ArrayList<Membre> membres = _modele.getSesMembres();


        txtTitre.setText(titreCarte);
        txtDescription.setText(descriptionCarte);
        lblDescription.setText(descriptionCarte);

        lblSaListe.setText("Dans la liste "+saListe);

        lblDateDebut.setText(dateDebutCarte);
        lblDateFin.setText(dateFinCarte);
        lstMembres.setListData(membres.toArray());
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
        _liste.redessiner();
    }

}