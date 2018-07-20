package com.quickrescue.operations;

import java.util.List;

import com.quickrescue.entities.Contact;
import com.quickrescue.models.ManageContact;

public class ContactOperations extends Operations {

	private ManageContact manageContact = new ManageContact();

	@Override
	public void insertOperation() {
		//manageContact.addContact("Mohsin", "Zafar", "abc@gmail.com", "Male", "123456", "Active", 2, "ABCD - DEF -123",
		//		"SGD", "PUN", "PK");
		
		manageContact.addContact("M", "Z", "mmz@gmail.com", "Male", "123456", "InActive", 1, "ABCD - xyz 3454",
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
	
	@Override
	public void updateOperation() {
		manageContact.updateContact(2, "Hassan", "A", "B", "C", "D", "Active", 3, "ST-567", "X", "Y", "IN");
	}
	
	@Override
	public void deleteOperation() {
		manageContact.deleteContact(2);
	}
}
