package com.quickrescue.app;

import com.quickrescue.operations.AccountOperations;
import com.quickrescue.operations.ContactOperations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//AccountOperations accountOperations = new AccountOperations();
    	//accountOperations.insertOperation();
    	//accountOperations.viewAllOperation();
    	//accountOperations.updateOperation();
    	//accountOperations.viewAllOperation();
    	
    	ContactOperations contactOperations = new ContactOperations();
    	//contactOperations.insertOperation();
    	contactOperations.viewAllOperation();
    	contactOperations.updateOperation();
    	contactOperations.viewAllOperation();
    	System.exit(0);
    }
}
