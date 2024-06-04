package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public void execute() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        ResourceBundle messages = ResourceBundle.getBundle("Messages");

        System.out.println(messages.getString("locales"));
        for (Locale locale : availableLocales) {
            System.out.println(locale.toString() + " " + locale.getDisplayName());
        }
    }
}
