package ua.net.itlabs.searchtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static ua.net.itlabs.searchtest.CustomConditions.minimumSizeOf;
import static ua.net.itlabs.searchtest.CustomConditions.sizeOf;

public class GoogleSearchTest {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }

    @Test
    public void testSearchAndFollowLink() {
        driver.get("http://google.com/ncr");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Selenium automates browsers" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(sizeOf(By.cssSelector(searchResults), 10));
        wait.until(textToBePresentInElementLocated(By.cssSelector(searchResults + ":first-child"), "Selenium automates browsers"));

        followNthLink(0);
        wait.until(textToBePresentInElementLocated(By.cssSelector("#header>h1>a"), "Browser Automation"));
        wait.until(urlContains("http://www.seleniumhq.org/"));
    }

    @Test
    public void testFollowResultLink() {
        driver.get("http://google.com/ncr");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Selenium automates browsers" + Keys.ENTER);

        followNthLink(0);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(textToBePresentInElementLocated(By.cssSelector("#header>h1>a"), "Browser Automation"));
        wait.until(urlContains("http://www.seleniumhq.org/"));
    }

    public String searchResults = ".srg>.g";

    public void followNthLink(int index) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(minimumSizeOf(By.cssSelector(searchResults), index+1));
        driver.findElements(By.cssSelector(searchResults)).get(index).findElement(By.cssSelector(".r>a")).click();
    }

}
