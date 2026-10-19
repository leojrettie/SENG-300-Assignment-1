package User;

import java.util.Objects;
import paymentProcessor.paymentProcessor;
import fee_calculator.FeeCalculator;
import UserTripHandler.UserTripHandler;
import Trip.Trip;

public abstract class User {
    // Create fields for FeeCalculator, PaymentProcessor, and UserTripHandler
    private final FeeCalculator feeCalculator;
    private final Processor paymentProcessor;
    private final UserTripHandler userTripHandler;
    private Trip activeTrip;        // Field to hold the active trip for the user, null if no active trip
    
    // Constructor to initialize the User with FeeCalculator, PaymentProcessor, and UserTripHandler
    protected User (FeeCalculator feeCalculator, Processor paymentProcessor, UserTripHandler userTripHandler) {
        this.feeCalculator = Objects.requireNonNull(feeCalculator, "FeeCalculator cannot be null");
        this.paymentProcessor = Objects.requireNonNull(paymentProcessor, "PaymentProcessor cannot be null");
        this.userTripHandler = Objects.requireNonNull(userTripHandler, "UserTripHandler cannot be null");
    }
}
