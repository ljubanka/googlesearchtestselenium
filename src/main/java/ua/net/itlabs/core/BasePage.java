package ua.net.itlabs.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage extends ConciseAPI {

    @FindBy(css = "[role='main'] .zA")
    public List<WebElement> emails;

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;//is this line correct?needed?
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
}
