package com.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLRewritingServlet
 */
@WebServlet("/URLRewritingServlet")
public class URLRewritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		if(name == null) {
			name = "Guest";
		}
		
		String newURL = "WelcomeServlet?user=" + name;
		response.setContentType("text/html");
        response.getWriter().println("<a href='" + newURL + "'>Click Here to Continue</a>");
	}
    

	

}
