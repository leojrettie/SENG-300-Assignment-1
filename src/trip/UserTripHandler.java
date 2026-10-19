package trip;

import fee_calculator.FeeCalculator;

public class UserTripHandler {
    private final User user;

    public UserTripHandler(User u){
        this.user = u;
    }

    public Trip startTrip(Vehicle v){
        User user = this.user;
        return new Trip(user, v);
    }

    public void endTrip(Trip trip){
        trip.endTrip();
        int Fee = User.fee_calculator.getPrice(trip);
        //user.paymentProcessor.chargeUser(user.feeCalculator.getPrice(trip));
    }
}
