package notification_service;

public class EmailNotificationHandler {
    void NotifyUser(Integer NotificationType) {
        //Implementation of the email notification logic based on NotificationType. Most probably an external library.
        if (NotificationType == 1){
            System.out.println(Message.MESSAGE1 + "(to an email service)");
        }
        else if (NotificationType == 2){
            System.out.println(Message.MESSAGE2 + "(to an email service)");
        }
    }
}
