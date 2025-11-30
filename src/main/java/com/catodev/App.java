package com.catodev;

import com.catodev.client.ExchangeRateApiClient;
import com.catodev.controller.CurrencyConversorApp;
import com.catodev.service.ConversorCurrencyService;
import com.catodev.util.Config;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Config config = new Config();
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient(config.configApiKey());
        ConversorCurrencyService service = new ConversorCurrencyService(apiClient);
        CurrencyConversorApp app = new CurrencyConversorApp(service);

        app.start();
    }

}
