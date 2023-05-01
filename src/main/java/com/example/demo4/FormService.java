package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FormService {

	public boolean AddFormData(Login login, FormModel formModel) {

		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		int rows = 0;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Create a statement object
			Statement stmt = conn.createStatement();
			// Execute a query to insert data into the database
			System.out.println("INSERT INTO Form (UserName, Date, Time1, Sugar_Level1, Time2, Sugar_Level2, Breakfast, Lunch, Dinner)"
							+ "VALUES ('" + login.getUsername() + "', '" + formModel.getDate() + "','"
							+ formModel.getTime1() + "', " + formModel.getSugar_Level1() + ", '"
							+ formModel.getTime2() + "', " + formModel.getSugar_Level2() + ", '"
							+ formModel.getBreakFast() + "', '" + formModel.getLunch() + "','" + formModel.getDinner()
							+ "');");
			rows = stmt.executeUpdate(
					"INSERT INTO Form (UserName, Date, Time1, Sugar_Level1, Time2, Sugar_Level2, Breakfast, Lunch, Dinner)"
							+ "VALUES ('" + login.getUsername() + "', '" + formModel.getDate() + "','"
							+ formModel.getTime1() + "', " + formModel.getSugar_Level1() + ", '"
							+ formModel.getTime2() + "', " + formModel.getSugar_Level2() + ", '"
							+ formModel.getBreakFast() + "', '" + formModel.getLunch() + "','" + formModel.getDinner()
							+ "');");

			// Close the statement and connection objects
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (rows == 0) {
			return false;
		} else {
			return true;
		}

	}

	// This method retrieves details of a registered user from the database
	// and returns a List of FormModel objects containing the details
	public List<FormModel> getDetails(Login login) {
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		boolean detailsExits = false;
		// List to store FormModel objects containing the user's details
		List<FormModel> Details = new ArrayList<>();

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			// Query to select all rows from diabetesData table with matching username
			ResultSet rs = stmt.executeQuery("SELECT * FROM Form where Username='" + login.getUsername() + "';");
			// Loop through the result set and create a FormModel object for each row
			while (rs.next()) {
				FormModel form = new FormModel();
				form.setDate(rs.getString("Date"));
				form.setTime1(rs.getString("Time1"));
				form.setTime2(rs.getString("Time2"));
				form.setSugar_Level1(rs.getString("Sugar_Level1"));
				form.setSugar_Level2(rs.getString("Sugar_Level2"));
				form.setBreakFast(rs.getString("Breakfast"));
				form.setLunch(rs.getString("Lunch"));
				form.setDinner(rs.getString("Dinner"));
				Details.add(form);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Return the list of FormModel objects
		return Details;
	}
}
