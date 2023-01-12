package com.fc.demo.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ClientMain {


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        StringBuilder stringToSend = null;
        for (int i = 1; i < 10; i++) {
            if (i == 1) {
                stringToSend = new StringBuilder("integers=" + 7);
            }
            stringToSend.append("&integers=").append(i * 2);
        }
        String sum = (getUrlContent("http://localhost:8080/sum?" + stringToSend));
        System.out.println("Obliczona suma liczb wynosi: " + sum);

    }


    public static String getUrlContent(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI(url))
                        .GET()
                        .build();

        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = httpResponse.statusCode();
        return httpResponse.body();
    }
}
