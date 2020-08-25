package com.hagan.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hagan.controllers.MainController;

/**
 * Servlet implementation class Sub
 */
public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {

		String uri = request.getRequestURI();

		switch (uri) {
		case "/TRMS/test": {
			response.getWriter().append("Test");
			response.setStatus(200);
			break;
		}
		case "/TRMS/reimbursementform/.do": {
			MainController.sendForm(request, response);
			break;
		}
		case "/TRMS/userlogin/.do": {
			MainController.login(request, response);
			break;
		}
		case "/TRMS/employeerequestview/.do": {
			MainController.getFormsByName(request, response);
			break;
		}
		case "/TRMS/updaterequestgrade/.do": {
			MainController.getFormsByName(request, response);
			break;
		}

		case "/TRMS/head/headrequest/.do": {
			MainController.addHeadProcess(request, response);
			break;
		}

		default: {
			response.sendError(451, "Get off my lawn!");
			break;
		}
		}

	}
}
