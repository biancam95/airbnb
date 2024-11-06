package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String getCurrentDateInMMDDYYYY(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }
}
