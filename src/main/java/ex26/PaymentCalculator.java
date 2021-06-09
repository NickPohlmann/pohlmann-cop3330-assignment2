/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex26;

import java.lang.Math;

public class PaymentCalculator {
    public int calculate(float balance, float dailyRate, float montlyPayment) {
        float numMonthsUnrounded = 0;
        numMonthsUnrounded = (float) ((-1/30) * Math.log(1 + (balance / montlyPayment) * (1-Math.pow(1+dailyRate, 30))) / Math.log(1+dailyRate));
        if (numMonthsUnrounded % 1 != 0) {
            int numMonth = (int) (numMonthsUnrounded + 1);
            return numMonth;
        }
        int numMonth = (int) (numMonthsUnrounded);
        return numMonth;
    }
}
