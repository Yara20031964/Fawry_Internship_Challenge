package behavior;

public class Shippable implements ShippableInterface{
    private double weight;
    public Shippable (double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public boolean isEligibleForShipping(){
        return true;
    }

}
