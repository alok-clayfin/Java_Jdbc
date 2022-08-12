package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Project3 {
	public static void main(String[] args) 
	  {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/j2ee_db?user=root&password=root";
		    con=DriverManager.getConnection(dbUrl);
		    String query="select * from student_info where regno=?";
		    pstmt=con.prepareStatement(query);
		    pstmt.setInt(1, 10007);
		    rs=pstmt.executeQuery() ;
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1));
		    	System.out.println(rs.getString(2));
		    	System.out.println(rs.getDouble(3));
		    	System.out.println(rs.getInt(4));
		    	System.out.println(rs.getString(5));
		    	System.out.println();
		    }
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
				if(rs!=null)
					rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	  }

}
