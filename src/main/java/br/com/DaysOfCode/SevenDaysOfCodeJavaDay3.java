package br.com.DaysOfCode;

import br.com.DaysOfCode.model.Movie;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class SevenDaysOfCodeJavaDay3 {
    public static void main(String[] args) throws Exception{
        URI topMoviesUrl = URI.create("https://imdb-api.com/en/API/Top250Movies/k_66k2z665");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(topMoviesUrl).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        List<String> titles = parseTitles(parseJsonMovies(json));
        List<String> urlImage = parseImage(parseJsonMovies(json));
        List<String> rating = parseRating(parseJsonMovies(json));
        List<String> year = parseYear(parseJsonMovies(json));

        List<Movie> movies = new ArrayList<>();

        for(int i = 0; i < 250; i++){
            movies.add(new Movie(titles.get(i), urlImage.get(i), Double.parseDouble(rating.get(i)), Integer.parseInt(year.get(i))));
        }
    }

    public static String[] parseJsonMovies(String json){
        String jsonMovies = json.substring(10, (json.length() - 20 ));
        return jsonMovies.split("(?<=},)");
    }

    public static List<String> parseTitles(String[] arrayMovies) {
        List<String> titlesList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            titlesList.add(movies.substring(movies.indexOf("title") + 8,movies.indexOf('"',movies.indexOf("title") + 8)));
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

    public static List<String> parseRating(String[] arrayMovies){
        List<String> ratingList = new ArrayList<>();
        for (String movies:arrayMovies) {
            ratingList.add(movies.substring(movies.indexOf("imDbRating") + 13, movies.indexOf('"', movies.indexOf("imDbRating") + 13)));
        }
        return  ratingList;
    }

    public static List<String> parseYear(String[] arrayMovies){
        List<String> yearList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            yearList.add(movies.substring(movies.indexOf("year") + 7, movies.indexOf('"',movies.indexOf("year") + 7)));
        }
        return yearList;
    }
}
