package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ua.net.itlabs.gmailtest.core.BasePage;

import static ua.net.itlabs.gmailtest.core.CustomConditions.listNthElementHasText;
import static ua.net.itlabs.gmailtest.core.CustomConditions.texts;

public class MailsPage extends BasePage {
    public MailsPage(WebDriver driver) {
        super(driver);
    }

    public void send(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public  void assertMail(int index, String text) {
        assertThat(listNthElementHasText(emails, index, text));
    }

    public void assertMails(String... emailTexts) {
        assertThat(texts(emails, emailTexts));
    }

    public void searchBySubject(String text) {
        $(By.name("q")).sendKeys("subject: " + text + Keys.ENTER);
    }

    public By emails = By.cssSelector("[role='main'] .zA");
}
