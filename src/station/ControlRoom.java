package station;

import java.util.ArrayList;
import java.util.List;

public class ControlRoom{
    private static List<Station> stations;
    private static ControlRoom instance;

    
    private ControlRoom(List<Station> stations){
        ControlRoom.stations = new ArrayList<>(stations);
    }

    public static synchronized ControlRoom getInstance() {
        // Create a station: id 1, 3 docking points, in the "Downtown" zone.
        // (The zone name decides its colours, which are read from a settings file.)
        Station downtown = new Station(1, 3, "Downtown");

        // A second station: id 2, 2 docking points, "Campus" zone, screens in French.
        Station campus = new Station(2, 2, "Campus", Language.FR);

        if (instance == null) {
            ControlRoom instance = new ControlRoom(List.of(downtown, campus));
        }
        return instance;
    }

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