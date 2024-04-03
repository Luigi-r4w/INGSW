package com.example.backendingsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    private static String jdbcURL="jdbc:";
    private static String username="root";
    private static String password="1234";
    private static Connection con;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(jdbcURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
