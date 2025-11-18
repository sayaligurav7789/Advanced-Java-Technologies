package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		int k = 0;
		
		//fetch the Cookie
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		
		out.println("Sum is:" + k);
		
		k = k * k;
		out.println("Square of Sum is:" + k);
		
	}
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res); // allow GET requests too
    }
}
