package com;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    private MainPage mainPage;

    public StepDefinitions() {
    }

    @When("I open main page")
    public void i_open_main_page() {
        mainPage = MainPage.openMainPage();
    }

    @Then("I see {}, {}, {}, {}, {}, {} and {} navigation items")
    public void iSeeMainNavigationResourcesBlocks(String... params) {
        assertThat(mainPage.getNavigationBlocks()).containsExactly("Tools", "Docs", "Learn BDD", "Resources");
    }
}
