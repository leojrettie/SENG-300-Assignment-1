package station;

import java.util.ArrayList;
import java.util.List;

public class ControlRoom{
    private final List<Station> stations;

    public ControlRoom(List<Station> stations){this.stations = new ArrayList<>(stations);}

    //Moves a docked vehicle to another station
    public void moveVehicle(Vehicle vehicle, Station destination) {
        Station source = findStationOf(vehicle);
        if (source == null)
            throw new IllegalStateException("Vehicle " + vehicle.getId() + " is not docked at any station");
        if (vehicle.isInUse())
            throw new IllegalStateException("Vehicle " + vehicle.getId() + " is in use");
        if (source == destination) return;
        if (!destination.hasFreePoint())
            throw new IllegalStateException("Station " + destination.getId() + " is full");

        source.removeVehicle(vehicle);
        destination.dockVehicle(vehicle);
    }

    //Takes a vehicle out of service
    public void removeVehicle(Vehicle vehicle) { vehicle.setInService(false); }

    //Puts a vehicle back into service
    public void restoreVehicle(Vehicle vehicle) { vehicle.setInService(true); }

    public Station findStationOf(Vehicle vehicle) {
        for (Station s : stations)
            if (s.contains(vehicle)) return s;
        return null;
    }

    public List<Station> getStations() { return new ArrayList<>(stations); }
}