package payment_processor;

// Simulates external card card infrastructure, used to show communication with handler
public class DummyCreditCardPaymentInfrastructure{
  // example here just using one bank account
  private int balance = 500;
  private int card_fee = 1;

  public void Charge(int amount){
    if(amount > balance){
      return;
    }

    balance -= (amount+card_fee);
  }

  public void Refund(int amount){
    balance += (amount-card_fee);
  }
}