package fr.moveo.applicationlourde.model;

/**
 * Created by alexMac on 09/05/15.
 * classe Model de connexion qui permet de se connection à la base de données
 */

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;


public class Bdd {
    private String server, bdd, user, password;
    private Connection myConnexion;

    /**
     * Méthode permettant de construire une nouvelle connexion à la base de données
     * @param server le nom du serveur
     * @param bdd le nom de la base de donnée
     * @param user l'identifiant de la personne qui souhaite se connecter (doit etre un admin ou un modérateur)
     * @param password le mot de passe de l'utilisateur
     */
    public Bdd(String server, String bdd, String user, String password){
        this.server=server;
        this.bdd=bdd;
        this.user=user;
        this.password=password;
        this.myConnexion=null;
    }

    /**
     * méthode qui permet de chager le driver de connexion à la base de données
     */
    public void loadingDriver(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException exp){
            System.out.println("absence du pilote JDBC");
        }
    }

    /**
     * méthode qui permet la connexion à la base de données
     */
    public void connecting(){
        try{
            this.myConnexion= DriverManager.getConnection("jdbc:mysql://"+this.server+"/"+this.bdd, this.user, password);
        }catch(SQLException exp){
            System.out.println("probleme de connexion ‡ :"+this.server);
        }
    }

    /**
     * méthode permettant de se déconnecter à la base de données... tres importante pour eviter de canaliser toute une connexion
     */
    public void disConnecting(){
        try{
            if (this.myConnexion!=null){
                this.myConnexion.close();
            }
        }catch (SQLException exp){
            System.out.println("erreur lors de la fermeture de la connection !");
        }
    }

    /**
     * methode qui permet de récuperer une connexion à la base de données pour éviter d'avoir à en recreer une une.
     * @return la connexion utilisé
     */
    public Connection getMyConnexion(){
        return this.myConnexion;
    }
}
