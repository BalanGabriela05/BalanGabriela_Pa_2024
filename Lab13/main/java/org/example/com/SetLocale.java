package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    private Locale currentLocale;

    public void execute(String languageTag) {
        currentLocale = Locale.forLanguageTag(languageTag);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", currentLocale);

        System.out.println(messages.getString("locale.set").replace("{0}", currentLocale.toString()));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
