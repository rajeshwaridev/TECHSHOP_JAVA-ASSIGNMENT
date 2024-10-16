
package com.hexaware.techshop.dao;
/* 
 * @Author:Rajeshwari
 * */
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBUtil {
	public static Connection getDBConnection() {
		Connection conn=null;
		try {
//			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			FileReader reader=new FileReader("Resources/DBConfig.properties");
			Properties prop=new Properties();
			prop.load(reader);
			String driver = prop.getProperty("driver.classname");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
//		   
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techshop", "root", "Raji#1234");
			Class.forName(driver);

			conn = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
		
		e.printStackTrace();
		
	}
		return conn;

}
}
