package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ua.net.itlabs.core.ConciseAPI;

import static ua.net.itlabs.core.CustomConditions.listNthElementHasText;
import static ua.net.itlabs.core.CustomConditions.texts;

public class Mails extends ConciseAPI {

    public static void send(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public  static void assertMail(int index, String text) {
        assertThat(listNthElementHasText(emails, index, text));
    }

    public static void assertMails(String... emailTexts) {
        assertThat(texts(emails, emailTexts));
    }

    public static void searchBySubject(String text) {
        $(By.name("q")).sendKeys("subject: " + text + Keys.ENTER);
    }

    public static By emails = By.cssSelector("[role='main'] .zA");
}
