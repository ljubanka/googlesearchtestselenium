package ua.net.itlabs.core;

import org.openqa.selenium.WebDriver;

public class BasePage extends ConciseAPI {

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
}
