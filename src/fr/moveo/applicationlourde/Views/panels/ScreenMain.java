package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.services.AbstractMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * page principale du logiciel
 */
public class ScreenMain extends JPanel implements ListSelectionListener{

    // VARIABLES
    JTabbedPane jTabbedPane = new JTabbedPane();
    JPanel jCards = new JPanel(new CardLayout());
    UserSheet jIDSheet = new UserSheet();
    Sheet jTrip = new Sheet();
    Sheet jComments = new Sheet();
    JLabel message = new JLabel("");
    UserSheet userSheet = new UserSheet();
    JList list = new JList();

    public ScreenMain(){
        AbstractMethods abstractMethods = new AbstractMethods();
        /*
        ArrayList<User> userList = abstractMethods.getUsers();
        String users = "";
        for (int i=0;i<userList.size();i++){
            users += userList.get(i).getLastName()+" "+userList.get(i).getFirstName();
        }
        String[] result = {users};
        list = new JList(result);
        list.addListSelectionListener(this);
        */
        this.setLayout(new BorderLayout());
        this.add(list, BorderLayout.WEST);
        this.add(userSheet, BorderLayout.CENTER);
        this.screenConfiguration();
        this.add(message, BorderLayout.SOUTH);

        // panel des différentes fiches qui s'afficheront en fonction des onglets
        jCards.add(jIDSheet);
        jIDSheet.setBackground(Color.BLUE);
        jCards.add(jTrip);
        jTrip.setBackground(Color.RED);
        jCards.add(jComments);
        jComments.setBackground(Color.GREEN);

        //rajout des boutons dans le panel d'onglets
        jTabbedPane.addTab("Fiche Utilisateur", jIDSheet);
        jTabbedPane.addTab("Voyages", jTrip);
        jTabbedPane.addTab("Commentaires", jComments);
        add(jTabbedPane, BorderLayout.CENTER);
    }

    public void screenConfiguration(){
        this.setOpaque(false); // mettre l'écran en transparent
        this.setPreferredSize(new Dimension(600, 400)); // taille de l'écran
        this.setBackground(Color.GREEN);//Définition de sa couleur de fond
        this.setVisible(true);
    }


    public JLabel getMessage() {
        return message;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
}