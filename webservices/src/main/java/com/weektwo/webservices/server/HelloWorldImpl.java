package com.weektwo.webservices.server;

import javax.jws.WebService;

@WebService(endpointInterface = "com.weektwo.webservices.server.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String getHelloWorldAsString(String name) {
		return "Hello World -- "+name;
	}

}
