package EspaceDeTravail;
import javax.swing.*;
import java.awt.event.ActionListener;



public class Partager {
    JButton partager = new JButton("Partager");
    //Définition de l'action du Parager
    partager.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(++indice > 2)
                indice = 0;
            //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
            cl.show(content, listContent[indice]);
        }
    });
}
