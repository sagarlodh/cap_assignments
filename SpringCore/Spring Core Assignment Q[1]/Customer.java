package io.org.javaBrains;

public class Customer {
	
	private int customerId;
	private String customerName;
	private int customerContact;
	private Address customerAddress;
	
	public int getCustomerId() {return customerId;}
	public void setCustomerId(int customerId) {this.customerId = customerId;}

	public String getCustomerName() {return customerName;}
	public void setCustomerName(String customerName) {this.customerName = customerName;}

	public int getCustomerContact() {return customerContact;}
	public void setCustomerContact(int customerContact) {this.customerContact = customerContact;}
	
	/**
	 * for using SETTER INJECTION from Address class
	 */
	public Address getCustomerAddress() {return customerAddress;}
	public void setCustomerAddress(Address customerAddress) {this.customerAddress = customerAddress;}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ",\n customerName=" + customerName + ",\n customerContact="
				+ customerContact + ",\n customerAddress=" + customerAddress + "]";
}}












