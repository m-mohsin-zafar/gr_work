package com.quickrescue.app;

import com.quickrescue.operations.AccountOperations;
import com.quickrescue.operations.ContactOperations;
import com.quickrescue.operations.Operations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Operations accountOperations = new AccountOperations();
    	//accountOperations.insertOperation();
    	//accountOperations.viewAllOperation();
    	//accountOperations.updateOperation();
    	//accountOperations.viewAllOperation();
    	//accountOperations.deleteOperation();

    	
    	
    	Operations contactOperations = new ContactOperations();
    	//contactOperations.insertOperation();
    	//contactOperations.viewAllOperation();
    	//contactOperations.updateOperation();
    	//contactOperations.viewAllOperation();
    	//contactOperations.deleteOperation();
    	
    	System.exit(0);
    }
}
