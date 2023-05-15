package EspaceDeTravail;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Buttons {

        // Affiche la liste des utilisateurs avec qui partager
        public JButton partagerTableau() {
                Action a = new AbstractAction("Bouton partager") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Perform action when the button is clicked
                                System.out.println("Partagé!");
                        }
                };
                return createButton(a);
        }

        public JButton creerCarte() {
                Action a = new AbstractAction("Ajouter une carte") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Perform action when the button is clicked
                                System.out.println("Carte créé!");
                        }
                };
                return createButton(a);
        }

        public JButton createButton(Action a) {
                JButton b = new JButton() {
                public Dimension getMaximumSize() {
                        int width = 20;
                        int height = 15;
                        return new Dimension(width, height);
                }
                };
                // setting the following client property informs the button to show
                // the action text as it's name. The default is to not show the
                // action text.
                b.putClientProperty("displayActionText", Boolean.TRUE);
                b.setAction(a);
                // b.setAlignmentX(JButton.CENTER_ALIGNMENT);
                return b;
        }

}
