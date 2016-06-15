package com.twu.biblioteca;

import com.twu.biblioteca.controller.Controller;
import com.twu.biblioteca.controller.core.BookController;
import com.twu.biblioteca.controller.core.MainMenu;
import com.twu.biblioteca.controller.core.MovieController;
import com.twu.biblioteca.controller.shell.*;
import com.twu.biblioteca.model.*;

import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {
    private static Books books = new Books();
    private static Movies movies = new Movies();
    private static BookList bookList = new BookList(books);
    private static MovieList movieList = new MovieList(movies);
    private static MainMenuOptions mainMenuOptions= new MainMenuOptions();
    private static MainMenu mainMenu = new MainMenu(mainMenuOptions.getOptions());
    private static BookController bookController = new BookController(books,bookList);
    private static MovieController movieController = new MovieController(movies,movieList);

    private static Accounts accounts = new Accounts();

    public static void main(String[] args) {
        MyCommand rootCommand = new ReturnMainMenuCommand(mainMenu);


        final Map<String,MyCommand> returnMainMenuMapper = new HashMap<String, MyCommand>(){
            {
                put("1",new ReturnMainMenuCommand(mainMenu));
            }
        };

        final Map<String,MyCommand> bookListMapper = new HashMap<String, MyCommand>(){
            {
                put("1",new CheckoutBookCommand(bookController,returnMainMenuMapper));
                put("2",new ReturnBookCommand(bookController,returnMainMenuMapper));
                put("3",new ReturnMainMenuCommand(mainMenu));
            }
        };

        final Map<String,MyCommand> movieListMapper = new HashMap<String, MyCommand>(){
            {
                put("1",new CheckoutMovieCommand(movieController,returnMainMenuMapper));
                put("2",new ReturnMovieCommand(movieController,returnMainMenuMapper));
                put("3",new ReturnMainMenuCommand(mainMenu));
            }
        };

        Map<String,MyCommand> mainMenuMapper = new HashMap<String, MyCommand>(){
            {
                put("1",new AccountCommand(accounts,returnMainMenuMapper));
                put("2",new ListBookCommand(bookController,bookListMapper));
                put("3",new ListMovieCommand(movieController,movieListMapper));
                put("4",new QuitCommand());
            }
        };

        Router router = new Router(mainMenuMapper,rootCommand);
        Controller controller = new Controller(router);

        controller.Start();
    }
}
