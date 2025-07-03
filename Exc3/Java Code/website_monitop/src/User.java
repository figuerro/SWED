import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class User {
    private String userID;
    private String name;
    private String contactInfo;
    private List<Subscription> subscriptions = new ArrayList<>();

    public User(String name, String contactInfo) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void registerForUpdates(Subscription sub) {
        subscriptions.add(sub);
    }

    public void cancelSubscription(Subscription sub) {
        subscriptions.remove(sub);
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
