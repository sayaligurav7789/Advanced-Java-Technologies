package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(false);
		if (session != null) {
			String user = (String) session.getAttribute("username");
		
			out.println("<h2 style = 'color: green'>"+"Welcome " +user+"!!</h2>");
			out.println("This is our Welcome page!<br><br>");
		
			//Next to Logout page
		
			out.println("<a href= 'logout'><button>LogOut -></button></a>");
		}
		else {
            out.println("<p>No active session. <a href='index.html'>Login</a></p>");
        }
	
	}

}
