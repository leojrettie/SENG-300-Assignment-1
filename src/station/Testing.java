package station;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class Testing {

    @Test
    public void createStations(){
        Station downtown = new Station(1, 2, "Downtown");
        Station country = new Station(2, 4, "outside", Language.EN);

        assertEquals(2, downtown.getTotalCapacity());
        assertEquals(4, country.getTotalCapacity());
        assertEquals("English", downtown.getLang());
        System.out.println(country.getLang());
    }
    

}

