package com.hexaware.techshop.entity;
/* 
 * @Author:Rajeshwari
 * */

public class Customers {
 @Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", eMail=" + eMail + ", phone=" + phone + ", address=" + address + "]";
	}
private int customerId;
 private String firstName;
 private String lastName;
 private String eMail;
 private String phone;
 private String address;
public Customers() {
	super();
	
}
public Customers(int customerId, String firstName, String lastName, String eMail, String phone, String address) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.eMail = eMail;
	this.phone = phone;
	this.address = address;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

 
 
}
