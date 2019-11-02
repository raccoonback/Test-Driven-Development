package money;

/**
 * Created by koseungbin on 2019-11-01
 */

public class Franc extends Money {
    public Franc(int amount) {
        this.amount = amount;

    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);

    }

}