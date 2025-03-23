package com.ty.closeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ClosingConnectionUsingTryWithResource {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con=DriverManager.getConnection(url, user, password);)
		{
			Statement stm = con.createStatement();
			
			stm.execute("UPDATE student SET name='xyz' WHERE sid=101");
			
			System.out.println("record is updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
