package com.quickrescue.operations;

import java.util.List;

import com.quickrescue.entities.Account;
import com.quickrescue.models.ManageAccount;

public class AccountOperations extends Operations{

	private ManageAccount manageAccount = new ManageAccount();

	
	@Override
	public void insertOperation() {
		manageAccount.addAccount("FA", "fav@orgfa.com", "GMT +2");
	}
	
	@Override
	public void viewAllOperation() {
		List<Account> accounts = manageAccount.viewAllAccounts();
		for (Account account : accounts) {
			System.out.println("Name: "+account.getName()+"\tEmail Address: "+account.getEmailAddress()+"\tTime Zone: "+account.getTimeZone());
		}
	}
	
	@Override
	public void updateOperation() {
		manageAccount.updateAccount(2, "", "", "GMT +4");
	}
	
	@Override
	public void deleteOperation() {
		manageAccount.deleteAccount(1);
		manageAccount.deleteAccount(3);
	}
}
