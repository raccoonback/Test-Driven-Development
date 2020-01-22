package money;

/**
 * Created by koseungbin on 2020-01-22
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * () $5 + 10CHF = $10 (환율이 2:1 일 경우)
 * () $5 + $5 = $10
 *
 * */
class AddOperationTest {
    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);

    }

}
