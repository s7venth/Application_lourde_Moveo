package fr.moveo.applicationlourde.frames;

import fr.moveo.applicationlourde.autres.MenuBar;
import fr.moveo.applicationlourde.panels.ScreenMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sylvain on 11/03/15.
 */
public class WindowMain extends JFrame implements ActionListener {

    // MENU
    private MenuBar menu;

    // PANELS
    private ScreenMain home;

    //  AUTRES
    private Color homecolor;

    // #CONSTRUCTEUR#
    public WindowMain(String nom){

        // Ce frame utilisera une grille de placement de type BorderLayout
        this.getContentPane().setLayout(new BorderLayout());

        // Le menu
        menu = new MenuBar();
            this.setJMenuBar(menu); // Integration de la barre de menu
            menu.getLogOutItem().addActionListener(this);

        home = new ScreenMain();
        this.add(home);

        homecolor= new Color(83, 155, 0);

        // **************CONFIGURATION DE LA FENETRE ************** //

        this.setBackground(homecolor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Logo.png")); 	//Icone
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrete completement le processus [X]
        this.setTitle("Bienvenue "+nom);  //Définit un titre pour notre fenêtre
        this.setSize(700, 400); // Taille fenetre en pixel (l,L) l=largeur L=longeur
        this.setLocationRelativeTo(null);  // Centre la fenetre par defaut
        this.setResizable(false); // Empêche le redimensionnement
        this.setVisible(true); //Rendre visible la fenetre

        // ********************************************************** //
    }

    public void setPanel(JPanel pan){
        this.setVisible(false);
       // this.tempo.removeAll();
        // this.tempo.add(pan,BorderLayout.CENTER);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu.getLogOutItem()){
            home.getMessage().setText("Au revoir");
        }
    }
}
