package User;

import fee_calculator.FeeCalculator;
import payment_processor.PaymentProcessor;
import trip.Trip;
import trip.UserTripHandler;

public abstract class User {
    // Create fields for FeeCalculator, PaymentProcessor, and UserTripHandler
    private final FeeCalculator feeCalculator;
    private final PaymentProcessor paymentProcessor;
    private final UserTripHandler userTripHandler;
    protected Trip activeTrip;        // Field to hold the active trip for the user, null if no active trip
    
    // Constructor to initialize the User with FeeCalculator, PaymentProcessor, and UserTripHandler
    protected User (FeeCalculator feeCalculator, PaymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        this.feeCalculator = feeCalculator;
        this.paymentProcessor = paymentProcessor;
        this.userTripHandler = userTripHandler;
    }
    
    
}
