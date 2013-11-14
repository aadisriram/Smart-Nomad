package com.nomad.smart.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class CreateEvent implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
	}

}
