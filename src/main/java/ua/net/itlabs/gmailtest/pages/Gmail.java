package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import ua.net.itlabs.gmailtest.core.BasePage;

public class Gmail extends BasePage {
    public Gmail(WebDriver driver) {
        super(driver);
    }

    public void logIn(String email, String pass) {
        $("#Email").sendKeys(email);
        $("#next").click();
        $("#Passwd").sendKeys(pass);
        $("#signIn").click();
    }
}
