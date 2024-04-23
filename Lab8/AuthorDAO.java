package org.example;

import java.sql.*;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into books (author) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "select id from books where author = ?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public String findById(int id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "select author from books where id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
    }
    public void printAllAuthors() throws SQLException {
        String sql = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("author"));
            }
        }
    }
}
