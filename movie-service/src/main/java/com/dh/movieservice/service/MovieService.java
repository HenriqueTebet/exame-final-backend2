package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllByGenre(String genre);

    Movie findMovieById(Integer movieId);

    Movie saveMovie(Movie movie);
}
