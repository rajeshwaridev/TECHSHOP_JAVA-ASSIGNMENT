package com.hexaware.techshop.dao;
/* 
 * @Author:Rajeshwari
 * */
import java.util.List;

import com.hexaware.techshop.entity.Customers;
import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.OrderDetails;
import com.hexaware.techshop.entity.Products;

public interface ITechshopDao {
	boolean checkExistOrderId(int orderId);
	boolean checkNotExistOrderId(int orderId);
	boolean checkNotExistCustomerId(int customerId);
	boolean checkExistCustomerId(int customerId);
	 boolean checkExistProductId(int productId);
	 boolean checkNotExistProductId(int productId);
	boolean checkNotExistInventoryId(int inventoryId);
	boolean checkExistInventoryId(int inventoryId);
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
	int removeFromInventory(int inventoryId,int quantity);
	int updateStockQuantity(int productId,int quantity);
	int isProductAvailable(int productid);
	int listLowStockProducts(int threshold);
	int listOutOfStockProducts();
	int listAllProducts();
	int addDiscount(int orderId,int discountPercentage);
	boolean addProductToProducts(Products product);
	boolean addProduct(Inventory inventory);
	boolean addCustomer(Customers customer);
	boolean getInventoryValue();
	
	
	


}
