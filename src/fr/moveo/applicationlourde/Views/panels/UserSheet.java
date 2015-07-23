package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class than contains the users informations
 */
public class UserSheet extends JPanel implements ActionListener {
    String id;
    User moderatorUser, oneUser;
    ConnectMethods connectMethods = new ConnectMethods();
    GridLayout gridLayout = new GridLayout(10,2);
    JLabel idLabel, firstNameLabel, lastNameLabel, birthdayLabel, emailLabel, adminLabel,
            countryLabel, cityLabel, passwordLabel;
    JButton update, delete, addButton, sendMessage;
    JTextField idTextfield = new JTextField();
    JTextField firstNameTextfield = new JTextField();
    JTextField lastNameTextfield = new JTextField();
    JTextField birthdayTextfield = new JTextField();
    JTextField emailTextfield = new JTextField();
    JTextField adminTextfield = new JTextField();
    JTextField countryTextfield = new JTextField();
    JTextField cityTextfield = new JTextField();
    JTextField passwordTextfield = new JTextField();
    /**
     *  constructor of the userSheet
     * @param user the information of the user
     * @param moderator the information of the moderator
     * @param admin boolean use to know if the panel should be for administrator or moderator
     */
    public UserSheet(User user, User moderator, boolean admin) {
        oneUser = user;
        id  = Integer.toString(user.getId());
        moderatorUser = moderator;
        idLabel = new JLabel("Id");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        firstNameLabel = new JLabel("Prénom");
        firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        lastNameLabel = new JLabel("Nom");
        lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
        emailLabel = new JLabel("email :");
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        birthdayLabel = new JLabel("Date de Naissance");
        birthdayLabel.setHorizontalAlignment(JLabel.CENTER);
        adminLabel = new JLabel("Administrateur");
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        countryLabel = new JLabel("Pays");
        countryLabel.setHorizontalAlignment(JLabel.CENTER);
        cityLabel = new JLabel("Ville");
        cityLabel.setHorizontalAlignment(JLabel.CENTER);
        passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        sendMessage = new JButton("envoyer message");
        update = new JButton(moderator.isAdmin()?"Modifier":"Modifier l'utilisateur");
        delete = new JButton(moderator.isAdmin()?"Supprimer":"Supprimer l'utilisateur");
        if (moderator.isAdmin()) addButton = new JButton("Ajouter un moderateur");

        idTextfield.setText(id);
        lastNameTextfield.setText(user.getLastName());
        firstNameTextfield.setText(user.getFirstName());
        emailTextfield.setText(user.getEmail());
        birthdayTextfield.setText(user.getBirthday().toString()==null?"no data":user.getBirthday().toString());
        cityTextfield.setText(user.getCity()==null?"no data":user.getCity());
        countryTextfield.setText(user.getCountry()==null?"no data":user.getCountry());
        adminTextfield.setText(user.isAdmin() ? "OUI" : "NON");
        passwordTextfield.setText(user.getPassword()==null?"FOBIDDEN":user.getPassword());

        update.addActionListener(this);
        delete.addActionListener(this);
        sendMessage.addActionListener(this);
        if (moderatorUser.isAdmin()) addButton.addActionListener(this);

        setLayout(gridLayout);
        if (admin){
            this.add(idLabel, 0);
            this.add(idTextfield, 1);
            this.add(lastNameLabel,2);
            this.add(lastNameTextfield,3);
            this.add(emailLabel,4);
            this.add(emailTextfield,5);
            this.add(passwordLabel,6);
            this.add(passwordTextfield,7);
            this.add(adminLabel,8);
            this.add(adminTextfield,9);
            this.add(sendMessage,10);
            this.add(delete, 11);
            this.add(update, 12);
            this.add(addButton,13);
        }else{
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
            this.add(sendMessage,16);
            this.add(delete,17);
            this.add(update,18);
        }
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
            StringBuffer response = connectMethods.updateUser(userId, userLastName, userFirstName, userBirthday, userCity, userCountry);
            System.out.println("la réponse : "+response);
        }
        else if (e.getSource()==delete && !moderatorUser.isAdmin()){
            String userId = idTextfield.getText();
            StringBuffer response = connectMethods.deleteUser(userId);
            System.out.println("la réponse : "+response);
        }
        else if (e.getSource()== sendMessage){
            JFrame jFrame = new JFrame();
            ConnectMethods connectMethods = new ConnectMethods();
            System.out.println(this.id);
            StringBuffer response = connectMethods.sendMessage(this.id,JOptionPane.showInputDialog(jFrame, "", "Votre Message", JOptionPane.QUESTION_MESSAGE));
            System.out.println("la réponse : " + response);
        }
    }
}
