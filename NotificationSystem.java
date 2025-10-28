// Abstract class
abstract class Notification {
    protected String type;

    public Notification(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // Abstract method
    public abstract void send(String to, String msg);
}

// Derived class for Email Notification
class EmailNotification extends Notification {
    public EmailNotification() {
        super("Email");
    }

    @Override
    public void send(String to, String msg) {
        System.out.println("Sending Email to: " + to);
        System.out.println("Message: " + msg);
        System.out.println("Status: Email sent successfully!\n");
    }
}

// Derived class for SMS Notification
class SMSNotification extends Notification {
    public SMSNotification() {
        super("SMS");
    }

    @Override
    public void send(String to, String msg) {
        System.out.println("Sending SMS to: " + to);
        System.out.println("Message: " + msg);
        System.out.println("Status: SMS delivered successfully!\n");
    }
}

// Derived class for Push Notification
class PushNotification extends Notification {
    public PushNotification() {
        super("Push");
    }

    @Override
    public void send(String to, String msg) {
        System.out.println("Sending Push Notification to: " + to);
        System.out.println("Message: " + msg);
        System.out.println("Status: Push notification sent!\n");
    }
}

// NotificationService class
class NotificationService {
    public void notifyUser(Notification notification, String to, String msg) {
        System.out.println("Notification Type: " + notification.getType());
        notification.send(to, msg);
    }
}

// Main class
public class NotificationSystem {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification push = new PushNotification();

        service.notifyUser(email, "sk@example.com", "Welcome to our service!");
        service.notifyUser(sms, "+919876543210", "Your OTP is 123456.");
        service.notifyUser(push, "User123", "You have a new message.");
    }
}
