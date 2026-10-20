package trip;
import java.util.List;
import java.util.Scanner;
import User.User;
import station.*;

/* UserTripHandler.java is a class thats responsible for managing trip objects, starting and ending trips, updating relevant values, and reporting issues durring a trip.
 * @author Nico MacDonald
 */
public class UserTripHandler {
    private final User user; 

    /*
     * Constructor method for UserTripHandler.
     * @return new UserTripHandler object.
     */
    public UserTripHandler(User u) {
        this.user = u;
    }

    private Station getUserStation(){
        Station station;
        List<Station> stationsList = ControlRoom.getInstance().getStations();

        System.out.println("Please choose one of the following stations:");
        for (int i=0; i <= stationsList.size(); i++) {
            System.out.printf("%d/t%s", i, stationsList.get(i).getId());
        }
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        while (true) {
            input = s.nextLine();
            try {
                if (input == null || input.isEmpty()){
                    throw new Exception();
                }
                station = stationsList.get(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number: ");
            }
        }
        return station;
    }

    private Vehicle getUserVehicle() { 
        Vehicle v;
        List<Vehicle> VehicleList = this.user.availableVehicles(getUserStation());
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
     * Creates a new trip object after asking the user what vehicle they'd like.
     * @return a Trip object
     */
    public Trip startTrip() {
        Trip trip = new Trip(this.user, getUserVehicle());
        trip.getTripVehicle().setInUse(true);
        return trip;
    }

    /*
     * Creates a new trip object after asking the user what vehicle they'd like
     * @param a Trip to end
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
