package fr.moveo.applicationlourde.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sylvain on 12/03/15.
 */
public class ScreenConnection extends JPanel {
    JButton loginButton;
    JLabel mailLabel,passwordLabel;
    JTextField mailEditText,passwordEditText;

    public ScreenConnection(){
        mailLabel = new JLabel("Identifiant :");
            this.add(mailLabel);
        mailEditText = new JTextField();
            this.add(mailEditText);
        passwordLabel =  new JLabel("Mot de passe :");
            this.add(passwordLabel);
        passwordEditText = new JTextField();
            this.add(passwordEditText);
        loginButton = new JButton("Se connecter");
            this.add(loginButton);

        this.screenConfiguration();

    }

    public void screenConfiguration(){
        GridLayout grid = new GridLayout();// type de layout managers en forme de grille
        grid.setColumns(2);                // Ajout de 2 colonnes
        grid.setRows(3);                   // Ajout de 2 lignes
        grid.setHgap(8);                   // 5px d'espace horizontal entre les colonnes
        grid.setVgap(10);                  // 5px d'espace vertical entre les colonnes
        this.setLayout(grid);              // Mettre en place la grille
        this.setOpaque(true);
        //this.setPreferredSize(new Dimension(900,300)); // taille de l'écran
        // this.setBackground(Color.WHITE); //Définition de sa couleur de fond
    }

    public JTextField getMailEditText() {
        return mailEditText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
