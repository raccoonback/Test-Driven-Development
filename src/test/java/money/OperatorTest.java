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
 * () Dollar/Franc 중복
 * (Done) 공용 equals
 * () 공용 times
 * () Franc과 Dollar 비교하기
 *
 */
class OperatorTest {
    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

    }

    @Test
    void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));

    }

    @Test
    void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));

    }

}