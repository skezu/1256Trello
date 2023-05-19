package Views;
import EspaceDeTravail.EspaceTravail;
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
    // Label indiquant qu'il y a une liste de tableaux
    private JLabel lblTableauxBlocTitre;
    // Label affichant la visibilite de l'espace de travail
    private JLabel lblVisibilite;


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
        lblNomEspaceDeTravail = new JLabel();
        lblTableauxBlocTitre = new JLabel();
        lblTableauxBlocTitre.setText("Vos Tableaux");
        lblNomEspaceDeTravail.setForeground(AppliTrelloLite.navTextColor);
        lblTableauxBlocTitre.setForeground(AppliTrelloLite.navTextColor);
        add(lblNomEspaceDeTravail);
        add(lblTableauxBlocTitre);
        setLayout(new GridLayout(3,1));
        setBackground(AppliTrelloLite.navBorderColor);
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
        }
}
