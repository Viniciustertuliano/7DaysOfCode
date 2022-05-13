package br.com.DaysOfCode;

import br.com.DaysOfCode.model.Movie;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private final PrintWriter writer;

    public HTMLGenerator(PrintWriter writer){
        this.writer = writer;
    }

    public void generate(List<Movie> movies){
        String head =
                "<!DOCTYPE html>"+
                "<head>"+
                    "<meta charset=\"utf-8\">"+
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"+
                    "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" "+
                         "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"+
                "</head>"+
                "<body style=\"background-color: #292828;\">>"+
                        "<div class=\"container d-flex flex-wrap justify-content-center\">"+
                        "<div class=\"d-flex flex-wrap justify-content-center\" style=\"max-width: 18rem;\">";

        String divTemplate =

                "<div class=\"card text-white bg-dark mb-1\" style=\"max-width: 18rem;\">"+
                        "<h4 class=\"card-header\">%s</h4>"+
                            "<div class=\"card-body\">"+
                                "<img class=\"card-img\" src=\"%s\" alt=\"%s\">"+
                                "<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>"+
                            "</div>"+
                "</div>";
        String footer =
                "</div>"+
                    "</div>"+
                        "</body>"+
                                "</html>";

        writer.println(head);
        movies.forEach(movie -> {
           writer.println(String.format(divTemplate, movie.getTitle(), movie.getUrlImage(), movie.getTitle(), movie.getRating(), movie.getYear()));
        });
        writer.println(footer);
    }
}
