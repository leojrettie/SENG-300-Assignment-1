package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.paymentProcessor;
import UserTripHandler.UserTripHandler;
import notification_service.*;

public class UserApp extends User {
    // Constructor to initialize the UserApp with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserApp(FeeCalculator feeCalculator, paymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    public Trip startTrip(User user, Vehicle vehicle) {
        // Start a new trip for the user
        Trip newTrip = new Trip(user, vehicle);
        user.activeTrip = newTrip; // Set the active trip for the user
        return newTrip;
    }

    public void endTrip() {
        // End the active trip for the user
        if (this.activeTrip != null) {
            this.activeTrip.endTrip();
            this.activeTrip = null; // Clear the active trip after ending it
        } else {
            showMessage("No active trip to end.");
        }
    }
}
