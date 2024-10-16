package com.hexaware.techshop.service;
/* 
 * @Author:Rajeshwari
 * */
import java.util.List;

import com.hexaware.techshop.entity.Customers;
import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.OrderDetails;
import com.hexaware.techshop.entity.Products;



public interface ITechshopService {
//	boolean checkExistInventoryId(int inventoryId)
//	boolean validateNotOrderId(int orderId);
//	boolean validateOrderId(int orderId);
	int calculateTotalService(int customerId);
	List<Customers>     getAllCustomerDetails();
	int updateCustomerInfo(int customerId,String phone);
	List<Products>     getProductDetails();
	int updateProductInfo(String productname,int productprice);
	int calculateTotalAmount(int customerid);
	int updateOrderStatus(int orderId);
	int cancelOrder(int cancelId);
	int getOrderDetailInfo(int orderId);
	int updateQuantity(int updateId,int newQuantity);
	int getProduct();
	int getQuantityInStock(String productName);
	int addToInventory(int inventoryId,int quantity);
	int removeFromInventory(int productId,int quantity);
	int updateStockQuantity(int productId,int quantity);
	int isProductAvailable(int productid);
	int listLowStockProducts(int threshold);
	int listOutOfStockProducts();
	int listAllProducts();
	int addDiscount(int orderId,int discountPercentage);
	boolean addProduct(Inventory inventory);
	boolean addProductToProducts(Products product);
	boolean addCustomer(Customers customer);
    boolean getInventoryValue();

	
	

}
