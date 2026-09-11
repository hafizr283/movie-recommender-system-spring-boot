package io.datajek.springbootdemo.recommender_api;

public class Movie {
    int id;
    String name;
    double rating;

    public Movie(double rating, String name, int id) {
        this.rating = rating;
        this.name = name;
        this.id = id;
    }
    public  Movie(){

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }
}
