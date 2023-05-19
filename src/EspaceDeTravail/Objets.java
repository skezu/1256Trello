package EspaceDeTravail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Objets {
    public class JCarte extends JPanel {
        JCarte(Carte Carte) {
            JLabel l;
            l = new JLabel(Carte.getTitreCarte());
        }
        JPanel panel = new JPanel();

    }
}
