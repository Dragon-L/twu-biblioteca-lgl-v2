package com.twu.biblioteca.controller.core;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.MovieList;
import com.twu.biblioteca.model.Movies;

import java.util.List;

public class MovieController {
    private Movies movies;
    private MovieList movieList;

    public MovieController(Movies movies,MovieList movieList){
        this.movies = movies;
        this.movieList = movieList;
    }

    public boolean CheckoutMovie(String id) {
        if (movies.CheckoutMovie(id)){
            movieList.updateMovieList(movies);
            return true;
        }
        return false;
    }

    public boolean ReturnMovie(String id) {
        if (movies.ReturnMovie(id)){
            movieList.updateMovieList(movies);
            return true;
        }
        return false;
    }

    public List<Movie> getMovieList(){
        return movieList.getMovieList();
    }
}
