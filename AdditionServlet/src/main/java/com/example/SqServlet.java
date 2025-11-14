package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int k =Integer.parseInt(req.getParameter("k"));
		out.println("Sum is:" + k);
		
		k = k * k;
		out.println("Square of Sum is:" + k);
		
	}
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res); // allow GET requests too
    }
}
