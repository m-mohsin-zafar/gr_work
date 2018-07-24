package com.weektwo.webservices.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.weektwo.webservices.server.HelloWorld;

public class HelloWorldClient {

	public static void main (String args[]) throws Exception {
		URL url = new URL("http://localhost:9898/ws/hello?wsdl");
		QName qName = new QName("http://server.webservices.weektwo.com/","HelloWorldImplService");
		Service service = Service.create(url, qName);
		HelloWorld hello = service.getPort(HelloWorld.class);
		System.out.println(hello.getHelloWorldAsString("Mohsin.."));
	}
}
