package money;

/**
 * Created by koseungbin on 2019-11-02
 */

public class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;

    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);

    }

    public String currency() {
        return this.currency;

    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());

    }

    public String toString() {
        return amount + " " + currency;

    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");

    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");

    }

}