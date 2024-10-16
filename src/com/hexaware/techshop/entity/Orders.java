package com.hexaware.techshop.entity;
/* 
 * @Author:Rajeshwari
 * */
import java.util.Date;

public class Orders {
 private int orderId;
 private Date orderDate;
 private Customers customer;
 private double totalAmount;
public Orders() {
	super();
	
}
public Orders(int orderId, Date orderDate, Customers customer, double totalAmount) {
	super();
	this.orderId = orderId;
	this.orderDate = orderDate;
	this.customer = customer;
	this.totalAmount = totalAmount;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Customers getCustomer() {
	return customer;
}
public void setCustomer(Customers customer) {
	this.customer = customer;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
@Override
public String toString() {
	return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", totalAmount="
			+ totalAmount + "]";
}

 
}
