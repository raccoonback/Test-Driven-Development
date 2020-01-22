package money;

/**
 * Created by koseungbin on 2019-11-01
 */

public class Franc extends Money {
    public Franc(int amount, String currency) {
        super(amount, currency);

    }

    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);

    }

}