/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex28;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdderTest {

    //Test for all positive numbers
    @Test
    void positiveNumbers() {
        Adder newAdder = new Adder();

        double[] numArray = {2.5,3,5.6,6.8};

        double actual = newAdder.computeSum(numArray);
        double expected = 17.9;
        double delta = 0.0001;

        assertEquals(expected, actual, delta);
    }

    //test for all negative numbers
    @Test
    void negativeNumbers() {
        Adder newAdder = new Adder();

        double[] numArray = {-2.5,-3,-5.6,-6.8};

        double actual = newAdder.computeSum(numArray);
        double expected = -17.9;
        double delta = 0.0001;

        assertEquals(expected, actual, delta);
    }

    //test for some positives and some negatives
    @Test
    void posAndNegNumbers() {
        Adder newAdder = new Adder();

        double[] numArray = {-2.5,3,-5.6,6.8};

        double actual = newAdder.computeSum(numArray);
        double expected = 1.7;
        double delta = 0.0001;

        assertEquals(expected, actual, delta);
    }

    //test for all values at 0
    @Test
    void allZeros() {
        Adder newAdder = new Adder();

        double[] numArray = {0,0,0,0};

        double actual = newAdder.computeSum(numArray);
        double expected = 0.0;
        double delta = 0.0001;

        assertEquals(expected, actual, delta);
    }
}
