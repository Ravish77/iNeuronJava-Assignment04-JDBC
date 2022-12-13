package assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class StatementInsertion {
	
	private StatementInsertion() {
		
	}
	
	public static void insertStatement() throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Student Name: ");
		String name = sc.next();
		
		System.out.println("Enter the Student Address: ");
		String address = sc.next();
		
		System.out.println("Enter the Student Jersy Number: ");
		int j_num = sc.nextInt();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection != null)
				statement = connection.createStatement();
			if(statement != null) {
				String insertQuery = String.format("insert into student(`s_name`,`s_addr`,`s_jrsy_num`) values('%s','%s',%d)", name,address,j_num);
				int rowsAffected = statement.executeUpdate(insertQuery);
				
				System.out.println("Number of Rows inserted: "+rowsAffected);
			}
				
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(null, statement, connection);
		}
		if(sc!=null) {
			sc.close();
		}
	}

}
