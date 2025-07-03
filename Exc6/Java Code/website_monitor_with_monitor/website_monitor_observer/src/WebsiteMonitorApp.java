import java.time.LocalDateTime;

public class WebsiteMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("Omid Fatehi", "omid@fatehi.com");
        User user2 = new User("Max Mustermann", "max@mustermann.com");
        User user3 = new User("Anna Schmidt", "anna@schmidt.com");

        Website website1 = new Website("https://www.google.com", new ContentSizeStrategy());
        Website website2 = new Website("https://www.google.com", new HtmlContentStrategy());
        Website website3 = new Website("https://www.google.com", new TextContentStrategy());

        NotificationPreferences prefs = new NotificationPreferences("15", "terminal");

        // Alle drei Observer registrieren
        website1.addObserver(user1);
        website2.addObserver(user2);
        website3.addObserver(user3);

        System.out.println("Monitoring mit allen drei Strategien gestartet...");

        while (true) {
            System.out.println("\n--- Checking mit Content Size Strategy ---");
            boolean changed1 = website1.checkForUpdates();
            if (!changed1) {
                System.out.println("[" + LocalDateTime.now() + "] Keine Größenänderung auf " + website1.getUrl());
            }

            System.out.println("--- Checking mit HTML Content Strategy ---");
            boolean changed2 = website2.checkForUpdates();
            if (!changed2) {
                System.out.println("[" + LocalDateTime.now() + "] Keine HTML-Änderung auf " + website2.getUrl());
            }

            System.out.println("--- Checking mit Text Content Strategy ---");
            boolean changed3 = website3.checkForUpdates();
            if (!changed3) {
                System.out.println("[" + LocalDateTime.now() + "] Keine Text-Änderung auf " + website3.getUrl());
            }
            Thread.sleep(Integer.parseInt(prefs.getFrequency()) * 1000);
        }
    }
}
