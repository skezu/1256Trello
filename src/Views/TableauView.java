package Views;

import Controller.CarteController;
import Controller.ListeController;
import EspaceDeTravail.Carte;
import EspaceDeTravail.Liste;
import EspaceDeTravail.Tableau;

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

        // Create a panel with FlowLayout
        pnlBody = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create a scroll pane with horizontal scrolling
        scrollPane = new JScrollPane(pnlBody,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(lblTitreTableau, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);

        redessiner();
    }

    public void ajouterListe(Liste liste){
        ListeView listeView = new ListeView(liste);
        pnlBody.add(listeView);
    }

    public void redessiner(){
        //recuperation des données
        String titreTableau = _modele.getNomTableau();
        ArrayList<Liste> listeTab = _modele.getSesListes();
        // affectation
        lblTitreTableau.setText(titreTableau);

        pnlBody.removeAll();

        Liste liste = new Liste(_modele, "A Faire");
        Liste liste1 = new Liste(_modele, "En Cours");
        Liste liste2 = new Liste(_modele, "Terminee");
        //ajouterListe(liste);
        //ajouterListe(liste1);
        //ajouterListe(liste2);

        for (Liste l : _modele.getSesListes()) {
            ListeView vue = new ListeView(l);
            ListeController controller = new ListeController(l, vue);
            vue.add(controller);
            pnlBody.add(vue);

        }
        //pnlBody.revalidate();
        //pnlBody.repaint();
    }
}
