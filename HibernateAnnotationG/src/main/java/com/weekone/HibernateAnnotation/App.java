package com.weekone.HibernateAnnotation;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 *
 */
public class App {

	private static SessionFactory factory;

	public static void main(String args[]) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		try {
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageContact mc = new ManageContact(factory);

		Integer c01 = mc.insContact("H-371, Street-9, Moh. Millatabad, Satellite Twon", "Sargodha", "Punjab",
				"Pakistan", "03007612552", "mmohsin970@gmail.com");
		Integer c02 = mc.insContact("A1", "B", "C", "D", "E", "F");

	}
}
