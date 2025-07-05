package behavior;

import java.time.LocalDate;

public class Expirable implements ExpirableInterface {
    private LocalDate expirationDate;

    public Expirable(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
    
}
