/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    //Tests for negative or zero number entered for balance
    @Test
    void negativeBalance() {
        PaymentCalculator calc = new PaymentCalculator();

        int actual = calc.calculate(-12.0,13.5, 102.0);
        int expected = 0;

        assertEquals(expected, actual);
    }

    //Tests for negative or zero number entered for daily rate
    @Test
    void negativeDailyRate() {
        PaymentCalculator calc = new PaymentCalculator();

        int actual = calc.calculate(5000,-12.0,34.5);
        int expected = 0;

        assertEquals(expected, actual);
    }

    //Tests for negative or zero monthly payment
    @Test
    void negativeMonthlyPayment() {
        PaymentCalculator calc = new PaymentCalculator();

        int actual = calc.calculate(2345,56789,-123);
        int expected = 0;

        assertEquals(expected, actual);
    }

    //Tests for positive values for all
    @Test
    void allPositiveNums() {
        PaymentCalculator calc = new PaymentCalculator();

        int actual = calc.calculate(5000, (.12/365), 100);
        int expected = 70;

        assertEquals(expected, actual);
    }
}
