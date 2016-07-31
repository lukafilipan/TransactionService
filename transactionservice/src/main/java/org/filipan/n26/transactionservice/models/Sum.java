package org.filipan.n26.transactionservice.models;

/*
 * Sum object for serialization as a REST response
 */
public class Sum {
	
	private double sum;

	// Constructors
	public Sum(){}
	
	public Sum(double sum){
		this.sum = sum;
	}
	
	// Getters
	public double getSum() { return sum; }

	// Setters
	public void setSum(double sum) { this.sum = sum; }
	
}
