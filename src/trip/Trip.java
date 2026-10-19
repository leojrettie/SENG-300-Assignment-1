package trip;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Trip {
    private final String tripID;
    private final User user;
    private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public Trip(User user, Vehicle vehicle) {
        this.tripID = UUID.randomUUID().toString();
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.user = user;
    }

    @Override
    public String toString() {
        final String notEndedYetString = "Trip is still ongoing.";
        String endString;
        long durrationMinutes;
        
        try {
            endString = endTime.toString();
            durrationMinutes = Duration.between(startTime, endTime).toSeconds();
        } catch (NullPointerException e) {
            endString = notEndedYetString;
            durrationMinutes = Duration.between(startTime, LocalDateTime.now()).toSeconds();
        }
        final String s = String.format("""
        Trip ID: %s\n
        User ID: %s\n
        Vehicle: %s\n
        Start Time: %s\n
        End Time: %s\n
        Duration:%d\n
        """,
        this.tripID, 
        this.user.getID(), 
        this.vehicle.getID(), 
        this.startTime,
        endString,
        durrationMinutes
        );

        return s;
    }
    
    public void endTrip(){
        if (this.endTime == null){
            this.endTime = LocalDateTime.now();
        }
        //TODO:end trip charge card behavior
    }

    public static void main(){
        User u = new User();
        Vehicle v = new Vehicle();
        Trip trip = new Trip(u, v);

        System.out.println(trip.toString());
        trip.endTrip();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println(trip.toString());

    }
}
