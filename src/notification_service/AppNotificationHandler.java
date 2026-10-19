package notification_service;

public class AppNotificationHandler {
  void NotifyUser(Integer NotificationType) {
    //Implementation of the app notification logic based on NotificationType
      switch(NotificationType){
            case 1 :
                System.out.println(Message.MESSAGE1 + "(in the application)");
            case 2:
                System.out.println(Message.MESSAGE2 + "(in the application))");
            default:
                System.out.println(Message.DNF);
        }
  }
}
