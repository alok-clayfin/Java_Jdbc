package com.cf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	private static final String INSERT_MULTIPLE_USERS_SQL = "insert into ClayinEmployee values(1207)";
	public static void main(String[] args) {
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
		            // Step 2:Create a statement using connection object
		            Statement statement = connection.createStatement();) {
		            // Step 3: Execute the query or update query
		            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
		            System.out.println("No. of records affected : " + result);
		        } catch (SQLException e) {
		            // print SQL exception information
		        	System.err.println("SQLState: " + e.getSQLState());
	                System.err.println("Error Code: " + e.getErrorCode());
	                System.err.println("Message: " + e.getMessage());
		        }
	}

}
