package fr.moveo.applicationlourde.services;

import fr.moveo.applicationlourde.model.User;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to be le methods class.
 */
public class AbstractMethods {
    private final String USER_AGENT = "chrome";
    private Connection connection = new Connection();
    /**
     * method used to get all the users of the application
     * @return an array of user
     */

    public List<NameValuePair> getUsers(){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","getUsers"));
        return urlParameters;
    }

    public StringBuffer getUsersTest(){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","getUsers"));
        return connection.getJsonFromUrl(urlParameters);
    }

    public ArrayList<User> getArrayList(StringBuffer jsonReceived){
        ArrayList<User> userArrayList = new ArrayList<User>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        JSONArray userTable = json.getJSONArray("user");
        for (int i = 0; i < userTable.length(); i++) {
            User user = new User();
            user.setId(userTable.getJSONObject(i).getInt("user_id"));
            user.setLastName(userTable.getJSONObject(i).getString("user_last_name"));
            user.setFirstName(userTable.getJSONObject(i).getString("user_first_name"));
            user.setEmail(userTable.getJSONObject(i).getString("user_email"));
            /*
            System.out.println(userTable.getJSONObject(i).getString("user_birthday"));
            String dateStr = userTable.getJSONObject(i).getString("user_birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date birthDate = sdf.parse(dateStr);
                user.setBirthday(birthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setCountry(userTable.getJSONObject(i).getString("user_country"));
            user.setCity(userTable.getJSONObject(i).getString("user_city"));
            */
            userArrayList.add(user);
        }
        System.out.println("la list d'utilisateurs : "+userTable.toString());
        System.out.println("ArrayList : "+userArrayList.toString());
        return userArrayList;
    }

    public DefaultListModel setUserList(ArrayList<User> userArrayList){
        //Création du model
        DefaultListModel listModel = new DefaultListModel();
        //Remplir le model
        int size = userArrayList.size();
        for(int index=0; index<size; index++)
        {
            listModel.addElement(userArrayList.get(index).getLastName()+" "+userArrayList.get(index).getFirstName());
        }
        return listModel;
    }

    public StringBuffer loggin(String email, String password) {

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","login"));
        urlParameters.add(new BasicNameValuePair("email",email));
        urlParameters.add(new BasicNameValuePair("password", password));
        return connection.getJsonFromUrl(urlParameters);
    }
}
