package com.hagan.models;

public class Alert {
String username;
int formId;
int amount;
int balance;
String status; 

public Alert() {
	super(); 
}

@Override
public String toString() {
	return "Alert [username=" + username + ", formId=" + formId + ", amount=" + amount + ", balance=" + balance
			+ ", status=" + status + "]";
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getFormId() {
	return formId;
}

public void setFormId(int formId) {
	this.formId = formId;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Alert(String username, int formId, int amount, int balance, String status) {
	super();
	this.username = username;
	this.formId = formId;
	this.amount = amount;
	this.balance = balance;
	this.status = status;
}
}
