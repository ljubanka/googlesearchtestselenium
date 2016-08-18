package ua.net.itlabs.core;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public void open(String url) {
        getWebDriver().get(url);
    }

    public WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator));
    }

    public WebElement $(String cssSelector){
        return $(By.cssSelector(cssSelector));
    }

    public By byText(String elementText) {
        return By.xpath("//*[text()='" + elementText + "']");
    }

    public By byTitle(String title) {
        return By.xpath("//*[starts-with(@title,'" + title + "')]");
    }

//        super(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");

    public <V> V assertThat(Function<? super WebDriver, V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public <V> V assertThat(Function<? super WebDriver, V> condition, int timeout) {
        return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

}
