package com.quickrescue.models;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.quickrescue.configurations.TransactionConfigurations;
import com.quickrescue.entities.Account;
import com.quickrescue.interfaces.IManageAccount;

public class ManageAccount implements IManageAccount {

	private TransactionConfigurations tc;// = new TransactionConfigurations();
	private Transaction tx = null;
	private Account account = null;

	public void addAccount(String name, String emailAddress, String timeZone) {
		
		tc = new TransactionConfigurations();
		
		try {
			account = new Account(name, emailAddress, timeZone);

			tx = tc.getTransaction();

			tc.getSessionObject().save(account);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

	}

	public List<Account> viewAllAccounts() {
		
		tc = new TransactionConfigurations();
		
		List<Account> accounts = null;

		try {
			
			tc.endSession();
			
			tx = tc.getTransaction();
			tc.getSessionObject();

			accounts = tc.getSessionObject().createQuery("From Account").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

		return accounts;
	}

	public void updateAccount(int id, String name, String emailAddress, String timeZone) {
		
		tc = new TransactionConfigurations();
		
		try {
			tc.endSession();
			
			tx = tc.getTransaction();
			tc.getSessionObject();

			Account account = (Account) tc.getSessionObject().get(Account.class, id);
			
			Account original =account;
			
			if (!name.isEmpty()) {
				account.setName(name);
			} else {
				account.setName(original.getName());
			}

			if (!emailAddress.isEmpty()) {
				account.setEmailAddress(emailAddress);
			} else {
				account.setEmailAddress(original.getEmailAddress());
			}

			if (!timeZone.isEmpty()) {
				account.setTimeZone(timeZone);
			} else {
				account.setTimeZone(original.getTimeZone());
			}

			tc.getSessionObject().update(account);

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}
		System.out.println("===========GOOD SHOT==========");
	}

	public void deleteAccount(int id) {

	}

}
