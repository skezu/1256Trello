package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EspaceDeTravail.*;
import Views.MembreView;


public class MembreController extends JPanel implements ActionListener {
    //action des boutton
    private static final String ACTION_ADD_MEMBRE_CARTE = "ADD_MEMBRE_CARTE";
    // conposante graphique
    JButton _btnAjouterMembreCarte;
    // autre
    Carte c;
    Menu menu;

    //constructeur
    public MembreController(Menu menu, Carte c){
        _btnAjouterMembreCarte = new JButton("Ajouter Membre");
        _btnAjouterMembreCarte.setActionCommand(ACTION_ADD_MEMBRE_CARTE);
        _btnAjouterMembreCarte.addActionListener(this);
        add(_btnAjouterMembreCarte);
        this.c=c;
        this.menu =menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(ACTION_ADD_MEMBRE_CARTE)){
            new MembreView(menu,c);
        }
    }
}
