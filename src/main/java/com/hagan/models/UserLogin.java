package com.hagan.models;

public class UserLogin {

	String username;
	String password;
	String employeeType; 
	public UserLogin() {
		super();

	}

	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public UserLogin(String employeeType) {
		super();
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
