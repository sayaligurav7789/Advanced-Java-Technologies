package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);  // don't create new
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (session != null) {
            String user = (String) session.getAttribute("username");
            out.println("<h3>Welcome, " + user + "</h3>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<p>No active session. <a href='index.html'>Login</a></p>");
        }
    }
}
