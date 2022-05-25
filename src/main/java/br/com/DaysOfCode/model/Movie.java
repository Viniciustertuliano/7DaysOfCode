package br.com.DaysOfCode.model;

public class Movie implements Comparable<Movie>{

    private String title;
    private String urlImage;
    private Double rating;
    private int year;

    public Movie(){}

    public Movie(String title, String urlImage, Double rating, int year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public int compareTo(Movie outroMovie) {
        return this.getRating().compareTo((outroMovie.getRating()));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
