package Views;

import javax.swing.*;
import EspaceDeTravail.Log;
import Trello.AppliTrelloLite;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class LogView extention de la classe JDialog
 */
public class LogView extends JDialog {
    //////////////////////////////
    //          Classes         //
    //////////////////////////////
    ////////////////////////////
    //          Attributs     //
    ////////////////////////////
    private Log modele;

    //panel contenet les menbre
    private JTextArea sortie;
    /////////////////////////////
    //      Constructeur       //
    /////////////////////////////

    /**
     * Constructeur de la classe LogView.
     * @param modele
     */
    public LogView(Log modele){
        this.modele = modele;

        // Creation des elements
        sortie = new JTextArea();
        // Style
        setTitle("[Logs] Lite+ de Trello");
        sortie.setFont(new Font("Consolas", Font.PLAIN, 13));
        sortie.setEditable(false);
        sortie.setBackground(Color.black);
        sortie.setForeground(AppliTrelloLite.navTextColor);
        setSize(700, 500);

        // Ajout des elements
        add(sortie);

        // Appel de la fonction redessiner qui va actualiser les logs
        redessiner();
        // Rendre la page invisible
        this.setVisible(false);
    }

    public void redessiner() {
        // Redessin de la JTextArea
        sortie.setText("");
        // Récupération des logs
        List<String> logs = modele.getActivities();
        // Ajout de chaque log dans la JTextArea
        for (String log : logs) {
            sortie.append(log + "\n");
        }
    }
}
