package assignment.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class DateOperationSelection {
	public static void main(String[] args) throws ParseException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Name: ");
		String name = sc.next();
		
	
		
		
		
		
		String selectQuery = "select name,DOB from date_table where name= ? ";
		
		try {
			
			connection = JDBCUtil.getConnection();
			
			if(connection!=null) 
				pstmt = connection.prepareStatement(selectQuery);
			if(pstmt != null) {
				pstmt.setString(1, name);
				
				resultSet = pstmt.executeQuery();
				System.out.println();
			}
			if(resultSet!=null) {
				if (resultSet.next()) {
					String userName = resultSet.getString(1);
					Date userDOB = resultSet.getDate(2);
					//formatting the output as per end user
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String sUserDOB = sdf.format(userDOB);
					System.out.println("Name is :" + userName);
					System.out.println("DOB of "+userName+" is : " + sUserDOB);
				}
				else {
					System.out.println("Record with the given name is not available in Datebase");
				}
			}
			
			
		
		}
			catch (SQLException se) {
			se.printStackTrace();
		} 	catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				JDBCUtil.closeConnection(resultSet, pstmt, connection);	
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}
		
	}

}
