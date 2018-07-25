package com.quickrescue.models;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.quickrescue.configurations.TransactionConfigurations;
import com.quickrescue.entities.Account;
import com.quickrescue.entities.Contact;
import com.quickrescue.entities.ContactAddress;
import com.quickrescue.interfaces.IManageContact;

public class ManageContact implements IManageContact {

	private TransactionConfigurations tc;
	private Transaction tx = null;
	// private Contact contact = null;
	// private ContactAddress contactAddress = null;

	public Contact addContact(String firstName, String lastName, String emailAddress, String gender, String phoneNumber,
			String status, int accountId, String streetAddress, String city, String state, String country) {

		Contact contact = null;
		ContactAddress contactAddress = null;

		tc = new TransactionConfigurations();

		try {

			tc.endSession();

			Account account = (Account) tc.getSessionObject().get(Account.class, accountId);

			if (account != null) {

				if (!firstName.isEmpty() && !lastName.isEmpty() && !emailAddress.isEmpty() && !gender.isEmpty()
						&& !phoneNumber.isEmpty() && !status.isEmpty()
						&& (status.equals("Active") || status.equals("InActive")) && !streetAddress.isEmpty()
						&& !city.isEmpty() && !state.isEmpty() && !country.isEmpty()) {

					contact = new Contact(firstName, lastName, emailAddress, gender, phoneNumber, status, account);
					contactAddress = new ContactAddress(streetAddress, city, state, country, contact);

					tx = tc.getTransaction();
					tc.getSessionObject().save(contact);
					tc.getSessionObject().save(contactAddress);
					tx.commit();

				}
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

		if (contact != null) {
			if (contact.getContactAddress() == null) {
				contact.setContactAddress(contactAddress);
			}
		}
		return contact;
	}

	public List<Contact> viewContacts() {

		tc = new TransactionConfigurations();

		List<Contact> contacts = null;

		try {

			tc.endSession();

			tx = tc.getTransaction();
			tc.getSessionObject();

			contacts = tc.getSessionObject().createQuery("From Contact").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

		return contacts;
	}

	public Contact updateContact(int id, String firstName, String lastName, String emailAddress, String gender,
			String phoneNumber, String status, int accountId, String streetAddress, String city, String state,
			String country) {

		Contact contact = null;
		ContactAddress contactAddress = null;

		tc = new TransactionConfigurations();

		try {

			tc.endSession();
			tx = tc.getTransaction();
			tc.getSessionObject();

			contact = (Contact) tc.getSessionObject().get(Contact.class, id);
			Contact original = contact;

			if (contact != null) {

				if (!firstName.isEmpty()) {
					contact.setFirstName(firstName);
				} else {
					contact.setFirstName(original.getFirstName());
				}

				if (!lastName.isEmpty()) {
					contact.setLastName(lastName);
				} else {
					contact.setLastName(original.getLastName());
				}

				if (!emailAddress.isEmpty()) {
					contact.setEmailAddress(emailAddress);
				} else {
					contact.setEmailAddress(original.getEmailAddress());
				}

				if (!gender.isEmpty()) {
					contact.setGender(gender);
				} else {
					contact.setGender(original.getGender());
				}

				if (!phoneNumber.isEmpty()) {
					contact.setPhoneNumber(phoneNumber);
				} else {
					contact.setPhoneNumber(original.getPhoneNumber());
				}

				if (!status.isEmpty()) {
					contact.setStatus(status);
				} else {
					contact.setStatus(original.getStatus());
				}

				Account account = (Account) tc.getSessionObject().get(Account.class, accountId);
				if (account != null) {
					contact.setAccount(account);
				} else {
					contact.setAccount(null);
				}

				contactAddress = contact.getContactAddress();

				if (!streetAddress.isEmpty()) {
					contactAddress.setStreetAddress(streetAddress);
				} else {
					contactAddress.setStreetAddress(original.getContactAddress().getStreetAddress());
				}

				if (!city.isEmpty()) {
					contactAddress.setCity(city);
				} else {
					contactAddress.setCity(original.getContactAddress().getCity());
				}

				if (!state.isEmpty()) {
					contactAddress.setState(state);
				} else {
					contactAddress.setState(original.getContactAddress().getState());
				}

				if (!country.isEmpty()) {
					contactAddress.setCountry(country);
				} else {
					contactAddress.setCountry(original.getContactAddress().getCountry());
				}

				tc.getSessionObject().update(contact);
				tc.getSessionObject().update(contactAddress);

				tx.commit();

			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

		if (contact != null) {
			contact = (Contact) tc.getSessionObject().get(Contact.class, id);
		}
		return contact;
	}

	public void deleteContact(int id) {

		Contact contact = null;
		ContactAddress contactAddress = null;

		tc = new TransactionConfigurations();

		try {

			tc.endSession();
			tx = tc.getTransaction();
			tc.getSessionObject();

			contact = (Contact) tc.getSessionObject().get(Contact.class, id);

			if (contact != null) {
				contactAddress = contact.getContactAddress();
				if (contactAddress != null) {
					tc.getSessionObject().delete(contactAddress);
				}
				tc.getSessionObject().delete(contact);
				tx.commit();
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			tc.getSessionObject().close();
		}

	}

}
