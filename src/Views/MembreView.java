package Views;

import EspaceDeTravail.Carte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import EspaceDeTravail.Membre;
import EspaceDeTravail.Menu;
import Views.MenuView;

public class MembreView extends JDialog implements ActionListener {

    //panel contenet les menbre
    private JPanel PanelMembre;


    ArrayList<Membre> lesmenbre;
    Menu menu;
    Carte c;

    String constructeurActif;

    //constrcteur
    public MembreView(Menu menu,Carte c){
        constructeurActif="Carte";
        this.c=c;
        this.menu=menu;
        lesmenbre =menu.getListeMembres();
        for (Membre m:lesmenbre) {
            JButton membre =new JButton(m.getNomMembre());
            membre.addActionListener(this);
            //ajouter un bouton a la fenetre qui doit souvrire
            //quand cette methode est appeler
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        for (Membre m:lesmenbre) {
            if(m.getNomMembre()==e.getActionCommand()){
                if( constructeurActif=="Carte"){
                    c.ajouterMembre(m);
                }
            }
        }
    }

}
