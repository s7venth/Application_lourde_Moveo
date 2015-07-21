package fr.moveo.applicationlourde.services;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.UnknownHostException;
import java.util.List;

/**
 * the connection class allow to create a connection with the web service.
 */
public class Connection {

    /**
     * This method is used to send information to an url with params
     * @param url the url needed to cennect
     * @param postParameters a list of key,value as params
     * @return a respond with 3 tag : error, success and message
     */
    public StringBuffer getJsonFromUrl(String url, List<NameValuePair> postParameters){
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(url);
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
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

