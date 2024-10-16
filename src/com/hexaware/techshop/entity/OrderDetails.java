package com.hexaware.techshop.entity;
/* 
 * @Author:Rajeshwari
 * */
public class OrderDetails {
	private int orderDetailsId;
	private Orders order;
	private Products product;
	private int quantity;
	public OrderDetails() {
		super();
		
	}
	public OrderDetails(int orderDetailsId, Orders order, Products product, int quantity) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	public int getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	
	
	

}
