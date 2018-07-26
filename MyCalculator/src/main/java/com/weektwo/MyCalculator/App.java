package com.weektwo.MyCalculator;

import java.util.Properties;

import javax.naming.InitialContext;

import com.mylogic.Addition;
import com.mylogic.AdditionRemote;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {

			System.out.println("Hello From Java!");
//			Properties props = new Properties();
//			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
//			props.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
//			props.put("java.naming.provider.url", "remote+http://127.0.0.1:8080");
//			props.put("jboss.naming.client.ejb.context", "true");
//			props.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
//			props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
//			props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//			props.put("java.naming.provider.url", "localhost");
//			InitialContext context = new InitialContext(props);

//			String appName = "";
//			String moduleName = "MyAdditionEJB";
//			String distinctName = "";
//			String beanName = Addition.class.getSimpleName();
//			String interfaceName = AdditionRemote.class.getName();
//			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
//					+ interfaceName;
//			String name = "MyAdditionEJB/Addition!com.mylogic.AdditionRemote";
			String name = "Addition";
			ServiceManager sm = new ServiceManager();
			sm.getService(name);
//			System.out.println(name);
//			AdditionRemote bean = (AdditionRemote) context.lookup(name);
			AdditionRemote bean = (AdditionRemote) sm.getService(name);
			int result = bean.add(7, 7);
			System.out.println("Result computed by EJB is :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
