package br.com.DaysOfCode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SevenDaysOfCodeJavaDay1 {
    public static void main(String[] args) {
        String topMoviesUrl = "https://imdb-api.com/en/API/Top250Movies/k_66k2z665";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(topMoviesUrl)).GET().build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}