package station;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class Testing {

    @Test
    public void createStations(){
        Station downtown = new Station("S1", 2, "Downtown");
        Station country = new Station("S2", 4, "outside", "fr");

        System.out.println(downtown + " | " + country);

        assertEquals(2, downtown.getCapacity());
        assertEquals(4, country.getCapacity());
    }
    

}

