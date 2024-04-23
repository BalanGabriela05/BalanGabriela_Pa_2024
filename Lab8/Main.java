package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();
        try {
            authorDAO.create("Nume Autor");
            Integer id = authorDAO.findByName("Nume Autor");
            authorDAO.printAllAuthors();
            if (id != null) {
                System.out.println("Autorul a fost adaugat cu ID-ul: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Eroare inserare autor: " + e.getMessage());
        }

    }
}