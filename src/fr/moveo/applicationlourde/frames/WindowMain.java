package fr.moveo.applicationlourde.frames;

import fr.moveo.applicationlourde.panels.ScreenMain;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sylvain on 11/03/15.
 */
public class WindowMain extends JFrame {

    // MENU
    private MenuBar menu;

    // PANELS
    private ScreenMain home;


    //  AUTRES
    private Color homecolor;

    public WindowMain(){
        menu = new MenuBar();

        home = new ScreenMain();
        this.add(home);

        homecolor= new Color(27, 155, 148);

        // **************CONFIGURATION DE LA FENETRE ************** //

        this.setBackground(homecolor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/Logo.png")); 	//Icone
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrete completement le processus [X]
        this.setTitle("Bienvenue");  //Définit un titre pour notre fenêtre
        this.setSize(700, 400); // Taille fenetre en pixel (l,L) l=largeur L=longeur
        this.setLocationRelativeTo(null);  // Centre la fenetre par defaut
        this.setResizable(false); // Empêche le redimensionnement
        this.setVisible(true); //Rendre visible la fenetre

        // ********************************************************** //
    }



}
