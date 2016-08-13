package ua.net.itlabs.gmailtest.pages;


import org.openqa.selenium.WebDriver;

public class Gmail extends BasePage{
    public Gmail(WebDriver driver) {
        super(driver);
    }

    public void vizit() {
        open("http://gmail.com");
    }

    public static void logIn(String email, String pass) {
//        $("#Email").setValue(email);
//        $("#next").click();
//        $("#Passwd").setValue(pass);
//        $("#signIn").click();
    }
}
