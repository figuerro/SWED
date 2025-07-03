
import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private String notificationID;
    private String message;
    private LocalDateTime timestamp;
    private String status;

    public Notification(String message, String status) {
        this.notificationID = UUID.randomUUID().toString();
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public void send() {
        System.out.println("[" + timestamp + "] " + message);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}