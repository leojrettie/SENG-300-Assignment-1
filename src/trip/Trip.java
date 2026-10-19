package trip;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
//import vehicle.*;

public class Trip {
    private final String tripID;
    //TODO: private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;


    /*
    * Trip is a constructor class that creates a new trip to store data like, vehicle and start/end times
    * @param vehicle: The vehicle used durring the trip
    */

    public Trip(){ //, Vehicle vehicle) {
        this.tripID = UUID.randomUUID().toString();
        this.startTime = LocalDateTime.now();
        //TODO this.vehicle = vehicle;
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
        Vehicle: %s\n
        Start Time: %s\n
        End Time: %s\n
        Duration:%d\n
        """,
        this.tripID, 
        "Vehicle Class Not Implemented Yet", //TODO: this.vehicle.toString(), 
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
    }
    public int getDurrationMinutes() {
        long durrationMinutes;
        try {
            durrationMinutes = Duration.between(startTime, endTime).toMinutes();
        } catch (NullPointerException _) {
            throw new IllegalStateException("Cannot get duration of a trip that hasn't ended");
        }
        return (int) durrationMinutes;
    }
}
