package com.example.practice_movie_description_Josh_L.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int rating;

    // AI generated IMDB rating
    private Double imdbRating;

    private String description;

    public Movie() {

    }

    public Movie(int rating, Double imdbRating, String title, String description) {
        this.rating = rating;
        this.imdbRating = imdbRating;
        this.title = title;
        this.description = description;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
