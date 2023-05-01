package com.example.demo4;

import java.util.Date;

public class Register {
	private String Full_Name;
	private String Email;
	private long Phone_Number;
	private String Date_Of_Birth;
	private String Username;
	private String Password;
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(long phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}
	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Register [Full_Name=" + Full_Name + ", Email=" + Email + ", Phone_Number=" + Phone_Number
				+ ", Date_Of_Birth=" + Date_Of_Birth + ", Username=" + Username + ", Password=" + Password + "]";
	}

	

}
