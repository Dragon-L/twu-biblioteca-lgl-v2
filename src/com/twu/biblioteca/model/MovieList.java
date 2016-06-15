package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movie> movieList;

    public MovieList(Movies movies) {
        movieList = new ArrayList<Movie>();

        for (Movie movie:movies.getMovies()){
            if (movie.getIsBorrowed() == false){
                movieList.add(movie);
            }
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void updateMovieList(Movies movies){
        movieList.clear();

        for (Movie movie:movies.getMovies()){
            if (movie.getIsBorrowed() == false){
                movieList.add(movie);
            }
        }
    }

    public boolean removeMovie(String id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                movieList.remove(movie);
                return true;
            }
        }
        return false;
    }
}
