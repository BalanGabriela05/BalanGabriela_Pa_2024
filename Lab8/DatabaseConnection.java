package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static final String url = "jdbc:mysql://localhost:3306/db"; // URL-ul bazei de date
    private static final String username = "root"; // numele de utilizator al bazei de date
    private static final String password = "itgabriela05"; // parola bazei de date
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            this.connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static void closeConnection() {
        if (instance != null) {
            try {
                instance.connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
