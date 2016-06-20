package com.twu.biblioteca.controller.command;

import com.twu.biblioteca.controller.commandRouter.Router;

public class QuitCommand implements MyCommand{
    public String execute(Router router){
        System.out.print(" *********************************************************\n");
        System.out.print(" *                       Bye                             *\n");
        System.out.print(" *********************************************************\n");
        System.exit(0);
        return null;
    }
}
