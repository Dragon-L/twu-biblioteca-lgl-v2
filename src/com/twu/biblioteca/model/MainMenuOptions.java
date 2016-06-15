package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class MainMenuOptions {
    private static List<String> options;

    public MainMenuOptions(){
        this.options = new ArrayList<String>();
        options.add("List Books");
        options.add("List Movies");
        options.add("Quit");
    }


    public List<String> getOptions(){
        return options;
    }


}
