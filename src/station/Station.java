package station;

import java.util.ArrayList;
import java.util.List;

public class Station {
       private String stationId;
       private String zone;
       private String lang;
       private List<DockingPoint> dockingPoints = new ArrayList<>();

       public Station(int myStationId, int myNumOfPoints, String myZone){
          this(myStationId, myNumOfPoints, myZone, Language.EN); //Default lang is English
       }

       public Station(int myStationId, int myNumOfPoints, String myZone, Language myLang){
          // Takes the station id and changes it to "S#" then added to a dockingPoints array for that station 
          stationId = "S" + String.valueOf(myStationId); 

          zone = myZone;
          lang = myLang.getDisplayName();  

          for (int i = 0; i < myNumOfPoints; i++){
               dockingPoints.add(new DockingPoint(stationId + "-" + i));
            }
       } 



       // GETTERS & SETTERS
       public String getId(){return stationId;}
       public int getTotalCapacity(){return dockingPoints.size();}
       public String getZone(){return zone;}
       public String getLang(){return lang;}
}
