package fr.moveo.applicationlourde.services;

import fr.moveo.applicationlourde.model.Comment;
import fr.moveo.applicationlourde.model.Trip;
import fr.moveo.applicationlourde.model.TripTableModel;
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

    // je fais des variable static pour une meilleure gestion à l'avenir
    public static final String GET_USER = "getUsers";
    public static final String DELETE_USER = "deleteUser";
    public static final String UPDATE_USER = "updateProfil";
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
    public static final String GET_COMMENT_LIST_BY_USER = "getCommentListByUser";
    public static final String COMMENT_ID = "comment_id";
    public static final String COMMENT_MESSAGE = "comment_message";
    public static final String COMMENT_DATE_INSERTED = "comment_added_datetime";

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

    public StringBuffer deleteUser(String userId){
        List<NameValuePair> accountRequest = new ArrayList<NameValuePair>();
        accountRequest.add(new BasicNameValuePair("tag", DELETE_USER));
        accountRequest.add(new BasicNameValuePair("userId", userId));
        return connection.getJsonFromUrlUser(accountRequest);
    }

    public StringBuffer updateUser(String id, String lastName, String firstName, String birthday, String city, String country){
        List<NameValuePair> modifyUserForm = new ArrayList<NameValuePair>();
        modifyUserForm.add(new BasicNameValuePair("tag", UPDATE_USER));
        modifyUserForm.add(new BasicNameValuePair("userId", id));
        modifyUserForm.add(new BasicNameValuePair("lastName", lastName));
        modifyUserForm.add(new BasicNameValuePair("firstName", firstName));
        modifyUserForm.add(new BasicNameValuePair("birthday", birthday));
        modifyUserForm.add(new BasicNameValuePair("city", city));
        modifyUserForm.add(new BasicNameValuePair("country", country));
        return connection.getJsonFromUrl(modifyUserForm);
    }

    public StringBuffer getTripList(String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_TRIP_LIST));
        urlParameters.add(new BasicNameValuePair(USER_ID, userId));
        return connection.getJsonFromUrlTrip(urlParameters);
    }

    public StringBuffer getCommentListByUser(String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_COMMENT_LIST_BY_USER));
        urlParameters.add(new BasicNameValuePair(USER_ID, userId));
        return connection.getJsonFromUrlTrip(urlParameters);
    }

    public ArrayList<User> getArrayList(StringBuffer jsonReceived){
        ArrayList<User> userArrayList = new ArrayList<User>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        if (json.getInt("error")==1){
            JOptionPane.showMessageDialog(null, json.getString("message"));
        }
        JSONArray userTable = json.getJSONArray("user");
        for (int i = 0; i < userTable.length(); i++) {
            User user = new User();
            try {
                user.setId(userTable.getJSONObject(i).getInt(USER_ID));
                user.setLastName(userTable.getJSONObject(i).getString(USER_LAST_NAME));
                user.setFirstName(userTable.getJSONObject(i).getString(USER_FIRST_NAME));
                user.setEmail(userTable.getJSONObject(i).getString(USER_EMAIL));
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
        return userArrayList;
    }

    public ArrayList<Trip> getArrayListTrip (StringBuffer jsonReceived){
        ArrayList<Trip> tripArrayList = new ArrayList<Trip>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        if (json.has("trip")){
            JSONArray tripTable = json.getJSONArray("trip");
            for (int i = 0; i < tripTable.length(); i++) {
                Trip trip = new Trip();
                try {
                    trip.setId(tripTable.getJSONObject(i).getInt(TRIP_ID));
                    trip.setName(tripTable.getJSONObject(i).getString(TRIP_NAME));
                    trip.setCountry(tripTable.getJSONObject(i).getString(TRIP_COUNTRY));
                    if(tripTable.getJSONObject(i).has(TRIP_COMMENT_COUNT)&&!tripTable.getJSONObject(i).isNull(TRIP_COMMENT_COUNT)){
                        trip.setCommentCount(tripTable.getJSONObject(i).getInt(TRIP_COMMENT_COUNT));
                    } else trip.setCommentCount(0);
                    tripArrayList.add(trip);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }else {
            if (json.getInt("error")==1){
                Trip trip = new Trip();
                tripArrayList.add(trip);
            }
        }
        return tripArrayList;
    }

    public ArrayList<Comment> getArrayListComments (StringBuffer jsonReceived){
        ArrayList<Comment> commentArrayList = new ArrayList<Comment>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        if (json.has("comment")){
            JSONArray commentTable = json.getJSONArray("comment");
            for (int i = 0; i < commentTable.length(); i++) {
                Comment comment = new Comment();
                try {
                    comment.setCommentId(commentTable.getJSONObject(i).getInt(COMMENT_ID));
                    comment.setCommentMessage(commentTable.getJSONObject(i).getString(COMMENT_MESSAGE));
                    if(commentTable.getJSONObject(i).has(COMMENT_DATE_INSERTED)&&!commentTable.getJSONObject(i).isNull(COMMENT_DATE_INSERTED)){
                        String dateStr = commentTable.getJSONObject(i).getString(COMMENT_DATE_INSERTED);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date insertionDate = sdf.parse(dateStr);
                            comment.setCommentCreation(insertionDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else try {
                        Date insertionDate = new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00");
                        comment.setCommentCreation(insertionDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    comment.setTripId(commentTable.getJSONObject(i).getInt(TRIP_ID));
                    comment.setUserId(commentTable.getJSONObject(i).getInt(USER_ID));
                    comment.setCommentUserLastName(commentTable.getJSONObject(i).getString(USER_LAST_NAME));
                    comment.setCommentUserFirstName(commentTable.getJSONObject(i).getString(USER_FIRST_NAME));
                    commentArrayList.add(comment);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }else {
            if (json.getInt("error")==1){
                Comment comment = new Comment();
                commentArrayList.add(comment);
            }
        }
        return commentArrayList;
    }

    public TripTableModel getTableTrip(ArrayList<Trip> tripArrayList){
        return new TripTableModel(tripArrayList);
    }
}
