package fr.moveo.applicationlourde.Events;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Sylvain on 23/04/15.
 * Premier listener qui permet d'afficher une popu si on veut quitter l'application
 */
public class MyListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        int reponse = JOptionPane.showConfirmDialog(null,"Êtes vous sûr de vouloir quitter ?");
        if(reponse == 0){
            System.exit(0);
        }
    }
}
