package assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class PreparedStatementUpdate {

	public static void main(String[] args) throws SQLException {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name:");
		String name = sc.next();
		
		System.out.println("Enter the New Jersy Number");
		int j_num = sc.nextInt();
		
		Connection connection = null;
		PreparedStatement pstmt =  null;
		
		String updateQuery = "update student set s_jrsy_num =? where s_name=? ";
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection !=null)
				pstmt = connection.prepareStatement(updateQuery);
			if(pstmt != null) {
				pstmt.setInt(1, j_num);
				pstmt.setString(2, name);
				
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
