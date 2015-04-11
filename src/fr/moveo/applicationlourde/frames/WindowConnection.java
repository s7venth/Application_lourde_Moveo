package fr.moveo.applicationlourde.frames;

import fr.moveo.applicationlourde.panels.ScreenConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sylvain on 12/03/15.
 */
public class WindowConnection extends JFrame implements ActionListener {

    // DECLARATION DES PANELS
    private ScreenConnection screen;

    // CONSTRUCTEUR
    public WindowConnection(){
        screen = new ScreenConnection();
            this.add(screen);

        screen.getLoginButton().addActionListener(this);
        this.windowConfiguration();
    }

    // Procedure permettant de configuration la fenêtre
    public void windowConfiguration(){

        Color homeColor = new Color(5, 100, 200);
        this.setBackground(homeColor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/img/icon.png")); 	//Icône en haut à gauche
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrête complètement le processus avec le bouton [X]
        this.setTitle("Moveo");  //Définit un titre pour notre fenêtre
        this.setSize(400, 200); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenêtre par défaut
        this.setResizable(false); // Empêche le redimensionnement de la fenêtre
        this.setVisible(true); //Rendre visible la fenêtre

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new WindowMain(screen.getMailEditText().getText());
    }
}
