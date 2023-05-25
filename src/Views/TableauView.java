package Views;

import Controller.CarteController;
import Controller.ListeController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Tableau;
import Trello.AppliTrelloLite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableauView extends JPanel{
    // Modele associe a la vue
    Tableau _modele;

    // vue graphique
    JPanel pnlHeader;

    JPanel pnlBody;
    // Scroll pane with horizontal scrolling
    JScrollPane scrollPane;

    // composants
    JLabel lblTitreTableau;

    public TableauView(Tableau modele) {
        _modele = modele;
        setLayout(new BorderLayout());

        // Set the title
        lblTitreTableau = new JLabel(_modele.getNomTableau());

        // Create a panel with BoxLayout
        pnlBody = new JPanel();
        pnlBody.setLayout(new BoxLayout(pnlBody, BoxLayout.X_AXIS));
        pnlBody.setAlignmentY(Component.TOP_ALIGNMENT);
        pnlBody.setBackground(Color.DARK_GRAY);

        // Create a scroll pane with horizontal scrolling
        scrollPane = new JScrollPane(pnlBody,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(AppliTrelloLite.FRAME_WIDTH-100, AppliTrelloLite.FRAME_HEIGHT-200));

        add(lblTitreTableau, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);

        redessiner();
    }

    public void ajouterListe(Liste liste){
        ListeView listeView = new ListeView(liste);
        ListeController listeController = new ListeController(liste,listeView);
        listeView.add(listeController, BorderLayout.PAGE_END);
        pnlBody.add(listeView);
    }

    public void redessiner(){
        //recuperation des données
        String titreTableau = _modele.getNomTableau();
        ArrayList<Liste> listeTab = _modele.getSesListes();
        // affectation
        lblTitreTableau.setText(titreTableau);

        pnlBody.removeAll();
        // Ajout des listes dans le tableau
        for (Liste l : listeTab) {
            ajouterListe(l);
        }
        //pnlBody.revalidate();
        //pnlBody.repaint();
    }
}
