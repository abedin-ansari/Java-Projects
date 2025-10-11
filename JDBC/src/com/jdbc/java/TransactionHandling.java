//package com.jdbc.java;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class TransactionHandling {
//
//    private static final String url = "jdbc:mysql://localhost:3306/lenden";
//    private static final String username = "root";
//    private static final String password = "abedin62*****";
//
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            connection.setAutoCommit(false);
//
//            String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
//            String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
//
//            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
//            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter Source Account_Number: ");
//            int fromAccount = sc.nextInt();
//            System.out.println("Enter Destination Account_Number: ");
//            int toAccount = sc.nextInt();
//            System.out.println("Enter Amount: ");
//            double amount = sc.nextDouble();
//
//            // Check balance first
//            if (isSufficient(connection, fromAccount, amount)) {
//                // Execute debit
//                debitPreparedStatement.setDouble(1, amount);
//                debitPreparedStatement.setInt(2, fromAccount);
//                debitPreparedStatement.executeUpdate();
//
//                // Execute credit
//                creditPreparedStatement.setDouble(1, amount);
//                creditPreparedStatement.setInt(2, toAccount);
//                creditPreparedStatement.executeUpdate();
//
//                connection.commit();
//                System.out.println("Transaction Success");
//            } else {
//                connection.rollback();
//                System.out.println("Transaction failed: Insufficient Balance");
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    static boolean isSufficient(Connection connection, int account_number, double amount) {
//        try {
//            String query = "SELECT balance FROM accounts WHERE account_number = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, account_number);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                double currentBalance = resultSet.getDouble("balance");
//                return amount <= currentBalance;
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//}

package com.jdbc.java;

import java.sql.*;
import java.util.Scanner;


public class TransactionHandling {
	
	private static final String url = "jdbc:mysql://localhost:3306/lenden"; // JDBC URL + database name
	private static final String username = "root";   // MySQL username
	private static final String password = "abedin62*****"; // MySQL password
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
			String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
			String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
			
			// Two Prepared Statement will be there becouse of two quaries
			PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
			PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Account_Number: ");
			int account_number = sc.nextInt();
			System.out.println("Enter Amount: ");
			double amount = sc.nextDouble();
			
			
			debitPreparedStatement.setDouble(1, amount);
			debitPreparedStatement.setInt(2, account_number);
			
			creditPreparedStatement.setDouble(1, amount);
			creditPreparedStatement.setInt(2, account_number);
			
			// Execute
			debitPreparedStatement.executeUpdate();
			creditPreparedStatement.executeUpdate();
			
			if(isSufficient(connection, account_number, amount)) {
				connection.commit();
				System.out.println("Transaction Success");
			} else {
				connection.rollback();
				System.out.println("Transaction failed");
			}
			
			debitPreparedStatement.executeUpdate();
			creditPreparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static boolean isSufficient(Connection connection, int account_number, double amount) {
		try {
			String query = "SELECT balance from accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, account_number);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				double currentBalance = resultSet.getDouble("balance");
				if(amount > currentBalance) {
					return false;
				} else {
					return true;
				}
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
