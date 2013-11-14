package com.nomad.smart.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.nomad.smart.client.GreetingService;
import com.nomad.smart.shared.FieldVerifier;
import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
GreetingService {
	
	public String greetServer(String input) throws IllegalArgumentException {
		
		HttpServletRequest request = this.getThreadLocalRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id", "12345");
		
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		
		User user = new User();
		user.setUserId("12345");
		user.setEmailId("temp@temp.com");
		
		String temp = null;
		
		try {
			HttpURLConnection connection = getConnection("smarttravelservice", null);

			return new Gson().toJson(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			temp = "fail";
			e.printStackTrace();
		}
		
		return "This works I think !" + temp
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/* Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public String addUser(String fbUser, String accessCode, List<String> skills) throws Exception {
		
		HttpServletRequest request = this.getThreadLocalRequest();
		HttpSession session = request.getSession();
		
		List<String> tempo = new ArrayList<String>();
		for(int i = 0; i < 5; i++) {
			tempo.add("Test " + i);
		}
		
		User user = new User();
		user.setUserId("12345");
		user.setEmailId("temp@temp.com");
		
		try {
			HttpURLConnection connection = getConnection("addorupdateuser", "?userId=12345&contact=12434234234&emailId=temp@temp&userName=tempo&skillString=homestuff-expert,driving-expert");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String) session.getAttribute("user_id");
	}
	
	private HttpURLConnection getConnection(String api, String queryArgs) throws Exception {

		String url = "http://1.smartnomadservice.appspot.com/";
		if(api != null)
			url += api;
		
		if(queryArgs != null)
			url += "?" + queryArgs;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		return con;
	}
	
	// HTTP POST request
	private HttpsURLConnection getPostConnection() throws Exception {
 
		String url = "http://1.smartnomadservice.appspot.com/";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		// Send post request
		con.setDoOutput(true);
		
		return con;
	}
}
