package com.twu.biblioteca.controller.shell;

import com.twu.biblioteca.controller.core.BookController;

import java.util.Map;
import java.util.Scanner;

public class CheckoutBookCommand implements MyCommand {

    private final BookController bookController;
    private final Map<String, MyCommand> mapper;

    public CheckoutBookCommand(BookController bookController,Map<String,MyCommand> mapper){
        this.bookController = bookController;
        this.mapper = mapper;
    }

    public String excute(Router router){
        String result = "";
        System.out.print(" *********************************************************\n");
        System.out.print(" *          Please input the id  of book                 *\n");
        System.out.print(" *********************************************************\n");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();
        boolean isSuccessful = bookController.CheckoutBook(bookId);
        if (isSuccessful){
            result += String.format(" *********************************************************\n");
            result += String.format(" *           Thank you!Enjoy the book                    *\n");
            result += String.format(" *********************************************************\n");
        }else {
            result += String.format(" *********************************************************\n");
            result += String.format(" *           That book is not available                  *\n");
            result += String.format(" *********************************************************\n");
        }

        result += String.format(" *                                1.Return the MainMenu  *\n");
        result += String.format(" *********************************************************\n");

        router.setCurrentMapper(mapper);
        return result;

    }
}
