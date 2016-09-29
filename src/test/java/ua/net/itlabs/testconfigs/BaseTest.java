package ua.net.itlabs.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.ConciseAPI.setWebDriver;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        setWebDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void finish() {
        getWebDriver().quit();
    }

}
