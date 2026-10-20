package station;

import java.util.Map;

public class Theme{

    private static final Map<String, String[]> ZONES = Map.of(
        "downtown",   new String[]{"#128219", "#128251", "#82127B", "ZoneLogo.jpg"},
        "campus",     new String[]{"#385C43", "#385C55", "#38515C", "ZoneLogo.jpg"},
        "airport",    new String[]{"#00948A", "#005494", "#000A94", "ZoneLogo.jpg"},
        "residential",new String[]{"#000F94", "#3B0094", "#850094", "ZoneLogo.jpg"},
        "industrial", new String[]{"#940039", "#941100", "#945B00", "ZoneLogo.jpg"}
    );
    
    private static final String[] DEFAULT_THEME = {"#FFFFFF", "#FFFF31", "#000000", "ZoneLogo.jpg"};

    private static final String LOGO_DIR = "resources/zoneLogos/";

    private final String colourBg1; //hex strings
    private final String colourBg2;   
    private final String colourText;
    private final String zoneLogo; //Links to image file with the zone logo

    public Theme(String zone){
        String[] v = ZONES.getOrDefault(zone.trim().toLowerCase(), DEFAULT_THEME);
        this.colourBg1 = v[0];
        this.colourBg2 = v[1];
        this.colourText = v[2];
        this.zoneLogo = LOGO_DIR + v[3]; 
    }

    //Getters
    public String getColourBg1() {return colourBg1;}
    public String getColourBg2() {return colourBg2;}
    public String getColourText() {return colourText;}
    public String getZoneLogo() {return zoneLogo;}

}
