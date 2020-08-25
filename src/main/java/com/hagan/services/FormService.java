package com.hagan.services;

import java.util.List;

import com.hagan.models.Form;

public interface FormService {

	public Form getForm(Form formId);

	public List<Form> getFormsByName(String username);

	public Form sendForm(Form form); 
	
	public boolean updateFinalGrade(Form form); 
	
	public List<Form> getAllPendingForms();

	
}
