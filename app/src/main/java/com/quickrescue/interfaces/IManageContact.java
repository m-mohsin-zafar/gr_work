package com.quickrescue.interfaces;

import java.util.List;

import com.quickrescue.entities.Contact;

public interface IManageContact {

	public Contact addContact(String firstName, String lastName, String emailAddress, String gender, String phoneNumber,
			String status, int accountId, String streetAddress, String city, String state, String country);
	public List<Contact> viewContacts();
	public Contact updateContact(int id, String firstName, String lastName, String emailAddress, String gender, String phoneNumber,
			String status, int accountId, String streetAddress, String city, String state, String country);
	public void deleteContact(int id);
}
