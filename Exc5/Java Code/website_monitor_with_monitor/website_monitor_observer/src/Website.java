import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Website implements Subject {
    private String websiteID;
    private String url;
    private LocalDateTime lastCheckedTimestamp;
    private LocalDateTime lastUpdateDetectedTimestamp;
    private String lastContent = "";
    private List<Observer> observers = new ArrayList<>();

    public Website(String url) {
        this.websiteID = UUID.randomUUID().toString();
        this.url = url;
    }

    public boolean checkForUpdates() {
        try {
            String content = getUrlContent(url);
            lastCheckedTimestamp = LocalDateTime.now();
            if (!lastContent.equals(content)) {
                lastUpdateDetectedTimestamp = LocalDateTime.now();
                lastContent = content;
                notifyObservers();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Prüfen: " + e.getMessage());
        }
        return false;
    }

    public String getUrl() {
        return url;
    }

    private String getUrlContent(String urlString) throws Exception {
        StringBuilder content = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                content.append(inputLine);
        }
        return content.toString();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(url);
        }
    }
}
