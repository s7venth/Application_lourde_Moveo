package fr.moveo.applicationlourde.services;

import fr.moveo.applicationlourde.model.*;
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
 * This class contains all the methods used by the application to communicate with the web service.
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
    public static final String GET_INBOX = "getInbox";

    /*
        private String urlModerator = "http://moveo.besaba.com/moderator.php";
        private String urlTrip = "http://moveo.besaba.com/trip.php";
        private String urlUser = "http://moveo.besaba.com/user.php";
        private String urlDialog = "http://moveo.besaba.com/dialog.php";
        */
    private static final String urlModerator = "http://moveo.16mb.com/moderator.php";
    private static final String urlTrip = "http://moveo.16mb.com/trip.php";
    private static final String urlUser = "http://moveo.16mb.com/user.php";
    private static final String urlDialog = "http://moveo.16mb.com/dialog.php";
    private Connection connection = new Connection();

    /**
     * method used to log the moderator
     * @param email the email of the moderator
     * @param password the password of the moderator
     * @return a respond by the web service in a StringBuffer
     */
    public StringBuffer loggin(String email, String password) {

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag","login"));
        urlParameters.add(new BasicNameValuePair("email",email));
        urlParameters.add(new BasicNameValuePair("password", password));
        return connection.getJsonFromUrl(urlModerator, urlParameters);
    }

    /**
     * method used to get all the users of the application
     * @return a respond in a stringBuffer
     */
    public StringBuffer getUsers(){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_USER));
        return connection.getJsonFromUrl(urlModerator, urlParameters);
    }

    /**
     * method used to delete a user by the moderator
     * @param userId the ID of the user that need to be delete
     * @return a respond by the web service in a StringBuffer
     */
    public StringBuffer deleteUser(String userId){
        List<NameValuePair> accountRequest = new ArrayList<NameValuePair>();
        accountRequest.add(new BasicNameValuePair("tag", DELETE_USER));
        accountRequest.add(new BasicNameValuePair("userId", userId));
        return connection.getJsonFromUrl(urlUser, accountRequest);
    }

    /**
     * method used to update a user
     * @param id the id of the user
     * @param lastName of the user
     * @param firstName of the user
     * @param birthday of the user
     * @param city of the user
     * @param country of the user
     * @return a response of the web service in a StringBuffer
     */
    public StringBuffer updateUser(String id, String lastName, String firstName, String birthday, String city, String country){
        List<NameValuePair> modifyUserForm = new ArrayList<NameValuePair>();
        modifyUserForm.add(new BasicNameValuePair("tag", UPDATE_USER));
        modifyUserForm.add(new BasicNameValuePair("userId", id));
        modifyUserForm.add(new BasicNameValuePair("firstName", firstName));
        modifyUserForm.add(new BasicNameValuePair("lastName", lastName));
        modifyUserForm.add(new BasicNameValuePair("country", country));
        modifyUserForm.add(new BasicNameValuePair("city", city));
        modifyUserForm.add(new BasicNameValuePair("birthday", birthday));
        System.out.println("le modifyuserform : " + modifyUserForm.toString());
        return connection.getJsonFromUrl(urlUser, modifyUserForm);
    }

    /**
     * method used to get all the trip of a user
     * @param userId the userid needed to get all his trip
     * @return a stringBuffer with the respond
     */
    public StringBuffer getTripList(String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_TRIP_LIST));
        urlParameters.add(new BasicNameValuePair(USER_ID, userId));
        return connection.getJsonFromUrl(urlTrip,urlParameters);
    }

    /**
     * method used to get all the comment given by the user
     * @param userId the userId needed to get all his comments
     * @return a respond in a format StringBuffer
     */
    public StringBuffer getCommentListByUser(String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_COMMENT_LIST_BY_USER));
        urlParameters.add(new BasicNameValuePair(USER_ID, userId));
        return connection.getJsonFromUrl(urlTrip, urlParameters);
    }

    /**
     * method used to get the message contained in the box of a user
     * @param userId the userID needed to select the user we needed to get all his messages
     * @return a respond in a format of StringBuffer
     */
    public StringBuffer getInboxByUser (String userId){
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("tag", GET_INBOX));
        urlParameters.add(new BasicNameValuePair(USER_ID, userId));
        return connection.getJsonFromUrl(urlDialog, urlParameters);
    }

    /**
     * method that convert a StringBuffer into an Arraylist of user. the StringBuffer must contain users
     * @param jsonReceived the StringBuffer needed to be convert
     * @return an Arraylist of users.
     */
    public ArrayList<User> getArrayList(StringBuffer jsonReceived){
        ArrayList<User> userArrayList = new ArrayList<User>();
        JSONObject json = new JSONObject(jsonReceived.toString());
        if (json.getInt("error")==1){
            JOptionPane.showMessageDialog(null, json.getString("message"));
        }
        JSONArray userTable = json.getJSONArray("user");
        if (!json.has("user")||json.isNull("user")){
            JOptionPane.showMessageDialog(null,"the json must have a user key","WARNING",JOptionPane.WARNING_MESSAGE);
        }
        else{
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
        }
        return userArrayList;
    }

    /**
     * method used to convert a stringBuffer into an Arraylist of trip
     * @param jsonReceived The StringBuffer needed to be converted
     * @return an Arraylist of Trips.
     */
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

    /**
     * Method used to convert a StringBuffer into an ArrayList of Comment
     * @param jsonReceived the StringBuffer needed to be converted
     * @return an ArrayList of comments
     */
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

    /**
     * method used to convert an ArrayList of trip into a table of trip
     * @param tripArrayList the arrayList of trip needed to be converted into a table of trip
     * @return a table of trip
     */
    public TripTableModel getTableTrip(ArrayList<Trip> tripArrayList){
        return new TripTableModel(tripArrayList);
    }

    /**
     * method used to convert an ArrayList of comments into a table of comment
     * @param commentArrayList the arraylist of comment needed to be converted into a table of comment
     * @return a table of Comment
     */
    public CommentTableModel getTableComment(ArrayList<Comment> commentArrayList){
        return new CommentTableModel((commentArrayList));
    }
}
