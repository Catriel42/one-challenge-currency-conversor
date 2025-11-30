package com.catodev.service;

import com.catodev.client.ExchangeRateApiClient;
import com.catodev.log.HistoryLogger;

import java.util.Map;

public class ConversorCurrencyService {
    private final ExchangeRateApiClient exchangeRateApiClient;

    public ConversorCurrencyService(ExchangeRateApiClient exchangeRateApiClient) {
        this.exchangeRateApiClient = exchangeRateApiClient;
    }

    public double getConversion(String currencyFrom, String currencyTo, String amount) {
        try {
            double result =  exchangeRateApiClient
                    .getConversion(currencyFrom, currencyTo, amount)
                    .conversionResult();
            HistoryLogger.logConversion("USD", "EUR", amount, result);
            return result;
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
