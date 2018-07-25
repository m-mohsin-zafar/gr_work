package com.quickrescue.models;

import com.quickrescue.entities.Account;
import com.quickrescue.entities.Contact;

import junit.framework.TestCase;

public class ManageContactTest extends TestCase {

	private ManageContact manageContact = new ManageContact();
	private ManageAccount manageAccount = new ManageAccount();

	
	/*
	 * Add Contact Test Case:
	 * 	A: Populate Account Table via addDummyAccount() Method
	 * 	B: Populate Contact and Contact Address Table via addDummyContact() Method
	 * 
	 * 	Test 1:
	 * 		Compare size of Both Tables Account & Contact before and after
	 * 		insertion
	 * 
	 * 	Test 2:
	 * 		Check for fields in Account, Contact & Contact Address Tables 
	 * 		whether data has been inserted or not
	 * 
	 * 	Finally, Delete inserted records to get DB into original state
	 * 
	 */
	public void testAddContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact(insertedAccount.getId());
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		assertTrue(originalAccountTableSize < afterInsertAccountTableSize);
		assertTrue(originalContactTableSize < afterInsertContactTableSize);
		
		assertEquals("Hassan", insertedContact.getFirstName());
		assertEquals("H-1", insertedContact.getContactAddress().getStreetAddress());
		assertEquals("QRescue", insertedContact.getAccount().getName());
		
		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	/*
	 * View All Contacts Test Case:
	 * 	A: Populate Account Table via addDummyAccount() Method
	 * 	B: Populate Contact and Contact Address Table via addDummyContact() Method
	 * 
	 * 	Test 1:
	 * 		Compare size of Both Tables Account & Contact before and after
	 * 		insertion
	 * 
	 * 	Finally, Delete inserted records to get DB into original state
	 * 
	 */
	public void testViewContacts() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact(insertedAccount.getId());
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		assertTrue(originalAccountTableSize < afterInsertAccountTableSize);
		assertTrue(originalContactTableSize < afterInsertContactTableSize);

		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	/*
	 * Update Contact Test Case:
	 * 	A: Populate Account Table via addDummyAccount() Method
	 * 	B: Populate Contact and Contact Address Table via addDummyContact() Method
	 * 
	 * 	Test 1:
	 * 		Compare size of Both Tables Account & Contact before and after
	 * 		insertion
	 * 
	 * 	Test 2:
	 * 		Compare size of Contact Table before and after Update took place
	 * 
	 * 	Test 3-End:
	 * 		Compare different fields that were expected to be updated and what
	 * 		actually were updated.
	 * 
	 * 	Finally, Delete inserted records to get DB into original state
	 * 
	 */
	public void testUpdateContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact(insertedAccount.getId());
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		assertTrue(originalAccountTableSize < afterInsertAccountTableSize);
		assertTrue(originalContactTableSize < afterInsertContactTableSize);

		Contact toBeUpdated = manageContact.updateContact(insertedContact.getId(), "Basit", "Ali", "bali@gmail.com", "Male", "03127894561", "InActive", insertedContact.getAccount().getId(), "H-2", "Lahore", "Punjab", "Pakistan");
		
		int afterUpdateContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(afterUpdateContactTableSize, afterInsertContactTableSize);
		assertEquals("Ali",toBeUpdated.getLastName());
		assertEquals("Lahore",toBeUpdated.getContactAddress().getCity());
		
		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	/*
	 * Delete Contact Test Case:
	 * 	A: Populate Account Table via addDummyAccount() Method
	 * 	B: Populate Contact and Contact Address Table via addDummyContact() Method
	 * 
	 * 	Test 1:
	 * 	Compare Size of Both Tables before & After Insertion took place.
	 * 
	 * 	Test 2:
	 * 	Compare Size of Both Tables before & After Deletion took place.
	 * 
	 * 
	 */
	public void testDeleteContact() {
		int originalAccountTableSize = manageAccount.viewAllAccounts().size();
		int originalContactTableSize = manageContact.viewContacts().size();
		
		Account insertedAccount = addDummyAccount();
		Contact insertedContact = addDummyContact(insertedAccount.getId());
		
		int afterInsertAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterInsertContactTableSize = manageContact.viewContacts().size();
		
		assertTrue(originalAccountTableSize < afterInsertAccountTableSize);
		assertTrue(originalContactTableSize < afterInsertContactTableSize);

		//manageContact.deleteContact(insertedContact.getId());
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int afterDelAccountTableSize = manageAccount.viewAllAccounts().size();
		int afterDelContactTableSize = manageContact.viewContacts().size();
		
		assertEquals(originalAccountTableSize, afterDelAccountTableSize);
		assertEquals(originalContactTableSize, afterDelContactTableSize);
	}

	/*
	 * Populate Account Table
	 */
	private Account addDummyAccount() {
		return manageAccount.addAccount("QRescue", "con@qr.org", "GMT +5");
	} 

	/*
	 * Populate Contact Table & Contact Address Table
	 */
	private Contact addDummyContact(int accountId) {
		return manageContact.addContact("Hassan", "Ali", "hali@gmail.com", "Male", "03123456789", "Active", accountId, "H-1", "Sargodha", "Punjab", "Pakistan");
	}

}
