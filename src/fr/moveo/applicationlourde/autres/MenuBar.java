package fr.moveo.applicationlourde.autres;

import javax.swing.*;

/**
 * Class menu which create a menu into the application
 */
public class MenuBar extends JMenuBar {

    //Les sous menus
    private JMenuItem logOutItem,aboutItem,helpItem, updateButtonMenu, moderatorButton;

    /**
     * the constructor of the class
     */
    public MenuBar(){

        JMenu mainMenu = new JMenu("Menu Principal");
            updateButtonMenu = new JMenuItem("actualiser");
                mainMenu.add(updateButtonMenu);
            moderatorButton = new JMenuItem("moderateurs");
                mainMenu.add(moderatorButton);

        JMenu optionMenu = new JMenu("?");
            aboutItem= new JMenuItem("À propos");
                optionMenu.add(aboutItem);
            helpItem= new JMenuItem("Aide");
                optionMenu.add(helpItem);
            logOutItem= new JMenuItem("Déconnexion");
                optionMenu.add(logOutItem);

        // Ajouter les menus dans la barre de menu
        this.add(mainMenu);
        this.add(optionMenu);

    }

    /**
     * method that return the button about
     * @return the button about
     */
    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    /**
     * method that return the button help
     * @return the button help
     */
    public JMenuItem getHelpItem() {
        return helpItem;
    }

    /**
     * method that return the button logout
     * @return the button logout
     */
    public JMenuItem getLogOutItem() {
        return logOutItem;
    }

    /**
     * method that return the button update
     * @return the button update
     */
    public JMenuItem getUpdateButtonMenu() {
        return updateButtonMenu;
    }

    /**
     * method used to return the button moderator
     * @return the button moderator
     */
    public JMenuItem getModeratorButton() {
        return moderatorButton;
    }
}