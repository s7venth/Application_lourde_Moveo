package fr.moveo.applicationlourde.Events;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Sylvain on 23/04/15.
 * first listener of the application
 */
public class MyListener extends WindowAdapter {

    /**
     * method which allow to popup a window if the cross button is checked
     * @param e the event of the click on the cross button
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int reponse = JOptionPane.showConfirmDialog(null,"Êtes vous sûr de vouloir quitter ?");
        if(reponse == 0){
            System.exit(0);
        }
    }
}
