package money;

/**
 * Created by koseungbin on 2019-11-02
 */

public class Money {
    protected int amount;

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount;

    }

}