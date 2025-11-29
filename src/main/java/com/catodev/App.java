package com.catodev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter currency from: ");
        String currencyFrom = scanner.nextLine();
        System.out.println("Enter currency to: ");
        String currencyTo = scanner.nextLine();
        System.out.println("Enter amount: ");
        String amount = scanner.nextLine();

        ExchangeRateApiClient exchangeRateApiClient = new ExchangeRateApiClient("f4f0e83a4f2fab1bf8bc33ea");
        PairConversionWithAmountResponse response = exchangeRateApiClient.getConversion(currencyFrom, currencyTo, amount);
        System.out.println(response.conversionResult());
    }
}
