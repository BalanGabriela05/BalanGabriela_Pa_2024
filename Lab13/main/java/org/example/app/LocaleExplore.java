package org.example.app;

import org.example.com.DisplayLocales;
import org.example.com.SetLocale;
import org.example.com.Info;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", Locale.getDefault());

        SetLocale setLocale = new SetLocale();
        DisplayLocales displayLocales = new DisplayLocales();
        Info info = new Info();

        while (true) {
            System.out.println(messages.getString("prompt"));
            String command = scanner.nextLine();

            if (command.equals("locales")) {
                displayLocales.execute();
            } else if (command.startsWith("set")) {
                String[] parts = command.split(" ");
                if (parts.length == 2) {
                    setLocale.execute(parts[1]);
                    messages = ResourceBundle.getBundle("Messages", setLocale.getCurrentLocale());
                } else {
                    System.out.println(messages.getString("invalid"));
                }
            } else if (command.equals("info")) {
                info.execute(setLocale.getCurrentLocale());
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}
