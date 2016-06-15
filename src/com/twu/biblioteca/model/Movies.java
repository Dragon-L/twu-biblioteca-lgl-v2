package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> movies;

    public Movies(){
        movies = new ArrayList<Movie>();
        movies.add(new Movie("12","Warcraft1","Blizzard","8.9",false));
        movies.add(new Movie("23","Warcraft2","Blizzard","9.0",false));
        movies.add(new Movie("34","Warcraft3","Blizzard","9.1",false));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public boolean CheckoutMovie(String id){
        for (Movie movie:movies){
            if (movie.getId().equals(id) && !movie.getIsBorrowed()){
                movie.setIsBorrowed(true);
                return true;
            }
        }
        return false;
    }

    public boolean ReturnMovie(String id){
        for (Movie movie:movies){
            if (movie.getId().equals(id) && movie.getIsBorrowed()){
                movie.setIsBorrowed(false);
                return true;
            }
        }
        return false;
    }
}

