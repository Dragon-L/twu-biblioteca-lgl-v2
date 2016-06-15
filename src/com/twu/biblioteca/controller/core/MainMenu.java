package com.twu.biblioteca.controller.core;

import com.twu.biblioteca.model.MainMenuOptions;

import java.util.List;

public class MainMenu {

    private final List<String> mainMenuOptions;

    public MainMenu(List<String> mainMenuOptions) {
        this.mainMenuOptions = mainMenuOptions;
    }

    public List<String> ShowMenu() {
        return mainMenuOptions;
    }
}
