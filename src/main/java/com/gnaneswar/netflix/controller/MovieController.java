package com.gnaneswar.netflix.controller;

import com.gnaneswar.netflix.entity.Movie;
import com.gnaneswar.netflix.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Home API
    @GetMapping("/")
    public String home() {
        return "Netflix Backend is running successfully!";
    }

    // Status API
    @GetMapping("/status")
    public String status() {
        return "Backend + Database connected (H2)";
    }

    // Get all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a movie
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
}
