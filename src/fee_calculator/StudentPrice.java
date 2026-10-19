package fee_calculator;
import trip.*;
public class StudentPrice implements FeeCalculator{
    final static int STUDENT_LONG_TRIP_SURCHARGE = 100;
    final static int STUDENT_PER_MINUTE_RATE = 2;

    @Override 
    public int getPrice(Trip trip){
        int cost = trip.getDurrationMinutes() * STUDENT_PER_MINUTE_RATE;
        if (trip.getDurrationMinutes() >= 120){
            cost += STUDENT_LONG_TRIP_SURCHARGE;
        }
        return ((int)cost);
    }
}
