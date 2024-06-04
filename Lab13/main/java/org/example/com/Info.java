package org.example.com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public void execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        System.out.println(messages.getString("info").replace("{0}", locale.toString()));
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));

        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");

        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        System.out.println("Week Days: " + String.join(", ", symbols.getWeekdays()));
        System.out.println("Months: " + String.join(", ", symbols.getMonths()));

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println("Today: " + dateFormat.format(new Date()));
    }
}
