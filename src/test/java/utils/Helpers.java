package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helpers {
    public static String getTodayDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }
}
