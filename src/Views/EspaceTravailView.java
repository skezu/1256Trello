package Views;
import Controller.EditableLabel;
import Controller.EspaceTravailController;
import Controller.TableauController;
import EspaceDeTravail.EspaceTravail;
import EspaceDeTravail.Membre;
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
    Membre _membre;

    // Label affichant le nom de l'espace de travail et du membre
    private JLabel lblNomEspaceDeTravail;
    private EditableLabel lblNomMembre;
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
        _membre = _modele.getSonProprietaire();
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
        lblNomMembre = new EditableLabel("", pnlHeader, _membre);
        lblNomEspaceDeTravail.setForeground(AppliTrelloLite.navTextColor);
        lblNomMembre.setForeground(AppliTrelloLite.navTextColor);
        pnlHeader.add(lblNomEspaceDeTravail);
        pnlHeader.add(lblNomMembre);

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
        p.setVisible(true);
        }
        public void clearPage(){
        pnlBody.removeAll();
        redessiner();
        }
        public void ajouterAside(JPanel p){
            pnlAside.add(p);
        }

        // -----------------------------
        // ||    MAJ de l'affichage   ||
        // -----------------------------

        /**
         * Redessines l'Espace de Travail avec le nom, logo, and visibilite de l'espace de travail du modele.
         */
        public void redessiner() {
            // Recuperer le titre de l'espace de travail du modele (ainsi que du membre)
            String titreMembreTitulaire = "";
            if (_modele.getSonProprietaire() != null){
                titreMembreTitulaire = _modele.getSonProprietaire().getNomMembre();
            }

            //System.out.println("EspaceTravailView.java:114");
            //System.out.println(_modele.getSonProprietaire());

            String titreEspaceDeTravail = _modele.getNomEspaceDeTravail();

            // Recuperer le logo de l'espace de travail du modele
            String logoEspaceDeTravail = _modele.getLogoEspaceDeTravail();
            // Recuperer la visibilite de l'espace de travail du modele
            //String visibiliteEspaceDeTravail = _modele.getSaVisibilité().toString(); // <- faire en sorte d'avoir un visibilite.getNom()

            // Afficher le nom de l'espace de travail et du membre
            lblNomEspaceDeTravail.setText(titreEspaceDeTravail);
            lblNomMembre.setText(titreMembreTitulaire);
            // Afficher le logo de l'espace de travail
            // TODO : Afficher le logo de l'espace de travail
            // Afficher la visibilite de l'espace de travail
            //lblVisibilite.setText(visibiliteEspaceDeTravail);

            // Afficher les tableaux de l'espace de travail
            if (_modele.getSesTableaux() != null) {
                Tableau tableau = _modele.getSesTableaux().get(0);
                TableauView tableauView = new TableauView(tableau);
                TableauController tableauController = new TableauController(tableau, tableauView);
                JPanel pnlTableau = new JPanel();
                pnlTableau.add(tableauView);
                pnlTableau.add(tableauController);
                setPage(pnlTableau);
            }

            // TODO : Faire un truc pour selectionner le tableau specifique

        }
}
