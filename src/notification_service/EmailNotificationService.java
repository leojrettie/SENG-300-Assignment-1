package notification_service;

public class EmailNotificationService implements NotificationService{
  private final EmailNotificationHandler handler = new EmailNotificationHandler();

  public void NotifyUser(Integer NotificationType) {
    handler.NotifyUser(NotificationType);
  }

  
}
