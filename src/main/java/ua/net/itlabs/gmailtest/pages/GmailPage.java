package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import ua.net.itlabs.core.BasePage;

public class GmailPage extends BasePage {
    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void vizit(String url) {
        open(url);
    }

    public void logIn(String email, String pass) {
        $("#Email").sendKeys(email);
        $("#next").click();
        $("#Passwd").sendKeys(pass);
        $("#signIn").click();
    }
}
