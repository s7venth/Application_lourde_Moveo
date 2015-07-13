package fr.moveo.applicationlourde.Views.frames;

import com.google.gson.Gson;
import fr.moveo.applicationlourde.Events.MyListener;
import fr.moveo.applicationlourde.Views.panels.ScreenConnection;
import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.AbstractMethods;
import fr.moveo.applicationlourde.services.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sylvain on 12/03/15.
 * Fenetre de connection. Censé etre la premiere fenetre qui doit apparaitre.
 */
public class WindowConnexion extends JFrame implements ActionListener {

    // DECLARATION DES PANELS
    private ScreenConnection screen;

    // CONSTRUCTEUR
    public WindowConnexion(){
        screen = new ScreenConnection();
            this.add(screen);

        screen.getLoginButton().addActionListener(this);
        this.windowConfiguration();
    }

    // Procedure permettant de configuration la fenêtre
    public void windowConfiguration(){
        MyListener myListener = new MyListener();
        addWindowListener(myListener);
        Color homeColor = new Color(5, 100, 200);
        this.setBackground(homeColor); // Couleur de fond
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/img/icon.png")); 	//Icône en haut à gauche
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Arrête complètement le processus avec le bouton [X]
        this.setTitle("fenetre");  //Définit un titre pour notre fenêtre
        this.setSize(300, 150); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenêtre par défaut
        this.setResizable(false); // Empêche le redimensionnement de la fenêtre
        pack();
        this.setVisible(true); //Rendre visible la fenêtre admin@moveo.fr admin

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection connection = new Connection();
        Gson gson = new Gson();
        User moderator = new User();
        StringBuffer result = new StringBuffer();
        AbstractMethods abstractMethods = new AbstractMethods();
        result = connection.getJsonFromUrl(abstractMethods.loggin(screen.getMailEditText().getText(),screen.getPasswordEditText().getText()));
        System.out.print("le json en string : "+result.toString());
        moderator = gson.fromJson(result.toString(), User.class);

        if (result!=null && result.toString() == "acces refuse"){
            this.dispose();
            new WindowMain(screen.getMailEditText().getText());
        }
        else JOptionPane.showMessageDialog(null,result);
    }
}
