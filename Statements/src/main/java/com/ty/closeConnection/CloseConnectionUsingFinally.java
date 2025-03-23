package com.ty.closeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseConnectionUsingFinally {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentd";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		Connection con = null;

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);
			System.out.println("connection is created");

			Statement stm = con.createStatement();

			String query = "UPDATE student SET hone=123456789 WHERE sid=101";

			stm.executeUpdate(query);

			System.out.println("update query executed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("connection is closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
