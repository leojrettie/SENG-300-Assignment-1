package fee_calculator;
import trip.*;

/* StudentPrice.java calculates the price for students
 * @author Nico MacDonald
 */
public class StudentPrice implements FeeCalculator{
    final static int STUDENT_LONG_TRIP_SURCHARGE = 100;
    final static int STUDENT_PER_MINUTE_RATE = 2;

    /* Calculates the price for a trip
     * @param Trip the trip you want to calculte the price for
     */
    @Override 
    public int getPrice(Trip trip){
        int cost = trip.getDurrationMinutes() * STUDENT_PER_MINUTE_RATE;
        if (trip.getDurrationMinutes() >= 120){
            cost += STUDENT_LONG_TRIP_SURCHARGE;
        }
        return ((int)cost);
    }
}
