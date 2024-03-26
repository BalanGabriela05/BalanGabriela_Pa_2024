package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----Compulsory-----");
        try {
            Repository repo = new Repository("C:\\Users\\Gabriela\\Documents\\BalanGabriela_Pa_2024\\LAB5\\masterFile");
            repo.displayContent();
        } catch (IOException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
  }
}