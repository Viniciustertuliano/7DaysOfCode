package br.com.DaysOfCode;

import br.com.DaysOfCode.model.Movie;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SevenDaysOfCodeJavaDay7 {
    public static void main(String[] args) throws Exception{
        String json = new ImdbApiClient("k_66k2z665").getBody();
        List<Movie> movies = new ImdbMovieJsonParser(json).parse();


        PrintWriter writer = new PrintWriter("moviesByTitle.html");
        Collections.sort(movies, Comparator.comparing(Movie::getTitle));
        new HTMLGenerator(writer).generate(movies);

        writer = new PrintWriter("moviesByYear.html");
        Collections.sort(movies, Comparator.comparing(Movie::getYear).reversed());
        new HTMLGenerator(writer).generate(movies);

        Collections.sort(movies, Comparator.reverseOrder());
        writer = new PrintWriter("moviesByRating.html");
        new HTMLGenerator(writer).generate(movies);

        writer.close();

    }
}
