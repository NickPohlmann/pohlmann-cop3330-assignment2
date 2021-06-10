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

        double rateOfReturn = newCalculator.getRateOfReturn();
        double years = newCalculator.calculateYears(rateOfReturn);
        String outputString = newCalculator.generateOutputString(years);
        newCalculator.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(double years) {
        return String.format("It will take %.0f years to double your initial investment.", years);
    }

    private double calculateYears(double rateOfReturn) {
        double years = 72 / rateOfReturn;
        return years;
    }

    private double getRateOfReturn() {
        boolean rateOfReturnNotValid = true;
        String rateOfReturnStr = "";

        while (rateOfReturnNotValid) {
            System.out.print("What is the rate of return? ");
            rateOfReturnStr = in.nextLine();

            boolean areThereLetters = false;
            try {
                double i = Double.parseDouble(rateOfReturnStr);
            } catch (NumberFormatException nfe) {
                areThereLetters = true;
            }

            if (areThereLetters) {
                System.out.println("Sorry. That's not a valid input.");
            } else {
                double rateOfReturn = Double.parseDouble(rateOfReturnStr);
                if (rateOfReturn <= 0.0) {
                    System.out.println("Sorry. That's not a valid input.");
                } else {
                    rateOfReturnNotValid = false;
                }
            }
        }
        double rateOfReturn = Double.parseDouble(rateOfReturnStr);
        return rateOfReturn;
    }
}
