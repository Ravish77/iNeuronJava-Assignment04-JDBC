package assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class PreparedStatementInsertion {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name:");
		String name = sc.next();
		
		System.out.print("Enter the address:");
		String address = sc.next();
		
		System.out.print("Enter the name:");
		int jrsyNum = sc.nextInt();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String insertQuery = "insert into student(`s_name`,`s_addr`,`s_jrsy_num`) values(?,?,?)";
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection!= null)
				pstmt = connection.prepareStatement(insertQuery);
			if(pstmt!=null) {
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setInt(3, jrsyNum);
				
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Number of rows affected: "+rowsAffected);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeConnection(null, pstmt, connection);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}

	}

}
