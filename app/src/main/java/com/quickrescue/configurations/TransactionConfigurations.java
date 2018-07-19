package com.quickrescue.configurations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class TransactionConfigurations {

	private Session session = null;
	private Transaction tx = null;

	public Session getSessionObject() {
		if (session == null || !session.isOpen()) {
			session = SessionFactoryInstance.getSessionFactoryInstance().getSessionFactory().openSession();
		}
		return session;
	}

	public Transaction getTransaction() {
		if (tx == null ) {
			tx = getSessionObject().beginTransaction();
		}
		return tx;
	}

	public void endSession() {
		if(session != null) {
			session.close();
		}
	}
}
