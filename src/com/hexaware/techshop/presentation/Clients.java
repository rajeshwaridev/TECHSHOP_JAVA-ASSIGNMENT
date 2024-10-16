package com.hexaware.techshop.presentation;
//package com.hexaware.techshop.service;
/* 
 * @Author:Rajeshwari
 * */
import java.util.List;
import java.util.Scanner;

import com.hexaware.techshop.entity.Customers;
import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.Products;
import com.hexaware.techshop.service.ITechshopService;
import com.hexaware.techshop.service.TechshopServiceImp;

public class Clients {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		ITechshopService service=new TechshopServiceImp();
		boolean flag = true;
		while(flag) {

			System.out.println("*****Welcome to Techshop*****");
			System.out.println("1.Count customer orders");
			System.out.println("2.Show all Customer details");
			System.out.println("3.Update Customer Information");
			System.out.println("4.Show all product Details");
			System.out.println("5.Update Product Information");
			System.out.println("6.Show total amount Details of the order");
			System.out.println("7.Update order Status from proccessing to shipped");
			System.out.println("8.Cancel the order");
			System.out.println("9.Get order Details Information ");
			System.out.println("10.Update quantity of products in order Details");
			System.out.println("11.Get all product name from inventory");
			System.out.println("12.Get Qunatity of the product in Stock");
			System.out.println("13.Add to Inventory");
			System.out.println("14.Remove from inventory");
			System.out.println("15.Update stock Quantity");
			System.out.println("16.Check whether product available in inventory");
			System.out.println("17.Show Product which has less than 20 in inventory");
			System.out.println("18.List Out of Stock products");
			System.out.println("19.List all products and quantity from inventry");
			System.out.println("20.Apply Discount for particular orders");
			System.out.println("21.Add New product to products");
			System.out.println("22.Add new products to inventory");
			System.out.println("23.Add new Customer");
			System.out.println("24.Get Inventory value");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter customer id");
				
				int customerId=scanner.nextInt()	;
				boolean isValid = TechshopServiceImp.validateCustomerId(customerId);
				if(isValid) {
					int count=service.calculateTotalService(customerId);
					if(count>0) {
						System.out.println("customer placed "+count+"  orders");
					}
					else {
						System.err.println("not yet place the order");
					}
				}
				break;
			case 2:
				
				List<Customers> list = service.getAllCustomerDetails();

				for (Customers customer : list) {

					System.out.println(customer);

				}

				break;
			case 3:
				System.out.println("Enter customer id for the customer to change information");
				int updateCustomerId=scanner.nextInt();
				System.out.println("Enter Phone number to update");
				String phone=scanner.next();
				int count=service.updateCustomerInfo(updateCustomerId,phone);
				boolean validatePhone=TechshopServiceImp.validatePhone(phone);
				if(validatePhone) {
					int updateCount=service.updateCustomerInfo(updateCustomerId, phone);
					if(updateCount>0) {
					  System.out.println("Phone number updated  successfully");	
					}
					else {
						System.err.println("Error with phone number update");
					}
				
				}
				else {
					System.err.println("NOT VALID PHONE NUM");
				}
				break;
			case 4:
				List<Products> product = service.getProductDetails();

				for (Products p : product) {

					System.out.println(p);

				}

				break;
			case 5:
				System.out.println("Enter Product Name");
				String pname=scanner.next();
				System.out.println("Enter new Price");
				int priceAmount=scanner.nextInt();
				boolean isValidPrice=TechshopServiceImp.validPrice(priceAmount);
				if(isValidPrice) {
					int updateCount=service.updateProductInfo(pname, priceAmount);
					if(updateCount>0) {
						System.out.println("Price updated successfully");
					}
					else {
						System.err.println("Problem with PriceUpdate");
					}
				}
				else {
					System.err.println("Not valid price");
				}
				break;
				
			case 6:
				System.out.println("Enter customerId to find TotalAmount of order");
				int customerIdd=scanner.nextInt();
				boolean isValidId=TechshopServiceImp.validateCustomerId(customerIdd);
				if(isValidId) {
					int totalAmount=service.calculateTotalAmount(customerIdd);
					System.out.println("Total Amount is "+totalAmount);
				}
				else {
					System.err.println("Invalid customer id");
				}
				break;
			case 7:
				System.out.println("Enter orderid to upadte status");
				int ordId=scanner.nextInt();
				boolean isValidOrderId=TechshopServiceImp.validateOrderId(ordId);
				if(isValidOrderId) {
					int res=service.updateOrderStatus(ordId);
					if(res>0) {
					System.out.println("Status Updated Successfully");
					}
					else {
						System.err.println("Status not updadted");
					}
				
				}
				
				else {
					System.err.println("INVALID ORDERID");
				}
				break;
			case 8:
				System.out.println("Enter your orderId to cancle the order");
				int cancelId=scanner.nextInt();	
				boolean isValidCancelId=TechshopServiceImp.validateOrderId(cancelId);
				if(isValidCancelId) {
					int del=service.cancelOrder(cancelId);
					if(del>0) {
						System.out.println("Order Cancelled");
					}
				}
				else {
					System.err.println("INVALID ORDERID");
				}
			case 9:
				System.out.println("Enter OrderId to get Order Details");
				int oId=scanner.nextInt();
				int orderInfo=0;
				boolean isValidOrderDetailId=TechshopServiceImp.validateOrderId(oId);
				if(isValidOrderDetailId) {
					orderInfo=service.getOrderDetailInfo(oId);;
					
				}
				else {
					System.err.println("Invalid orderid");
				}
				break;
			case 10:
				System.out.println("Enter Order Id to update the quantity of products");
				int updateId=scanner.nextInt();
				System.out.println("Enter the new Quantity of products");
				int newQuantity=scanner.nextInt();
				boolean validityCheck=(TechshopServiceImp.validateOrderId(updateId)) && (TechshopServiceImp.quantityCheck(newQuantity));
				if(validityCheck) {
					int quantityUpdate=service.updateQuantity(updateId, newQuantity);
					if(quantityUpdate>0) {
						System.out.println("Quantity updated successfully");
					}
					else {
						System.err.println("NOT UPDATE THE QUANTITY");
					}
				
				}
				else {
					System.err.println("INVALID ORDERID OR QUANTITY");
				}
				break;
			case 11:
				int productListInventory=service.getProduct();
				break;
			case 12:
				System.out.println("Enter productname to find the stockquantity");
				String productName=scanner.next();
			    int n=service.getQuantityInStock(productName);
			
				break;
			case 13:
				System.out.println("Enter inventory id to add quantity");
				int inventoryId=scanner.nextInt();
				System.out.println("Enter amount to add in inventory");
				int quantity=scanner.nextInt();
				boolean validate=(TechshopServiceImp.validateInventoyId(inventoryId)) && TechshopServiceImp.quantityCheck(quantity);
				if(validate) {
					int updateInventory=service.addToInventory(inventoryId, quantity);
					if(updateInventory>0) {
						System.out.println("Updated successfully");
					}
					else {
						System.err.println("Not Updated");
					}
		
					
				}
				else {
					System.err.println("Invalid inventoryId or quantity");
				}
			case 14:
				System.out.println("Enter inventory id to remove from quantity");
				int invenId=scanner.nextInt();
				System.out.println("Enter amount to remove in inventory");
				int quantityRemove=scanner.nextInt();
				boolean validates=(TechshopServiceImp.validateInventoyId(invenId))&& (TechshopServiceImp.quantityCheck(quantityRemove));
				if(validates) {
					int removeCount=service.removeFromInventory(invenId, quantityRemove);
					if(removeCount>0) {
						System.out.println("Quantity Removed Successfully");
					}
					else {
						System.err.println("Couldn't remove");
					}
				}
				else {
					System.err.println("INVALID QUANTITY OR INVENTORY ID");
				}
			case 15:
				System.out.println("Enter Product  ID");
				int productId=scanner.nextInt();
				System.out.println("Enter new Product Quantity");
				int productQuantity=scanner.nextInt();
				boolean isValidQuantity=(TechshopServiceImp.validProductId(productId)) && (TechshopServiceImp.quantityCheck(productQuantity));;
				if(isValidQuantity) {
					int updateCount=service.updateStockQuantity(productId, productQuantity);
					
					if(updateCount>0) {
						System.out.println("Price updated successfully");
					}
					else {
						System.err.println("Problem with PriceUpdate");
					}
				}
				else {
					System.err.println("Not valid price");
				}
				break;
			case 16:
				System.out.println("Enter productid to check availability");
				int checkAvail=scanner.nextInt();
				boolean validProductId=TechshopServiceImp.validProductId(checkAvail);
				if(validProductId) {
					int checkInInventory=service.isProductAvailable(checkAvail);
					if(checkInInventory>0) {
						System.out.println("Product is Available in stock");
					}
					else {
						System.err.println("PRODUCT NOT AVAILABALE");
					}
				}
				else {
					System.err.println("INVALID PRODUCT ID");
				}
				break;
			case 17:
				System.out.println("Enter Threshold Value");
				int threshold=scanner.nextInt();
				int lessThreshold=service.listLowStockProducts(threshold);
				break;
			case 18:
				int lowStock=service.listOutOfStockProducts();
				break;
			case 19:
				int listProduct=service.listAllProducts();
			    break;
			case 20:
				
				System.out.println("Enter order id to add discout");
				int orderId=scanner.nextInt();
				System.out.println("Enter discount Percentage");
				int discountPercentage=scanner.nextInt();
				boolean validatePercentage=(TechshopServiceImp.validateOrderId(orderId)) && (TechshopServiceImp.validatePercentage(discountPercentage));
				if(validatePercentage) {
					int discountCount=service.addDiscount(orderId, discountPercentage);
					if(discountCount>0) {
						System.out.println("Discount Added successfully");
					}
					else {
						System.err.println("Couldn't add discount");
					}
			
				}
				else {
					System.err.println("Invalid orderid or percentage");
				}
				break;
			case 21:
				System.out.println("Enter product id");
				int newProductId=scanner.nextInt();
				System.out.println("Enter product name");
				String newProductName=scanner.next();
				System.out.println("Enter description of the product");
				String description=scanner.next();
				System.out.println("enter price");
				double price=scanner.nextDouble();
				Products productInsert=new Products(newProductId,newProductName,description,price);
				boolean priceCheck=(TechshopServiceImp.validPrice(price)) && (TechshopServiceImp.validNotExistProductId(newProductId)) && TechshopServiceImp.validProductName(newProductName);
				if(priceCheck) {
				boolean addProduct=service.addProductToProducts(productInsert);
				if(addProduct) {
					System.out.println("Product add to Product table");
				}
				else {
					System.err.println("product not added");
				}
				}
				else {
					System.err.println("Invalid information");
				}
			case 22:
				System.out.println("Add Product Details");
				Products productObject = new Products();
//				Inventory inventoryObject=new Inventory();
				System.out.println("Enter ProductID");
				int addProductId = scanner.nextInt();
				productObject.setProductId(addProductId);
				System.out.println("Enter Inventory ID");
				int inventoryID = scanner.nextInt();
				System.out.println("Enter Quantity ");
				int quantityInStock=scanner.nextInt();
				System.out.println("Enter LastStock update");
				int lastStock=scanner.nextInt();
				Inventory inventoryObject=new Inventory(inventoryID,productObject,quantityInStock,lastStock);
				boolean checkInventoryId=TechshopServiceImp.validateNotExistInventoryId(inventoryID) && TechshopServiceImp.validProductId(addProductId);
				if(checkInventoryId) {
				boolean flags = service.addProduct(inventoryObject);
				if(flags) {
					
					System.out.println("Object Added");
				}else {
					System.out.println("Unsuccessfull");
				}
				}
				else {
					System.err.println("Problem ");
				}
				break;
			    
			case 23:
				System.out.println("Enter customer Id");
				int newCustomerId=scanner.nextInt();
				System.out.println("Enter customer Firstname");
				String customerFirstName=scanner.next();
				System.out.println("Enter customer Lastname");
				String customerLastName=scanner.next();
				System.out.println("Enter Email id");
				String email=scanner.next();
				System.out.println("Enter phone number");
				String phoneNumber=scanner.next();
				System.out.println("enter Address");
				String address=scanner.next();
				Customers customer=new Customers(newCustomerId,customerFirstName,customerLastName,email,phoneNumber,address);
				boolean check=(TechshopServiceImp.validateNotCustomerId(newCustomerId)) && (TechshopServiceImp.validatePhone(phoneNumber)) && (TechshopServiceImp.validFirstName(customerFirstName)) &&(TechshopServiceImp.validAddress(address));
				if(check) {
				boolean f=service.addCustomer(customer);
				if(f) {
					System.out.println("Customer added successfully");
				}
				else {
					System.err.println("Customer not added");
				}
				}
				else {
					System.err.println("Invalid data");
				}
				break;
			case 24:
				boolean getValue=service.getInventoryValue();
				break;
			case 0:
				flag=false;
			default:
				System.err.println("Enter Valid Option");
			}
			
			
			   
				
		}
		
		

	}

}
