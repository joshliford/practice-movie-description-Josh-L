package com.example.practice_movie_description_Josh_L.repositories;

import com.example.practice_movie_description_Josh_L.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
