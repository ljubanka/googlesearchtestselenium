package ua.net.itlabs.core;

import com.google.common.base.Function;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> sizeOf(final By elementsLocator, final int expectedSize){
            return elementExceptionsCatcher(new ExpectedCondition<Boolean>() {
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
            });
        }

        public static ExpectedCondition<Boolean> minimumSizeOf(final By elementsLocator, final int expectedSize){
            return elementExceptionsCatcher(new ExpectedCondition<Boolean>() {
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
            });
        }

        public static ExpectedCondition<List<WebElement>> texts(final By elementsLocator, final String... expectedTexts) {
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {
            private List<WebElement> elements;
            private List<String> texts;

            public List<WebElement> apply(WebDriver webDriver) {
                elements = webDriver.findElements(elementsLocator);
                texts = Helpers.getTexts(elements);
                if (texts.size() != expectedTexts.length) {
                    return null;
                }
                for (int i = 0; i < texts.size(); i++) {
                    if (!texts.get(i).contains(expectedTexts[i])) {
                        return null;
                    }
                }
                return elements;
            }

            public String toString() {
                return String.format("texts in list to be %s \n while actual texts are %s \n" , StringUtils.join(expectedTexts, ", "), StringUtils.join(texts, ", "));
            }
        });
    }

    public static ExpectedCondition<WebElement> listNthElementHasText(final By elementsLocator, final int index, final String expectedText) {
        return elementExceptionsCatcher(new ExpectedCondition<WebElement>() {
            private List<WebElement> elements;
            private List<String> texts;

            public WebElement apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                texts = Helpers.getTexts(elements);
                if (texts.get(index).contains(expectedText)) {
                    return elements.get(index);
                }
                return null;
            }

            public String toString() {
                return String.format("Text in %s-th element in list %s \n to be %s\n" , index, StringUtils.join(texts, ", "), expectedText);
            }
        });
    }

    public static <V> ExpectedCondition<V> elementExceptionsCatcher(final Function<? super WebDriver, V> condition) {
        return new ExpectedCondition<V>() {
            public V apply(WebDriver input) {
                try {
                    return condition.apply(input);
                } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return condition.toString();
            }
        };
    }

    }
