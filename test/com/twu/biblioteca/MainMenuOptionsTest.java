package com.twu.biblioteca;

import com.twu.biblioteca.model.MainMenuOptions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MainMenuOptionsTest {
    MainMenuOptions mainMenuOptions;

    @Before
    public void setUp() throws Exception{
        mainMenuOptions = new MainMenuOptions();
    }

    @Test
    public void should_return_a_list_of_options_when_call_getOptions() throws Exception{
        List<String> options = mainMenuOptions.getOptions();
        assertThat(options.get(0),equalTo("List Book"));
        assertThat(options.get(1),equalTo("Checkout Book"));
        assertThat(options.get(2),equalTo("Return Book"));
        assertThat(options.get(3),equalTo("Quit"));
    }
}
