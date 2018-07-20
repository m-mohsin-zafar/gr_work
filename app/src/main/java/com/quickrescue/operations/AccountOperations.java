package com.quickrescue.operations;

import java.util.List;

import com.quickrescue.entities.Account;
import com.quickrescue.models.ManageAccount;

/*
 * Description: 
 * This class is for manual test purposes and contains access to 
 * CRUD operations that are performed in "ManageAccount" Class
 * 
 */

public class AccountOperations extends Operations{

	private ManageAccount manageAccount = new ManageAccount();


//	Input Format - (String name, String emailAddress, String timeZone);
	@Override
	public void insertOperation() {
		manageAccount.addAccount("Quick Rescue", "contact@quickrescue.org", "GMT +5");
	}
	
	@Override
	public void viewAllOperation() {
		List<Account> accounts = manageAccount.viewAllAccounts();
		for (Account account : accounts) {
			System.out.println("Name: "+account.getName()+"\tEmail Address: "+account.getEmailAddress()+"\tTime Zone: "+account.getTimeZone());
		}
	}
	
//	Input Format - (int id, String name, String emailAddress, String timeZone);
	@Override
	public void updateOperation() {
		manageAccount.updateAccount(1, "Global Rescue", "hr@globalrescue.com", "GMT +5");
	}
	
//	Input Format - (int id)
	@Override
	public void deleteOperation() {
		manageAccount.deleteAccount(1);
	}
}
