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
public class Third_Password_Images {

	public List<Images> getImages() {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/diabetes1";
		String username = "Madhu";
		String password = "Madhu@123";
		
		List<Images> images = new ArrayList<Images>();
		try {
			// Load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(url, username, password);
			// Execute a query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Images");
					
			while (rs.next()) {
				Images image = new Images();
				image.setImageName(rs.getString("ImageName"));
				image.setImage(rs.getBytes("Image"));
				images.add(image);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return images;

	}

}
