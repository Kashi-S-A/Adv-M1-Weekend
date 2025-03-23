package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/studentdb?user=postgres&password=root");

			Statement stm = con.createStatement();

			String query = "SELECT * FROM student";

			ResultSet rs = stm.executeQuery(query);
			System.out.println("=====Student Details====");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				long phone = rs.getLong(3);
				String address = rs.getString(4);

				System.out.println("Sid : " + sid);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("Address : " + address);
				System.out.println("====================");
			}

			con.close();

			System.out.println("Records fetched and connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
