package fr.moveo.applicationlourde.Views.frames;

import fr.moveo.applicationlourde.autres.MenuBar;
import fr.moveo.applicationlourde.Views.panels.ScreenMain;
import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.AbstractMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Sylvain on 11/03/15.
 */
public class WindowMain extends JFrame implements ActionListener {

    // DECLARATION DU MENU
    private MenuBar menu;

    // DECLARATION DES PANELS
    private ScreenMain home;

    // AUTRES DECLARATIONS
    Color homeColor;

    // CONSTRUCTEUR
    public WindowMain(User moderator, ArrayList<User> userList){

        // Ce frame utilisera une grille de placement de type BorderLayout
        this.getContentPane().setLayout(new BorderLayout());

        // Le menu
        menu = new MenuBar();
            this.setJMenuBar(menu); // Integration de la barre de menu
            menu.getLogOutItem().addActionListener(this);
            menu.getUpdateButtonMenu().addActionListener(this);

        home = new ScreenMain(moderator, userList);
        this.add(home);

        this.windowConfiguration(moderator.getLastName());

    }

    // Procedure permettant de configuration la fenêtre
    public void windowConfiguration(String nom){

        this.homeColor = new Color(5, 100, 200);
        this.setBackground(homeColor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/img/icon.png")); 	//Icône en haut à gauche
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrête complètement le processus avec le bouton [X]
        this.setTitle("Bienvenue "+nom);  //Définit un titre pour notre fenêtre
        this.setSize(700, 400); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenêtre par défaut
        this.setResizable(true); // Empêche le redimensionnement de la fenêtre
        pack();
        this.setVisible(true); //Rendre visible la fenêtre

    }

    public void setPanel(JPanel pan){
        this.setVisible(false);
       // this.tempo.removeAll();
        // this.tempo.add(pan,BorderLayout.CENTER);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if (source == menu.getUpdateButtonMenu()){
            home.getMessage().setText(e.getSource().toString());
            StringBuffer stringBuffer = new StringBuffer();
            AbstractMethods abstractMethods = new AbstractMethods();
            stringBuffer = abstractMethods.getUsersTest();
            System.out.println("le getUser en toString : " + stringBuffer.toString());
            home.setList(new JList(abstractMethods.setUserList(abstractMethods.getArrayList(stringBuffer))));
        }

        else if(source ==menu.getLogOutItem()){
            home.getMessage().setText("Au revoir");
        }
    }
}
