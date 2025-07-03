public class WebsiteMonitorApp {
    public static void main(String[] args) throws InterruptedException {

        User user = new User("Omid Fatehi", "omid@fatehi.com");
        Website website = new Website("https://www.google.com"); // Hier beliebige URL eintragen
        NotificationPreferences prefs = new NotificationPreferences("10", "terminal"); // alle 10 Sekunden
        Subscription sub = new Subscription(user, website, prefs);
        user.registerForUpdates(sub);

        while (true) {
            boolean changed = website.checkForUpdates();
            Notification notification;
            if (changed) {
                notification = new Notification("Update erkannt auf " + website.getUrl(), "SENT");
            } else {
                notification = new Notification("Keine Änderung auf " + website.getUrl(), "NO_CHANGE");
            }
            notification.send();
            Thread.sleep(Integer.parseInt(prefs.getFrequency()) * 1000);
        }
    }
}
