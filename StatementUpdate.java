package assignment.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class StatementUpdate {
	
	private StatementUpdate(){
		
	}
	
	public static void updateStatement() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name for whom to update jersy number: ");
		String name = sc.next();
		
		System.out.println("Enter new jersy number of the person to update : ");
		int j_num = sc.nextInt();
		
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection!=null)
				statement = connection.createStatement();
			if(statement!= null) {
				String updateQuery = "update student set s_jrsy_num="+j_num+" where s_name='"+name+"'";
				int rowsAffected = statement.executeUpdate(updateQuery);
				
				System.out.println("Number of rows updated: "+rowsAffected);
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
