package com.hagan.services;

import java.util.List;

import com.hagan.models.Alert;

public interface AlertService {

	public Alert getBalance(Alert balance);
	
	public Alert getStatus(Alert status); 
	
	public List<Alert> getFormsByUser(String username); 
	
	public List<Alert> getForms(Alert forms); 
	
	
}
