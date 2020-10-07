package com.ms.payment.model;


public class Payment {
	private int paymentId;
	private int amount;
	private String creditType; //(IMPS,NEFT,direct)
	private String description;
	private Customer customer;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
