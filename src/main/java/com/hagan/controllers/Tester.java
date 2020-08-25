package com.hagan.controllers;

import com.hagan.models.Form;
import com.hagan.services.FormServiceImpl;

public class Tester {

	
	
	public static void main(String[] args) {
	Form form = new Form();
	
	form.setUsername("Stuart");
	form.setEventType("Cert");
	form.setEventCost(100);
	form.setGradeFormat("");
	form.setEventDate("");
	form.setAmount(100);
	form.setGrade("");
	form.setStatus("");
	form.setDescription("");
	form.setAmountAdd(100);
	
	FormServiceImpl fs = new FormServiceImpl();
	fs.sendForm(form);
	
	
	
}
}
