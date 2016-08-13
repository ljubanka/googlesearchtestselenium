package ua.net.itlabs.searchtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Arrays;
import java.util.List;

public class CustomConditions {
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
                return String.format("\nsize of list located by: %s\n to be: %s\n while actual size is: %s\n", elementsLocator, expectedSize, listSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> minimumSizeOf(final By elementsLocator, final int expectedSize){
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                listSize = elements.size();
                return listSize >= expectedSize;
            }

            public String toString() {
                return String.format("\nminimum size of list located by: %s\n to be: %s\n while actual size is: %s\n", elementsLocator, expectedSize, listSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> containText(final By elementsLocator, final String... expectedTexts) {
        return new ExpectedCondition<Boolean>() {
            private List<WebElement> elements;

            public Boolean apply(WebDriver webDriver) {
                elements = webDriver.findElements(elementsLocator);
                if (elements.size() != expectedTexts.length) {
                    return false;
                } else {
                    for (int i = 0; i < expectedTexts.length; ++i) {
                        WebElement element = elements.get(i);
                        String expectedText = expectedTexts[i];
                        if (!element.getText().contains(expectedText)) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            public String toString() {
                return String.format("Texts in list located by %s \n to be %s\n" , elementsLocator, Arrays.toString(expectedTexts));
            }
        };
    }

}
