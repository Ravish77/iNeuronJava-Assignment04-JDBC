package assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class PreparedStatementSelect {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name:");
		String name = sc.next();
		
		Connection connection = null;
		PreparedStatement pstmt =  null;
		ResultSet resultSet = null;
		
		String selectQuery = "select s_name,s_addr from student where s_name =? ";
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection !=null)
				pstmt = connection.prepareStatement(selectQuery);
			if(pstmt != null) {
				pstmt.setString(1, name);
				
				resultSet = pstmt.executeQuery();
				if(resultSet.next()) {
					
					String s_name = resultSet.getString(1);
					String s_addr = resultSet.getString(2);
					
					System.out.println(s_name +"\t"+s_addr);
				}
				
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
