package Views;

import EspaceDeTravail.Membre;
import Models.ListeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ListeViews extends JPanel {
    private ListeModel ListeModel;
    private JFrame frame;
    private JLabel titleLabel;
    private JTextArea descriptionTextArea;

    public ListeViews (ListeModel liste){
        this.ListeModel=liste;

        //création d'une fenetre
        frame =new JFrame("Liste "+ liste.getNomListe());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JButton partagerListe() {
        Action a = new AbstractAction("Bouton partager") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when the button is clicked
                System.out.println("Partagé!");
                Membre m ;
                // ajouter le membre qui doit etre récupére parmie les membre disponible.
                //ListeModel.ajouterMembre(m);
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
