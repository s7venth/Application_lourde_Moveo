package fr.moveo.applicationlourde;

import fr.moveo.applicationlourde.Views.frames.WindowConnexion;

import javax.swing.*;

/**
 * the Main class of the application
 */
public class Main {

    /**
     * the method used to launch the application
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new WindowConnexion();
            }
        };
        SwingUtilities.invokeLater(runnable);

    }
}
