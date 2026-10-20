package trip;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.ListView;

import User.User;
import fee_calculator.*;
import station.Vehicle;
import station.ControlRoom;

public class UserTripHandler {
    private final User user; 

    /*
     * Constructor method for UserTripHandler.
     * @returns new UserTripHandler object.
     */
    public UserTripHandler(User u) {
        this.user = u;
    }

    private Vehicle getUserVehicle() { 
        Vehicle v;
        List<Vehicle> VehicleList = this.user.availableVehicles(null); //TODO: choose a station
        System.out.println("Please choose one of the following vehicles:");
        for (int i=0; i <= VehicleList.size(); i++) {
            System.out.printf("%d/t%s", i, VehicleList.get(i).getClass());
        }
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        while (true) {
            input = s.nextLine();
            try {
                if (input == null || input.isEmpty()){
                    throw new Exception();
                }
                v = VehicleList.get(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number: ");
            }
        }
        
        return v;
    }


    /*
     * Creates a new trip object after asking the user what vehicle they'd like
     * @throws IOException("Must enter a valid number")
     * @returns a trip object
     */
    public Trip startTrip() {
        Trip trip = new Trip(this.user, getUserVehicle());
        trip.getTripVehicle().setInUse(true);
        return trip;
    }

    /*
     * Creates a new trip object after asking the user what vehicle they'd like

     * @returns a trip object
     */
    public void endTrip(Trip trip){
        trip.getTripVehicle().setInUse(false);
        trip.endTrip();
    }

    public void reportIssue(Trip trip) {
        endTrip(trip);
        ControlRoom.getInstance().removeVehicle(trip.getTripVehicle());
    }
}
