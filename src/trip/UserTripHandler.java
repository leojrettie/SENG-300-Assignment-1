package trip;
//package control_room.*;

import fee_calculator.*;
import vehicle.*;

public class UserTripHandler {

    /*
     * Constructor method for UserTripHandler.
     * @returns new UserTripHandler object.
     */
    public UserTripHandler() {
    }

    /*
     * Creates a new trip object after asking the user what vehicle they'd like
     * @returns a trip object
     */
    public Trip startTrip() {
        
        //ask user what vehicle they want
        return new Trip();
    }

    public void endTrip(Trip trip){
        // Check if vehicle 
        trip.endTrip();
    }

    public void reportIssue(Trip trip) {
        ControlRoom.removeVehicle();//trip.vehicle);
        throw new UnsupportedOperationException("Unimplemented method 'reportIssue'");
    }
}
