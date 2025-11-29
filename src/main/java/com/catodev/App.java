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
        String url = "https://v6.exchangerate-api.com/v6/f4f0e83a4f2fab1bf8bc33ea/pair/"+currencyFrom+"/"+currencyTo+"/"+amount;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
