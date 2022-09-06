package com.cf.jdbc;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;

public class FisrtProgram {
	
	public static void main (String[] args) throws SQLException {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","root");
		Statement stmt=con.createStatement();
		stmt.execute("CREATE TABLE ClayinEmployee (PersonsID Number)");
		System.out.println("Table created successfully....");
		con.close();
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
    }
}