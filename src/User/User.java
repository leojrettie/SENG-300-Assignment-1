package User;

import fee_calculator.FeeCalculator;
import java.util.*;
import payment_processor.PaymentProcessor;
import station.*;
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
        this.feeCalculator = Objects.requireNonNull(feeCalculator, "FeeCalculator cannot be null");
        this.paymentProcessor = Objects.requireNonNull(paymentProcessor, "PaymentProcessor cannot be null");
        this.userTripHandler = Objects.requireNonNull(userTripHandler, "UserTripHandler cannot be null");
    }

    

    /**
     * Function that returns a list of available vehicles able to be booked to start a trip
     * @param station The station the user is currently at
     */
    public List<Vehicle> availableVehicles (Station station) {
        List<Vehicle> available = new ArrayList<>();

        //iterate through the docking points to see which vehicles are available
        for (DockingPoint point : station.getDockingPoints()){
            Vehicle vehicle = point.getDockedVehicle();

            if (vehicle != null && vehicle.checkAvailability()) {
                available.add(vehicle);
            }
        }
        return available;
    }
}
