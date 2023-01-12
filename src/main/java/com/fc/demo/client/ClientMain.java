package com.fc.demo.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ClientMain {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String stringToSend = "Network_Programing";
        String sum = (getUrlContent("http://localhost:8080/echo?text=" + stringToSend));
        System.out.println("A echo na to :" + sum);

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
