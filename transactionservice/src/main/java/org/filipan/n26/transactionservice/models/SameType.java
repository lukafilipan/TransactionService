package org.filipan.n26.transactionservice.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class SameType {
	
	@XmlElement(name = "ids")
	private List<Long> ids;

	public SameType(){}
	
	public SameType(List<Long> ids){
		this.ids = ids;
	}
	
	// Getters
	@XmlElement(name = "ids")
	public void setList(List<Long> ids) { this.ids = ids; }
	
	// Setters
	@XmlElement(name = "ids")
	public List<Long> getList() { return ids; }
	

}
