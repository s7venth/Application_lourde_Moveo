package fr.moveo.applicationlourde.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.moveo.applicationlourde.model.User;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to be le methods class.
 */
public class AbstractMethods {

    /**
     * method used to get all the users of the application
     * @return an array of user
     */
    public ArrayList<User> getUsers(){
        String stringJson ="";
        StringBuffer result = new StringBuffer();
        ArrayList<User> userArrayList = new ArrayList<User>();
        Type userCollection = new TypeToken<ArrayList<User>>(){
        }.getType();
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","getUsers"));
        Connection connection = new Connection();
        try {
            result = connection.getJsonFromUrl(urlParameters);
            stringJson = result.toString();
            Gson gson = new Gson();
            userArrayList = gson.fromJson(stringJson,userCollection);
        }catch (Exception e){
            e.getMessage();
        }
        return userArrayList;
    }



}
