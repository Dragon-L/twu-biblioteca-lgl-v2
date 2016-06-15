package com.twu.biblioteca.controller.shell;

public class QuitCommand implements MyCommand{
    public String excute(Router router){
        System.out.print(" *********************************************************\n");
        System.out.print(" *                       Bye                             *\n");
        System.out.print(" *********************************************************\n");
        System.exit(0);
        return null;
    }
}
