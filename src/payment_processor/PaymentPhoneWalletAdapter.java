package payment_processor;

public class PaymentPhoneWalletAdapter implements PaymentProcessor{
  private int current_deposit_amount;
  private PhonePaymentHandler handler;
  @Override
  public void ChargeDeposit(){
    handler.ChargeDeposit(current_deposit_amount);
  }

  @Override
  public void ReturnDeposit(int fee){
    handler.ReturnDeposit(fee);
  }
}