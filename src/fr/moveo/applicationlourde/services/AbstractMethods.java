package fr.moveo.applicationlourde.services;

import fr.moveo.applicationlourde.model.Trip;
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
    public static final String GET_USER = "getUsers";
    public static final String USER_LAST_NAME = "user_last_name";
    public static final String USER_ID = "user_id";
    public static final String USER_FIRST_NAME = "user_first_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_BIRTHDAY = "user_birthday";
    public static final String USER_COUNTRY = "user_country";
    public static final String USER_CITY = "user_city";
    public static final String GET_TRIP_LIST = "getTripList";
    public static final String TRIP_ID = "trip_id";
    public static final String TRIP_NAME = "trip_name";
    public static final String TRIP_COUNTRY = "trip_country";
    public static final String TRIP_COMMENT_COUNT = "trip_comment_count";

    private Connection connection = new Connection();
    /**
     * method used to get all the users of the application
     * @return an array of user
     */

    public StringBuffer loggin(String email, String password) {

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","login"));
        urlParameters.add(new BasicNameValuePair("email",email));
        urlParameters.add(new BasicNameValuePair("password", password));
        return connection.getJsonFromUrl(urlParameters);
    }


    public StringBuffer getUsers(){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_USER));
        return connection.getJsonFromUrl(urlParameters);
    }

    public StringBuffer getTripList(String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag",GET_TRIP_LIST));
        urlParameters.add(new BasicNameValuePair(USER_ID,userId));
        return connection.getJsonFromUrlTrip(urlParameters);
    }

    public ArrayList<User> getArrayList(StringBuffer jsonReceived){
        ArrayList<User> userArrayList = new ArrayList<User>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        JSONArray userTable = json.getJSONArray("user");
        for (int i = 0; i < userTable.length(); i++) {
            User user = new User();
            try {
                user.setId(userTable.getJSONObject(i).getInt(USER_ID));
                user.setLastName(userTable.getJSONObject(i).getString(USER_LAST_NAME));
                user.setFirstName(userTable.getJSONObject(i).getString(USER_FIRST_NAME));
                user.setEmail(userTable.getJSONObject(i).getString(USER_EMAIL));
                System.out.println(userTable.getJSONObject(i).getString(USER_BIRTHDAY));
                if(userTable.getJSONObject(i).has(USER_BIRTHDAY)&&!userTable.getJSONObject(i).isNull(USER_BIRTHDAY)){
                    String dateStr = userTable.getJSONObject(i).getString(USER_BIRTHDAY);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date birthDate = sdf.parse(dateStr);
                        user.setBirthday(birthDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else try {
                    Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00");
                    user.setBirthday(birthDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(userTable.getJSONObject(i).has(USER_BIRTHDAY)&&!userTable.getJSONObject(i).isNull(USER_BIRTHDAY)){
                    if (!(userTable.getJSONObject(i).getString(USER_COUNTRY).compareTo("null")==0)){
                        user.setCountry(userTable.getJSONObject(i).getString(USER_COUNTRY));
                    }else user.setCountry("no data");
                }else user.setCountry("no data");
                if(userTable.getJSONObject(i).has(USER_BIRTHDAY)&&!userTable.getJSONObject(i).isNull(USER_BIRTHDAY)){
                    user.setCity(userTable.getJSONObject(i).getString(USER_CITY));
                }else user.setCity("no data");
                userArrayList.add(user);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        System.out.println("la list d'utilisateurs : " + userTable.toString());
        System.out.println("ArrayList : " + userArrayList.toString());
        return userArrayList;
    }

    public ArrayList<Trip> getArrayListTrip (StringBuffer jsonReceived){
        ArrayList<Trip> tripArrayList = new ArrayList<Trip>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        JSONArray tripTable = json.getJSONArray("trip");
        for (int i = 0; i < tripTable.length(); i++) {
            Trip trip = new Trip();
            try {
                trip.setId(tripTable.getJSONObject(i).getInt(TRIP_ID));
                trip.setName(tripTable.getJSONObject(i).getString(TRIP_NAME));
                trip.setCountry(tripTable.getJSONObject(i).getString(TRIP_COUNTRY));
                trip.setCommentCount(tripTable.getJSONObject(i).getInt(TRIP_COMMENT_COUNT));
                tripArrayList.add(trip);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        System.out.println("la list d'utilisateurs : " + tripTable.toString());
        System.out.println("ArrayList : " + tripArrayList.toString());
        return tripArrayList;
    }
}
