package com.jrsaavedra.javatests.movies.service;

import com.jrsaavedra.javatests.movies.data.MovieRepository;
import com.jrsaavedra.javatests.movies.model.Genre;
import com.jrsaavedra.javatests.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByName(String name){
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().
                        contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase()
                .contains(director.toLowerCase())).collect(Collectors.toList());
    }

    public Movie findMovieById(Long id){
        return movieRepository.findById(id);
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        if(template.getId() != null){
            Collection<Movie> filters = new ArrayList<>();
            filters.add(findMovieById(Long.valueOf(template.getId())));
            return filters;
        }

        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("duration must be greater or equal than zero.");
        }
        return movieRepository.findAll().stream()
                .filter(movie -> template.getName() !=null? movie.getName().toLowerCase().contains( template.getName().toLowerCase() ): movie.getName() != null)
                .filter(movie -> template.getMinutes() != null? movie.getMinutes() <= template.getMinutes(): movie.getMinutes() > 0)
                .filter(movie -> template.getGenre() != null ? movie.getGenre().equals(template.getGenre() ): movie.getGenre() != null)
                .filter(movie -> template.getDirector() != null ? movie.getDirector().toLowerCase().contains( template.getDirector().toLowerCase()) : movie.getDirector() != null)
                .collect(Collectors.toList());
    }
}
