package trip;

import java.util.UUID;

/**
 * Vehicle
 */
public class Vehicle {
    private final String vehicleID;

    public Vehicle(){
        this.vehicleID = UUID.randomUUID().toString();
    }

    public Object getID() {
        return this.vehicleID;
    }
}
