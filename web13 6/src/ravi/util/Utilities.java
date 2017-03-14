package ravi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import ravi.model.FailureResponse;
import ravi.model.ParentBeans;
import ravi.model.ResponseSuccess;

public class Utilities {

	public static HttpURLConnection getSignedUrl(String eventUrl) throws IOException {
		OAuthConsumer consumer = new DefaultOAuthConsumer("techchallenge1-152646", "JCT1OLGyvnyG");
		URL url = new URL(eventUrl);
		HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
		try {
			consumer.sign(httpUrl);
			System.out.println("url signed successfully");
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpUrl.setRequestProperty("Accept", "application/json");
		System.out.println("Connection to eventUrl : Successfull");
		return httpUrl;

	}

	public static String getEventUrlJsonString(String eventUrl) throws IOException {
		HttpURLConnection httpUrl = getSignedUrl(eventUrl);
		InputStream inputStream = httpUrl.getInputStream();
		StringBuilder output = new StringBuilder();
		if (inputStream != null) {
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				output.append(line);
				line = bufferedReader.readLine();
			}
		}
		return output.toString();
	}

	public static ParentBeans extractDataFromJson(String jsonOutput) throws Exception {
		ObjectMapper obj = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		ParentBeans pr = null;
		pr = mapper.readValue(jsonOutput, ParentBeans.class);
		return pr;
//		System.out.println(pr.getApplicationUuid()+pr.getMarketplace().toString());

	}

	public static String getNewAccountIdentifier(String fname, String uuid){
		return fname+uuid.substring(uuid.length()-4, uuid.length());
	}
	
	public static String sendSuccessResponse(HttpServletResponse response, String accountIdentifier) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		response.setStatus(200);
		ResponseSuccess responseObject = new ResponseSuccess(true, accountIdentifier);
		String json = mapper.writeValueAsString(responseObject);
		return json;
	}

	public static String sendFailureResponse(HttpServletResponse response) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		response.setStatus(500);
		FailureResponse responseObject = new FailureResponse(false,"USER_ALREADY_EXISTS","User Already Exists");
		String json = mapper.writeValueAsString(responseObject);
		return json;

	}

}
