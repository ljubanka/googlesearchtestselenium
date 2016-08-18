package ua.net.itlabs.gmailtest.pages;

import ua.net.itlabs.core.ConciseAPI;

public class Menu extends ConciseAPI {

    public static void refresh() {
        $(".nu").click();
    }

    public static void goToSent() {
        $(byTitle("Sent Mail")).click();
    }

    public static void goToInbox() {
        $(byTitle("Inbox")).click();
    }
}
