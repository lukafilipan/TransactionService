package org.filipan.n26.transactionservice.database;

import java.util.HashMap;
import java.util.Map;

import org.filipan.n26.transactionservice.models.Transaction;

/*
 *  Stub class which acts as a faux database, the map uses key-value pairs to make traversing entries easier and faster.
 *  The tradeoff, however, is that this isn't threadable, but this is not a real-world scenario  
 */
 
public class DatabaseClass {

	// This Map stores all the generated transactions in memory for the time the service is running
	private static Map<Long, Transaction> transactions = new HashMap<>();
	
	public static Map<Long, Transaction> getTransactions(){
		return transactions;
	}
	
}
