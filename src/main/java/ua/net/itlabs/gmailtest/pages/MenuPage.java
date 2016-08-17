package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import ua.net.itlabs.gmailtest.core.BasePage;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }
    public void refresh() {
        $(".nu").click();
    }

    public void goToSent() {
        $(byText("Sent Mail")).click();
    }

    public void goToInbox() {
        $(byText("Inbox")).click();
    }
}
