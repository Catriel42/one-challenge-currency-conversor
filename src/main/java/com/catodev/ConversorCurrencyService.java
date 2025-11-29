package com.catodev;

import java.util.Map;

public class ConversorCurrencyService {
    private final ExchangeRateApiClient exchangeRateApiClient;

    public ConversorCurrencyService(ExchangeRateApiClient exchangeRateApiClient) {
        this.exchangeRateApiClient = exchangeRateApiClient;
    }

    public double getConversion(String currencyFrom, String currencyTo, String amount) {
        try {
            return exchangeRateApiClient
                    .getConversion(currencyFrom, currencyTo, amount)
                    .conversionResult();
        } catch (Exception e) {
            throw new RuntimeException("Error while converting currency", e);
        }
    }

    public Map<String, Double> getLatestRate(String currency)  {
        try {
            return exchangeRateApiClient.getLatestRate(currency).conversionRates();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
