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

    // PANELS
        private ScreenConnection screen;

    //  AUTRES
    private Color homecolor;

    public WindowConnection(){
        screen = new ScreenConnection();
            this.add(screen);

        homecolor = new Color(5,100,200);

        screen.getButton().addActionListener(this);

        // **************CONFIGURATION DE LA FENETRE ************** //

        this.setBackground(homecolor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/img/icone.jpg")); 	//Icone en haut à gauche
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Arrete completement le processus avec le bouton [X]
        this.setTitle("Moveo");  //Définit un titre pour notre fenêtre
        this.setSize(400, 200); // Taille fenetre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenetre par defaut
        this.setResizable(false); // Empêche le redimensionnement
        this.setVisible(true); //Rendre visible la fenetre

        // ********************************************************** //
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new WindowMain(screen.getMailEditText().getText());
    }
}
