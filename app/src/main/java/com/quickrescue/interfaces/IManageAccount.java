package com.quickrescue.interfaces;

import java.util.List;

import com.quickrescue.entities.Account;

public interface IManageAccount {

	public Account addAccount(String name, String emailAddress, String timeZone);
	public List<Account> viewAllAccounts();
	public Account updateAccount(int id, String name, String emailAddress, String timeZone);
	public void deleteAccount(int id);
}
