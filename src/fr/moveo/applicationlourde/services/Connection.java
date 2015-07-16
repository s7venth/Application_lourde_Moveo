package fr.moveo.applicationlourde.services;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.List;

/**
 * the connection class allow to
 */
public class Connection {

    //FIXME ajouter la varitable url de connection
    String urlModerator = "http://moveo.besaba.com/moderator.php";
    String urlTrip = "http://moveo.besaba.com/trip.php";
    String urlUser = "http://moveo.besaba.com/user.php";

    public StringBuffer getJsonFromUrl(List<NameValuePair> postParameters){
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(urlModerator);
            // Request parameters and other properties.
            httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                result.append(line);
            }
            bufferedReader.close();
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public StringBuffer getJsonFromUrlTrip(List<NameValuePair> postParameters){
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(urlTrip);
            // Request parameters and other properties.
            httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                result.append(line);
            }
            bufferedReader.close();
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public StringBuffer getJsonFromUrlUser(List<NameValuePair> postParameters){
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(urlUser);
            // Request parameters and other properties.
            httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                result.append(line);
            }
            bufferedReader.close();
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

