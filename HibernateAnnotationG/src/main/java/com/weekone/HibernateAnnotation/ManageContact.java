package com.weekone.HibernateAnnotation;

import java.util.*;
import org.hibernate.*;

public class ManageContact {

	private SessionFactory sf;

	public ManageContact(SessionFactory sf) {
		this.sf = sf;
	}

	/* INSERT Contact Details */
	
	public Integer insContact(String str_adr, String city, String state, String country, String cell_num,
			String email_adr) {

		Session ses = sf.openSession();
		Transaction tx = null;
		Integer id = null;

		try {
			tx = ses.beginTransaction();
			Contact contact = new Contact();
			contact.setStreet_adr(str_adr);
			contact.setCity(city);
			contact.setState(state);
			contact.setCountry(country);
			contact.setCell_num(cell_num);
			contact.setEmail_adr(email_adr);
			id = (Integer) ses.save(contact);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			ses.close();
		}
		System.out.println("Insertion Successfull!");
		return id;
	}

	/* GET all Contacts */
	public List<Contact> getAllContacts() {
		Session ses = sf.openSession();
		Transaction tx = null;
		
		List<Contact> cont =null;

		try {
			tx = ses.beginTransaction();
			List contacts = ses.createQuery("FROM contact").list();
			cont = contacts;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			ses.close();
		}
		return cont;
	}
	
}
