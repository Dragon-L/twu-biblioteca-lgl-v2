package com.twu.biblioteca;

import com.twu.biblioteca.controller.core.MainMenu;
import com.twu.biblioteca.model.MainMenuOptions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class MainMenuTest {
    MainMenuOptions mainMenuOptions;

    MainMenu mainMenu;

    @Before
    public void setUp() throws Exception{
        mainMenuOptions = new MainMenuOptions();
        mainMenu = new MainMenu(mainMenuOptions.getOptions());
    }

    @Test
    public void should_return_mainMenuOptions_when_call_showMenu() throws Exception{
        List<String> options =  mainMenu.ShowMenu();
        assertThat(options.get(0),equalTo("List Book"));
        assertThat(options.get(1),equalTo("Checkout Book"));
        assertThat(options.get(2),equalTo("Return Book"));
        assertThat(options.get(3),equalTo("Quit"));
    }
}
