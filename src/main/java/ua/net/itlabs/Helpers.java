package ua.net.itlabs;

public class Helpers {
    public static String getUniqueText(String prefix) {
        return prefix + System.currentTimeMillis();
    }
}
