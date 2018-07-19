package com.quickrescue.configurations;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryInstance {

	private static SessionFactoryInstance sfInstance = null;

	private SessionFactory factory = null;

	private SessionFactoryInstance() {
	}

	public static SessionFactoryInstance getSessionFactoryInstance() {
		if (sfInstance == null) {
			sfInstance = new SessionFactoryInstance();
		}
		return sfInstance;
	}

	public SessionFactory getSessionFactory() {
		if (factory == null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

			try {
				factory = meta.getSessionFactoryBuilder().build();
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return factory;
	}

}
