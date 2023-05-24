package Views;
import Controller.EspaceTravailController;
import EspaceDeTravail.EspaceTravail;
import EspaceDeTravail.Objets;
import EspaceDeTravail.Tableau;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;

public class EspaceTravailView extends JPanel {
    /**
     * -----------------------------
     * ||         Attributs       ||
     * -----------------------------
     */
    EspaceTravail _modele;

    // Label affichant le nom de l'espace de travail
    private JLabel lblNomEspaceDeTravail;
    // Label affichant la visibilite de l'espace de travail
    private JLabel lblVisibilite;

    // Panel pour organiser la page
    private JPanel pnlHeader;
    private JPanel pnlBody;
    private JPanel pnlAside;


    /**
     * Constructeur de la classe EspaceTravailView.
     *
     * @param  modele  Le modele de l'Espace de Travail a associer a la vue.
     * @return         None
     */

    public EspaceTravailView(EspaceTravail modele) {
        // Memorise le modele associe a la vue
        _modele = modele;
        // Cree la vue graphique sur ce modele
        ///
        // Header
        ///
        pnlHeader = new JPanel();
        pnlHeader.setBackground(AppliTrelloLite.mainTrelloColor);

        ///
        // Body
        ///
        // body pris en charge par redessinner()

        pnlBody = new JPanel();
        pnlBody.setBackground(AppliTrelloLite.greyPanelColor);
        pnlBody.setLayout(new BorderLayout());

        ///
        // Aside
        ///
        pnlAside = new JPanel();
        pnlAside.setBackground(AppliTrelloLite.navBorderColor);
        //pnlAside.setLayout(new GridLayout(8,1));


        // Composants
        lblNomEspaceDeTravail = new JLabel();
        lblNomEspaceDeTravail.setForeground(AppliTrelloLite.navTextColor);
        pnlHeader.add(lblNomEspaceDeTravail);

        /// Format page
        setLayout(new BorderLayout());
        add(pnlHeader, BorderLayout.PAGE_START);
        add(pnlBody, BorderLayout.CENTER);
        add(pnlAside, BorderLayout.LINE_START);
        setBackground(AppliTrelloLite.navBorderColor);
        redessiner();
    }

        ////////////////////////////////
        //          Methodes          //
        ////////////////////////////////

        public void ajouterHeader(EspaceTravailController c){
        pnlHeader.add(c);
        }
        public void setPage(JPanel p){
        pnlBody.removeAll();
        pnlBody.add(p, BorderLayout.CENTER);
        }
        public void ajouterAside(JPanel p){
            pnlAside.add(p);
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
            // Recuperer le titre de l'espace de travail du modele
            String titreEspaceDeTravail = _modele.getNomEspaceDeTravail();
            // Recuperer le logo de l'espace de travail du modele
            String logoEspaceDeTravail = _modele.getLogoEspaceDeTravail();
            // Recuperer la visibilite de l'espace de travail du modele
            //String visibiliteEspaceDeTravail = _modele.getSaVisibilité().toString(); // <- faire en sorte d'avoir un visibilite.getNom()

            // Afficher le nom de l'espace de travail
            lblNomEspaceDeTravail.setText(titreEspaceDeTravail);
            // Afficher le logo de l'espace de travail
            // TODO : Afficher le logo de l'espace de travail
            // Afficher la visibilite de l'espace de travail
            //lblVisibilite.setText(visibiliteEspaceDeTravail);

            // Afficher les tableaux de l'espace de travail
            if (_modele.getSesTableaux() != null) {
                Tableau tableau = _modele.getSesTableaux().get(0);
                TableauView tableauView = new TableauView(tableau);
                JPanel pnlTableau = new JPanel();
                pnlTableau.add(tableauView);
                setPage(pnlTableau);
            }

            // TODO : Faire un truc pour selectionner le tableau specifique

        }
}
