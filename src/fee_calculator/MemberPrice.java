package fee_calculator;
public class MemberPrice implements FeeCalculator{
    final static int MEMBER_LONG_TRIP_SURCHARGE = 50;
    final static int MEMBER_PER_MINUTE_RATE = 3;

    @Override 
    public int getPrice(trip.Trip trip){
        int cost = trip.getDurrationMinutes() * MEMBER_PER_MINUTE_RATE;
        if (trip.getDurrationMinutes() >= 120){
            cost += MEMBER_LONG_TRIP_SURCHARGE;
        }
        return ((int)cost);
    }
}