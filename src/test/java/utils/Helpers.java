package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Helpers {
    public static String getTodayDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }


    public static String generateRandomWord() {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        Random RANDOM = new Random();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            char randomChar = ALPHABET.charAt(index);
            word.append(randomChar);
        }
        return word.toString();
    }
}
