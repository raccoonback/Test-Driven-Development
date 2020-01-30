package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by koseungbin on 2019-10-31
 */

/**
 * () $5 + 10CHF = $10(환율이 2:1 일 경우)
 * (Done) $5 * 2 = 10$
 * (Done) amount를 private으로 만들기
 * (Done) Dollar 부작용(side effect)?
 * () Money 반올림?
 * (Done) equals()
 * () hashCode()
 * () Equal null
 * () Equal object
 * (Done) 5CHF * 2 = 10CHF
 * (Done) Dollar/Franc 중복
 * (Done) 공용 equals
 * (Done) 공용 times
 * (Done) Franc과 Dollar 비교하기
 * (Done) 통화?
 * (Done) testFrancMultiplication을 제거
 *
 */
class OperatorTest {
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

    }

    @Test
    void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));

    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());

    }

}