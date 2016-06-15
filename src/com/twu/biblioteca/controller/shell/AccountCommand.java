package com.twu.biblioteca.controller.shell;

import com.twu.biblioteca.model.Account;
import com.twu.biblioteca.model.Accounts;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountCommand implements MyCommand {

    private Accounts accounts;
    private Map<String,MyCommand> mapper;

    public AccountCommand(Accounts accounts,Map<String,MyCommand> mapper){
        this.accounts = accounts;
        this.mapper = mapper;
    }


    public String excute(Router router){
        if (router.getUser() == null){
            return excuteLogin(router);
        }else {
            return excuteShowAccountInformation(router);
        }
    }

    private String excuteShowAccountInformation(Router router) {
        String result = "";

        result += String.format(" *********************************************************\n");
        result += String.format(" *                Account Information                    *\n");
        result += String.format(" *********************************************************\n");
        result += String.format(" *      Name     *    Email Address   *   Phone Number   *\n");
        result += String.format(" *********************************************************\n");
        result += String.format(" *  %-5s *  %-16s  *  %-15s *\n",router.getUser().getName(),router.getUser().getEmailAddress(),router.getUser().getPhoneNumber());
        result += String.format(" *********************************************************\n");
        result += String.format(" *                                1.Return the MainMenu  *\n");
        result += String.format(" *********************************************************\n");
        router.setCurrentMapper(mapper);

        return result;
    }

    private String excuteLogin(Router router){
        String result = "";
        System.out.print(" *********************************************************\n");
        System.out.print(" *          Please input the your library number         *\n");
        System.out.print(" *********************************************************\n");
        Scanner scanner = new Scanner(System.in);
        String libraryNumber = scanner.nextLine();
        for (Account account:accounts.getUsers()){
            if (account.getLibraryNumber().equals(libraryNumber)){
                router.setUser(account);
                result += String.format(" *********************************************************\n");
                result += String.format(" *                 Login Successfully!                   *\n");
                result += String.format(" *********************************************************\n");
            }
        }
        result += String.format(" *                                1.Return the MainMenu  *\n");
        result += String.format(" *********************************************************\n");

        router.setCurrentMapper(mapper);
        return result;
    }
}
