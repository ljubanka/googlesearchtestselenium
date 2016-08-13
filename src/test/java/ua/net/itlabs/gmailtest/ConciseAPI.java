package ua.net.itlabs.gmailtest;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
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

    public List<WebElement> $$(By locator) {
        return assertThat(visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> $$(String cssSelector) {
        return $$(By.cssSelector(cssSelector));
    }

    public <V> V assertThat(Function<? super WebDriver, V> condition) {
        return (new WebDriverWait(getWebDriver(), 8)).until(condition);
    }

}
