package com.twu.biblioteca;

import com.twu.biblioteca.controller.Controller;
import com.twu.biblioteca.controller.core.BookController;
import com.twu.biblioteca.controller.core.MainMenu;
import com.twu.biblioteca.controller.shell.*;
import com.twu.biblioteca.model.BookList;
import com.twu.biblioteca.model.Books;
import com.twu.biblioteca.model.MainMenuOptions;

import java.util.HashMap;
import java.util.Map;

public class BibliotecaApp {
    private static Books books = new Books();
    private static BookList bookList = new BookList(books);
    private static MainMenuOptions mainMenuOptions= new MainMenuOptions();
    private static MainMenu mainMenu = new MainMenu(mainMenuOptions.getOptions());
    private static BookController bookController = new BookController(books,bookList);



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

        Map<String,MyCommand> mainMenuMapper = new HashMap<String, MyCommand>(){
            {
                put("1",new ListBookCommand(bookController,bookListMapper));
                put("2",new QuitCommand());
            }
        };

        Router router = new Router(mainMenuMapper,rootCommand);
        Controller controller = new Controller(router);

        controller.Start();
    }
}
