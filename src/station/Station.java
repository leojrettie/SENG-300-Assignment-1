package station;

import java.util.ArrayList;
import java.util.List;

public class Station {
       private String stationId;
       private List<DockingPoint> dockingPoints = new ArrayList<>();

       public Station(String stationId, int numOfPoints, String zone){
            this(stationId, numOfPoints, zone, "en");
       }

       public Station(String stationId, int numOfPoints, String zone, String lang){
            this.stationId = stationId;
            
            for (int i = 0; i < numOfPoints; i++){
                dockingPoints.add(new DockingPoint(stationId + "-" + i));
            }
       } 

       public int getCapacity(){
            return dockingPoints.size();
       }
}
