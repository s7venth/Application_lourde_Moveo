package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.AbstractMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class than contains the users informations
 */
public class UserSheet extends JPanel implements ActionListener {

    AbstractMethods abstractMethods = new AbstractMethods();
    GridLayout gridLayout = new GridLayout(12,2);
    JLabel idLabel, firstNameLabel, lastNameLabel, birthdayLabel, emailLabel, adminLabel,
            countryLabel, cityLabel, registerLabel, lastConnexionLabel;
    JButton update, delete;
    JTextField idTextfield = new JTextField();
    JTextField firstNameTextfield = new JTextField();
    JTextField lastNameTextfield = new JTextField();
    JTextField birthdayTextfield = new JTextField();
    JTextField emailTextfield = new JTextField();
    JTextField adminTextfield = new JTextField();
    JTextField countryTextfield = new JTextField();
    JTextField cityTextfield = new JTextField();
    JTextField registerTextfield = new JTextField();
    JTextField lastConnexionTextfield = new JTextField();

    /**
     * constructor of the userSheet
     * @param user the information of the user
     */
    public UserSheet(User user) {

        idLabel = new JLabel("Id");
        firstNameLabel = new JLabel("Prénom");
        lastNameLabel = new JLabel("Nom");
        emailLabel = new JLabel("email :");
        birthdayLabel = new JLabel("Date de Naissance");
        adminLabel = new JLabel("Administrateur");
        countryLabel = new JLabel("Pays");
        cityLabel = new JLabel("Ville");
        registerLabel = new JLabel("date d'enregistrement");
        lastConnexionLabel = new JLabel("Date de derniere connexion");
        update = new JButton("Modifier");
        delete = new JButton("Supprimer");

        idTextfield.setText(Integer.toString(user.getId()));
        lastNameTextfield.setText(user.getLastName());
        firstNameTextfield.setText(user.getFirstName());
        emailTextfield.setText(user.getEmail());
        birthdayTextfield.setText(user.getBirthday().toString());
        cityTextfield.setText(user.getCity());
        countryTextfield.setText(user.getCountry());
        adminTextfield.setText(user.isAdmin()?"OUI":"NON");

        update.addActionListener(this);
        delete.addActionListener(this);

        setLayout(gridLayout);
        this.add(idLabel, 0);
        this.add(idTextfield, 1);
        this.add(lastNameLabel,2);
        this.add(lastNameTextfield,3);
        this.add(firstNameLabel,4);
        this.add(firstNameTextfield,5);
        this.add(birthdayLabel,6);
        this.add(birthdayTextfield,7);
        this.add(emailLabel,8);
        this.add(emailTextfield,9);
        this.add(countryLabel,10);
        this.add(countryTextfield,11);
        this.add(cityLabel,12);
        this.add(cityTextfield,13);
        this.add(adminLabel,14);
        this.add(adminTextfield,15);
        this.add(registerLabel,16);
        this.add(registerTextfield,17);
        this.add(lastConnexionLabel,18);
        this.add(lastConnexionTextfield,19);
        this.add(update, 20);
        this.add(delete, 21);
    }

    /**
     * method used when one of the button are clicked
     * @param e the event of the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==update){
            String userId = idTextfield.getText();
            String userLastName = lastNameTextfield.getText();
            String userFirstName = firstNameTextfield.getText();
            String userBirthday = birthdayTextfield.getText() ;
            String userCity = cityTextfield.getText();
            String userCountry = countryTextfield.getText();
            StringBuffer response = abstractMethods.updateUser(userId, userLastName, userFirstName, userBirthday, userCity, userCountry);
            System.out.println("la réponse : "+response);
        }
        else if (e.getSource()==delete){
            String userId = idTextfield.getText();
            StringBuffer response = abstractMethods.deleteUser(userId);
            System.out.println("la réponse : "+response);
        }
    }
}
