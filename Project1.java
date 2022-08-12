package jdbc_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Project1 {
	public static void main(String[] args) 
	  {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/j2ee_db?user=root&password=root";
		    con=DriverManager.getConnection(dbUrl);
		    String query="insert into student_info values(?,?,?,?,?)";
		    pstmt=con.prepareStatement(query);
		    pstmt.setInt(1, 10121);
		    pstmt.setString(2,"Alok");
		    pstmt.setDouble(3,8.5);
		    pstmt.setInt(4,2022);
		    pstmt.setString(5,"7051207192");
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
