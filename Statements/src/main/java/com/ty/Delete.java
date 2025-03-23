package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, user, password);

			Statement stm = con.createStatement();

			String query = "DELETE FROM student WHERE name='Leela'";
			
			int result = stm.executeUpdate(query);//returns the number of rows affected
			
			System.out.println("Affected row : "+result);
			
			con.close();
			
			System.out.println("Record deleted and connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
