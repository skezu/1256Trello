/**

 TableauView est une classe qui représente la vue graphique d'un tableau dans l'application Trello.
 Elle affiche le titre du tableau et les listes associées.
 */
package Views;

import Controller.CarteController;
import Controller.EditableLabel;
import Controller.ListeController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Tableau;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableauView extends JPanel {
    // Modele associe a la vue
    Tableau _modele;

    // Vue graphique
    JPanel pnlHeader;
    JPanel pnlBody;
    JScrollPane scrollPane;

    // Composants
    EditableLabel lblTitreTableau;

    /**
     * Constructeur de la classe TableauView.
     *
     * @param modele Le modèle de tableau à associer à la vue.
     */
    public TableauView(Tableau modele) {
        _modele = modele;
        setLayout(new BorderLayout());

        // Création de l'en-tête
        pnlHeader = new JPanel();
        lblTitreTableau = new EditableLabel(_modele.getNomTableau(), pnlHeader, _modele);

        // Création du corps avec un layout horizontal
        pnlBody = new JPanel();
        pnlBody.setLayout(new BoxLayout(pnlBody, BoxLayout.X_AXIS));
        pnlBody.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlBody.setBackground(Color.DARK_GRAY);

        // Création d'un scroll pane avec défilement horizontal
        scrollPane = new JScrollPane(pnlBody,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(AppliTrelloLite.FRAME_WIDTH - 100, AppliTrelloLite.FRAME_HEIGHT - 200));

        pnlHeader.add(lblTitreTableau);
        add(pnlHeader, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);

        redessiner();
    }

    /**
     * Ajoute une liste à la vue du tableau.
     *
     * @param liste La liste à ajouter.
     */
    public void ajouterListe(Liste liste) {
        ListeView listeView = new ListeView(liste, this);
        ListeController listeController = new ListeController(liste, listeView);
        listeView.add(listeController, BorderLayout.PAGE_END);
        pnlBody.add(listeView);
    }

    /**
     * Redessine la vue du tableau en mettant à jour les données affichées.
     */
    public void redessiner() {
        // Récupération des données du tableau
        String titreTableau = _modele.getNomTableau();
        ArrayList<Liste> listeTab = _modele.getSesListes();

        // Mise à jour du titre du tableau
        lblTitreTableau.setText(titreTableau);

        // Suppression des listes existantes dans le tableau
        pnlBody.removeAll();

        // Ajout des listes dans le tableau
        for (Liste l : listeTab) {
            ajouterListe(l);
        }

        pnlBody.revalidate();
        pnlBody.repaint();
    }
}
   