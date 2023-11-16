package pageobjects;

import com.google.common.collect.ImmutableList;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final WebDriver driver;
    private static final String MAIN_PAGE_URL = "https://cucumber.io";

    private final static By NAVIGATION_ITEMS_LIST_LINKS = By.xpath("//li[starts-with(@class, 'nav-item')]/a");
    private final static By ALLOW_ALL_COOKIES_BUTTON = By.xpath("//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary']");

    private MainPage(WebDriver driver){
        this.driver = driver;
    }

    public static MainPage openMainPage() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(MAIN_PAGE_URL);
        driver.findElement(ALLOW_ALL_COOKIES_BUTTON).click();
        return new MainPage(driver);
    }

    public ImmutableList<String> getNavigationBlocks() {
        return driver.findElements(NAVIGATION_ITEMS_LIST_LINKS).stream()
                .map(WebElement::getText)
                .collect(ImmutableList.toImmutableList());
    }
}
