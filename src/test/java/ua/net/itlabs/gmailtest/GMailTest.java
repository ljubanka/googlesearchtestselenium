package ua.net.itlabs.gmailtest;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.net.itlabs.core.Configuration;
import ua.net.itlabs.gmailtest.pages.GmailPage;
import ua.net.itlabs.gmailtest.pages.MailsPage;
import ua.net.itlabs.gmailtest.pages.MenuPage;
import ua.net.itlabs.gmailtest.testconfigs.BaseTest;

import static ua.net.itlabs.core.Helpers.getUniqueText;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class GMailTest extends BaseTest {

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 16;
    }

    GmailPage gmail = new GmailPage(getWebDriver());
    MailsPage mails = new MailsPage(getWebDriver());
    MenuPage menu = new MenuPage(getWebDriver());

    @Test
    public void testSendAndSearchEmail()  {
        Configuration.timeout = 16;
        gmail.vizit();

        gmail.logIn(email, password);
        String subject  = getUniqueText("Autotest email ");

        mails.send(email, subject);

        menu.refresh();

        menu.goToSent();
        mails.assertMail(0, subject);

        menu.goToInbox();
        mails.searchBySubject(subject);
        mails.assertMails(subject);
    }

}
