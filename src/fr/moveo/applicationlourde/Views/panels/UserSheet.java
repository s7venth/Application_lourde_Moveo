package fr.moveo.applicationlourde.Views.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe qui permet d'afficher la fiche d'un utilisateur
 * c'est un cardLayout pour faire plusieurs onglets sur un utilisateurs
 */
public class UserSheet extends JPanel {
    //VARIABLES
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JLabel idLabel, firstNameLabel, lastNameLabel, birthdayLabel, emailLabel, passwordLabel,
            countryLabel, cityLabel, registerLabel, lastConnexionLabel;

    //CONSTRUCTEUR
    public UserSheet() {
        idLabel = new JLabel("Id");
        firstNameLabel = new JLabel("Prénom");
        lastNameLabel = new JLabel("Nom");
        birthdayLabel = new JLabel("Date de Naissance");
        passwordLabel = new JLabel("Mot de passe");
        countryLabel = new JLabel("Pays");
        cityLabel = new JLabel("Ville");
        registerLabel = new JLabel("date d'enregistrement");
        lastConnexionLabel = new JLabel("Date de derniere connexion");
        setLayout(gridBagLayout);
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(idLabel, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        add(firstNameLabel, gridBagConstraints);
        gridBagConstraints.gridy = 2;
        add(lastNameLabel, gridBagConstraints);
        gridBagConstraints.gridy = 3;
        add(birthdayLabel, gridBagConstraints);
        gridBagConstraints.gridy = 4;
        add(passwordLabel, gridBagConstraints);
        gridBagConstraints.gridy = 5;
        add(countryLabel, gridBagConstraints);
        gridBagConstraints.gridy = 6;
        add(cityLabel, gridBagConstraints);
        gridBagConstraints.gridy = 7;
        add(registerLabel, gridBagConstraints);
        gridBagConstraints.gridy = 8;
        add(lastConnexionLabel, gridBagConstraints);
        gridBagConstraints.gridy = 9;
    }


    //METHODES

}
