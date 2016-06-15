package com.twu.biblioteca.controller.shell;

import com.twu.biblioteca.controller.core.MovieController;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.Map;

public class ListMovieCommand implements MyCommand {
    private MovieController movieController;
    private final Map<String, MyCommand> mapper;

    public ListMovieCommand(MovieController movieController, Map<String,MyCommand> mapper){
        this.movieController = movieController;
        this.mapper = mapper;
    }

    public String excute(Router router){
        String result = "";

        result += String.format(" *********************************************************\n");
        result += String.format(" *                       Movie List                      *\n");
        result += String.format(" *********************************************************\n");
        result += String.format(" *  id *         Name        *       Author    *  Year   *\n");
        result += String.format(" *********************************************************\n");

        List<Movie> movieList = movieController.getMovieList();

        for (Movie movie:movieList){
            result += String.format(" *  %-2s *  %-18s *  %-13s  *  %-5s  *\n",movie.getId(),movie.getName(),movie.getDirector(),movie.getRating());
        }
        result += String.format(" *********************************************************\n");
        result += String.format(" *1.Checkout Movie *2.Return Movie *3.Return the MainMenu*\n");
        result += String.format(" *********************************************************\n");
        router.setCurrentMapper(mapper);

        return result;
    }
}
