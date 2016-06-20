package com.twu.biblioteca.controller.command;

import com.twu.biblioteca.controller.commandRouter.Router;

public interface MyCommand {
    public String execute(Router router);
}
