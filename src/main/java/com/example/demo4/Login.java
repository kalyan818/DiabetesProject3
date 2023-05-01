package com.example.demo4;

public class Login {
	private String Username;
	private String Password;

	
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
		return "Login_User_Model [Username=" + Username + ", Password=" + Password + "]";
	}

	

}
