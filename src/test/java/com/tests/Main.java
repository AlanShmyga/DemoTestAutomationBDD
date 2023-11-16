package com.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    private static final String url = "https://duckduckgo.com/";
    private static final By DUCK_DUCK_GO_SEEARCH_INPUT = By.xpath("//input[@aria-label='Search with DuckDuckGo']");
    private static final By SEARCH_LINKS = By.id("links");
    private static final By SEARCH_RESULTS = By.className("nrn-react-div");

    @Test
    public void whenISearchForToptalOnDuckDuckGoIgetToptalAsTheFirstSearchResult() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement searchInput = driver.findElement(DUCK_DUCK_GO_SEEARCH_INPUT);
//        WebDriverWait driverWait = new WebDriverWait(driver, 100L);
//        driverWait.until(searchInput.isDisplayed())
        searchInput.clear();
        searchInput.sendKeys("toptal");
        searchInput.sendKeys(Keys.RETURN);
        driver.findElement(SEARCH_LINKS)
                .findElements(SEARCH_RESULTS)
                .stream()
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.toptal.com/");
        driver.close();
        driver.quit();
    }
}
