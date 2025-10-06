// Commented code are Boilerplate code for JDBC.

//package com.jdbc.java;

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
//			Class.forName("com.mysql.cj.jdbc.Driver") // To Load Driver
//		} catch(ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//			// or
//			// e.printStackTrace();
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

package com.jdbc.java;  // Package name

import java.sql.*;  // Import JDBC classes

public class Main {
	
	// Database credentials
	private static final String url = "jdbc:mysql://localhost:3306/mydb"; // DB URL + DB name
	private static final String username = "root";  // MySQL username
	private static final String password = "abedin62*****"; // MySQL password
	
	public static void main(String[] args) {
		try {
			// 🔹 Step 1: Load the JDBC Driver (registers the MySQL driver)
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("✅ Driver Loaded Successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("❌ Driver Not Found: " + e.getMessage());
		}
		
		try {
			// 🔹 Step 2: Establish Connection to MySQL
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("✅ Connected to Database!");

			// 🔹 Step 3: Create a Statement object to send SQL queries
			Statement statement = connection.createStatement();
			
			// 🔹 Step 4: Write SQL Query
			String query = "SELECT * FROM students";
			
			// 🔹 Step 5: Execute the Query and get ResultSet
			ResultSet resultSet = statement.executeQuery(query);
			
			// 🔹 Step 6: Loop through each record (row) in ResultSet
			while (resultSet.next()) {
				int id = resultSet.getInt("id");          // get integer value from 'id' column
				String name = resultSet.getString("name"); // get string value from 'name' column
				int age = resultSet.getInt("age");         // get integer value from 'age' column
				double marks = resultSet.getDouble("marks"); // get double value from 'marks' column
				
				// 🔹 Step 7: Display the data
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Age: " + age);
				System.out.println("Marks: " + marks);
				System.out.println("-------------------------");
			}
			
			// 🔹 Step 8: Close the connection (best practice)
			connection.close();
			System.out.println("✅ Connection Closed!");
			
		} catch (SQLException e) {
			System.out.println("❌ SQL Error: " + e.getMessage());
		}
	}
}