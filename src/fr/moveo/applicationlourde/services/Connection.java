package fr.moveo.applicationlourde.services;


import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by travail on 23/06/15.
 */
public class Connection {
	static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	public void getRequest(String urlRequest) {
		GenericUrl url = new GenericUrl(urlRequest);
		try {
			HttpRequest httpRequest= HTTP_TRANSPORT.createRequestFactory().buildGetRequest(url);
			HttpResponse httpResponse = httpRequest.execute();
			System.out.println(httpResponse.getStatusCode());
			InputStream is = httpResponse.getContent();
			int character;
			while ((character = is.read()) !=-1){
				System.out.println((char) character);
			}
			httpResponse.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
