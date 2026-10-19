package trip;

import java.util.UUID;

import fee_calculator.*;

/**
 * User
 */
public class User {
    public static FeeCalculator fee_calculator;
    public User() {
        this.fee_calculator = new StudentPrice(); // Choose one??
    }
}
