package org.example;
import com.opencsv.CSVReader;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            // Obține o conexiune din pool
            Connection connection = ConnectionPool.getDataSource().getConnection();
//            var authors = new AuthorDAO();
//            authors.create("William Shakespeare");
//            var genres = new GenreDAO();
//            genres.create("Tragedy");

            var books = new BookDAO(); //findByName

            List<String> authors1 = new ArrayList<>();
            authors1.add("William Shakespeare");

            List<String> genres1= new ArrayList<>();
            genres1.add("Tragedy");

            String title1 = "Romeo and Juliet";

            if(books.findByName(title1) == null)
                books.create(1597,title1 ,"eng",432, authors1,genres1);

            //la fel

//            authors.create("Douglas Adams");
//
//            genres.create("Science fiction");
//            genres.create("Comedy");
//            genres.create("Adventure");

            List<String> authors2 = new ArrayList<>();
            authors2.add("Douglas Adams");

            List<String> genres2= new ArrayList<>();
            genres2.add("Science fiction");
            genres2.add("Comedy");
            genres2.add("Adventure");

            String title2= "The Hitchhiker's Guide to the Galaxy";

            if(books.findByName(title2) == null)
                books.create(1979,title2,"eng",358, authors2, genres2);

            //------------------------------------
            // Citirea datelor din fișierul CSV

            List<Book> bookCsv = CsvReader.readBooksFromCsv("C:\\Users\\Gabriela\\Documents\\BalanGabriela_Pa_2024\\LAB8\\untitled\\src\\main\\resources\\bookCsv.csv");

            // Crearea unei instanțe a clasei BookDAO
            BookDAO bookDAO = new BookDAO();



            books.printAllBooks();

            DatabaseConnection.getConnection().commit();

            connection.close();

        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("Error");
        }finally {

             DatabaseConnection.closeConnection();
        }



}
}