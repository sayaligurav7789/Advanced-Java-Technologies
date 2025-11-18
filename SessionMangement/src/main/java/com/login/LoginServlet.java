package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String user = req.getParameter("username");
		
		//create session
		HttpSession session = req.getSession();
		session.setAttribute("username", user);
		
		out.println("<h2 style = 'color: green'>"+"Hi " +user+"!!</h2>");
		out.println("You have logged in Successfully!!<br><br>");
		
		//Next to welcome page
		
		out.println("<a href= 'welcome'><button>Welcome -></button></a>");
	}

}
