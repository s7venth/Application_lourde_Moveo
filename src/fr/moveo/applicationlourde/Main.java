package fr.moveo.applicationlourde;

import fr.moveo.applicationlourde.Views.frames.WindowConnexion;

import javax.swing.*;

public class Main {

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
