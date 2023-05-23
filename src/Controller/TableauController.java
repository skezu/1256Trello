package Controller;

import EspaceDeTravail.Tableau;
import Views.TableauView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableauController extends JPanel implements ActionListener {

    Tableau _modele;
    TableauView _vue;

    //////////////////////////////////
    //       Constructeur           //
    //////////////////////////////////

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public TableauController(Tableau modele, TableauView vue) {
        _modele = modele;
        _vue = vue;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
