package com.hexaware.techshop.service;
/* 
 * @Author:Rajeshwari
 * */
//import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.hexaware.ems.entity.Employee;
import com.hexaware.techshop.dao.ITechshopDao;
import com.hexaware.techshop.dao.TechshopDaoImp;
import com.hexaware.techshop.entity.Customers;
import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.OrderDetails;
import com.hexaware.techshop.entity.Products;
import com.hexaware.techshop.exception.InvalidDataException;
import com.hexaware.techshop.exception.InvalidInventoryException;

public class TechshopServiceImp implements ITechshopService {
     private static ITechshopDao dao;
     
	public TechshopServiceImp() {
		dao=new TechshopDaoImp();
	}
	public static boolean validateNotCustomerId(int customerId)  {

		boolean flag= dao.checkNotExistCustomerId(customerId);

 return flag;
		}
	public static boolean validateCustomerId(int customerId) {
		boolean flag=dao.checkExistCustomerId(customerId);
		if(flag==false) {
			try {
				throw new InvalidDataException();
			}
			catch(InvalidDataException e) {
				e.printStackTrace();
			}
			finally {
				System.out.println("CustomerId Not found");
			}
		}
		return flag;
	}
		
	public static boolean validateOrderId(int orderId) {
		boolean flag=dao.checkExistCustomerId(orderId);
		if(flag==false) {
			try {
				throw new InvalidDataException();
			}
			catch(InvalidDataException e) {
				e.printStackTrace();
			}
			finally {
				System.out.println("Order Id Not found");
			}
		}
		return flag;
	}
	public static boolean validateNotOrderId(int orderId) {
		return dao.checkExistOrderId(orderId);
	}

	public static boolean quantityCheck(int quantity) {
		boolean flag = false;

		if (quantity >= 0 ) {

			flag = true;

		}

		return flag;
	}

	
	public static boolean validateInventoyId(int inventoryId) {

  boolean flag=dao.checkExistInventoryId(inventoryId);
  if(flag==false) {
	  try {
		  throw new InvalidInventoryException();
	  }
	  catch(InvalidInventoryException e) {
		  e.printStackTrace();
	  }
	  finally {
		  System.err.println("Invalid Inventory Id");
	  }

  }
		return flag;

	}
	public static boolean validateNotExistInventoryId(int inventoryId) {
		boolean flag=dao.checkNotExistInventoryId(inventoryId);
		return flag;
	}
	
	public static boolean validatePhone(String phone) {
	
		// Define a regex pattern for phone number validation
		 String regex = "^(\\+91[\\-\\s]?)?[6-9]\\d{9}$";
     
        Pattern pattern = Pattern.compile(regex);
        
       
        Matcher matcher = pattern.matcher(phone);
        
        
        return matcher.matches();
	
	}
    public static boolean validPrice(double price) {
    	boolean flag=false;
    	if(price>0) {
    		flag=true;
    	}
    	return flag;
    }
    public static boolean validProductId(int productId) {

    	boolean flag=dao.checkExistProductId(productId);
    	if(flag==false) {
    		try {
    			throw new InvalidDataException();
    		}
    		catch(InvalidDataException e) {
    			e.printStackTrace();
    		}
    		finally {
    			System.err.println("Invalid Product Id");
    		}
    	}
    	return flag;
    }
    public static boolean validNotExistProductId(int productId) {

    	boolean flag=dao.checkNotExistProductId(productId);
    	return flag;
    }
    public static boolean validatePercentage(int percentage) {
    	boolean flag=false;
    	if(percentage>0) {
    		flag=true;
    	}
    	return flag;
    }
    public static boolean validProductName(String productName) {
    	boolean flag=false;
    	if(productName.length()>4) {
    		flag=true;
    	}
    	return flag;
    }
    public static boolean validFirstName(String firstName) {
    	boolean flag=false;
    	if(firstName.length()>4) {
    		flag=true;
    	}
    	return flag;
    }
    public static boolean validAddress(String address) {
    	boolean flag=false;
    	if(address.length()>5) {
    		flag=true;
    	}
    	return flag;
    }
  
    
	@Override
	public int calculateTotalService(int customerId) {
		
		return dao.calculateTotalService(customerId);
	}
	@Override
	public List<Customers> getAllCustomerDetails() {
	
		return dao.getAllCustomerDetails();
	}
	@Override
	public int updateCustomerInfo(int customerId,String phone) {

		
		return dao.updateCustomerInfo(customerId,phone);
	}
	@Override
	public List<Products> getProductDetails() {
	
		
		return dao.getProductDetails();
	}
	@Override
	public int updateProductInfo(String productname, int productprice) {
	
		return dao.updateProductInfo(productname, productprice);
	}
	@Override
	public int calculateTotalAmount(int customerid) {
		
		return dao.calculateTotalAmount(customerid);
	}
	@Override
	public int updateOrderStatus(int orderId) {

		
		return dao.updateOrderStatus(orderId);
	}
	@Override
	public int cancelOrder(int cancelId) {
		
		return dao.cancelOrder(cancelId);
	}
	@Override
	public int getOrderDetailInfo(int orderId) {
		
		return dao.getOrderDetailInfo(orderId);
	}
	@Override
	public int updateQuantity(int updateId, int newQuantity) {
		
		return dao.updateQuantity(updateId, newQuantity);
	}
	@Override
	public int getProduct() {
		
		return dao.getProduct();
	}
	@Override
	public int getQuantityInStock(String productName) {
		
		return dao.getQuantityInStock(productName);
	}
	@Override
	public int addToInventory(int inventoryId, int quantity) {
		
		return dao.addToInventory(inventoryId, quantity);
	}
	@Override
	public int removeFromInventory(int inventoryId, int quantity) {
		
		return dao.removeFromInventory(inventoryId, quantity);
	}
	@Override
	public int updateStockQuantity(int productId, int quantity) {
	
		return dao.updateStockQuantity(productId, quantity);
	}
	@Override
	public int isProductAvailable(int productid) {

		return dao.isProductAvailable(productid);
	}
	@Override
	public int listLowStockProducts(int threshold) {
	
		return dao.listLowStockProducts(threshold);
	}
	@Override
	public int listOutOfStockProducts() {
		
		return dao.listOutOfStockProducts();
	}
	@Override
	public int listAllProducts() {

		return dao.listAllProducts();
	}
	@Override
	public int addDiscount(int orderId, int discountPercentage) {
		
		return dao.addDiscount(orderId, discountPercentage);
	}
	@Override
	public boolean addProduct(Inventory inventory) {
		
		
		return dao.addProduct(inventory);
	}
	@Override
	public boolean addProductToProducts(Products product) {
		
		return dao.addProductToProducts(product);
	}
	@Override
	public boolean addCustomer(Customers customer) {

		return dao.addCustomer(customer);
	}
	@Override
	public boolean getInventoryValue() {
	
		return dao.getInventoryValue();
	}
	
	
	
	

	

	
	

}
