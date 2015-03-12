package fr.moveo.applicationlourde.panels;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * Created by Sylvain on 11/03/15.
 */
public class ScreenMain extends JPanel{
    JButton button;
    JLabel message;

    public ScreenMain(){
      /*  button = new JButton("cliquer ici");
            this.add(button); */
       /* mailLabel = new JLabel("Identidiant :");
            this.add(mailLabel);
        passwordLabel = new JLabel("Mot de passe :");
            this.add(passwordLabel); */
        message = new JLabel("");
            this.add(message);


        // **************CONFIGURATION DU PANEL ********************** //
        GridLayout grid = new GridLayout();// type de layout managers (2 lignes et 3 colonnes)
        grid.setColumns(3);
        grid.setRows(2);
        grid.setHgap(5); //5px d'espace horizontal entre les colonnes
        grid.setVgap(5); //5px d'espace vertical entre les colonnes
        this.setLayout(grid);
            this.setOpaque(false); // mettre l'écran en transparent
            this.setPreferredSize(new Dimension(400,200)); // taille de l'écran
            this.setBackground(Color.GREEN);//Définition de sa couleur de fond
        // ********************************************************** //
    }

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("res/img/Logo.png"));
            g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JLabel getMessage() {
        return message;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }
}