package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			Statement stm = con.createStatement();

			String query = "UPDATE student SET phone=123456789 WHERE sid=101";
			
			stm.execute(query);
			
			System.out.println("update query executed");
			
			con.close();
			
			System.out.println("connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
