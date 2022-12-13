package assignement.jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class JDBCUtil {
	
	private JDBCUtil() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user="root";
		String password = "root123";
		
		connection = DriverManager.getConnection(url, user, password);
		if(connection!=null) {
			return connection;
		}
		return connection;
	}
	
	
	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {  
		
		if(resultSet!=null) {
			resultSet.close();
		}
		if(statement!=null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}

}
