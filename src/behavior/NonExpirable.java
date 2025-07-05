package behavior;

public class NonExpirable implements ExpirableInterface{
    public boolean isExpired() {
        return false;
    }
}
