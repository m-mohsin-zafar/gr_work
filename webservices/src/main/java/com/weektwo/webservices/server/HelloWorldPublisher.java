package com.weektwo.webservices.server;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

	public static void main(String args[]) {
		Endpoint.publish("http://localhost:9898/ws/hello", new HelloWorldImpl());
	}
}
