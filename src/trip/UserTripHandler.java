package trip;

public class UserTripHandler {
    private final User user;

    public UserTripHandler(User u){
        this.user = u;
    }

    public Trip startTrip(){
        User user = new User();
        Vehicle vehicle = new Vehicle();
        return new Trip(user, vehicle);
    }

    public void endTrip(Trip trip){
        trip.endTrip();
        //Charge user using payment processor
    }
}
