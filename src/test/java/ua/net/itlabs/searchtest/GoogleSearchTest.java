package ua.net.itlabs.searchtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(sizeOf(By.cssSelector(".srg>.g"), 10));
        wait.until(textToBePresentInElementLocated(By.cssSelector(".srg>.g:first-child"), "Selenium automates browsers"));

        followNthLink(0);
        wait.until(textToBePresentInElementLocated(By.cssSelector("#header>h1>a"), "Browser Automation"));
        assertEquals("http://www.seleniumhq.org/", driver.getCurrentUrl());
    }

    public static ExpectedCondition<Boolean> textToBePresentInElementLocated(final By elementsLocator, final String text) {
        return new ExpectedCondition<Boolean>() {
            private WebElement element;

            public Boolean apply(WebDriver driver) {
                element = driver.findElement(elementsLocator);
                return element.getText().contains(text);
            }

            public String toString() {
                return String.format("\nelement: %s\n doesn't contain: %s\n", element, text);
            }
        };
    }

    public static ExpectedCondition<Boolean> sizeOf(final By elementsLocator, final int expectedSize){
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                listSize = elements.size();
                return listSize == expectedSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n to be: %s\n while actual size is: %s\n", elements, expectedSize, listSize);
            }
        };
    }

    public void followNthLink(int index) {
        driver.findElements(By.cssSelector(".srg>.g")).get(index).findElement(By.cssSelector(".r>a")).click();
    }

}
