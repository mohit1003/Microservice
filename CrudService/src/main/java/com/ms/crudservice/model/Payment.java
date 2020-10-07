package com.ms.crudservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	private int amount;
	private String creditType; //(IMPS,NEFT,direct)
	private String description;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerID")
	private Customer customer;	//(one to many payments, a customer can have multiple payments)

	public int getPaymentID() {
		return paymentId;
	}

	public void setPaymentID(int paymentID) {
		this.paymentId = paymentID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
