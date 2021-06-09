/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex26;

import java.util.Scanner;

public class App {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String balanceStr = myApp.readInput("What is your balance? ");
        String aprStr = myApp.readInput("What is the APR on the card (as a percent)? ");
        String monthlyPaymentStr = myApp.readInput("What is the monthly payment you can make? ");
        float balance = myApp.convertToFloat(balanceStr);
        float aprPercentage = myApp.convertToFloat(aprStr);
        float monthlyPayment = myApp.convertToFloat(monthlyPaymentStr);
        float aprDecimal = myApp.convertPercentToDecimal(aprPercentage);
        float dailyRate = myApp.computeDailyRate(aprDecimal);
        PaymentCalculator calc = new PaymentCalculator();
        int numMonths = calc.calculate(balance, dailyRate, monthlyPayment);
        String outputString = myApp.generateOutputString(numMonths);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(int numMonths) {
        return String.format("It will take you %d months to pay off this card.",numMonths);
    }

    private float computeDailyRate(float aprDecimal) {
        float dailyRate = aprDecimal / 365;
        return dailyRate;
    }

    private float convertPercentToDecimal(float percentage) {
        float decimal = percentage / 100;
        return decimal;
    }

    private float convertToFloat(String str) {
        float num = Float.parseFloat(str);
        return num;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }
}
