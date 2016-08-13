package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ua.net.itlabs.gmailtest.ConciseAPI;

public class BasePage extends ConciseAPI {

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
}
