package com.quickrescue.models;

import com.quickrescue.entities.Account;

import junit.framework.TestCase;

public class ManageAccountTest extends TestCase {

	private ManageAccount manageAccount = new ManageAccount();

	public void testAddAccount() {
		Account insertedAccount = addDummyAccount();
		int actualSize = manageAccount.viewAllAccounts().size();
		assertEquals(1, actualSize);
		assertEquals("Muhammad Mohsin", insertedAccount.getName());
		manageAccount.deleteAccount(insertedAccount.getId());
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		assertEquals(0, sizeAfterDel);
	}

	public void testViewAllAccounts() {
		Account insertedAccount = addDummyAccount();
		int actualSize = manageAccount.viewAllAccounts().size();
		assertEquals(1, actualSize);
		manageAccount.deleteAccount(insertedAccount.getId());
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		assertEquals(0, sizeAfterDel);
	}

	public void testUpdateAccount() {
		Account insertedAccount = addDummyAccount();
		Account toBeUpdated = manageAccount.updateAccount(insertedAccount.getId(), "Muhammad Sufyan", "ms@gmail.com", "GMT +5");
		int actualSize = manageAccount.viewAllAccounts().size();
		assertEquals(1, actualSize);
		assertEquals("Muhammad Sufyan",toBeUpdated.getName());
		assertEquals("ms@gmail.com",toBeUpdated.getEmailAddress());
		assertEquals("GMT +5",toBeUpdated.getTimeZone());
		manageAccount.deleteAccount(insertedAccount.getId());
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		assertEquals(0, sizeAfterDel);
	}

	public void testDeleteAccount() {
		int originalSize = manageAccount.viewAllAccounts().size();
		Account insertedAccount = addDummyAccount();
		int actualSize = manageAccount.viewAllAccounts().size();
		originalSize += 1;
		assertEquals(originalSize, actualSize);
		manageAccount.deleteAccount(insertedAccount.getId());
		int sizeAfterDel = manageAccount.viewAllAccounts().size();
		originalSize -= 1;
		assertEquals(originalSize, sizeAfterDel);
	}

	private Account addDummyAccount() {
		return manageAccount.addAccount("Muhammad Mohsin", "mmz@gmail.com", "GMT +5");
	}

}
