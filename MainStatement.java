package assignment.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class MainStatement {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Create/Insert a Record");
		System.out.println("2.Read/Select a Record");
		System.out.println("3.Update a Record");
		System.out.println("4.Delete a Record");
		System.out.println("Choose a number to perform respective operation:  ");
		int n = sc.nextInt();
		
		switch (n) {
		case 1: 
			StatementInsertion.insertStatement();
			break;
		case 2:
			StatementSelection.selectStatement();
			break;
		case 3:
			StatementUpdate.updateStatement();
			break;
		case 4:
			StatementDeletion.deleteStatement();
			break;
		default:
			System.out.println("Cannot perform this operation.Please Enter the correct nummber.");
		}
		
	}

}
