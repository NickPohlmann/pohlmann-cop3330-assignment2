/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex29;

import java.util.Scanner;

public class QuickCalculator {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        QuickCalculator newCalculator = new QuickCalculator();

        double validRateOfReturn = newCalculator.getValidRateOfReturn();
        double years = newCalculator.calculateYears(validRateOfReturn);

        String outputString = newCalculator.generateOutputString(years);
        newCalculator.printOutputString(outputString);
    }

    private double getValidRateOfReturn() {
        boolean rateOfReturnNotValid = true;
        String rateOfReturnStr = "";
        double rateOfReturn = 0;

        while (rateOfReturnNotValid) {
            System.out.print("What is the rate of return? ");
            rateOfReturnStr = in.nextLine();

            boolean isValid = isValid(rateOfReturnStr);

            if (isValid) {
                rateOfReturn = Double.parseDouble(rateOfReturnStr);
                rateOfReturnNotValid = false;
            } else {
                System.out.println("Sorry. That's not a valid input.");
            }
        }
        return rateOfReturn;
    }

    private boolean isValid(String input) {
        boolean isValid = true;
        try {
            double i = Double.parseDouble(input);
            isValid = (i > 0.0);
        } catch (NumberFormatException nfe) {
            isValid = false;
        }
        return isValid;
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(double years) {
        return String.format("It will take %.1f years to double your initial investment.", years);
    }

    public double calculateYears(double rateOfReturn) {
        double years = 72.0 / rateOfReturn;
        return years;
    }

}
