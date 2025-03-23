package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb";
		String username = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";
		
		try {
			//step 1 : Load the driver
			Class.forName(driver);
			System.out.println("driver is loaded");
			
			//step 2 : Create Connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection is created");
			
			//step 3 : Creating Statement
			Statement stm = con.createStatement();
			System.out.println("Statement is created");
			
			String query="INSERT INTO student VALUES(104,'Sheela',4567654,'Bandra')";
			
			//step 4 : Execute the query
			boolean result = stm.execute(query);
			
			System.out.println(result);
			
			System.out.println("query executed");
			
			//step 5 : Close the connection
			con.close();
			System.out.println("Connection is closed");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
