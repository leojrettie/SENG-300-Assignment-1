package fee_calculator;
public class MemberPrice implements FeeCalculator{
    @Override 
    public int getPrice(){
        return 100;
    }
}