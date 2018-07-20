package com.quickrescue.models;

import com.quickrescue.entities.Account;
import com.quickrescue.entities.Contact;

import junit.framework.TestCase;

public class ManageContactTest extends TestCase {

	private ManageContact manageContact = new ManageContact();
	private ManageAccount manageAccount = new ManageAccount();

	public void testAddContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact();
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		originalAccountTableSize += 1;
		originalContactTableSize += 1;
		
		assertEquals(originalAccountTableSize, afterInsertAccountTableSize);
		assertEquals(originalContactTableSize, afterInsertContactTableSize);
		assertEquals("Hassan", insertedContact.getFirstName());
		assertEquals("H-1", insertedContact.getContactAddress().getStreetAddress());
		assertEquals("QRescue", insertedContact.getAccount().getName());
		
		manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		originalAccountTableSize -= 1;
		originalContactTableSize -= 1;
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	public void testViewContacts() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact();
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		originalAccountTableSize += 1;
		originalContactTableSize += 1;
		
		assertEquals(originalAccountTableSize, afterInsertAccountTableSize);
		assertEquals(originalContactTableSize, afterInsertContactTableSize);

		manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		originalAccountTableSize -= 1;
		originalContactTableSize -= 1;
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	public void testUpdateContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact();
		
		originalAccountTableSize += 1;
		originalContactTableSize += 1;
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterInsertAccountTableSize);
		assertEquals(originalContactTableSize, afterInsertContactTableSize);

		Contact toBeUpdated = manageContact.updateContact(insertedContact.getId(), "Basit", "Ali", "bali@gmail.com", "Male", "03127894561", "InActive", insertedContact.getAccount().getId(), "H-2", "Lahore", "Punjab", "Pakistan");
		
		int afterUpdateContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(afterUpdateContactTableSize, afterInsertContactTableSize);
		assertEquals("Ali",toBeUpdated.getLastName());
		assertEquals("Lahore",toBeUpdated.getContactAddress().getCity());
		
		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		originalAccountTableSize -= 1;
		originalContactTableSize -= 1;
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	public void testDeleteContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact();
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		originalAccountTableSize += 1;
		originalContactTableSize += 1;
		
		assertEquals(originalAccountTableSize, afterInsertAccountTableSize);
		assertEquals(originalContactTableSize, afterInsertContactTableSize);

		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		originalAccountTableSize -= 1;
		originalContactTableSize -= 1;
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	private Account addDummyAccount() {
		return manageAccount.addAccount("QRescue", "con@qr.org", "GMT +5");
	}

	private Contact addDummyContact() {
		return manageContact.addContact("Hassan", "Ali", "hali@gmail.com", "Male", "03123456789", "Active", 1, "H-1", "Sargodha", "Punjab", "Pakistan");
	}

}
