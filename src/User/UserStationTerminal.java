package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.PaymentProcessor;
import UserTripHandler.UserTripHandler;

public class UserStationTerminal extends User {
    // Constructor to initialize the UserStationTerminal with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserStationTerminal(FeeCalculator feeCalculator, PaymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    @Override
    protected void showMessage(String message) {
        // Implementation to display the message to the user
        System.out.println("[UserStationTerminal] " + message);
    }
}