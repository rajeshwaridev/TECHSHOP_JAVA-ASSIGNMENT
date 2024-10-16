package com.hexaware.techshop.entity;
/* 
 * @Author:Rajeshwari
 * */
public class Inventory {
 private int inventoryId;
 private Products product;
 private int quantityInStock;
 private int lastStockUpdate;
public Inventory() {
	super();

}
public Inventory(int inventoryId, Products product, int quantityInStock, int lastStockUpdate) {
	super();
	this.inventoryId = inventoryId;
	this.product = product;
	this.quantityInStock = quantityInStock;
	this.lastStockUpdate = lastStockUpdate;
}
public int getInventory() {
	return inventoryId;
}
public void setInventory(int inventory) {
	this.inventoryId = inventory;
}
public Products getProduct() {
	return product;
}
public void setProduct(Products product) {
	this.product = product;
}
public int getQuantityInStock() {
	return quantityInStock;
}
public void setQuantityInStock(int quantityInStock) {
	this.quantityInStock = quantityInStock;
}
public int getLastStockUpdate() {
	return lastStockUpdate;
}
public void setLastStockUpdate(int lastStockUpdate) {
	this.lastStockUpdate = lastStockUpdate;
}
 
}
