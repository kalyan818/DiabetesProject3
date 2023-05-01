package com.example.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	// Autowiring JavaMailSender bean
	@Autowired
	private JavaMailSender mailSender;

	// Method to send a simple email message
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}

	// Method to validate the email format
	public boolean isValidEmail(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddress = new InternetAddress(email);
			emailAddress.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// Method to check if email exists in the database
	public boolean checkEmailExists(String email) {
		// Declaring database URL, username and password
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		// Declaring variable to hold the result of email existence
		boolean detailsExits = false;

		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query to get user data with the given email
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users where Email='" + email + "';");

			// If no user is found with the given email, detailsExits will remain false
			if (!rs.next()) {
				detailsExits = false;
			} else { // Otherwise, detailsExits will be set to true
				do {
					detailsExits = true;
					String name = rs.getString("Username");
				} while (rs.next());
			}
			// Closing the database connections and statement
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Returning the final result of email existence
		if (detailsExits) {
			return true;
		} else {
			return false;
		}
	}

}
