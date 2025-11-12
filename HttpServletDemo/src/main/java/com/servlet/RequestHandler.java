package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestHandeler")
public class RequestHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RequestHandler() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
    	// Set the type of content that the servlet will send as a response.
        // "text/html" means we’re sending an HTML page back to the client.
        response.setContentType("text/html");
        
        // Get a PrintWriter object to send HTML output to the browser.
        PrintWriter out = response.getWriter();

        // Get the data (parameters) sent by the user from the HTML form.
        // The names inside getParameter() must match the 'name' attributes from the HTML form.
        String name = request.getParameter("uname");
        String email = request.getParameter("uemail"); // fixed
        
        // Generate an HTML response dynamically using the data from the form.
        out.println("<html><body>");
        out.println("<h2>HTTP Request Handled Successfully!</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("</body></html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // For now, we’ll just call doGet() to handle POST requests the same way.
        doGet(request, response);
    }
}