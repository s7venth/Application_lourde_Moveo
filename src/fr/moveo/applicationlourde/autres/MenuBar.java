package fr.moveo.applicationlourde.autres;

import javax.swing.*;

/**
 * Created by Sylvain on 11/03/15.
 */
public class MenuBar extends JMenuBar {

    // Les menus
    private JMenu mainMenu;

    //Les sous menus
    private JMenuItem menuAccueil;

    public MenuBar(){

        mainMenu = new JMenu("Menu Principal");
        menuAccueil = new JMenuItem("Accueil");
        mainMenu.add(menuAccueil);

        // Ajouter les menus dans la barre de menu
        this.add(mainMenu);

    }
}