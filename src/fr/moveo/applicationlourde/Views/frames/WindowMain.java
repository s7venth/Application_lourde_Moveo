package fr.moveo.applicationlourde.Views.frames;

import com.apple.eawt.Application;
import fr.moveo.applicationlourde.autres.MenuBar;
import fr.moveo.applicationlourde.Views.panels.ScreenMain;
import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Main JFrame that contains all the JPanels of the application
 */
public class WindowMain extends JFrame implements ActionListener {

    User moderatorMain;
    private MenuBar menu;
    private ScreenMain home;
    Color homeColor;

    /**
     * the constructor of the JFrame
     * @param moderator the moderator's information
     * @param userList the arraylist of all the users of the application
     */
    public WindowMain(User moderator, ArrayList<User> userList){
        moderatorMain = moderator;
        this.getContentPane().setLayout(new BorderLayout());
        menu = new MenuBar();
            this.setJMenuBar(menu); // Integration de la barre de menu
            menu.getUpdateButtonMenu().addActionListener(this);
            menu.getModeratorButton().addActionListener(this);
            menu.getLogOutItem().addActionListener(this);
            menu.getAboutItem().addActionListener(this);
            menu.getHelpItem().addActionListener(this);
        home = new ScreenMain(moderator, userList, false);
        this.add(home);
        this.windowConfiguration(moderator.getLastName());

    }

    /**
     * the config of this JFrame
     * @param name the name of the moderator
     */
    public void windowConfiguration(String name){

        this.homeColor = new Color(5, 100, 200);
        this.setBackground(homeColor); // Couleur de fond
        Application application = Application.getApplication();// spécifique aux ordi Apple
        application.setDockIconImage(Toolkit.getDefaultToolkit().getImage("res/fr.moveo.applicationlourde/icon.png"));//definit l'image pour les dock d'apple
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/fr.moveo.applicationlourde/icon.png")); 	//Icône en haut à gauche/Icône en haut à gauche
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrête complètement le processus avec le bouton [X]
        this.setTitle("Bienvenue " + name);  //Définit un titre pour notre fenêtre
        this.setSize(700, 400); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenêtre par défaut
        this.setResizable(true); // Empêche le redimensionnement de la fenêtre
        pack();
        this.setVisible(true); //Rendre visible la fenêtre

    }

    /**
     * Method that contains all the events on the menuBar
     * @param e the event of the menuBar
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source == menu.getUpdateButtonMenu()){
            this.remove(home);
            ConnectMethods connectMethods = new ConnectMethods();
            ArrayList<User> userArrayList = connectMethods.getArrayList(connectMethods.getUsers());
            home = new ScreenMain(this.moderatorMain, userArrayList, false);
            this.add(home);
            home.getMessage().setText("Lise utilisateurs à jour");
            revalidate();
        }
        else if (source == menu.getModeratorButton()){
            if (moderatorMain.isAdmin()){
                this.remove(home);
                ConnectMethods connectMethods = new ConnectMethods();
                ArrayList<User> moderatorsArrayList = connectMethods.getArrayListModerator(connectMethods.getModerator());
                System.out.println("le getmoderators en toString : " +moderatorsArrayList.toString());
                home = new ScreenMain(this.moderatorMain, moderatorsArrayList, true);
                this.add(home);
                home.getMessage().setText("Liste de modérateurs à jours");
                revalidate();
            }
            else JOptionPane.showMessageDialog(null,"Vous n'etes pas Administrateur","SKYNET",JOptionPane.ERROR_MESSAGE);
        }

        else if(source == menu.getAboutItem()){
            JOptionPane.showMessageDialog(null,"Moveo application Lourde version 0.0.1", "About", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == menu.getHelpItem()){
            JOptionPane.showMessageDialog(null,"Aide non disponible pour le moment.", "HELP", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(source ==menu.getLogOutItem()){
            this.dispose();
        }
    }
}
