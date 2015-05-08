package fr.moveo.applicationlourde.Views.panels;

import javax.swing.*;
import java.awt.*;

/**
 * ceci est le panel de connection. le layout est un gridBagLayout de facon à pouvoir bien organiser la fenetre
 */
public class ScreenConnection extends JPanel {
    JButton loginButton;
    JLabel mailLabel,passwordLabel;
    JLabel[]array = new JLabel[12];
    JTextField mailEditText,passwordEditText;

    public ScreenConnection(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i=0; i<12; i++){
            array[i] = new JLabel("          ");
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(array[0], gbc);
        gbc.gridx = 1;
        this.add(array[1], gbc);
        gbc.gridx = 2;
        this.add(array[2], gbc);
        gbc.gridx = 3;
        this.add(array[3], gbc);
        gbc.gridx = 4;
        this.add(array[4], gbc);
        gbc.gridx = 5;
        this.add(array[5], gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(array[6], gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mailLabel = new JLabel("Identifiant :");
        this.add(mailLabel, gbc);
        gbc.gridx = 3;
        mailEditText = new JTextField();
        this.add(mailEditText, gbc);
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        this.add(array[7], gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        this.add(array[8], gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        passwordLabel =  new JLabel("Mot de passe :");
        this.add(passwordLabel, gbc);
        gbc.gridx = 3;
        passwordEditText = new JTextField();
        this.add(passwordEditText, gbc);
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        this.add(array[9], gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(array[10], gbc);
        gbc.gridx = 2;
        loginButton = new JButton("Se connecter");
        this.add(loginButton, gbc);
        gbc.gridx = 4;
        this.add(array[11], gbc);

        this.setOpaque(true);
    }

    public JTextField getMailEditText() {
        return mailEditText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
