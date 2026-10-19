package payment_processor;
public interface PaymentProcessor{
  public void ChargeDeposit();
  public void ReturnDeposit(int fee);
}
