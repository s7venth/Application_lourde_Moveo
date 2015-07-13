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
import java.util.List;

/**
 * the connection class allow to
 */
public class Connection {

    //FIXME ajouter la varitable url de connection
    String url = "";

    public StringBuffer getJsonFromUrl(List<NameValuePair> postParameters){
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://moveo.besaba.com/moderator.php");
            System.out.println( "le httppost : "+httppost);
            System.out.println( "le postParameters : "+postParameters);
            // Request parameters and other properties.
            System.out.print(new UrlEncodedFormEntity(postParameters, "UTF-8"));
            httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            System.out.println( "le response : "+response);
            HttpEntity entity = response.getEntity();
            System.out.println( "le entity : "+entity);
            InputStream inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                result.append(line);
                System.out.println("le result : " + result);
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

