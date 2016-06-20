package com.twu.biblioteca.controller.command;

import com.twu.biblioteca.controller.commandRouter.Router;
import com.twu.biblioteca.controller.core.MovieController;

import java.util.Map;
import java.util.Scanner;

public class CheckoutMovieCommand implements MyCommand {

    private final MovieController movieController;
    private final Map<String, MyCommand> mapper;

    public CheckoutMovieCommand(MovieController movieController, Map<String,MyCommand> mapper){
        this.movieController = movieController;
        this.mapper = mapper;
    }

    public String execute(Router router){
        String result = "";
        System.out.print(" *********************************************************\n");
        System.out.print(" *          Please input the id  of movie                *\n");
        System.out.print(" *********************************************************\n");
        Scanner scanner = new Scanner(System.in);
        String movieId = scanner.nextLine();
        boolean isSuccessful = movieController.CheckoutMovie(movieId);
        if (isSuccessful){
            result += String.format(" *********************************************************\n");
            result += String.format(" *           Thank you!Enjoy the movie                   *\n");
            result += String.format(" *********************************************************\n");
        }else {
            result += String.format(" *********************************************************\n");
            result += String.format(" *           That movie is not available                 *\n");
            result += String.format(" *********************************************************\n");
        }

        result += String.format(" *                                1.Return the MainMenu  *\n");
        result += String.format(" *********************************************************\n");

        router.setCurrentMapper(mapper);
        return result;

    }
}
