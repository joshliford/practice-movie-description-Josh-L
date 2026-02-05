package com.example.practice_movie_description_Josh_L.controllers;

import com.example.practice_movie_description_Josh_L.models.Movie;
import com.example.practice_movie_description_Josh_L.repositories.MovieRepository;
import com.example.practice_movie_description_Josh_L.services.GeminiService;
import org.apache.http.HttpException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    private final GeminiService geminiService;

    public MovieController(MovieRepository movieRepository, GeminiService geminiService) {
        this.movieRepository = movieRepository;
        this.geminiService = geminiService;
    }


    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @PostMapping
    public Movie addNewMovie(@RequestBody Movie movie) throws HttpException, IOException {
        String description = geminiService.generateMovieDescription(movie.getTitle());
        double imdbRating = geminiService.generateGeminiRating(movie.getTitle());
        movie.setDescription(description);
        movie.setImdbRating(imdbRating);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable int movieId) {
        movieRepository.deleteById(movieId);
    }

}
