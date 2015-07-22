package fr.moveo.applicationlourde.Views.frames;

import com.apple.eawt.Application;
import fr.moveo.applicationlourde.Events.MyListener;
import fr.moveo.applicationlourde.Views.panels.ScreenConnection;
import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.ConnectMethods;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Sylvain on 12/03/15.
 * JFrame used to be the first JFrame created when the application is launched
 */
public class WindowConnexion extends JFrame implements ActionListener {

    // DECLARATION DES PANELS
    private ScreenConnection screen;
    ImageIcon icon = new ImageIcon("res/fr.moveo.applicationlourde/Logo.png");
    JLabel jLabel;

    /**
     * the constructor of the jframe
     */
    public WindowConnexion(){
        jLabel = new JLabel(icon);
        screen = new ScreenConnection();
        this.add(jLabel, BorderLayout.NORTH);
        this.add(screen, BorderLayout.CENTER);

        screen.getLoginButton().addActionListener(this);
        this.windowConfiguration();
    }

    /**
     * config of the jframe
     */
    public void windowConfiguration(){
        MyListener myListener = new MyListener();
        addWindowListener(myListener);
        Color homeColor = new Color(5, 100, 200);
        this.setBackground(homeColor); // Couleur de fond
        Application application = Application.getApplication();// spécifique aux ordi Apple
        application.setDockIconImage(Toolkit.getDefaultToolkit().getImage("res/fr.moveo.applicationlourde/icon.png"));//definit l'image pour les dock d'apple
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/fr.moveo.applicationlourde/icon.png")); 	//Icône en haut à gauche
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Arrête complètement le processus avec le bouton [X]
        this.setTitle("Connexion");  //Définit un titre pour notre fenêtre
        this.setSize(500, 5000); // Taille fenêtre en pixel (h,v) h=horizontal v=vertical
        this.setLocationRelativeTo(null);  // Centre la fenêtre par défaut
        this.setResizable(true); // Empêche le redimensionnement de la fenêtre
        pack();
        this.setVisible(true); //Rendre visible la fenêtre admin@moveo.fr admin

    }

    /**
     * method used when the moderator click on the connection button
     * @param e the event of the click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        User moderator = new User();

        ConnectMethods connectMethods = new ConnectMethods();
        if (screen.getMailEditText().getText().equals("")|| screen.getPasswordEditText().getText().equals("")){
            JOptionPane.showMessageDialog(null, "veuillez remplir les deux champs","Attention",JOptionPane.ERROR_MESSAGE);
        }else{
            StringBuffer result = new StringBuffer();
            result = connectMethods.loggin(screen.getMailEditText().getText(),screen.getPasswordEditText().getText());
            System.out.println(result);
            JSONObject json = new JSONObject(result.toString());
            if (json.getInt("error")==1){
                JOptionPane.showMessageDialog(null, "le modérateur n'existe pas","Oups",JOptionPane.WARNING_MESSAGE);
            }else {
                moderator.setLastName(json.getJSONObject("moderator").getString("moderator_name"));
                moderator.setId(json.getJSONObject("moderator").getInt("moderator_id"));
                moderator.setEmail(json.getJSONObject("moderator").getString("moderator_email"));
                boolean is_admin = (1 == json.getJSONObject("moderator").getInt("is_admin"));
                moderator.setIsAdmin(is_admin);

                ArrayList<User> userList = connectMethods.getArrayList(connectMethods.getUsers());

                if (result.toString()!="acces refuse"){
                    this.dispose();
                    new WindowMain(moderator, userList);
                }
                else JOptionPane.showMessageDialog(null, result.toString(),"REFUSE",JOptionPane.WARNING_MESSAGE);
            }
        }
    }


}
