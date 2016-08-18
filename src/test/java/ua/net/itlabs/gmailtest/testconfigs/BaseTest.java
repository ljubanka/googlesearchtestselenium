package ua.net.itlabs.gmailtest.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.net.itlabs.core.ConciseAPI;
import ua.net.itlabs.core.Configuration;

public class BaseTest extends ConciseAPI {

    @BeforeClass
    public static void setup() {
        WebDriver driver = new FirefoxDriver();
        setWebDriver(driver);
    }

    @AfterClass
    public static void finish() {
        getWebDriver().quit();
    }

}
