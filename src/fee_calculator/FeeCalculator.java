package fee_calculator;

/* FeeCalculator.java is an interface for the fee calculations of differnt user types
 * @author Nico MacDonald
 */
public interface FeeCalculator {
    /* Calculates the price for a trip
     * @param Trip the trip you want to calculte the price for
     */
    public int getPrice(trip.Trip trip);
}
