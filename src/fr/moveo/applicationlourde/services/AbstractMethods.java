package fr.moveo.applicationlourde.services;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

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

    public StringBuffer loggin(String email, String password) {

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","login"));
        urlParameters.add(new BasicNameValuePair("email",email));
        urlParameters.add(new BasicNameValuePair("password", password));
        return connection.getJsonFromUrl(urlParameters);
    }
}
