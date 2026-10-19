package notification_service;

public enum Message {
  MESSAGE1("Here's a message of the first type!"),
  MESSAGE2("Here's a message of the second type!"),
  DNF("Invalid NotificationType.");
  
  public final String text;

  Message(final String text){
    this.text = text;
  }
}
