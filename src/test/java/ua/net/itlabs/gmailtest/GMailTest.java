package ua.net.itlabs.gmailtest;

import org.junit.Test;
import ua.net.itlabs.gmailtest.pages.GmailPage;
import ua.net.itlabs.gmailtest.pages.Mails;
import ua.net.itlabs.gmailtest.pages.Menu;
import ua.net.itlabs.gmailtest.testconfigs.BaseTest;

import static ua.net.itlabs.gmailtest.core.Helpers.getUniqueText;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class GMailTest extends BaseTest {
    GmailPage gmailPage = new GmailPage(getWebDriver());
    Mails mails = new Mails(getWebDriver());
    Menu menu = new Menu(getWebDriver());

    @Test
    public void testSendAndSearchEmail()  {
        gmailPage.vizit("http://gmailPage.com");

        gmailPage.logIn(email, password);
        String subject  = getUniqueText("Autotest email ");
        mails.send(email, subject);

        menu.refresh();
        mails.assertMail(0, subject);

        menu.goToSent();
        mails.assertMail(0, subject);

        menu.goToInbox();
        mails.searchBySubject(subject);
        mails.assertMails(subject);
    }









}
