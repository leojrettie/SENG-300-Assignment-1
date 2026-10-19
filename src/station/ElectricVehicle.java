package station;

public abstract class ElectricVehicle extends Vehicle {
    public static final float MIN_Charge = 20f; //min percent charge

    private float charge;

    protected ElectricVehicle(String vehicleId, float charge){
        super(vehicleId);
        setCharge(charge);
    }

    @Override
    public boolean checkAvailability(){
        return super.checkAvailability() && charge >= MIN_Charge;
    }

    public float getCharge(){return charge;}

    public void setCharge(float charge){
        if (charge < 0f || charge > 100f){
            throw new IllegalArgumentException("Charge must be 0-100, got " + charge);
        }
        this.charge = charge;
    }

}
