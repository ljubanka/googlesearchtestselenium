package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import ua.net.itlabs.core.BasePage;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }
    public void refresh() {
        $(".nu").click();
    }

    public void goToSent() {
        $(byTitle("Sent Mail")).click();
    }

    public void goToInbox() {
        $(byTitle("Inbox")).click();
    }
}
