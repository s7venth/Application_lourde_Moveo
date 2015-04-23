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
    }

    public JTextField getMailEditText() {
        return mailEditText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
