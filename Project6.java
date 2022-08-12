package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Project6 {
	public static void main(String[] args) 
	  {
		Connection con=null;
		PreparedStatement pstmt=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/j2ee_db?user=root&password=root";
		    con=DriverManager.getConnection(dbUrl);
		    String query="Update student_info set cgpa=? where regno=?";
		    pstmt=con.prepareStatement(query);
		    pstmt.setInt(1,9);
		    pstmt.setInt(2, 10011);
		    pstmt.executeUpdate();    
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	  }

}
