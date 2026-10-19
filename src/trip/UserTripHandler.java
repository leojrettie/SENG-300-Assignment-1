package trip;

import fee_calculator.*;
import vehicle.*;

public class UserTripHandler {

    public UserTripHandler(){
    }

    public Trip startTrip(){
        //ask user what vehicle they want
        return new Trip();
    }

    public void endTrip(Trip trip){
        // Check if vehicle 
        trip.endTrip();
    }

    public void reportIssue(Trip trip) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reportIssue'");
    }
}
