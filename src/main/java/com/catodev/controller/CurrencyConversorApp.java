package com.catodev.controller;

import com.catodev.service.ConversorCurrencyService;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConversorApp {
    private final ConversorCurrencyService conversorCurrencyService;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public CurrencyConversorApp(ConversorCurrencyService service){
        this.conversorCurrencyService = service;
    }

    public void start() {
        System.out.println("=== CONVERSOR DE MONEDAS ===");

        do {
            System.out.println("\n1. Conversiones específicas");
            System.out.println("2. Convierte cualquier moneda a otra");
            System.out.println("3. Ver todas las tasas de una moneda");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            String option = scanner.nextLine();


            switch (option) {
                case "1" -> specificConversions();
                case "2" -> convertCurrency();
                case "3" -> showAllRates();
                case "4" -> {
                    System.out.println("¡Hasta luego!");
                    running = false;
                }
                default -> System.out.println("Opción inválida");
            }
        }
        while (running);
    }

    private void specificConversions() {
        String baseCode = "";
        String targetCode = "";
        System.out.println("""
                --- Conversiones Específicas ---
                1. Dólar (USD) =>> Peso Argentino (ARS)
                2. Peso Argentino (ARS) =>> Dólar (USD)
                3. Dólar (USD) =>> Real Brasileño (BRL)
                4. Real Brasileño (BRL) =>> Dólar (USD)
                5. Dólar (USD) =>> Peso Colombiano (COP)
                6. Peso Colombiano (COP) =>> Dólar (USD)
                """);
        System.out.print("Elija una opción: ");
        try {
            String option = scanner.nextLine();

            switch (option){
                case "1" -> { baseCode = "USD"; targetCode = "ARS"; }
                case "2" -> { baseCode = "ARS"; targetCode = "USD"; }
                case "3" -> { baseCode = "USD"; targetCode = "BRL"; }
                case "4" -> { baseCode = "BRL"; targetCode = "USD"; }
                case "5" -> { baseCode = "USD"; targetCode = "COP"; }
                case "6" -> { baseCode = "COP"; targetCode = "USD"; }
                default -> {
                    System.out.println("Opción no válida");
                    return;
                }
            }
            System.out.print("Introduce la cantidad a convertir: ");
            String amount = scanner.nextLine();
            double result = conversorCurrencyService.getConversion(baseCode, targetCode, amount);
            System.out.printf("El resultado de la conversión de %s %s a %s es: %.2f%n", amount, baseCode, targetCode, result);
        }catch (InputMismatchException e){
            System.out.println("Opción inválida, por favor elija una opción del menú");
            scanner.nextLine();
        }
    }

    private void convertCurrency() {
        System.out.println("Introduce la moneda de origen (ejem.: USD): ");
        String currencyFrom = scanner.nextLine().toUpperCase();
        System.out.println("Introduce la moneda de destino (ejem.: EUR): ");
        String currencyTo = scanner.nextLine().toUpperCase();
        System.out.println("Introduce la cantidad a convertir: ");
        String amount = scanner.nextLine();
        double result = conversorCurrencyService.getConversion(currencyFrom, currencyTo, amount);
        System.out.printf("El resultado de la conversion de %s %s a %s es: %.2f%n", amount, currencyFrom, currencyTo, result);
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
