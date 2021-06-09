/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex26;

import java.lang.Math;

public class PaymentCalculator {
    public int calculate(double balance, double dailyRate, double montlyPayment) {
        //This is used to check for any negative numbers
        if (balance <= 0 || dailyRate <= 0 || montlyPayment <= 0) {
            System.out.println("You entered a negative number which isn't accepted.");
            return 0;
        }
        double numMonthsUnrounded = -1.0/30.0;
        numMonthsUnrounded = (numMonthsUnrounded*(Math.log(1 + (balance / montlyPayment) * (1-Math.pow(1+dailyRate, 30)))));
        numMonthsUnrounded =  (numMonthsUnrounded / Math.log(1 + dailyRate));
        //This is used to round up the month
        if (numMonthsUnrounded % 1 != 0) {
            int numMonth = (int) (numMonthsUnrounded + 1);
            return numMonth;
        }
        int numMonth = (int) (numMonthsUnrounded);
        return numMonth;
    }
}
