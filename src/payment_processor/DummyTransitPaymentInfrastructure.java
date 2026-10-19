package payment_processor;

// Simulates external transit payment infrastructure, used to show communication with handler
public class DummyTransitPaymentInfrastructure{
  // example here just using one bank account
  private int balance = 100;
  private int ticket_price = 4;
  private int refund_tickets = 0;

  public void Charge(int amount){
    if(amount > balance){
      return;
    }

    balance -= amount;
  }

  public void Refund(int amount){
    // Transit app doesn't allow cash refunds, only refunds via tickets
    refund_tickets += (amount/ticket_price);
  }
}