package behavior;

public class NotShippable implements ShippableInterface {
    public boolean isEligibleForShipping(){
        return false;
    }
    public double getWeight(){
        return 0.0;
    }
}
