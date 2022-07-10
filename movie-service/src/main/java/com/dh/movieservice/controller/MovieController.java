package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.impl.MovieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @PostMapping("/save")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.saveMovie(movie));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findMovieById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findMovieById(id));
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAllByGenre(genre));
    }
}
