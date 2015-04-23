package fr.moveo.applicationlourde.Views.panels;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Created by Sylvain on 11/03/15.
 */
public class ScreenMain extends JPanel{

    // VARIABLES
    JButton button;
    JLabel message;
    JTextField searchBar;
    PrintImage logo;

    public ScreenMain(){
      /*  button = new JButton("cliquer ici");
            this.add(button); */
       /* mailLabel = new JLabel("Identidiant :");
            this.add(mailLabel);
        passwordLabel = new JLabel("Mot de passe :");
            this.add(passwordLabel); */
        logo = new PrintImage("res/img/Logo.png");
            this.add(logo);
        message = new JLabel("");
            this.add(message);
        searchBar = new JTextField("Recherche");
            this.add(searchBar);
        logo = new PrintImage("res/img/Logo.png");
            this.add(logo);

        this.screenConfiguration();


    }

    public void screenConfiguration(){
        GridLayout grid = new GridLayout();// type de layout managers (2 lignes et 3 colonnes)
        grid.setColumns(1);
        grid.setRows(5);
        grid.setHgap(50); //5px d'espace horizontal entre les colonnes
        grid.setVgap(50); //5px d'espace vertical entre les colonnes
        this.setLayout(grid);
        this.setOpaque(false); // mettre l'écran en transparent
        this.setPreferredSize(new Dimension(600,400)); // taille de l'écran
        this.setBackground(Color.GREEN);//Définition de sa couleur de fond
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