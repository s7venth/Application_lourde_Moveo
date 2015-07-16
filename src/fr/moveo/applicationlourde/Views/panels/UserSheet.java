package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe qui permet d'afficher la fiche d'un utilisateur
 * c'est un cardLayout pour faire plusieurs onglets sur un utilisateurs
 */
public class UserSheet extends JPanel {
    //VARIABLES
    User user = new User();

    public void setUser(User user) {
        this.user = user;
    }

    GridLayout gridLayout = new GridLayout(12,2);
    JLabel idLabel, firstNameLabel, lastNameLabel, birthdayLabel, emailLabel, passwordLabel,
            countryLabel, cityLabel, registerLabel, lastConnexionLabel;
    JTextField idTextfield = new JTextField();
    JTextField firstNameTextfield = new JTextField();
    JTextField lastNameTextfield = new JTextField();
    JTextField birthdayTextfield = new JTextField();
    JTextField emailTextfield = new JTextField();
    JTextField passwordTextfield = new JTextField();
    JTextField countryTextfield = new JTextField();
    JTextField cityTextfield = new JTextField();
    JTextField registerTextfield = new JTextField();
    JTextField lastConnexionTextfield = new JTextField();

    //CONSTRUCTEUR
    public UserSheet(User user) {

        idLabel = new JLabel("Id");
        firstNameLabel = new JLabel("Prénom");
        lastNameLabel = new JLabel("Nom");
        emailLabel = new JLabel("email :");
        birthdayLabel = new JLabel("Date de Naissance");
        passwordLabel = new JLabel("Mot de passe");
        countryLabel = new JLabel("Pays");
        cityLabel = new JLabel("Ville");
        registerLabel = new JLabel("date d'enregistrement");
        lastConnexionLabel = new JLabel("Date de derniere connexion");

        idTextfield.setText(Integer.toString(user.getId()));
        lastNameTextfield.setText(user.getLastName());
        firstNameTextfield.setText(user.getFirstName());
        emailTextfield.setText(user.getEmail());
        birthdayTextfield.setText(user.getBirthday().toString());
        cityTextfield.setText(user.getCity());
        countryTextfield.setText(user.getCountry());

        setLayout(gridLayout);
        this.add(idLabel,0);
        this.add(idTextfield, 1);
        this.add(lastNameLabel,2);
        this.add(lastNameTextfield,3);
        this.add(firstNameLabel,4);
        this.add(firstNameTextfield,5);
        this.add(birthdayLabel,6);
        this.add(birthdayTextfield,7);
        this.add(emailLabel,8);
        this.add(emailTextfield,9);
        this.add(passwordLabel,10);
        this.add(passwordTextfield,11);
        this.add(countryLabel,12);
        this.add(countryTextfield,13);
        this.add(cityLabel,14);
        this.add(cityTextfield,15);
        this.add(registerLabel,16);
        this.add(registerTextfield,17);
        this.add(lastConnexionLabel,18);
        this.add(lastConnexionTextfield,19);
    }


    //METHODES

}
