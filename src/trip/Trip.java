package trip;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import User.User;
import station.Vehicle;

public class Trip {
    private final String tripID;
    private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;


    /*
    * Trip is a constructor class that creates a new trip to store data like, vehicle and start/end times
    * 
    * @param vehicle: The vehicle used durring the trip
    * @return a new Trip object with a start time of Now
    */
    protected Trip(User user, Vehicle vehicle) {
        this.tripID = UUID.randomUUID().toString();
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
    }

    /*
    * Overrides the to-string method and provides a string listing details of a specicif trip.
    * @return A string listing the atributes of the trip in a line by line format
    */
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
    
    /*
     * Ends an on going trip by setting the null end time to the current time.
     * @throws IllegalStateException: Cannot end a trip that has already ended.
     */
    public void endTrip(){
        if (this.endTime == null) {
            this.endTime = LocalDateTime.now();
        } else {
            throw new IllegalStateException("Cannot end a trip that has already ended.");
        }
    }

    /*
     * Returns the length of a trip that has ended in minutes
     * @throws IllegalStateException: Cannot get duration of a trip that hasn't ended
     * @return
     */
    public int getDurrationMinutes() {
        long durrationMinutes;
        try {
            durrationMinutes = Duration.between(startTime, endTime).toMinutes();
        } catch (NullPointerException _) {
            throw new IllegalStateException("Cannot get duration of a trip that hasn't ended.");
        }
        return (int) durrationMinutes;
    }

    /*
     * Getter method of the UUID for the trip object.
     * Returns the UUID as a string 
     */
    public String getTripId() {return this.tripID;}
     /*
     * Getter method of the vehicle for the trip object.
     * Returns the vehicle as a Vehicle object 
     */
    public Vehicle getTripVehicle() {return this.vehicle;}
}
