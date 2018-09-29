package com.wipro.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
		static Connection con;
		
		public static  Connection getDBConnection() {
			
			try {
				Class.forName("oracle.jdbc.driver.Oracle.driver");
				
				try {
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:15121:xe","system","12345");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			return con;
			
		}
		
		
		
}
