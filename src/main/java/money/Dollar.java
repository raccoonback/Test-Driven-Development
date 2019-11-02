package money;

/**
 * Created by koseungbin on 2019-11-01
 */

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;

    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);

    }

    public boolean equals(Object object) {
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;

    }

}