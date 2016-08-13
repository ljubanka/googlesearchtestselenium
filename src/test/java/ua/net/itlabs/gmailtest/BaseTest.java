package ua.net.itlabs.gmailtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest extends ConciseAPI {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 120);
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
