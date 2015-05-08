package fr.moveo.applicationlourde.Views.panels;

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
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mailLabel = new JLabel("Identifiant :");
        this.add(mailLabel, gbc);
        gbc.gridx = 2;
        mailEditText = new JTextField();
        this.add(mailEditText, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        passwordLabel =  new JLabel("Mot de passe :");
        this.add(passwordLabel, gbc);
        gbc.gridx = 2;
        passwordEditText = new JTextField();
        this.add(passwordEditText, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        loginButton = new JButton("Se connecter");
        this.add(loginButton, gbc);
    }
/*
    public void screenConfiguration(){
        this.setLayout(new GridBagLayout());              // Mettre en place la grille
        GridBagConstraints contraintes = new GridBagConstraints();// type de layout managers en forme de grille

        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 2;
        contraintes.gridheight = 2;
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.weightx = 1;
        contraintes.weighty = 1; // 5px d'espace vertical entre les colonnes



        this.setOpaque(true);
        //this.setPreferredSize(new Dimension(900,300)); // taille de l'écran
        // this.setBackground(Color.WHITE); //Définition de sa couleur de fond
    }*/

    public JTextField getMailEditText() {
        return mailEditText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
