package station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Theme{

    private static final String CONFIG_FILE = "resources/zoneCustomization";

    private final String colourBg1; //hex strings
    private final String colourBg2;   
    private final String colourText;
    private final String zoneLogo; //Links to image file with the zone logo

    public Theme(String zone){
        String values[] = findZone(zone);
        this.colourBg1 = values[1];
        this.colourBg2 = values[2];
        this.colourText = values[3];
        this.zoneLogo = "resources/zoneLogos/" + values[4]; //Zone images should be located in resources/zoneLogos/(image file name)
    }

    private static String[] findZone(String zone){
        //Tries to read the file and if it able to, cuts up the lines into pieces once it finds a match for the zone
        try (BufferedReader br = new BufferedReader(new FileReader(CONFIG_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].trim().equalsIgnoreCase(zone)) {
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }
                    return parts;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not read" + CONFIG_FILE, e);
        }
        throw new IllegalArgumentException("Unkown file");
    }

    //Getters
    public String getColourBg1() {return colourBg1;}
    public String getColourBg2() {return colourBg2;}
    public String getColourText() {return colourText;}
    public String getZoneLogo() {return zoneLogo;}

}
