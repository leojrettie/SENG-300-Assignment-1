package notification_service;

public class AppNotificationService {
  private final AppNotificationHandler handler = new AppNotificationHandler();

  public void NotifyUser(Integer NotificationType) {
    handler.NotifyUser(NotificationType);
  }
}
