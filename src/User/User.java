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

    /**
     * Method to start a trip
     *
     * @return the newly started trip
     */
    public Trip startTrip() {
        if (activeTrip != null) {
            throw new IllegalStateException("Cannot start a new trip while another trip is active.");
        }
        //implementation to start a trip
        paymentProcessor.chargeDeposit();
        activeTrip = userTripHandler.startTrip();
        return activeTrip;
    }

    /**
     * Method to end a trip, then releases the hold and returns the fare charged for the trip
     *
     * @param trip the trip to end
     * @return the fare charged for the trip
     */
    public double endTrip(Trip trip) {
        if (trip == null || trip != activeTrip) {
            throw new IllegalArgumentException("Invalid trip provided. No active trip to end.");
        }
        //implementation to end trip
        // Only end the trip if the vehicle is locked

        userTripHandler.endTrip(trip);
        double fare = feeCalculator.getPrice();
        paymentProcessor.chargeFare(fare);
        activeTrip = null; // Reset active trip after ending it
        showMessage(String.format("Trip ended. Fare: $%.2f", fare));
        return fare;
    }

    /**
     * Method to report issue
     *
     * @param trip the trip for which to report an issue
     */
    public void reportIssue(Trip trip) {
        userTripHandler.reportIssue(trip);
        showMessage("Issue reported for trip: " + trip.getTripId());
    }

    /**
     * Method that returns the active trip for the user, or null if there is no active trip
     * @return the active trip or null
     */
    public Trip getActiveTrip() {
        return activeTrip;
    }  
    /**
     * Method to show a message to the user
     *
     * @param message the message to display
     */
    protected void showMessage(String message) {
        System.out.println(message);
    }
}
