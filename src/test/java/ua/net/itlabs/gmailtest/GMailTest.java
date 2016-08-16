package ua.net.itlabs.gmailtest;

import org.junit.Test;
import ua.net.itlabs.gmailtest.pages.Gmail;
import ua.net.itlabs.gmailtest.pages.Mails;
import ua.net.itlabs.gmailtest.pages.Menu;
import ua.net.itlabs.gmailtest.testconfigs.BaseTest;

import static ua.net.itlabs.gmailtest.core.Helpers.getUniqueText;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class GMailTest extends BaseTest {

    @Test
    public void testSendAndSearchEmail()  {
        open("http://gmail.com");

        Gmail gmail = new Gmail(getWebDriver());
        Mails mails = new Mails(getWebDriver());
        Menu menu = new Menu(getWebDriver());

        gmail.logIn(email, password);
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
