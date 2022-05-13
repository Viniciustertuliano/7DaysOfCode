package br.com.DaysOfCode;

import br.com.DaysOfCode.model.Movie;

import java.io.PrintWriter;
import java.util.List;

public class SevenDaysOfCodeJavaDay4 {



    public static void main(String[] args) throws Exception{
        PrintWriter writer = new PrintWriter("movies.html");
        HTMLGenerator generator = new HTMLGenerator(writer);
        List<Movie> movies = new SevenDaysOfCodeJavaDay3().parse();
        generator.generate(movies);
        writer.close();
    }
}
