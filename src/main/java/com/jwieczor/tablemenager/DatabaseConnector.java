package com.jwieczor.tablemenager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://mysql.wmi.amu.edu.pl:3306/s485704_tin";
    private static final String USERNAME = "s485704";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER_CLASS);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                System.out.println("Connected to the database.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.err.println("Failed to connect to the database.");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection to the database is closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Failed to close connection to the database.");
            }
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            closeConnection();
        }
    }
}
