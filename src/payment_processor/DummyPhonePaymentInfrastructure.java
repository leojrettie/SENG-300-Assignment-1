package payment_processor;

// Simulates external phone payment infrastructure, used to show communication with handler
public class DummyPhonePaymentInfrastructure{
  // example here just using one bank account
  private int balance = 100;

  public void Charge(int amount){
    if(amount > balance){
      return;
    }

    balance -= amount;
  }

  public void Refund(int amount){
    balance += amount;
  }
}