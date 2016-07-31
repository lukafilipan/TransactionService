package org.filipan.n26.transactionservice.models;

import javax.xml.bind.annotation.XmlElement;

/*
 * This class holds all the transaction information.
 * The id is not implemented, because it will be added to the HashMap, to avoid duplicate values
 */
public class Transaction {

	private double amount;
	private String type;
	@XmlElement(name = "parent_id")	// MOXy follows Java Beans convention, so we need to implicitly specify the name for serialization
	private long parent_id;
	
	// Constructors
	public Transaction(){}
	
	public Transaction(double amount, String type){
		this.amount = amount;
		this.type = type;
	}
	
	public Transaction(double amount, String type, long parent_id){
		this.amount = amount;
		this.type = type;
		this.parent_id = parent_id;
	}
	
	// Getters
	public double getAmount(){ return amount; }
	
	public String getType(){ return type; }
	
	@XmlElement(name = "parent_id")
	public long getParentId(){ return parent_id; }
	
	// Setters 
	public void setAmount( double amount ){ this.amount = amount; }
	
	public void setType( String type ){ this.type = type; }
	
	@XmlElement(name = "parent_id")
	public void setParentId( long parent_id ){ this.parent_id = parent_id; }
	
	
	
	
	
	
}
