package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.PaymentProcessor;
import UserTripHandler.UserTripHandler;

public class UserStationTerminal extends User {
    // Constructor to initialize the UserStationTerminal with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserStationTerminal(FeeCalculator feeCalculator, PaymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    public Trip startTrip(User user, Vehicle vehicle) {
        // Start a new trip for the user
        Trip newTrip = new Trip(user, vehicle);
        user.activeTrip = newTrip; // Set the active trip for the user
        return newTrip;
    }

    public Trip endTrip() {
        // End the active trip for the user
        if (this.activeTrip != null) {
            this.activeTrip.endTrip();
            this.activeTrip = null; // Clear the active trip after ending it
        } else {
            showMessage("No active trip to end.");
        }
    }
}