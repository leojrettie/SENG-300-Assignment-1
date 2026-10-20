import java.util.List;

import station.*;  
import User.*;
import fee_calculator.FeeCalculator;
import fee_calculator.StudentPrice;
import trip.*;
import payment_processor.*;

/*
 * WHAT THIS PROGRAM IS
 * --------------------
 * A demo (a "story") that shows how the station part of GoCycle works:
 * stations, docking points, vehicles, and the control room.
 * It does not use a real app or screen; it just prints what happens.
 */
public class Main {

    
    public static void main(String[] args) {

        // ===== SETUP: build the little world =====

        // The control room needs to know which stations it watches.
        ControlRoom control = ControlRoom.getInstance();

        Station downtown = control.getStations().get(0);
        Station campus = control.getStations().get(1);


        // Create three vehicles. Each gets a name (id) so we can tell them apart.
        // A pedal bike has no battery, so it needs only a name.
        Vehicle pedal = new UnpoweredBike("BIKE-1");

        // Electric vehicles also need a battery level in PERCENT.
        Vehicle ebike = new ElectricBike("EBIKE-1", 80f);

        
        Vehicle scooter = new ElectricScooter("SCOOT-1", 15f);

        

        printHeading("1. Dock vehicles at Downtown (zone theme + language come from config)");
        // dockVehicle puts the vehicle in the first free docking point and locks it.
        downtown.dockVehicle(pedal);
        downtown.dockVehicle(ebike);
        downtown.dockVehicle(scooter);
        System.out.println("Downtown theme bg1=" + downtown.getTheme().getColourBg1()
                + ", language=" + downtown.getLang() + " | Campus language=" + campus.getLang());
        showStation(downtown);

        printHeading("2. Which vehicles can a rider take? (scooter has 15% battery)");
        // Look at every docking point; if a vehicle is there, ask: "can it be rented?"
        for (DockingPoint p : downtown.getDockingPoints()) {
            Vehicle v = p.getDockedVehicle();
            if (v != null) System.out.println(v.getId() + " available? " + v.checkAvailability());
        }
        // Expected: bike true, e-bike true, scooter false (battery under 20%).

        printHeading("3. Rider tries to take the scooter");
        // We try to take the scooter out of its docking point (the third one, number 2)
        // The dock refuses because the scooter is not available.
        //   REFUSED: Vehicle SCOOT-1 is not available
        try {
            downtown.getDockingPoints().get(2).takeVehicle();
        } catch (IllegalStateException e) {
            System.out.println("REFUSED: " + e.getMessage());
        }

        printHeading("4. Rider takes the e-bike (trip starts) and returns it to Campus");
        DockingPoint from = downtown.getDockingPoints().get(1);   // the e-bike's slot
        Vehicle ridden = from.takeVehicle();                      // rider takes it out
        ridden.setInUse(true);                                    // mark it as being ridden
        System.out.println(ridden.getId() + " available while riding? " + ridden.checkAvailability());
        // Expected false: nobody else can rent it while it is being ridden.

        boolean docked = campus.dockVehicle(ridden);              // rider returns it at Campus
        DockingPoint landing = campus.getDockingPoints().get(0);  // the slot it landed in
        System.out.println("Docked at Campus? " + docked + " | locked? " + landing.checkLock());
        if (landing.checkLock()) {
            // The trip only ends once the vehicle is really locked in a slot.
            ridden.setInUse(false);
            System.out.println("Trip ended. " + ridden.getId() + " available again? " + ridden.checkAvailability());
        }

        printHeading("5. Fault reported on the pedal bike: control room takes it out of service");
        control.removeVehicle(pedal);   // "removeVehicle" here means: take out of service
        System.out.println(pedal.getId() + " available? " + pedal.checkAvailability());   // false

        printHeading("6. Control room moves the e-bike back to Downtown, then restores the pedal bike");
        control.moveVehicle(ridden, downtown);   // operators move a vehicle between stations
        control.restoreVehicle(pedal);           // put the pedal bike back in service
        System.out.println(pedal.getId() + " available? " + pedal.checkAvailability());   // true

        printHeading("7. Final state");
        showStation(downtown);
        showStation(campus);


        UserApp u = new UserApp(new StudentPrice(), new PaymentCreditCardAdapter());
        u.startTrip();
        System.out.println(u.activeTrip.toString());
    }

    
    private static void printHeading(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    // Prints one station: its name, how many slots are free, and what is in each slot.
    private static void showStation(Station s) {
        System.out.println(s.getId() + " (" + s.getZone() + "), free points: "
                + s.getFreePoints() + "/" + s.getTotalCapacity());
        for (DockingPoint p : s.getDockingPoints()) {
            System.out.println("  " + p.getId() + ": "
                    + (p.isFree() ? "free" : p.getDockedVehicle().getId() + " locked=" + p.checkLock()));
        }
    }
}
