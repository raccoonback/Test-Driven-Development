package money;

/**
 * Created by koseungbin on 2020-01-22
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * (Done) $5 + 10CHF = $10 (환율이 2:1 일 경우)
 * (Done) $5 + $5 = $10
 * (Done) $5 + $5 에서 Money 반환하기
 * (Done) Bank.reduce(Money)
 * (Done) Money 에 대한 통화 변환을 수행하는 Reduce
 * (Done) Reduce(Bank, String)
 * (Done) Sum.plus
 * (Done) Expression.times
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

    @Test
    void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);

    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);

    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);

    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);

    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));

    }

    @Test
    void testMixedAddition() {
        Expression fiveBunks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBunks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);

    }

    @Test
    void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);

    }

    @Test
    void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);

    }

}
