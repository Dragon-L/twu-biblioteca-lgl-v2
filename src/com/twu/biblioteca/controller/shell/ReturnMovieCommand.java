package com.twu.biblioteca.controller.shell;

import com.twu.biblioteca.controller.core.MovieController;

import java.util.Map;
import java.util.Scanner;

public class ReturnMovieCommand implements MyCommand{
    private final MovieController movieController;
    private final Map<String, MyCommand> mapper;

    public ReturnMovieCommand(MovieController movieController, Map<String,MyCommand> mapper){
        this.movieController = movieController;
        this.mapper = mapper;
    }

    public String excute(Router router){
        String result = "";
        System.out.print(" *********************************************************\n");
        System.out.print(" *          Please input the id  of movie                 *\n");
        System.out.print(" *********************************************************\n");
        Scanner scanner = new Scanner(System.in);
        String movieId = scanner.nextLine();
        boolean isSuccessful = movieController.ReturnMovie(movieId);
        if (isSuccessful){
            result += String.format(" *********************************************************\n");
            result += String.format(" *           Thank you for returning the movie           *\n");
            result += String.format(" *********************************************************\n");
        }else {
            result += String.format(" *********************************************************\n");
            result += String.format(" *          That is not a valid movie to return           *\n");
            result += String.format(" *********************************************************\n");
        }

        result += String.format(" *                                1.Return the MainMenu  *\n");
        result += String.format(" *********************************************************\n");


        router.setCurrentMapper(mapper);

        return result;
    }
}
