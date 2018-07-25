package com.quickrescue.app;

import com.quickrescue.operations.AccountOperations;
import com.quickrescue.operations.ContactOperations;
import com.quickrescue.operations.Operations;

/**
 * Package and Class Descriptions:
 * 
 * com.quickrescue.app -- contains 'main' class
 * 
 * com.quickrescue.configurations -- contains 2 classes 
 * 									1: SessionFactoryInstance
 * 									2: TransactionConfigurations
 * 		These classes take care of object creations related to Hibernate 
 * 		and relevant connections to Database
 * 
 * com.quickrescue.entities -- contains 3 classes
 *								1: Account
 *								2: Contact
 *								3: ContactAddress
 *		These classes lay down a basic structure for table(s) creation
 *		and further manipulation 
 *
 * com.quickrescue.interfaces -- contains 2 interfaces
 * 								1: IManageAccount
 * 								2: IManageContact
 * 		These interfaces lay down a basic structure for ManageAccount & 
 * 		ManageContact classes
 * 
 * com.quickrescue.models -- contains 2 classes
 *								1: ManageAccount
 * 								2: ManageContact
 * 		These classes contain the implementation of CRUD Operations for 
 * 		relevant entities
 * 
 * com.quickrescue.operations -- contains 3 classes
 * 								1: Operations (Abstract Class)
 * 								2: AccountOperations
 * 								3: ContactOpeartions
 * 		These classes were implemented to perform manual testing and debugging
 * 		at initial stages.
 * 
 * =====Main Flow of Application=====
 * 1: App.Class -> main() 
 * 2: Instance Creation of Operations say AccountOperations.Class
 * 3: Call a Method from AccountOperations.Class say 'insertOperation'
 * 4: Flow transfer: App.Class -> AccountOperations -> insertOperation()
 * 5: Flow transfer: insertOperation() -> ManageAccount.Class -> addAccount()
 * 6: Flow transfer: addAccount() -> TransactionConfigurations.Class -> SessionFactoryInstance.Class
 * 7: Flow transfer: SessionFactoryInstance.Class -> TransactionConfigurations.Class -> ManageAccount.Class -> addAccount()
 * and so on and so forth....
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
    	Operations accountOperations = new AccountOperations();
    	accountOperations.insertOperation();
    	accountOperations.viewAllOperation();
//    	accountOperations.updateOperation();
//    	accountOperations.viewAllOperation();
//    	accountOperations.deleteOperation();

    	
    	
    	Operations contactOperations = new ContactOperations();
    	contactOperations.insertOperation();
    	contactOperations.viewAllOperation();
//    	contactOperations.updateOperation();
//    	contactOperations.viewAllOperation();
//    	contactOperations.deleteOperation();
    	
    	System.exit(0);
    }
}
