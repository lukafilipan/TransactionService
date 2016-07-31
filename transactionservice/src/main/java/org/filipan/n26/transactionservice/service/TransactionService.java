package org.filipan.n26.transactionservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.filipan.n26.transactionservice.database.DatabaseClass;
import org.filipan.n26.transactionservice.models.SameType;
import org.filipan.n26.transactionservice.models.Sum;
import org.filipan.n26.transactionservice.models.Transaction;


/*
 * TransactionService acts as a DAO for the faux database
 * Any "queries" towards the database will eb parsed here
 */
public class TransactionService {

	// Initializing the "database"
	private Map<Long, Transaction> transactions = DatabaseClass.getTransactions();
	
	
	// Constructor with hard-coded entries for testing purposes
	public TransactionService(){
		// Adding the key-value pair to the map, using the Id as the key to avoid duplicate entries.
		transactions.put(1L, new Transaction(1500, "food"));
		transactions.put(2L, new Transaction(5000, "rent", 2L));
	}
	
	public List<Transaction> getAllTransactions(){
		// Return a list of all available transactions
		return new ArrayList<Transaction>(transactions.values());
	}
	
	
	public Transaction getTransaction(long id){
		// Return a transaction whose id matches the key in the map
		return transactions.get(id);
	}
	
	
	public Boolean addTransaction(long id, Transaction transaction){
		// If the key doesn't already exist in the map, add a new entry
		Transaction t = transactions.get(id);
		if (t != null){
			return false;
		}else{
			transactions.put(id, transaction);
			return true;
		}
	}
	
	
	public Sum getAmountByParentId(long id){
		double sum = 0;
		// Browse the "database" for matching parent ids, and add the amount to the sum
		for (Entry<Long, Transaction> entry : transactions.entrySet()){
			Transaction t = entry.getValue();
			if (new Long(t.getParentId()).equals(new Long(id))){
				sum += t.getAmount();
			}
		}
		return new Sum(sum);
	}
	
	
	public SameType getTransactionsByType(String type){
		List<Long> ids = new ArrayList<>();
		// Browse the "database" for matching types, and add the amount to the list
		for (Entry<Long, Transaction> entry : transactions.entrySet()){
			Transaction t = entry.getValue();
			if (t.getType().equals(type)){
				ids.add(entry.getKey());
			}
		}	
		return new SameType(ids);
	}
		
	
	
	
}
