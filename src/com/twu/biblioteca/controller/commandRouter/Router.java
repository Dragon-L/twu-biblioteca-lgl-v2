package com.twu.biblioteca.controller.commandRouter;

import com.twu.biblioteca.controller.command.MyCommand;
import com.twu.biblioteca.model.Account;

import java.util.Map;

public class Router {
    private MyCommand rootCommand;
    private Map<String,MyCommand> originMapper;
    private Map<String,MyCommand> currentMapper;

    private Account user;

    public Router(Map<String,MyCommand> mapper,MyCommand rootCommand){
        this.originMapper = mapper;
        this.currentMapper = mapper;
        this.rootCommand = rootCommand;
        user = null;
    }


    public MyCommand getCommand(String str){
        return currentMapper.get(str);
    }

    public void setCurrentMapper(Map<String,MyCommand> mapper){
        currentMapper = mapper;
    }

    public void setOriginMapper(){ currentMapper = originMapper; }

    public String excuteRootCommand(){
        return rootCommand.execute(this);
    }

    public Account getUser(){
        return user;
    }

    public void setUser(Account user){
        this.user = user;
    }
}
