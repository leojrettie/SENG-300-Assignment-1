package payment_processor;
// handler method provided by third-party (transit payment platform)
public class TransitPaymentHandler{
  private DummyTransitPaymentInfrastructure infrastructure;

  public void ChargeDeposit(int amount){
    infrastructure.Charge(amount);
  }
  
  public void ReturnDeposit(int fee){
    infrastructure.Refund(fee);
  }
}