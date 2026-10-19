package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.paymentProcessor;
import trip.*;
import notification_service.*;

public class UserApp extends User {
    // Constructor to initialize the UserApp with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserApp(FeeCalculator feeCalculator, paymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    @Override
    protected void notifyUser(String message) {
        // Implementation to notify the user through the app or email
        AppNotificationService.AppNotificationService.notifyUser(message);
        EmailNotificationService.EmailNotificationService.notifyUser(message);
    }
}
