package com.hagan.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			RequestHelper.process(request, response);
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed");
			e.printStackTrace();
		}
		addCorsHeader(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
		addCorsHeader(response);
	}

	private void addCorsHeader(HttpServletResponse resp) {
		// log.trace("adding headers");
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		resp.addHeader("Vary", "Origin");
		// if I don't care about getting my cookie, this will work
		// response.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.addHeader("Access-Control-Max-Age", "1728000");
		resp.addHeader("Produces", "application/json");
	}

}
