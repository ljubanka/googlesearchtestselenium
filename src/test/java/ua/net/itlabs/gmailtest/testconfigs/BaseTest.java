package ua.net.itlabs.gmailtest.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.net.itlabs.core.ConciseAPI;
import ua.net.itlabs.core.Configuration;

public class BaseTest extends ConciseAPI {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
        Configuration.timeout = 16;
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
