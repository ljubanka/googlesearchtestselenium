package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.net.itlabs.core.BasePage;

import java.util.List;

import static ua.net.itlabs.core.CustomConditions.listNthElementHasText;
import static ua.net.itlabs.core.CustomConditions.texts;

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

    public  void assertMail(BasePage page, int index, String text) {
        assertThat(listNthElementHasText(page.emails, index, text));
    }

    public void assertMails(BasePage page, String... emailTexts) {
        assertThat(texts(page.emails, emailTexts));
    }

    public void searchBySubject(String text) {
        $(By.name("q")).sendKeys("subject: " + text + Keys.ENTER);
    }

    //public By emails = By.cssSelector("[role='main'] .zA");
}
