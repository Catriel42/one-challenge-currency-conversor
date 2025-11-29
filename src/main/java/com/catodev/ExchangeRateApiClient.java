package com.catodev;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public LatestRateResponse getLatestRate(String currency) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + apiKey + "/latest/" + currency))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), LatestRateResponse.class);
    }
}
