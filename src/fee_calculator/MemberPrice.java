package fee_calculator;
import trip.*;

/* MemberPrice.java calculates the price for memebers
 * @author Nico MacDonald
 */
public class MemberPrice implements FeeCalculator{
    final static int MEMBER_LONG_TRIP_SURCHARGE = 50;
    final static int MEMBER_PER_MINUTE_RATE = 3;

    /* Calculates the price for a trip
     * @param Trip the trip you want to calculte the price for
     */
    @Override 
    public int getPrice(Trip trip){
        int cost = trip.getDurrationMinutes() * MEMBER_PER_MINUTE_RATE;
        if (trip.getDurrationMinutes() >= 120){
            cost += MEMBER_LONG_TRIP_SURCHARGE;
        }
        return ((int)cost);
    }
}