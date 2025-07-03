import java.util.UUID;

public class NotificationPreferences {
    private String preferencesID;
    private String frequency; // in Sekunden als String
    private String communicationChannel;

    public NotificationPreferences(String frequency, String communicationChannel) {
        this.preferencesID = UUID.randomUUID().toString();
        this.frequency = frequency;
        this.communicationChannel = communicationChannel;
    }

    public void updateFrequency(String newFrequency) {
        this.frequency = newFrequency;
    }

    public void updateCommunicationChannel(String newChannel) {
        this.communicationChannel = newChannel;
    }

    public String getFrequency() {
        return frequency;
    }
}
