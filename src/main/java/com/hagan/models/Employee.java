package com.hagan.models;

public class Employee {
String username;
String password;
String empType;
String department;
String role;
public Employee() {
	super();
}



public Employee(String username, String password, String empType, String department, String role) {
	super();
	this.username = username;
	this.password = password;
	this.empType = empType;
	this.department = department;
	this.role = role;
}
@Override
public String toString() {
	return "Employee [username=" + username + ", password=" + password + ", empType=" + empType + ", department="
			+ department + ", role=" + role + "]";
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
public String getEmpType() {
	return empType;
}
public void setEmpType(String empType) {
	this.empType = empType;
}

public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
