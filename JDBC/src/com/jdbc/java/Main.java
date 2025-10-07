package com.jdbc.java;  // Package name

import java.util.*;
import java.sql.*;  // Import JDBC classes (Connection, Statement, PreparedStatement, ResultSet, etc.)

public class Main {

	// ======================================================
	// 🔹 Database Credentials
	// ======================================================
	private static final String url = "jdbc:mysql://localhost:3306/mydb"; // JDBC URL + database name
	private static final String username = "root";   // MySQL username
	private static final String password = "abedin62*****"; // MySQL password

	public static void main(String[] args) {

		// ======================================================
		// 🔹 Step 1: Load MySQL JDBC Driver
		// ======================================================
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // Registers MySQL JDBC Driver
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
			// 🔹 Step 3: Create PreparedStatement for Batch Insert
			// ======================================================
			// '?' → placeholders for dynamic values (set later using setXXX methods)
			String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			Scanner sc = new Scanner(System.in);

			// ======================================================
			// 🔹 Step 4: Take User Input and Add to Batch
			// ======================================================
			// Loop allows user to insert multiple records before executing all at once
			while (true) {
				System.out.print("Enter name: ");
				String name = sc.next();

				System.out.print("Enter age: ");
				int age = sc.nextInt();

				System.out.print("Enter marks: ");
				double marks = sc.nextDouble();

				// 🔸 Set parameters for current record (filling '?' placeholders)
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, age);
				preparedStatement.setDouble(3, marks);

				// 🔸 Add current record to batch (doesn’t run yet)
				preparedStatement.addBatch();

				System.out.print("Add more data? (Y/N): ");
				String choice = sc.next();

				if (choice.equalsIgnoreCase("N")) break; // stop when user says 'N'
			}

			// ======================================================
			// 🔹 Step 5: Execute All Queries in Batch
			// ======================================================
			// Runs all batched queries together → reduces round-trips to DB
			int[] results = preparedStatement.executeBatch();

			// ======================================================
			// 🔹 Step 6: Check Batch Execution Results
			// ======================================================
			System.out.println("\n📦 Batch Execution Results:");
			for (int i = 0; i < results.length; i++) {
				if (results[i] == Statement.SUCCESS_NO_INFO || results[i] > 0)
					System.out.println("✅ Query " + (i + 1) + " executed successfully.");
				else
					System.out.println("❌ Query " + (i + 1) + " failed.");
			}

			// ======================================================
			// 🔹 Step 7: Close Connection
			// ======================================================
			// Always close connection — prevents memory & resource leaks
			connection.close();
			System.out.println("\n✅ Connection Closed!");

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
