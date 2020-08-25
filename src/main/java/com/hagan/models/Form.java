package com.hagan.models;

public class Form {

	int formId;
	String username;
	String eventType;
	int eventCost;
	String gradeFormat;
	String eventDate;
	int amount;	
	String grade;
	String status;
	String description;
	String file; 
	String timeSubmitted; 
	int amountAdd;
	
	public Form() {
		super(); 
	}
	
	
	@Override
	public String toString() {
		return "Form [formId=" + formId + ", username=" + username + ", eventType=" + eventType + ", eventCost="
				+ eventCost + ", gradeFormat=" + gradeFormat + ", eventDate=" + eventDate + ", amount=" + amount
				+ ", grade=" + grade + ", status=" + status + ", description=" + description + ", file=" + file
				+ ", timeSubmitted=" + timeSubmitted + ", amountAdd=" + amountAdd + "]";
	}


	public int getFormId() {
		return formId;
	}


	public void setFormId(int formId) {
		this.formId = formId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public int getEventCost() {
		return eventCost;
	}


	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}


	public String getGradeFormat() {
		return gradeFormat;
	}


	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	public String getEventDate() {
		return eventDate;
	}


	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getTimeSubmitted() {
		return timeSubmitted;
	}


	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}


	public int getAmountAdd() {
		return amountAdd;
	}


	public void setAmountAdd(int amountAdd) {
		this.amountAdd = amountAdd;
	}


	public Form(int formId, String username, String eventType, int eventCost, String gradeFormat, String eventDate,
			int amount, String grade, String status, String description, String file, String timeSubmitted,
			int amountAdd) {
		super();
		this.formId = formId;
		this.username = username;
		this.eventType = eventType;
		this.eventCost = eventCost;
		this.gradeFormat = gradeFormat;
		this.eventDate = eventDate;
		this.amount = amount;
		this.grade = grade;
		this.status = status;
		this.description = description;
		this.file = file;
		this.timeSubmitted = timeSubmitted;
		this.amountAdd = amountAdd;
	}
	

}
