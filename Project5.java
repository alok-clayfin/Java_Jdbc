package jdbc_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Project5 {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/j2ee_db?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			String call="call updateStudentmobile(?,?)";
			cstmt=con.prepareCall(call);
			cstmt.setString(1, "7050007192");
			cstmt.setInt(2, 10002);
			cstmt.execute();
			
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
				if(cstmt!=null)
					cstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
