package com.jrsaavedra.javatests.movies.service;

import com.jrsaavedra.javatests.movies.data.MovieRepository;
import com.jrsaavedra.javatests.movies.model.Genre;
import com.jrsaavedra.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static com.jrsaavedra.javatests.movies.model.Genre.*;

public class MovieServiceShould {
    private MovieService movieService;
    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, "director 1", ACTION),
                        new Movie(2, "Memento", 113, "director 2", THRILLER),
                        new Movie(3, "There's Something About Mary", 119, "director 1",COMEDY),
                        new Movie(4, "Super 8", 112, "director 2", THRILLER),
                        new Movie(5, "Scream", 111, "director 1", HORROR),
                        new Movie(6, "Home Alone", 103, "director 2", COMEDY),
                        new Movie(7, "Matrix", 136, "director 1", ACTION),
                        new Movie(8, "Superman", 140, "director 2", ACTION)
                )
        );
        this.movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        //comprobar peliculas indicaas
        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));

    }

    @Test
    public void return_movies_by_length(){
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        //comprobar peliculas por duracion
        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
    }

    @Test
    public void return_movies_by_name(){
        Collection<Movie> movies = movieService.findMovieByName("super");
        //comprobar las películas por su nombre
        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(4, 8)));
    }

    @Test
    public void return_movies_by_director(){
        Collection<Movie> movies = movieService.findMovieByDirector("Director 1");
        //comprobar las peliculas por director
        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(1,3,5,7)));
    }

    @Test
    public void return_movies_by_various_fields(){
        String name = null; // no queremos buscar por nombre
        Integer minutes = 150; // 2h 30m
        String director = null; // no queremos buscar por director
        Genre genre = Genre.ACTION;
        Movie template = new Movie(name, minutes, director, genre);
        Collection<Movie> movies = movieService.findMoviesByTemplate(template);
        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(7, 8)) );
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }

}