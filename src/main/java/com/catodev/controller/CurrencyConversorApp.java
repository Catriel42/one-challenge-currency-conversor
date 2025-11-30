package com.catodev.controller;

import com.catodev.service.ConversorCurrencyService;

import java.util.Map;
import java.util.Scanner;

public class CurrencyConversorApp {
    private ConversorCurrencyService conversorCurrencyService;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public CurrencyConversorApp(ConversorCurrencyService service){
        this.conversorCurrencyService = service;
    }

    public void start() {
        System.out.println("=== CONVERSOR DE MONEDAS ===");

        do {
            System.out.println("\n1. Convertir moneda");
            System.out.println("2. Ver todas las tasas");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            String option = scanner.nextLine();


            switch (option) {
                case "1" -> convertCurrency();
                case "2" -> showAllRates();
                case "3" -> {
                    System.out.println("¡Hasta luego!");
                    running = false;
                }
                default -> System.out.println("Opción inválida");
            }
        }
        while (running);
    }

    private void convertCurrency() {
        System.out.println("Introduce la moneda de origen (ejem.: USD): ");
        String currencyFrom = scanner.nextLine().toUpperCase();
        System.out.println("Introduce la moneda de destino (ejem.: EUR): ");
        String currencyTo = scanner.nextLine().toUpperCase();
        System.out.println("Introduce la cantidad a convertir: ");
        String amount = scanner.nextLine();
        double result = conversorCurrencyService.getConversion(currencyFrom, currencyTo, amount);
        System.out.println(result);
    }

    private void showAllRates() {
        System.out.println("Introduce la moneda a consultar (ejem.: USD): ");
        String currency = scanner.nextLine();
        Map<String, Double> rates = conversorCurrencyService.getLatestRate(currency);
        System.out.println("\nTasas para " + currency + ":");
        rates.forEach((key, value) ->
                System.out.printf("%s: %.4f%n", key, value)
        );
    }
}
