/*The aim of this challenge is to implement a simple integer calculator.
The calculator takes a string of space-separated numbers and operators (like "1 + 2 + 3" or "10 + 4 - 5")
 and returns the result of the calculation.

It should resolve the following sums:

"1"
"1 + 1"
"1 + 2 + 3"
"10 - 6"
"10 + 5 - 6"
"10 * 5"
If an operator isn't known, an exception should be thrown.*/

package com.serenitydojo.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class WhenDoingMaths {
    Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroForAnEmptyString() {
        assertThat(calculator.evaluate("")).isEqualTo(0);
    }

    @Test(expected = IllegalMathsOperationException.class)
    public void shouldReportNonSupportedOperations() {
        calculator.evaluate("1 ^ 2");
    }

    @Test
    public void shouldReturnTheValueOfASingleNumber() {
        assertThat(calculator.evaluate("1")).isEqualTo(1);
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertThat(calculator.evaluate("6 + 2")).isEqualTo(8);
    }

    @Test
    public void shouldAddThreeNumbers() {
        assertThat(calculator.evaluate("1 + 2 + 3")).isEqualTo(6);
    }

    @Test
    public void shouldAlsoSubtract() {
        assertThat(calculator.evaluate("10 - 6")).isEqualTo(4);
    }

    @Test
    public void shouldAddAndSubtract() {
        assertThat(calculator.evaluate("10 + 5 - 6")).isEqualTo(9);
    }

    @Test
    public void shouldMultiplyNumbers() {
        assertThat(calculator.evaluate("10 * 5")).isEqualTo(50);
    }

    @Test (expected = IllegalMathsOperationException.class)
    public void shouldNotDivideNumber0()  {
        calculator.evaluate("10 / 0 * 2 + 4");
    }

    @Test
    public void shouldDivideNumbers() {
        assertThat(calculator.evaluate("10 / 3 * 2 + 4")).isEqualTo(10.67,within(0.01));
    }
}
