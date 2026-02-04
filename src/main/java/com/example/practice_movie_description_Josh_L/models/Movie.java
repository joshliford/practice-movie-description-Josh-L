package com.example.practice_movie_description_Josh_L.models;

import jakarta.persistence.*;
import javafx.scene.text.Text;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int rating;

    private String description;

    public Movie() {

    }

    public Movie(int rating, String title, String description) {
        this.rating = rating;
        this.title = title;
        this.description = description;
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
