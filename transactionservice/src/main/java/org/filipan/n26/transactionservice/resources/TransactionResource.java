package org.filipan.n26.transactionservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.filipan.n26.transactionservice.models.SameType;
import org.filipan.n26.transactionservice.models.Sum;
import org.filipan.n26.transactionservice.models.Transaction;
import org.filipan.n26.transactionservice.service.TransactionService;

/*
 * The class which handles the API requests, using TransactionService as a Data Acess Object
 */

@Path("/")
public class TransactionResource {

	private static final String SUCCESS_RESULT="{ \"status\": \"ok\" }";
	private static final String FAILURE_RESULT="{ \"status\": \"failed\" }";
	
	// Instantiate the TransactionService to access the "database"
	TransactionService transactionService = new TransactionService();
	
	@GET
	@Path("transaction")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getAllTransactions(){
		// General inquiry for returning all transactions
		return transactionService.getAllTransactions();
	}
	
	@GET
	@Path("transaction/{transactionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction getTransaction(@PathParam("transactionId") long id){
		// Inquiry for returning a specific transaction given the id
		return transactionService.getTransaction(id);
	} 
	
	@PUT
	@Path("transaction/{transactionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTransaction(@PathParam("transactionId") long id, Transaction transaction){
		// Inquiry for adding a new transaction, returns value based on insertion success
		if (transactionService.addTransaction(id, transaction)){
			return SUCCESS_RESULT;
		}else{
			return FAILURE_RESULT;
		}
	}
	
	@GET
	@Path("sum/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sum getAmountByParentId(@PathParam("parentId") long id){
		// Inquiry for returning the summed amount of all transactions sharing a parent id
		return transactionService.getAmountByParentId(id);
	} 
	
	@GET
	@Path("types/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public SameType getTransactionsByType(@PathParam("type") String type){
		// Inquiry for returning a list of ids for all transactions of the same type
		return transactionService.getTransactionsByType(type);
	}
	
}
