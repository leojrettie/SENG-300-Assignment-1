package payment_processor;

public class PaymentCreditCardAdapter implements PaymentProcessor{
  private final int current_deposit_amount = 10;
  private CreditCardPaymentHandler handler;
  @Override
  public void ChargeDeposit(){
    handler.ChargeDeposit(current_deposit_amount);
  }

  @Override
  public void ReturnDeposit(int fee){
    handler.ReturnDeposit(fee);
  }
}