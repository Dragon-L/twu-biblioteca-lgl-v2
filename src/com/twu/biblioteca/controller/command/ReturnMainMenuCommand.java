package com.twu.biblioteca.controller.command;

import com.twu.biblioteca.controller.commandRouter.Router;
import com.twu.biblioteca.controller.core.MainMenu;

public class ReturnMainMenuCommand implements MyCommand{
    private final MainMenu mainMenu;

    public ReturnMainMenuCommand(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

    public String execute(Router router){
        String result = "";
        result += String.format(" *********************************************************\n");
        result += String.format(" *                       MainMenu                        *\n");
        result += String.format(" *********************************************************\n");
        Integer index = 1;

        if (router.getUser() == null){
            result += String.format(" *                %d . %-34s *\n",index,"Login Account");
        }else{
            result += String.format(" *                %d . %-34s *\n",index,"Show Account Information");
        }

        for (String str: mainMenu.ShowMenu()){
            index++;
            result += String.format(" *                %d . %-34s *\n",index,str);
        }


        result += String.format(" *********************************************************\n");

        router.setOriginMapper();
        return result;
    }

}
