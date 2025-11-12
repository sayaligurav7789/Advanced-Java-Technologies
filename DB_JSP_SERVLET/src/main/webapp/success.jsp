<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Success</title>
</head>
<body style="font-family: Arial; text-align: center; margin-top: 60px;">
    <h2 style="color: green;">Welcome, ${userDetails.username}!</h2>
    
    <table align="center" cellspacing="5">
        <tr>
            <td><b>Email</b></td>
            <td>:</td>
            <td>${userDetails.email}</td>
        </tr>
        <tr>
            <td><b>Password</b></td>
            <td>:</td>
            <td>${userDetails.password}</td>
        </tr>
        <tr>
            <td><b>ID</b></td>
            <td>:</td>
            <td>${userDetails.id}</td>
        </tr>
    </table>
</body>
</html>

