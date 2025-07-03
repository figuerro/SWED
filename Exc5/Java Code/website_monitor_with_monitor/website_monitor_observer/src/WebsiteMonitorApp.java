import java.time.LocalDateTime;

public class WebsiteMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        // Zwei User erstellen
        User user1 = new User("Omid Fatehi", "omid@fatehi.com");
        User user2 = new User("Max Mustermann", "max@mustermann.com");

        Website website = new Website("https://www.google.com"); // Hier URL eintragen
        NotificationPreferences prefs = new NotificationPreferences("15", "terminal"); // alle 15 Sekunden

        Subscription sub1 = new Subscription(user1, website, prefs);
        Subscription sub2 = new Subscription(user2, website, prefs);

        // Beide User als Observer registrieren
        website.addObserver(user1);
        website.addObserver(user2);

        while (true) {
            boolean changed = website.checkForUpdates();
            if (!changed) {
                System.out.println("[" + LocalDateTime.now() + "] Keine Änderung auf " + website.getUrl());
            }
            Thread.sleep(Integer.parseInt(prefs.getFrequency()) * 1000);
        }
    }
}
