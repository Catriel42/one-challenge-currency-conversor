package com.catodev;

import com.catodev.client.ExchangeRateApiClient;
import com.catodev.controller.CurrencyConversorApp;
import com.catodev.service.ConversorCurrencyService;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient("f4f0e83a4f2fab1bf8bc33ea");
        ConversorCurrencyService service = new ConversorCurrencyService(apiClient);
        CurrencyConversorApp app = new CurrencyConversorApp(service);

        app.start();
    }

}
