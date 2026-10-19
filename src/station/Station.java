package station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
   private final Theme theme;
   private String stationId;
   private String zone;
   private Language lang;
   private List<DockingPoint> dockingPoints = new ArrayList<>();

   public Station(int myStationId, int myNumOfPoints, String myZone){
      this(myStationId, myNumOfPoints, myZone, Language.EN); //Default lang is English
   }

   public Station(int myStationId, int myNumOfPoints, String myZone, Language myLang){
      if (myNumOfPoints < 1) throw new IllegalArgumentException("A station needs at least 1 docking point"); 
      // Takes the station id and changes it to "S#" then added to a dockingPoints array for that station 
      stationId = "S" + String.valueOf(myStationId); 

      zone = myZone;
      theme = new Theme(myZone);
      lang = myLang;

      for (int i = 0; i < myNumOfPoints; i++){
         dockingPoints.add(new DockingPoint(stationId + "-" + i));
      }
   } 
       
   //Docks vehicles in the first free point, will return false if a station is full
   public boolean dockVehicle(Vehicle vehicle){
      for (DockingPoint p : dockingPoints){
         if (p.dock(vehicle)) {return true;}
      }
      return false;
   }

   //Removes a specific vehicle
   public boolean removeVehicle(Vehicle vehicle){
      for (DockingPoint p : dockingPoints) {
         if (p.getDockedVehicle() == vehicle){p.removeVehicle(); return true;}
      }
      return false;
   }

   public boolean contains(Vehicle vehicle) {
      return dockingPoints.stream().anyMatch(p -> p.getDockedVehicle() == vehicle);
   }
   public boolean hasFreePoint() { return getFreePoints() > 0; }

   public int getFreePoints() {
      return (int) dockingPoints.stream().filter(DockingPoint::isFree).count();
   }

   public List<Vehicle> getVehicles() {
      List<Vehicle> list = new ArrayList<>();
      for (DockingPoint p : dockingPoints)
         if (!p.isFree()) list.add(p.getDockedVehicle());
      return list;
   }

   // GETTERS & SETTERS
   public List<DockingPoint> getDockingPoints() {return Collections.unmodifiableList(dockingPoints);}
   public String     getId(){return stationId;}
   public int        getTotalCapacity(){return dockingPoints.size();}
   public String     getZone(){return zone;}
   public Language   getLanguage(){return lang;}
   public String getLang(){return lang.getDisplayName();}
   public Theme      getTheme(){return theme;}
}
