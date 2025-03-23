package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			PreparedStatement pstm = con.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			pstm.setInt(1, 106);
			pstm.setString(2, "Leela");
			pstm.setLong(3, 45678765);
			pstm.setString(4, "CSMT");
			
			int result = pstm.executeUpdate();
			
			System.out.println("affected row : "+result);
			
			con.close();
			
			System.out.println("data is inserted");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
