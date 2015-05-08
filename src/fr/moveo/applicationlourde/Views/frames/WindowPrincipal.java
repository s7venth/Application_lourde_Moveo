package fr.moveo.applicationlourde.Views.frames;

import fr.moveo.applicationlourde.Events.MyListener;
import fr.moveo.applicationlourde.model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexMac on 08/05/15.
 * vu principal de l'application. elle est faite en borderLayout.
 */

public class WindowPrincipal extends JFrame implements ActionListener, ListSelectionListener {
    Container[] containers = new Container[4];
    public WindowPrincipal() throws HeadlessException {
        for (int i=0;i<4; i++){
            containers[i] = new JPanel();
        }

    }

    public void windowsConfiguration(){
        setSize(700, 700); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        setTitle("Gestionnaire de Moveo");
        MyListener myListener = new MyListener();
        addWindowListener(myListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /**
     * Methode permettant d'indiquer le changement d'état lorsque l'utilisateur admin cliquera sur la liste
     * @param e la valeur de la ligne de la liste
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
