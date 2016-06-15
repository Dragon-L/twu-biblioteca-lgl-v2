package com.twu.biblioteca.controller.shell;

import com.twu.biblioteca.controller.core.MainMenu;

public class ReturnMainMenuCommand implements MyCommand{
    private final MainMenu mainMenu;

    public ReturnMainMenuCommand(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

    public String excute(Router router){
        String result = "";
        result += String.format(" *********************************************************\n");
        result += String.format(" *                       MainMenu                        *\n");
        result += String.format(" *********************************************************\n");
        Integer index = 1;
        for (String str: mainMenu.ShowMenu()){
            result += String.format(" *                %d . %-34s *\n",index,str);
            index++;
        }
        result += String.format(" *********************************************************\n");

        router.setOriginMapper();
        return result;
    }

}
