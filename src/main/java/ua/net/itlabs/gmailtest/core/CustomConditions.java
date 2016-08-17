package ua.net.itlabs.gmailtest.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.net.itlabs.gmailtest.core.Helpers.getTexts;

public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> texts(final By elementsLocator, final String... expectedTexts) {
        return new ExpectedCondition<List<WebElement>>() {
            private List<WebElement> elements;
            private List<String> texts;

            public List<WebElement> apply(WebDriver webDriver) {
                elements = webDriver.findElements(elementsLocator);
                texts = new ArrayList<String>();

                texts = getTexts(elements);

                if (texts.size() == expectedTexts.length) {
                    for (int i = 0; i < texts.size(); i++) {
                        if (!texts.get(i).contains(expectedTexts[i])) {
                            return null;
                        }
                    }
                    return elements;
                } else {
                    return null;
                }
            }

            public String toString() {
                return String.format("texts in list to be %s \n while actual texts are %s \n" , expectedTexts.toString(), texts);
            }

        };
    }



    public static ExpectedCondition<WebElement> listNthElementHasText(final By elementsLocator, final int index, final String expectedText) {
        return new ExpectedCondition<WebElement>() {
            private List<WebElement> elements;
            private List<String> texts;

            public WebElement apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                texts = new ArrayList<String>();

                texts = getTexts(elements);

                try {
                    if (texts.get(index).contains(expectedText)) {
                        return elements.get(index);
                    }
                }
                catch (IndexOutOfBoundsException e) {
                }
                return null;
            }

            public String toString() {
                return String.format("Text in %s-th element in list %s \n to be %s\n" , index, texts, expectedText);
            }
        };
    }

}
