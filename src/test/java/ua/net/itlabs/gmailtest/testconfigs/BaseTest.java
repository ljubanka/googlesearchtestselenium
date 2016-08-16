package ua.net.itlabs.gmailtest.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.net.itlabs.gmailtest.core.ConciseAPI;
import ua.net.itlabs.gmailtest.core.Configuration;

public class BaseTest extends ConciseAPI {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
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
