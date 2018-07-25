package com.quickrescue.models;

import com.quickrescue.entities.Account;
import junit.framework.TestCase;

public class ManageAccountTest extends TestCase {

	private ManageAccount manageAccount = new ManageAccount();

	/*
	 * Add Account Test Case:
	 * 	First Insert Account Credentials into Account Table via addDummyAccount()
	 * 	Method. 
	 * 	
	 * 	Test A:
	 * 	Compare Size of Account Table before & After Insertion took place.
	 * 
	 * 	Test B:
	 * 	Compare a field that we wanted to insert with what was inserted.
	 * 
	 * 	Finally Delete Record to return DB to original state.
	 */
	public void testAddAccount() {
		int originalSize = manageAccount.viewAllAccounts().size();
		
		Account insertedAccount = addDummyAccount();
		
		int afterInsertSize = manageAccount.viewAllAccounts().size();
		
		assertTrue(afterInsertSize > originalSize);
		assertEquals("Muhammad Mohsin", insertedAccount.getName());
		
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		
		assertEquals(originalSize, sizeAfterDel);
	}

	/*
	 * 	View All Accounts Test Case:
	 * 	First Insert Account Credentials into Account Table via addDummyAccount()
	 * 	Method. 
	 * 	
	 * 	Test A:
	 * 	Compare Size of Account Table before & After Insertion took place.
	 * 
	 * 	Finally Delete Record to return DB to original state.
	 */
	public void testViewAllAccounts() {
		int originalSize = manageAccount.viewAllAccounts().size();
		
		Account insertedAccount = addDummyAccount();
		
		int afterInsertSize = manageAccount.viewAllAccounts().size();
		
		assertTrue(afterInsertSize > originalSize);
		
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		
		assertEquals(originalSize, sizeAfterDel);
	}

	/*
	 * 	Update Account Test Case:
	 * 	First Insert Account Credentials into Account Table via addDummyAccount()
	 * 	Method. 
	 *  Locally store values/credentials that are to be inserted for 
	 *  later comparison	
	 * 
	 * 	Test A:
	 * 	Compare Size of Account Table before & After Insertion took place.
	 * 
	 * 	Test B: 
	 * 	Compare Size of Account Table before and after Update took place
	 * 
	 * 	Test C-End:
	 * 	Compare different fields that were expected to be updated and what
	 * 	actually were updated.
	 * 
	 * 	Finally Delete Record to return DB to original state.
	 */
	public void testUpdateAccount() {
		int originalSize = manageAccount.viewAllAccounts().size();
		
		Account insertedAccount = addDummyAccount();
		
		int afterInsertSize = manageAccount.viewAllAccounts().size();
		
		assertTrue(afterInsertSize > originalSize);
		
		Account toBeUpdated = manageAccount.updateAccount(insertedAccount.getId(), "Muhammad Sufyan", "ms@gmail.com", "GMT +5");
		
		int afterUpdateSize = manageAccount.viewAllAccounts().size();
		
		assertEquals(afterUpdateSize, afterInsertSize);
		assertEquals("Muhammad Sufyan",toBeUpdated.getName());
		assertEquals("ms@gmail.com",toBeUpdated.getEmailAddress());
		assertEquals("GMT +5",toBeUpdated.getTimeZone());
		
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		
		assertEquals(originalSize, sizeAfterDel);
	}

	/*
	 * Delete Account Test Case:
	 * 	First Insert Account Credentials into Account Table via addDummyAccount()
	 * 	Method. 
	 * 	
	 * 	Test A:
	 * 	Compare Size of Account Table before & After Insertion took place.
	 * 
	 * 	Test B:
	 * 	Compare Size of Account Table before & After Deletion took place.
	 * 
	 * 	
	 */
	public void testDeleteAccount() {
		int originalSize = manageAccount.viewAllAccounts().size();
		
		Account insertedAccount = addDummyAccount();
		
		int afterInsertSize = manageAccount.viewAllAccounts().size();
		
		assertTrue(afterInsertSize > originalSize);
		
		manageAccount.deleteAccount(insertedAccount.getId());
		
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		
		assertEquals(originalSize, sizeAfterDel);
	}

	/*
	 * Populate Account Table 
	 */
	private Account addDummyAccount() {
		return manageAccount.addAccount("Muhammad Mohsin", "mmz@gmail.com", "GMT +5");
	}

}
