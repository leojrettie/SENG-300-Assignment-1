package fee_calculator;
import trip.*;

public class PublicPrice implements FeeCalculator{
    final static int PUBLIC_LONG_TRIP_SURCHARGE = 200;
    final static int PUBLIC_PER_MINUTE_RATE = 5;

    @Override 
    public int getPrice(Trip trip){
        int cost = trip.getDurrationMinutes() * PUBLIC_PER_MINUTE_RATE;
        if (trip.getDurrationMinutes() >= 120){
            cost += PUBLIC_LONG_TRIP_SURCHARGE;
        }
        return ((int)cost);
    }
}
