package payment_processor;
// handler method provided by third-party (phone payment platform)
public class CreditCardPaymentHandler{
  private DummyCreditCardPaymentInfrastructure infrastructure;

  public void ChargeDeposit(int amount){
    infrastructure.Charge(amount);
  }
  
  public void ReturnDeposit(int fee){
    infrastructure.Refund(fee);
  }
}