package assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class PreparedStatementDeletion {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name:");
		String name = sc.next();
		
		Connection connection = null;
		PreparedStatement pstmt =  null;
		
		String deleteQuery = "delete from student where s_name =? ";
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection !=null)
				pstmt = connection.prepareStatement(deleteQuery);
			if(pstmt != null) {
				pstmt.setString(1, name);
				
				int  rowsAffected = pstmt.executeUpdate();
				System.out.println("Number of row affected :"+rowsAffected);
			}
				
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(null, pstmt, connection);
		}
		if(sc!=null) {
			sc.close();
		}

	}
}
