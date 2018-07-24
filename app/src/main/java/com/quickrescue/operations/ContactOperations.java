package com.quickrescue.operations;

import java.util.List;

import com.quickrescue.entities.Contact;
import com.quickrescue.models.ManageContact;

/*
 * Description: 
 * This class is for manual test purposes and contains access to 
 * CRUD operations that are performed in "ManageContact" Class
 * 
 */

public class ContactOperations extends Operations {

	private ManageContact manageContact = new ManageContact();

	/*
	 * Input Format (String firstName, String lastName, String emailAddress, String
	 * gender, String phoneNumber, String status, int accountId, String
	 * streetAddress, String city, String state, String country)
	 * 
	 */
	@Override
	public void insertOperation() {
		manageContact.addContact("Mohsin", "Zafar", "abc@gmail.com", "Male", "123456", "Active", 1, "ABCD - DEF -123",
				"SGD", "PUN", "PK");
	}

	@Override
	public void viewAllOperation() {
		List<Contact> contacts = manageContact.viewContacts();
		System.out.println("ID " + "\tFirst Name " + "\tLast Name " + "\tGender " + "\tPhone Number " + "\tStatus "
				+ "\tEmail " + "\tStreet Address " + "\tCity " + "\tState " + "\tCountry " + "\tAccount ID"
				+ "\tAccount Name");
		for (Contact contact : contacts) {
			System.out.println(contact.getId() + "\t" + contact.getFirstName() + "\t" + contact.getLastName() + "\t"
					+ contact.getGender() + "\t" + contact.getPhoneNumber() + "\t" + contact.getStatus() + "\t"
					+ contact.getEmailAddress() + "\t" + contact.getContactAddress().getStreetAddress() + "\t"
					+ contact.getContactAddress().getCity() + "\t" + contact.getContactAddress().getState() + "\t"
					+ contact.getContactAddress().getCountry() + "\t" + contact.getAccount().getId() + "\t"
					+ contact.getAccount().getName());
		}
	}

	/*
	 * Input Format
	 * (int id, String firstName, String lastName, String emailAddress, String gender, String phoneNumber,
	 * String status, int accountId, String streetAddress, String city, String state, String country)
	 * 
	 */

	@Override
	public void updateOperation() {
		manageContact.updateContact(1, "Hassan", "Ali", "B", "C", "D", "Active", 3, "ST-567", "X", "Y", "IN");
	}

	/*
	 * Input Format
	 * (int id)
	 */
	@Override
	public void deleteOperation() {
		manageContact.deleteContact(1);
	}
}
