package com.ibm.pratik.jenkins.checker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbCheckerUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/pratikdb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "pratik03";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_QUERY = "Select CURRENT_TIMESTAMP from dual";

	public static void main(String[] args) throws Exception {
		Class.forName(DB_DRIVER);  
		Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);  
		PreparedStatement stmt=con.prepareStatement(DB_QUERY);  
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()) {  
			System.out.println("DB Connection check successfully completed at "+ rs.getTimestamp("CURRENT_TIMESTAMP"));  
		}
		
		if(rs !=null) {
			rs.close();
			stmt.close();
			con.close();
		}
		
		
		

	}

}
