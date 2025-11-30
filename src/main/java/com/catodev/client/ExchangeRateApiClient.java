package com.catodev.client;

import com.catodev.dto.LatestRateResponse;
import com.catodev.dto.PairConversionWithAmountResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExchangeRateApiClient {
    private final String apiKey;
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient httpClient;
    private final Gson gson;

    public ExchangeRateApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     * Generic method to get data from the API
     * @param endpoint
     * @param responseType
     * @return
     * @param <T>
     * @throws Exception
     */
    private <T> T get(String endpoint, Class<T> responseType) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + apiKey + endpoint))
                .build();
        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la API: " + response.statusCode());
        }
        return gson.fromJson(response.body(), responseType);
    }

    public LatestRateResponse getLatestRate(String currency) throws Exception {
        return get("/latest/" + currency, LatestRateResponse.class);
    }

    public PairConversionWithAmountResponse getConversion(String currencyFrom, String currencyTo, String amount) throws Exception {
        return get("/pair/" + currencyFrom + "/" + currencyTo + "/" + amount, PairConversionWithAmountResponse.class);
    }
}
