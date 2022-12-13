package assignment.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import assignement.jdbcUtil.JDBCUtil;

public class StatementSelection {
	private StatementSelection() {
		
	}
	
	public static void selectStatement() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name to read a row: ");
		String name = sc.next();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			if(connection!=null) 
				statement = connection.createStatement();
			if(statement != null) {
				String selectQuery = "select s_name,s_addr,s_jrsy_num from student where s_name='"+name+"'";
				resultSet = statement.executeQuery(selectQuery);
				
				System.out.println("S_NAME\tS_ADDR\tS_JRSY_NUM");
				while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
				}
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(resultSet, statement, connection);
		}
		if(sc!=null) {
			sc.close();
		}
		
	}

}
