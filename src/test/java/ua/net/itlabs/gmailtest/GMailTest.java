package ua.net.itlabs.gmailtest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ua.net.itlabs.gmailtest.pages.Gmail;
import ua.net.itlabs.gmailtest.pages.Mails;
import ua.net.itlabs.gmailtest.pages.Menu;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static ua.net.itlabs.Helpers.getUniqueText;
import static ua.net.itlabs.searchtest.CustomConditions.containText;
import static ua.net.itlabs.searchtest.CustomConditions.minimumSizeOf;
import static ua.net.itlabs.testdata.LoginData.email;
import static ua.net.itlabs.testdata.LoginData.password;

public class GMailTest extends BaseTest{



    @Test
    public void testSendAndSearchEmail()  {
        driver.get("http://gmail.com");

        //login
        $(By.cssSelector("#Email")).sendKeys(email);
        $(By.cssSelector("#next")).click();
        $(By.cssSelector("#Passwd")).sendKeys(password);
        $(By.cssSelector("#signIn")).click();

        String subject  = getUniqueText("Autotest email ");

        //send email
        $(By.cssSelector(".z0>:nth-child(1)")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        $(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();

        //menu refresh
        $(By.cssSelector(".nu")).click();
        wait.until(minimumSizeOf(By.cssSelector(emails), 1));
        wait.until(textToBePresentInElementLocated(By.cssSelector(emails + ":first-child"), subject));

        //goto Sent
        $(By.cssSelector("a[href$='sent']")).click();
        wait.until(minimumSizeOf(By.cssSelector(emails), 1));
        wait.until(textToBePresentInElementLocated(By.cssSelector(emails + ":first-child"), subject));
        //assertMail(0, subject);

        //goto inbox
        $(By.cssSelector("a[href$='inbox']")).click();

        //search by subject
        $(By.name("q")).sendKeys("subject: " + subject + Keys.ENTER);

        //should there be wait.until 1(+) email is loaded???

        wait.until(containText(By.cssSelector(emails), subject));
        //assertMails(subject);
    }

    public String emails = "[role='main'] .zA";

    public  void assertMail(int index, String text) {
        wait.until(minimumSizeOf(By.cssSelector(emails), index+1));
        wait.until(textToBePresentInElementLocated(By.cssSelector(emails + ":nth-child(" + Integer.toString(index+1) + ")"), text));
  }
    public void assertMails(String... emailTexts) {
        wait.until(containText(By.cssSelector(emails), emailTexts));
    }



}
