package br.com.DaysOfCode;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class SevenDaysOfCodeJavaDay2 {
    public static void main(String[] args) throws Exception{
        URI topMoviesUrl = URI.create("https://imdb-api.com/en/API/Top250Movies/k_66k2z665");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(topMoviesUrl).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        List<String> titles = parseTitles(parseJsonMovies(json));
        List<String> urlImage = parseImage(parseJsonMovies(json));
        titles.forEach(System.out::println);
        urlImage.forEach(System.out::println);
    }

    public static String[] parseJsonMovies(String json){
        String jsonMovies = json.substring(10, (json.length() - 20 ));
        return jsonMovies.split("(?<=},)");
    }
    public static List<String> parseTitles(String[] arrayMovies) {
        List<String> titlesList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            titlesList.add(movies.substring(movies.indexOf("title") + 8, movies.indexOf('"',movies.indexOf("title") + 8)));
        }
        return titlesList;
    }
    public static List<String> parseImage(String[] arrayMovies) {
        List<String> urlImageList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            urlImageList.add(movies.substring(movies.indexOf("image") + 8, movies.indexOf('"',movies.indexOf("image") + 8)));
        }
        return urlImageList;
    }
}
