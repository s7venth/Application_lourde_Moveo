package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Trip;
import fr.moveo.applicationlourde.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe qui permet d'afficher la fiche des voyages d'un utilisateur
 */
public class TripSheet extends JPanel {
    //VARIABLES
    Trip trip = new Trip();

    GridLayout gridLayout = new GridLayout(12,4);
    JLabel idLabel, nameLabel, descriptionLabel, countryLabel, dateCreation;
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
    public TripSheet(User user) {

        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Nom");
        descriptionLabel = new JLabel("Description");
        countryLabel = new JLabel("Pays");
        dateCreation = new JLabel("Date de derniere connexion");
        setLayout(gridLayout);
    }


    //METHODES

}
