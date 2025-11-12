package com.model;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;

public class User {
    // 🟢 Fields (variables)
    private int id;
    private String username;
    private String password;
    private String email;

    // 🟢 Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 🟢 Validate user login
    public boolean validate(String username, String password) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌Database connection failed!");
                return false;
            }

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
                System.out.println("User found: " + rs.getString("username"));
            } else {
                System.out.println(" Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // 🟢 Fetch complete user details
    public User getUserByUsername(String username) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌Database connection failed!");
                return null;
            }

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}