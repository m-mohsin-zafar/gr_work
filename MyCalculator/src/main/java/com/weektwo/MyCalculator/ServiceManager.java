package com.weektwo.MyCalculator;

import java.util.HashMap;
import java.util.Properties;

import javax.naming.InitialContext;

public class ServiceManager {

	private InitialContext ic = null;
	private HashMap<String, Object> services = new HashMap<String, Object>();

	private final String MODULE_NAME = "MyAdditionEJB";

	private Properties loadProperties() {
		Properties props = new Properties();
		props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
		props.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		props.put("java.naming.provider.url", "remote+http://127.0.0.1:8080");
		props.put("jboss.naming.client.ejb.context", "true");
		props.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
		return props;
	}

	private InitialContext getContext() {

		try {
			if (ic == null) {

				Properties props = loadProperties();
				ic = new InitialContext(props);
			}
		} catch (Exception e) {
			// log graceful exception info
		}

		return ic;
	}

	public Object getService(String name) {
		try {

			InitialContext context = getContext();
			String contextPath = "ejb:/" + MODULE_NAME + "//" + name + "!com.mylogic." + name + "Remote";

			Object service = services.get(name);
			if (service == null) {
				service = context.lookup(contextPath);
				services.put(name, service);
			}
			return services.get(service);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
