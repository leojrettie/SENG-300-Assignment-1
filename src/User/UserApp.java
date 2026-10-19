package User;
import paymentProcessor.PaymentProcessor;

public class UserApp {
    public Trip

    startTrip(FeeCalculator feeCalculator, PaymentProcessor paymentProcessor) {
        int price = feeCalculator.getPrice();
        paymentProcessor.processPayment(price);
    }


}
