package fr.moveo.applicationlourde.Views.frames;

import fr.moveo.applicationlourde.Events.MyListener;
import fr.moveo.applicationlourde.model.Bdd;
import fr.moveo.applicationlourde.model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alexMac on 08/05/15.
 * vu principal de l'application. elle est faite en borderLayout.
 */

public class WindowPrincipal extends JFrame implements ActionListener, ListSelectionListener {
    JList<User> userJList = new JList<User>();
    //requete de sélection de tous les utilisateurs
    String requeteSQL = "SELECT user.user_last_name, user.user_first_name\n" +
            "FROM user\n" +
            "WHERE (user.user_last_name *)\n" +
            "ORDER BY user.user_last_name ASC, user.user_first_name ASC";
    Bdd bdd = new Bdd("localhost","moveo_database","root","");//TODO les parametres doivent etre modifier pour qu'ils ne soient pas en dur dans le code
    Container[] containers = new Container[4];
    public WindowPrincipal() throws HeadlessException {/*
        for (int i=0;i<4; i++){
            containers[i] = new JPanel();
        }
        containers[0].setLayout();
        */

        try {
            bdd.loadingDriver();
            bdd.connecting();
            Statement unEtat = bdd.getMyConnexion().createStatement();
            unEtat.execute(requeteSQL);
            unEtat.close();
            bdd.disConnecting();
            System.out.println("récupération réussi");
        } catch (SQLException e) {
            System.out.println("echec de récupération de la liste d'utilisateur");
            e.printStackTrace();
        }

    }

    public void windowsConfiguration(){
        setSize(700, 700); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        setTitle("Gestionnaire de Moveo");
        MyListener myListener = new MyListener();
        addWindowListener(myListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /**
     * Methode permettant d'indiquer le changement d'état lorsque l'utilisateur admin cliquera sur la liste
     * @param e la valeur de la ligne de la liste
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
