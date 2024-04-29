package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {
    private final String insertGenre = "INSERT INTO genres (name) VALUES (?)";
    private final String findGenreByName = "SELECT id FROM genres WHERE name = ?";
    private BasicDataSource dataSource = ConnectionPool.getDataSource();
    public void create(String name) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
  //      Connection con = dataSource.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(insertGenre)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
       Connection con = DatabaseConnection.getConnection();
 //       Connection con = dataSource.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(findGenreByName)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }
}
