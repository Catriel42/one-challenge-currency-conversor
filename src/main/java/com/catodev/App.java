package com.catodev;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient("f4f0e83a4f2fab1bf8bc33ea");
        ConversorCurrencyService service = new ConversorCurrencyService(apiClient);
        CurrencyConversorApp app = new CurrencyConversorApp(service);

        app.start();
    }

}
