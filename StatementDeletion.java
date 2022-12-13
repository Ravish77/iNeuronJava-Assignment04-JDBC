package assignment.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class StatementDeletion {
	
	private StatementDeletion(){
		
	}
	
	public static void deleteStatement() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name to delete: ");
		String name = sc.next();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection!=null)
				statement = connection.createStatement();
			if(statement!= null) {
				String deleteQuery = "delete from student where s_name = '"+name+"'";
				int rowsAffected = statement.executeUpdate(deleteQuery);
				
				System.out.println("Number of rows deleted: "+rowsAffected);
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
