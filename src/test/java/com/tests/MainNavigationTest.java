package com.tests;

import com.google.common.collect.ImmutableList;
import managers.DriverManager;
import org.junit.After;
import org.junit.Test;
import pageobjects.MainPage;

import static org.assertj.core.api.Assertions.assertThat;


public class MainNavigationTest {

    @After
    public void tearDown() {
        DriverManager.teardownDriver();
    }

    @Test
    public void whenIGetToTheMainPageISeeNavigationItems() {
        ImmutableList<String> actualNavigationBlocks = MainPage.openMainPage().getNavigationBlocks();

        assertThat(actualNavigationBlocks)
                .containsExactly("Tools", "Docs", "Learn BDD", "Resources", "Search", "Login");
    }
}
