package ua.net.itlabs.gmailtest.pages;

import static ua.net.itlabs.core.ConciseAPI.*;

public class Gmail {

    public static void vizit() {
        open("http://gmail.com");
    }

    public static void logIn(String email, String pass) {
        $("#Email").sendKeys(email);
        $("#next").click();
        $("#Passwd").sendKeys(pass);
        $("#signIn").click();
    }
}
