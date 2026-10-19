package notification_service;

public class EmailNotificationHandler {
    void NotifyUser(Integer NotificationType) {
        //Implementation of the email notification logic based on NotificationType. Most probably an external library.
        switch(NotificationType){
            case 1 :
                System.out.println(Message.MESSAGE1 + "(to an email service)");
            case 2:
                System.out.println(Message.MESSAGE2 + "(to an email service)");
            default:
                System.out.println(Message.DNF);
        }
    }
}
