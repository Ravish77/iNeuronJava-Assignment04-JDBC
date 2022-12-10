package assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class DateOperationInsertion {

	public static void main(String[] args) throws ParseException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Name: ");
		String name = sc.next();
		
		System.out.println("Enter the Address: ");
		String address = sc.next();
		
		System.out.println("Enter the Gender: ");
		String gender = sc.next();
		
		System.out.println("Enter the Date of Birth (dd-MM-yyyy): ");
		String stringDOB = sc.next();
		
		System.out.println("Enter the Date of Joining (MM-dd-yyyy): ");
		String stringDOJ = sc.next();
		
		System.out.println("Enter the Date of Marriage (yyyy-MM-dd): ");
		String stringDOM = sc.next();
		
		
		//To Convert dd-MM-yyyy to yyyy-MM-dd for DOB
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDOBDate = sdf1.parse(stringDOB);
		long timeDOB = uDOBDate.getTime();
		java.sql.Date sqlDOBDate = new java.sql.Date(timeDOB);
		
		
		//To Convert MM-dd-yyyy to yyyy-MM-dd for DOJ
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date uDOJDate = sdf2.parse(stringDOJ);
		long timeDOJ = uDOJDate.getTime();
		java.sql.Date sqlDOJDate = new java.sql.Date(timeDOJ);
		
		//To Convert yyyy-MM-dd to yyyy-MM-dd for DOM
		java.sql.Date sqlDOMDate = java.sql.Date.valueOf(stringDOM);
		
		String insertQuery = "insert into date_table(`name`,`address`,`gender`,`DOB`,`DOJ`,`DOM`) values(?,?,?,?,?,?)";
		
		try {
			
			connection = JDBCUtil.getConnection();
			
			if(connection!=null) 
				pstmt = connection.prepareStatement(insertQuery);
			if(pstmt != null) {
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, gender);
				pstmt.setDate(4, sqlDOBDate);
				pstmt.setDate(5, sqlDOJDate);
				pstmt.setDate(6, sqlDOMDate);
				
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Number of rows affected: "+ rowsAffected);
			}
		
		}
			catch (SQLException se) {
			se.printStackTrace();
		} 	catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				JDBCUtil.closeConnection(null, pstmt, connection);	
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			if(sc!=null) {
				sc.close();
			}
		}
		
	}

}
