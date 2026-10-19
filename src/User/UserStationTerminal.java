package User;

import fee_calculator.FeeCalculator;
import paymentProcessor.PaymentProcessor;
import trip.*;

public class UserStationTerminal extends User {
    // Constructor to initialize the UserStationTerminal with FeeCalculator, PaymentProcessor, and UserTripHandler
    public UserStationTerminal(FeeCalculator feeCalculator, PaymentProcessor paymentProcessor, UserTripHandler userTripHandler) {
        super(feeCalculator, paymentProcessor, userTripHandler);
    }

    public Trip startTrip(User user, Vehicle vehicle) {
        // Start a new trip for the user
        Trip newTrip = new trip.Trip(user, vehicle);
        user.activeTrip = newTrip; // Set the active trip for the user
        return newTrip;
    }

    public void endTrip() {
        // End the active trip for the user
        if (this.activeTrip != null) {
            this.activeTrip.endTrip();
            this.activeTrip = null; // Clear the active trip after ending it
        } else {
            notification_service.NotificationService.NotifyUser(1); // Notify the user that there is no active trip to end
        }
    }
}