package ua.net.itlabs.gmailtest;

import org.junit.Test;
import ua.net.itlabs.core.Configuration;
import ua.net.itlabs.gmailtest.testconfigs.BaseTest;

import static ua.net.itlabs.core.Helpers.getUniqueText;
import static ua.net.itlabs.gmailtest.pages.Gmail.*;
import static ua.net.itlabs.gmailtest.pages.Mails.*;
import static ua.net.itlabs.gmailtest.pages.Menu.*;
import static ua.net.itlabs.gmailtest.testdata.LoginData.email;
import static ua.net.itlabs.gmailtest.testdata.LoginData.password;

public class GMailTest extends BaseTest {

    @Test
    public void testSendAndSearchEmail()  {
        Configuration.timeout = 16;
        vizit();

        logIn(email, password);
        String subject  = getUniqueText("Autotest email ");

        send(email, subject);

        refresh();

        goToSent();
        assertMail(0, subject);

        goToInbox();
        searchBySubject(subject);
        assertMails(subject);
    }

}
