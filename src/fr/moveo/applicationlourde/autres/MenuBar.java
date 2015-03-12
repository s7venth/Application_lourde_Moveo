package fr.moveo.applicationlourde.autres;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Sylvain on 11/03/15.
 */
public class MenuBar extends JMenuBar {

    // Les menus
    private JMenu mainMenu,optionMenu;

    //Les sous menus
    private JMenuItem memberManagementItem,logOutItem,aboutItem,helpItem;

    public MenuBar(){

        mainMenu = new JMenu("Menu Principal");
            memberManagementItem = new JMenuItem("Gestion de membre");
                mainMenu.add(memberManagementItem);

        optionMenu = new JMenu("?");
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

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    public JMenuItem getHelpItem() {
        return helpItem;
    }

    public JMenuItem getLogOutItem() {
        return logOutItem;
    }

    public JMenuItem getMemberManagementItem() {
        return memberManagementItem;
    }
}