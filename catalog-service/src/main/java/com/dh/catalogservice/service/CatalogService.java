package com.dh.catalogservice.service;

import com.dh.catalogservice.dto.CatalogDTO;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;

import java.util.Optional;

public interface CatalogService {

    void saveMovie(Movie movie);

    void saveSerie(Serie serie);

    Optional<Movie> findMovieById(String movieId);

    CatalogDTO findCatalogByGenre(String genre);
}
