package br.com.DaysOfCode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {
    private final URI topMoviesUrl;

    public ImdbApiClient(String chave){
        this.topMoviesUrl  = URI.create(String.format("https://imdb-api.com/en/API/Top250Movies/%s",chave));
    }

    public String getBody() throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(this.topMoviesUrl).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}