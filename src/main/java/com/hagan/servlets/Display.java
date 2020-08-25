package com.hagan.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hagan.models.Form;
import com.hagan.services.AlertService;
import com.hagan.util.DBConnect;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><body>");

		 try 
         {  
             Connection conn = DBConnect.getConnection();            
             Statement stmt = conn.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from BENCO_REQUEST");  
             out.println("<table border=1 width=10% height=10%>");  
             out.println("<tr><th>Username</th><th>Form ID</th><th>Amount</th> <th>Balance</th> <th>Status</th><th>Grade</th><tr>");  
             while (rs.next()) 
             {  
                Form form = new Form(); 
            	 String name = rs.getString("USERNAME");  
                 int form_id = rs.getInt("F_ID");  
                 int amount = rs.getInt("AMT");  
                 int amount_add = rs.getInt("AMT_ADD");
                 String status = rs.getString("STATUS"); 
                 String grade = rs.getString("GRADE"); 
                
                 out.println("<tr><td>" + name + "</td><td>" + form_id + "</td><td>" + amount + "</td><td>" + amount_add + "</td><td>" + status + "</td><td>" + grade + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             conn.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 
}