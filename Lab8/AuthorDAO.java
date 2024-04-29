package org.example;

import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class AuthorDAO {
    private final String insertAuthor = "insert into authors (name) values (?)";
    private final String nameAuthor = "select id from authors where name = ?";
    private final String idAuthor = "select name from authors where id = ?";

    private BasicDataSource dataSource = ConnectionPool.getDataSource();
    public void create(String name) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
 //       Connection con = dataSource.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(insertAuthor)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();

        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
   //     Connection con = dataSource.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(nameAuthor)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
//        Connection con = dataSource.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(idAuthor)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
    }

}
