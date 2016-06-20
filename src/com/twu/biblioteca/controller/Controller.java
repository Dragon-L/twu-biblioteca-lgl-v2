package com.twu.biblioteca.controller;

import com.twu.biblioteca.controller.command.MyCommand;
import com.twu.biblioteca.controller.commandRouter.Router;

import java.util.Scanner;

public class Controller {
    private Router router;

    public Controller(Router router){
        this.router = router;
    }

    public void Start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println(router.excuteRootCommand());

        MyCommand command;
        while (true){
            do {
                String command1 = scanner.nextLine();
                command = router.getCommand(command1);

                if (command == null){
                    System.out.print(" *********************************************************\n");
                    System.out.print(" *                Select a valid option!                 *\n");
                    System.out.print(" *********************************************************\n");
                }
            }while (command == null);

            String outputMessage = command.execute(router);
            System.out.println(outputMessage);
        }
    }

}
