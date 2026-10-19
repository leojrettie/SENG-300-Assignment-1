package trip;

public class UserTripHandler {
    public Trip startTrip(){
        User user = new User();
        Vehicle vehicle = new Vehicle();
        return new Trip(user, vehicle);
        
    }    
}
