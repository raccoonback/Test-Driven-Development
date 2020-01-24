package money;

/**
 * Created by koseungbin on 2020-01-23
 */

public class Sum implements Expression {
    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;

    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);

    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, addend);

    }

   public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));

    }

}
