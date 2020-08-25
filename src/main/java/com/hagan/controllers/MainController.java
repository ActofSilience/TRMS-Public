package com.hagan.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hagan.util.DBConnect;
import com.google.gson.Gson;
import com.hagan.services.AlertServiceImpl;
import com.hagan.services.EmployeeService;
import com.hagan.services.EmployeeServiceImpl;
import com.hagan.services.FormService;
import com.hagan.services.FormServiceImpl;
import com.hagan.services.ProcessService;
import com.hagan.services.ProcessServiceImpl;
import com.hagan.services.UserLoginService;
import com.hagan.services.UserLoginServiceImpl;
import com.hagan.models.Form;
import com.hagan.models.UserLogin;
import com.hagan.services.AlertService;
import com.hagan.models.Process;

public class MainController {
	public static Connection conn = DBConnect.getConnection();
	/**
	 * 
	 */

	public static AlertService as = new AlertServiceImpl();
	public static FormService fs = new FormServiceImpl();
	public static EmployeeService es = new EmployeeServiceImpl();
	public static ProcessService ps = new ProcessServiceImpl();
	public static UserLoginService us = new UserLoginServiceImpl();
	public static Gson gson = new Gson();
	static UserLogin user;
	static UserLogin userP;
	static String activeUser;

	public static void getFormsByName(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println(activeUser);

		List<Form> f = fs.getFormsByName(activeUser);

		if (f != null)
			response.getWriter().append("Forms found");

	}

	public static void sendForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {

		Form form = gson.fromJson(request.getReader(), Form.class);
		response.getWriter().append(gson.toJson(form));

		form.setUsername(activeUser);
		form.setGrade("Awaiting Input");
		form.setAmountAdd(100);
		form.setStatus("Pending");
		form.setFile(null);

		System.out.println(form);

		fs.sendForm(form);

	}

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String username = request.getParameter("username");

		UserLogin user = new UserLogin();
		user = us.getUser(username);

		request.getSession().setAttribute("user", user);
		String accountType = user.getEmployeeType();

		if (accountType.equals("Employee")) {
			if (user.getPassword().equals(request.getParameter("password"))) {
				activeUser = user.getUsername();
				response.getWriter().append("Login sucessful");
				response.sendRedirect("/TRMS/employee/employeemenu.html");
			}
		} else if (accountType.equals("Head")) {
			if (user.getPassword().equals(request.getParameter("password"))) {
				activeUser = user.getUsername();
				response.getWriter().append("Login sucessful");
				response.sendRedirect("/TRMS/head/headmenu.html");
			}
		} else if (accountType.equals("Supervisor")) {
			if (user.getPassword().equals(request.getParameter("password"))) {
				activeUser = user.getUsername();
				response.getWriter().append("Login sucessful");
				response.sendRedirect("/TRMS/supervisorpages/supervisormenu.html");
			}
		} else {
			response.sendRedirect("/TRMS/userlogin.html");
			response.getWriter().append("Login failed");
		}
	}

	public static void getAllPendingForms(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Form> formA = fs.getAllPendingForms();

		if (formA != null)
			response.getWriter().append("Forms found");

	}
	
	public static void addHeadProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Process headprocess = gson.fromJson(request.getReader(), Process.class);
		response.getWriter().append(gson.toJson(headprocess));
		
		
		headprocess.setUsername("Josh");
		
		System.out.println(headprocess);
		String decision = request.getParameter("headApprove"); 
		String reason = request.getParameter("headReason"); 
		String form_id = request.getParameter("formId");
		
		int f_id = Integer.parseInt(form_id); 
		
		
		headprocess.setHeadApprove(decision);
		headprocess.setHeadReason(reason);
		headprocess.setFormId(f_id); 				

		

		ps.addHeadProcess(headprocess);

	}

}
