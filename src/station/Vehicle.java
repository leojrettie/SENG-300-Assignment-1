package station;

public abstract class Vehicle {
    private final String vehicleId;
    private boolean inService = true;
    private boolean inUse = false;

    protected Vehicle(String vehicleId) {this.vehicleId = vehicleId;}

    //Availiable means that it is not being ridden and is working
    public boolean checkAvailability() {return inService && !inUse;}

    //GETTERS & SETTERS
    public String getId()           {return vehicleId;}
    public boolean isInService()    {return inService;}
    public boolean isInUse()        {return inUse;}
    public void setInService(boolean inService) {this.inService = inService;}
    public void setInUse(boolean inUse) {this.inUse = inUse;}
}