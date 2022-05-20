package br.com.DaysOfCode;

import br.com.DaysOfCode.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser {
    private final String json;

    public ImdbMovieJsonParser(String json){
        this.json = json;
    }

    public List<Movie> parse(){
        List<String> titles = parseTitles(parseJsonMovies(this.json));
        List<String> urlImage = parseImage(parseJsonMovies(this.json));
        List<String> rating = parseRating(parseJsonMovies(this.json));
        List<String> year = parseYear(parseJsonMovies(this.json));

        List<Movie> movies = new ArrayList<>();

        for(int i = 0; i < 250; i++){
            movies.add(new Movie(titles.get(i), urlImage.get(i), Double.parseDouble(rating.get(i)), Integer.parseInt(year.get(i))));
        }
        return movies;
    }

    public String[] parseJsonMovies(String json){
        String jsonMovies = json.substring(10, (json.length() - 20 ));
        return jsonMovies.split("(?<=},)");
    }

    public List<String> parseTitles(String[] arrayMovies) {
        List<String> titlesList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            titlesList.add(movies.substring(movies.indexOf("title") + 8,movies.indexOf('"',movies.indexOf("title") + 8)));
        }
        return titlesList;
    }

    public List<String> parseImage(String[] arrayMovies) {
        List<String> urlImageList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            urlImageList.add(movies.substring(movies.indexOf("image") + 8, movies.indexOf('"',movies.indexOf("image") + 8)));
        }
        return urlImageList;
    }

    public List<String> parseRating(String[] arrayMovies){
        List<String> ratingList = new ArrayList<>();
        for (String movies:arrayMovies) {
            ratingList.add(movies.substring(movies.indexOf("imDbRating") + 13, movies.indexOf('"', movies.indexOf("imDbRating") + 13)));
        }
        return  ratingList;
    }

    public List<String> parseYear(String[] arrayMovies){
        List<String> yearList = new ArrayList<>();
        for (String movies:arrayMovies)
        {
            yearList.add(movies.substring(movies.indexOf("year") + 7, movies.indexOf('"',movies.indexOf("year") + 7)));
        }
        return yearList;
    }
}
