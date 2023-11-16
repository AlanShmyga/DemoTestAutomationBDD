package utilities;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class ScenarioContext {

    private final WebDriver driver;

    public ScenarioContext() {
        this.driver = DriverManager.getDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
