package fee_calculator;
public class PublicPrice implements FeeCalculator{
    @Override 
    public int getPrice(){
        return 200;
    }
}
