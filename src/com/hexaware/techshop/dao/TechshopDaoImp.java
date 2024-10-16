package com.hexaware.techshop.dao;
/* 
 * @Author:Rajeshwari
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.techshop.entity.Customers;
import com.hexaware.techshop.entity.Inventory;
import com.hexaware.techshop.entity.OrderDetails;
import com.hexaware.techshop.entity.Products;

public class TechshopDaoImp implements ITechshopDao {
     private Connection conn;
     public TechshopDaoImp() {
    	 conn=DBUtil.getDBConnection();
     }
    
public boolean checkNotExistCustomerId(int customerId) {
	String str="select customerid from customers";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existCustomerId=rs.getInt(1);
			if(customerId==existCustomerId) {
				return false;
			}
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	return true;
}
public boolean checkNotExistOrderId(int orderId) {
	String str="select orderId from orders";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existOrderId=rs.getInt(1);
			if(orderId==existOrderId) {
				return false;
			}
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	return true;
}
public boolean checkExistOrderId(int orderId) {
	String str="select orderId from orders";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existOrderId=rs.getInt(1);
			if(orderId==existOrderId) {
				return true;
			}
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	return false;
}
public boolean checkExistCustomerId(int customerId) {
	String str="select customerid from customers";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existCustomerId=rs.getInt(1);
			if(customerId==existCustomerId) {
				return true;
			}
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	return false;
}
public boolean checkNotExistProductId(int productId) {
	String str="select productid from products";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existProductId=rs.getInt(1);
			if(productId==existProductId) {
				return false;
			}
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return true;
}
public boolean checkExistProductId(int productId) {
	String str="select productid from products";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existProductId=rs.getInt(1);
			if(productId==existProductId) {
				return true;
			}
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return false;
}
public boolean checkNotExistInventoryId(int inventoryId) {
	String str="select inventoryid from inventory";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existInventoryId=rs.getInt(1);
			if(inventoryId==existInventoryId) {
				return false;
			}
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return true;
}
public boolean checkExistInventoryId(int inventoryId) {
	String str="select inventoryid from inventory";
	try {
		PreparedStatement pstmt=conn.prepareStatement(str);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			int existInventoryId=rs.getInt(1);
			if(inventoryId==existInventoryId) {
				return true;
			}
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return false;
}
	@Override
	public int calculateTotalService(int customerId) {
		String totalcount="select count(customerid) from orders where customerid=?";
		int count=0;
		try {
			PreparedStatement stmt=conn.prepareStatement(totalcount);
			stmt.setInt(1,customerId);
			 ResultSet rs=stmt.executeQuery();
			 while(rs.next()) {
				 count=rs.getInt(1);
				 
			 }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Customers> getAllCustomerDetails() {
		
		List<Customers> list=new ArrayList<Customers>();
		String selectAll="select * from Customers";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String address=rs.getString(5);
				Customers customer=new Customers(cid,fname,lname,email,phone,address);
				list.add(customer);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
    
	@Override
	public int updateCustomerInfo(int customerId, String phone) {
		
		String update="update customers set phone=? where customerid=?";
		int count=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setString(1,phone);
			pstmt.setInt(2, customerId);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Products> getProductDetails() {
	
		String selectProducts="select * from products";
		List<Products> productList=new ArrayList<Products>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectProducts);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int productid= rs.getInt(1);
				String pname=rs.getString(2);
				String description=rs.getString(3);
				int price=rs.getInt(4);
				Products product=new Products(productid,pname,description,price);
				productList.add(product);
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public int updateProductInfo(String productName, int productPrice) {
		
		String updateProductPrice="Update products set price=? where productname=?"; 
		int priceUpdateCount=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateProductPrice);
			pstmt.setInt(1, productPrice);
			pstmt.setString(2, productName);
			priceUpdateCount=pstmt.executeUpdate(); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return priceUpdateCount;
	}

	@Override
	public int calculateTotalAmount(int customerid) {
	
		String getTotalAmount="select sum(totalamount) from orders where customerid=?";
		int totalAmount=0;
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(getTotalAmount);
			pstmt.setInt(1, customerid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				totalAmount +=rs.getInt(1);
//				always use like this 
//				System.out.println(rs);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    return totalAmount;
		
				
	}

	@Override
	public int updateOrderStatus(int orderId) {

		String updateOrdStatus="update orders set status='Shipped' where orderid=?";
		int ordStatus=0;
		try {
			PreparedStatement pstmt =conn.prepareStatement(updateOrdStatus);
			pstmt.setInt(1, orderId);
			ordStatus=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ordStatus;
	}

	@Override
	public int cancelOrder(int cancelId) {
		
		String cancel="delete from orders where orderid=?";
		int del=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(cancel);
			pstmt.setInt(1, cancelId);
			del=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public int getOrderDetailInfo(int orderId) {
	
		List <OrderDetails> orderDetailList=new ArrayList<OrderDetails>();
		String selectInfo="select * from orderdetails where orderid=?";
		int count=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectInfo);
			pstmt.setInt(1, orderId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int orderDetailId=rs.getInt(1);
				int ordersId=rs.getInt(2);
				int productId=rs.getInt(3);
				int quantity=rs.getInt(4);
//				OrderDetails od=new OrderDetails(orderDetailId,orderId,productId,quantity);
				System.out.println("Orderdetails Id  "+orderDetailId);
				System.out.println("Quantity "+ quantity);
//	
				count=count+1;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int updateQuantity(int updateId, int newQuantity) {
		
		int c=0;
		String updateQuantity="update orderdetails set quantity=? where orderid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateQuantity);
			pstmt.setInt(1,newQuantity);
			pstmt.setInt(2, updateId);
			c=pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return c;
		
	}

	@Override
	public int getProduct() {
		
		int product=0;
		String getProduct="select productname from products where productid in(select productid from inventory)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(getProduct);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			product+=1;
			
		}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public int getQuantityInStock(String productName) {
	
		int quantityStock=0;
		String quantity=" select quantityinstock from inventory where productid=(select productid from products where productname=?)";
		
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(quantity);
			pstmt.setString(1, productName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int addToInventory(int inventoryId, int quantity) {

		String addInventory="update inventory set quantityinstock=quantityinstock+? where inventoryid=?";
		int updateQuantity=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(addInventory);
			pstmt.setInt(1,quantity);
			pstmt.setInt(2,inventoryId);
			updateQuantity+=pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return updateQuantity;
	}

	@Override
	public int removeFromInventory(int inventoryId, int quantity) {
		
		String addInventory="update inventory set quantityinstock=quantityinstock-? where inventoryid=?";
		int updateQuantityRemove=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(addInventory);
			pstmt.setInt(1,quantity);
			pstmt.setInt(2,inventoryId);
			updateQuantityRemove+=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return updateQuantityRemove;
	}

	@Override
	public int updateStockQuantity(int productId, int quantity) {
	
		String updateStock="update inventory set quantityinstock=? where productid=?";
		int updateCounts=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(updateStock);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, productId);
			updateCounts+=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return updateCounts;
		
	}

	@Override
	public int isProductAvailable(int productid) {
		
		String productCheck="select productid from inventory where quantityinstock!= 0 && productid=?";
		int productCheckCount=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(productCheck);
			pstmt.setInt(1 ,productid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				productCheckCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return productCheckCount;
	}

	@Override
	public int listLowStockProducts(int threshold) {

		String str="select productname from products where productid in(select productid from inventory where quantityinstock<?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, threshold);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String productName=rs.getString(1);
				System.out.println(productName);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return 0;

	}

	@Override
	public int listOutOfStockProducts() {
		
		String str=" select productname from products where productid in(select productid from inventory where quantityinstock=0)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String lowStockProduct=rs.getString(1);
				System.out.println(lowStockProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int listAllProducts() {
		
		String str=" select p.productname, i.quantityinstock from products p join inventory i where p.productid=i.productid";
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("productname--->  "+rs.getString(1)+"  Quantity  "+rs.getInt(2));
//				System.out.println("Quantity  "+rs.getInt(2));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int addDiscount(int orderId, int discountPercentage) {
		
		String str=" update orders set totalamount=totalamount-((?/100)*totalamount) where orderid=?";
		int count=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, discountPercentage);
			pstmt.setInt(2, orderId);
			count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public boolean addProduct(Inventory inventory) {
		// TODO Auto-generated method stub
		String str = "insert into inventory(InventoryID,ProductID,QuantityInStock,LastStockUpdate) "
				+ "values(?,?,?,?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, inventory.getInventory());
			pstmt.setInt(2, inventory.getProduct().getProductId());
			pstmt.setInt(3, inventory.getQuantityInStock());
			pstmt.setInt(4, inventory.getLastStockUpdate());
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
		return false;
	}

	@Override
	public boolean addProductToProducts(Products product) {
		
		String str="insert into products(ProductId,ProductName,Description,Price) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			pstmt.setInt(1,product.getProductId());
			pstmt.setString(2,product.getProductName());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4,(int) product.getPrice());
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addCustomer(Customers customer) {
	
		String str="insert into customers(CustomerId,FirstName,LastName,Email,Phone,Address)"+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getFirstName());
			pstmt.setString(3, customer.getLastName());
			pstmt.setString(4,customer.geteMail());
			pstmt.setString(5, customer.getPhone());
			pstmt.setString(6, customer.getAddress());
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		return false;
	}

	@Override
	public boolean getInventoryValue() {
	
		String str="select p.ProductName,i.LastStockUpdate*p.price TotalValue from Products p join Inventory i on p.ProductID=i.ProductID";
		try {
			PreparedStatement pstmt=conn.prepareStatement(str);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String productName=rs.getString(1);
				int totalValue=rs.getInt(2);
				System.out.println(productName+"----> "+totalValue);
			}
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	

	
	

		

}
