package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class DatabaseOperations {

	public boolean insert(Register register, Second_Password_Model second_Password_Model, String[] selectedCheckboxes) {
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		int rows = 0;
		int rows1 = 0;
		int rows2 = 0;
		// Declaring variable to hold the result of email existence
		boolean detailsExits = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query to get user data with the given email
			Statement stmt = conn.createStatement();
			rows = stmt.executeUpdate("INSERT INTO users (Full_Name, Email, Phone_Number, Date_Of_Birth, Username, Password)" 
			+ "VALUES ('"+register.getFull_Name()+"','"+register.getEmail()+"',"+register.getPhone_Number()+",'"
			+ register.getDate_Of_Birth()+"','"+register.getUsername()+"','"+register.getPassword()+"');");
			
			rows1 = stmt.executeUpdate("INSERT INTO second_Password (Question1, Question2, Question3, Answer1, Answer2, Answer3,Username)" 
					+ "VALUES ('"+second_Password_Model.getQuestion1()+"','"+second_Password_Model.getQuestion2()+"','"+second_Password_Model.getQuestion3()+"','"
					+ second_Password_Model.getAnswer1()+"','"+second_Password_Model.getAnswer2()+"','"+second_Password_Model.getAnswer3()
					+"','"+register.getUsername()+"');");
			
			rows2 = stmt.executeUpdate("INSERT INTO third_Password (Username, Image1, Image2, Image3)" 
					+ "VALUES ('"+register.getUsername()+"','"+selectedCheckboxes[0]+"','"+selectedCheckboxes[1]+"','"
					+ selectedCheckboxes[2]+"');");

			System.out.println(rows);
			System.out.println(rows1);
			System.out.println(rows2);
			
			// Closing the database connections and statement
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Returning the final result of email existence
		if (rows==1 && rows1==1 && rows2==1 ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUser(Register register) {
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		int rows = 0;
		int rows1 = 0;
		int rows2 = 0;
		// Declaring variable to hold the result of email existence
		boolean detailsExits = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			// Search for a user with the same username or email as the input RegisterUser
			// object
			ResultSet rs = stmt.executeQuery("SELECT * FROM users where Username='" + register.getUsername()
					+ "' or Email = '" + register.getEmail() + "';");

			if (!rs.next()) { // if ResultSet is empty, no details exist in the database
				detailsExits = false;
			} else { // if ResultSet is not empty, details exist in the database
				do {
					detailsExits = true;
					String name = rs.getString("Username");
				} while (rs.next());
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (detailsExits) { // return true if details exist in the database, false otherwise
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUserLogin(Login login, Second_Password_Model second_Password_Model, String[] selectedCheckboxes) {
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		boolean detailsPresentLogin = false;
		boolean detailsPresentSecondPassword= false;
		boolean detailsPresentThirdPassword = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			System.out.println("SELECT * FROM users where Username='" + login.getUsername() + "' and "
					+ "Password = '" + login.getPassword() + "';");
			ResultSet rsLogin = stmt.executeQuery("SELECT * FROM users where Username='" + login.getUsername() + "' and "
					+ "Password = '" + login.getPassword() + "';");
			
			if (!rsLogin.next()) {
				detailsPresentLogin = false;
			} else {
				do {
					detailsPresentLogin = true;
					String name = rsLogin.getString("Username");
				} while (rsLogin.next());
			}
			System.out.println("SELECT * FROM second_Password where Question1='" + second_Password_Model.getQuestion1()+ "' and "
					+ "Question2 = '" + second_Password_Model.getQuestion2() +"' and "
					+ "Question3 = '" + second_Password_Model.getQuestion3() +"' and "
					+ "Answer1 = '" + second_Password_Model.getAnswer1() +"' and "
					+ "Answer2 = '" + second_Password_Model.getAnswer2() +"' and "
					+ "Answer3 = '" + second_Password_Model.getAnswer3() +"' and "
					+ "Username = '" + login.getUsername()+"';");
			ResultSet rsSecondPassword = stmt.executeQuery("SELECT * FROM second_Password where Question1='" + second_Password_Model.getQuestion1()+ "' and "
					+ "Question2 = '" + second_Password_Model.getQuestion2() +"' and "
					+ "Question3 = '" + second_Password_Model.getQuestion3() +"' and "
					+ "Answer1 = '" + second_Password_Model.getAnswer1() +"' and "
					+ "Answer2 = '" + second_Password_Model.getAnswer2() +"' and "
					+ "Answer3 = '" + second_Password_Model.getAnswer3() +"' and "
					+ "Username = '" + login.getUsername()+"';");
			
	
			if (!rsSecondPassword.next()) {
				detailsPresentSecondPassword = false;
			} else {
				do {
					detailsPresentSecondPassword = true;
					String name = rsSecondPassword.getString("Username");
				} while (rsSecondPassword.next());
			}
			
			System.out.println("SELECT * FROM third_Password where Username='" + login.getUsername()+ "' and "
					+ "Image1 = '" + selectedCheckboxes[0] +"' and "
					+ "Image2 = '" + selectedCheckboxes[1] +"' and "
					+ "Image3 = '" + selectedCheckboxes[2]+"';");
			ResultSet rsThirdPassword = stmt.executeQuery("SELECT * FROM third_Password where Username='" + login.getUsername()+ "' and "
					+ "Image1 = '" + selectedCheckboxes[0] +"' and "
					+ "Image2 = '" + selectedCheckboxes[1] +"' and "
					+ "Image3 = '" + selectedCheckboxes[2]+"';");
			
			if (!rsThirdPassword.next()) {
				detailsPresentThirdPassword = false;
			} else {
				do {
					detailsPresentThirdPassword = true;
					String name = rsThirdPassword.getString("Username");
				} while (rsThirdPassword.next());
			}
			
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (detailsPresentThirdPassword && detailsPresentSecondPassword && detailsPresentLogin) {
			return true;
		} else {
			return false;
		}
	}
	public boolean updateUser(String email, String password2, Second_Password_Model second_Password_Model, String[] selectedCheckboxes) {
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		int rows = 0;
		int rows1 = 0;
		int rows2 = 0;
		// Declaring variable to hold the result of email existence
		boolean detailsExits = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query to get user data with the given email
			Statement stmt = conn.createStatement();
			System.out.println("UPDATE users  SET Password = '" + password2+ "'  "+"WHERE Email = '"+ email+ "';");
			
			rows = stmt.executeUpdate("UPDATE users  SET Password = '" + password2+ "'  "+"WHERE Email = '"+ email+ "';");
			
			
			
			
			System.out.println("UPDATE second_Password  SET Question1 = '" +second_Password_Model.getQuestion1() + "',"
					+ "Question2 ='" + second_Password_Model.getQuestion2()+ "' , "
					+ "Question3 ='" + second_Password_Model.getQuestion3()+ "' , "
					+ "Answer1 ='" + second_Password_Model.getAnswer1() + "' , "
					+ "Answer2 ='" + second_Password_Model.getAnswer2() + "' , "
					+ "Answer3 ='" + second_Password_Model.getAnswer3() + "'  "
					+ "WHERE Username = '" + getUsername(email)+ "';");
			
			rows1 = stmt.executeUpdate("UPDATE second_Password  SET Question1 = '" +second_Password_Model.getQuestion1() + "',"
					+ "Question2 ='" + second_Password_Model.getQuestion2()+ "' , "
					+ "Question3 ='" + second_Password_Model.getQuestion3()+ "' , "
					+ "Answer1 ='" + second_Password_Model.getAnswer1() + "' , "
					+ "Answer2 ='" + second_Password_Model.getAnswer2() + "' , "
					+ "Answer3 ='" + second_Password_Model.getAnswer3() + "'  "
					+ "WHERE Username = '" + getUsername(email)+ "';");
			System.out.println("UPDATE third_Password SET Image1 = '" +selectedCheckboxes[0] + "',"
					+ "Image2 ='" + selectedCheckboxes[1]+ "' , "
					+ "Image3 ='" + selectedCheckboxes[2]+"'  "
					+ "WHERE Username = '" + getUsername(email)+ "';");
			rows2 = stmt.executeUpdate("UPDATE third_Password SET Image1 = '" +selectedCheckboxes[0] + "',"
					+ "Image2 ='" + selectedCheckboxes[1]+ "' , "
					+ "Image3 ='" + selectedCheckboxes[2]+"'  "
					+ "WHERE Username = '" + getUsername(email)+ "';");

			
			
			System.out.println(rows);
			System.out.println(rows1);
			System.out.println(rows2);
			
			// Closing the database connections and statement
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Returning the final result of email existence
		if (rows==1 && rows1==1 && rows2==1 ) {
			return true;
		} else {
			return false;
		}
	}

public String getUsername(String Email) {
	
	
	
	String url = "jdbc:mysql://localhost:3306/diabetes1";
	String username = "Madhu";
	String password = "Madhu@123";
	String name="";

	try {
		// Load the MySQL driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish the database connection
		Connection conn = DriverManager.getConnection(url, username, password);
		// Execute a query
		Statement stmt = conn.createStatement();
		System.out.println("SELECT * FROM users where Email='" + Email+ "';");
		ResultSet rs = stmt.executeQuery("SELECT * FROM users where Email='" + Email+ "';");
		if (rs.next()) {
			name = rs.getString("Username");
		} 
		

		
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return name;
	
	
}

}
