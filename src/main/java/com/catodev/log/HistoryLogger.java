package com.catodev.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryLogger {
    private static final String FILE = "conversion_history.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logConversion(String fromCurrency, String toCurrency, String amount, double result) {
        String log = String.format("%s - User request: %s → %s, Amount: %s, Result: %.2f%n",
                LocalDateTime.now().format(FORMATTER),
                fromCurrency,
                toCurrency,
                amount,
                result);

        try (FileWriter writer = new FileWriter(FILE, true)) {
            writer.write(log);
        } catch (IOException e) {
            System.out.println("Error save history: " + e.getMessage());
        }
    }
}
