package com.ty;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThirdStm {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/studentdb?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			CallableStatement cstm = con.prepareCall("call procedure_name(?,?,?)");//command to call stored procedure
			cstm.setInt(1, 111);
			cstm.setString(2, "abc");
			cstm.setLong(3, 45678);
			
			cstm.execute();
			
			con.close();

			System.out.println("procedure is called");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
