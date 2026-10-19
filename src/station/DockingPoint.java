package station;

public class DockingPoint{

    private String pointId;
    private Vehicle dockedVehicle; //null means its free
    private boolean locked;

    public DockingPoint(String pointId){this.pointId = pointId;}
    public boolean isFree() {return dockedVehicle == null;}


    //Locks a vehicle into a spot. Returns false if occupied
    public boolean dock(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("vehicle is null");
        if (!isFree()) return false;
        dockedVehicle = vehicle;
        locked = true;
        return true;
    }

    //True if vehicle is here and locked
    public boolean checkLock() {return dockedVehicle != null && locked;}

    //Rider has a vehicle, this will be refused if the vehicle cannot be taken
    public Vehicle takeVehicle() {
        if (isFree()) throw new IllegalStateException("No vehicle at " + pointId);
        if (!dockedVehicle.checkAvailability())
            throw new IllegalStateException("Vehicle " + dockedVehicle.getId() + " is not available");
        return removeVehicle();
    }

    public Vehicle removeVehicle() {
        Vehicle v = dockedVehicle;
        dockedVehicle = null;
        locked = false;
        return v;
    }

    public String getId() {return pointId;}
    public Vehicle getDockedVehicle() {return dockedVehicle;}
}