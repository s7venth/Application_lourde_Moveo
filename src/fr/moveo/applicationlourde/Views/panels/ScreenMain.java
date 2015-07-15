package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.User;
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
public class ScreenMain extends JPanel{

    // VARIABLES
    User user;
    ArrayList usersList = new ArrayList();
    JTabbedPane jTabbedPane = new JTabbedPane();
    JPanel jCards = new JPanel();
    CardLayout card = new CardLayout();
    UserSheet userSheet;
    Sheet jTrip,jComments;
    JLabel message = new JLabel("");
    JList list;

    public ScreenMain(User moderator, ArrayList<User>  userList){
        jCards.setLayout(card);
        DefaultListModel listModel = new DefaultListModel();
        usersList = userList;
        for (int i = 0; i < usersList.size(); i++) {
            User user = (User) usersList.get(i);
            userSheet = new UserSheet(user);
            listModel.addElement(user);
            jCards.add(userSheet, user.toString());
        }
        jTrip = new Sheet();
        jComments = new Sheet();
        user = new User();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    Object obj = list.getSelectedValue();
                    User user = (User) obj;
                    jCards.add(userSheet);
                    CardLayout cL = (CardLayout) (jCards.getLayout());
                    cL.show(jCards, user.toString());
                    System.out.println(user.toString());
                }

            }
        });

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(list), BorderLayout.WEST);
        this.add(message, BorderLayout.SOUTH);
        this.screenConfiguration();


        // panel des différentes fiches qui s'afficheront en fonction des onglets
        jCards.add(jTrip);
        jTrip.setBackground(Color.RED);
        jCards.add(jComments);
        jComments.setBackground(Color.GREEN);

        //rajout des boutons dans le panel d'onglets
        jTabbedPane.addTab("Fiche Utilisateur", jCards);
        jTabbedPane.addTab("Voyages", jTrip);
        jTabbedPane.addTab("Commentaires", jComments);
        this.add(jTabbedPane, BorderLayout.CENTER);

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


//
}