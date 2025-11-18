package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		HttpSession session = req.getSession();
		int k = (int) session.getAttribute("k");
		
		out.println("<h2 style = 'color: green'>--Results using Session--<h2>");

		out.println("<h4><b>Sum is:</b> " + k + "</h4>");

		k = k * k;

		out.println("<h4><b>Square of sum is:</b> " + k + "</h4>");



		
	}
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res); // allow GET requests too
    }
}
