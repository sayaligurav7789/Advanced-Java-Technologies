<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form Output</title>
</head>
<body>
    <h2>Form Data Received</h2>

    <%
        // Retrieve form data from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
    %>
