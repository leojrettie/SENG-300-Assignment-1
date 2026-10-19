package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.paymentProcessor;
import UserTripHandler.UserTripHandler;

public class UserApp extends User {
    // Constructor to initialize the UserApp with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserApp(FeeCalculator feeCalculator, paymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    @Override
    protected void showMessage(String message) {
        // Implementation to display the message to the user
        System.out.println("[UserApp] " + message);
    }
}
