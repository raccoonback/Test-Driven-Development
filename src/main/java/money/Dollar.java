package money;

/**
 * Created by koseungbin on 2019-11-01
 */

public class Dollar {
    int amount;

    public Dollar(int amount) {
        this.amount = amount;

    }

    public void times(int multiplier) {
        amount *= multiplier;

    }

}