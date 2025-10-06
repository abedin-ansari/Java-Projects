package com.jdbc.java;  // Package name

import java.sql.*;  // Import JDBC classes (Connection, Statement, PreparedStatement, ResultSet, etc.)

public class Main {
	
	// ======================================================
	// 🔹 Database Credentials
	// ======================================================
	private static final String url = "jdbc:mysql://localhost:3306/mydb"; // JDBC URL + database name
	private static final String username = "root";  // MySQL username
	private static final String password = "abedin62*****"; // MySQL password
	
	public static void main(String[] args) {
		
		// ======================================================
		// 🔹 Step 1: Load MySQL JDBC Driver
		// ======================================================
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // Registers the MySQL JDBC Driver class
			System.out.println("✅ Driver Loaded Successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("❌ Driver Not Found: " + e.getMessage());
			return; // Stop program if driver not found
		}
		
		// ======================================================
		// 🔹 Step 2: Establish Database Connection
		// ======================================================
		try {
			Connection connection = DriverManager.getConnection(url, username, password); // Creates DB connection
			System.out.println("✅ Connected to Database!");

			
			// ======================================================
			// 🔹 Step 3: Create a PreparedStatement (Safer than Statement)
			// ======================================================
			// Using '?' placeholders prevents SQL Injection attacks and makes code cleaner
			// Example for INSERT:
			// String query = "INSERT INTO students(name, age, marks) VALUES (?, ?, ?)";
			// Example for UPDATE:
			String query = "UPDATE students SET name = ? WHERE id = ?";

			// Create prepared statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			// ======================================================
			// 🔹 Step 4: Set Values for the Placeholders (in order)
			// ======================================================
			// For INSERT Example:
			// preparedStatement.setString(1, "Munchun Gupta");
			// preparedStatement.setInt(2, 22);
			// preparedStatement.setDouble(3, 50.0);
			
			// For UPDATE Example:
			preparedStatement.setString(1, "Munchun C");  // replaces first '?'
			preparedStatement.setInt(2, 4);              // replaces second '?'
			
			
			// ======================================================
			// 🔹 Step 5: Execute SQL Query
			// ======================================================
			// executeUpdate() → used for INSERT, UPDATE, DELETE (returns affected row count)
			int rowsAffected = preparedStatement.executeUpdate();
			
			
			// ======================================================
			// 🔹 Step 6: Check Query Result
			// ======================================================
			if (rowsAffected > 0) {
				System.out.println("✅ Data Updated Successfully!");
			} else {
				System.out.println("❌ No Rows Updated!");
			}
			
			
			// ======================================================
			// 🔹 Step 7: Close Connection (Always close resources)
			// ======================================================
			connection.close();
			System.out.println("✅ Connection Closed!");
			
		} catch (SQLException e) {
			System.out.println("❌ SQL Error: " + e.getMessage());
		}
	}
}


// =========================================================
// 🧠 NOTES — To Remember JDBC Boilerplate Structure
// =========================================================
//
// 🔸 Step 1 → Load JDBC Driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
// 🔸 Step 2 → Establish Connection
//        Connection con = DriverManager.getConnection(url, user, pass);
//
// 🔸 Step 3 → Create Statement / PreparedStatement
//        Statement stmt = con.createStatement();
//        OR
//        PreparedStatement pstmt = con.prepareStatement(query);
//
// 🔸 Step 4 → Set parameters (for PreparedStatement only)
//        pstmt.setString(1, "name");
//
// 🔸 Step 5 → Execute Query
//        stmt.executeQuery()  → for SELECT
//        stmt.executeUpdate() → for INSERT / UPDATE / DELETE
//
// 🔸 Step 6 → Process Results (if SELECT)
//
// 🔸 Step 7 → Close Connection
//
// =========================================================
//
// Below code (commented) is your reference for JDBC boilerplate — 
// it shows the basic structure for quickly setting up JDBC in new projects.
// Keep it for review later.
// ---------------------------------------------------------

//package com.jdbc.java;
//
//import java.sql.*;
//
//public class Main {
//	
//	private static final String url = "jdbc:mysql://localhost:3306/?user=root";
//	private static final String username = "root";
//	private static final String password = "abedin62*****";
//	
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // To Load Driver
//		} catch(ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			Connection connection = DriverManager.getConnection(url, username, password);
//			Statement statement = connection.createStatement();
//		} catch(SQLException e){
//			System.out.println(e.getMessage());
//		}
//	}
//}
