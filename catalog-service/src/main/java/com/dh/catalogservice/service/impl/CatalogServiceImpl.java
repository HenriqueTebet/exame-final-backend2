package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.dto.CatalogDTO;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.repository.SerieRepository;
import com.dh.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final MovieRepository movieRepository;
    private final SerieRepository serieRepository;

    @Override
    public Optional<Movie> findMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public CatalogDTO findCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogDTO(genre,movies,series);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void saveSerie(Serie serie) {
        serieRepository.save(serie);
    }
}
