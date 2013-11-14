package com.nomad.smart.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void addUser(String fbUser, String accessCode, List<String> skills, AsyncCallback<String> callback) 
			throws Exception;
}
