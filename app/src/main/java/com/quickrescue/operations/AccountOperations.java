package com.quickrescue.operations;

import java.util.List;

import com.quickrescue.entities.Account;
import com.quickrescue.models.ManageAccount;

public class AccountOperations {

	private ManageAccount manageAccount = new ManageAccount();
	
	public void insertOperation() {
		manageAccount.addAccount("FA", "fav@orgfa.com", "GMT +2");
	}
	
	public void viewAllOperation() {
		List<Account> accounts = manageAccount.viewAllAccounts();
		for (Account account : accounts) {
			System.out.println("Name: "+account.getName()+"\tEmail Address: "+account.getEmailAddress()+"\tTime Zone: "+account.getTimeZone());
		}
	}
	
	public void updateOperation() {
		manageAccount.updateAccount(2, "", "", "GMT +4");
	}
}
