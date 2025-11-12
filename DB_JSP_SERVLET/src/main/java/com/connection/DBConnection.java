package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
