package payment_processor;

public class PaymentTransitCardAdapter implements PaymentProcessor{
  private final int current_deposit_amount = 10;
  private TransitPaymentHandler handler;
  @Override
  public void ChargeDeposit(){
    handler.ChargeDeposit(current_deposit_amount);
  }

  @Override
  public void ReturnDeposit(int fee){
    handler.ReturnDeposit(fee);
  }
}