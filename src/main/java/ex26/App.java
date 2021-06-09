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
        double balance = myApp.convertToDouble(balanceStr);
        double aprPercentage = myApp.convertToDouble(aprStr);
        double monthlyPayment = myApp.convertToDouble(monthlyPaymentStr);
        double aprDecimal = myApp.convertPercentToDecimal(aprPercentage);
        double dailyRate = myApp.computeDailyRate(aprDecimal);
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

    private double computeDailyRate(double aprDecimal) {
        double dailyRate = aprDecimal / 365;
        return dailyRate;
    }

    private double convertPercentToDecimal(double percentage) {
        double decimal = percentage / 100;
        return decimal;
    }

    private double convertToDouble(String str) {
        double num = Double.parseDouble(str);
        return num;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }
}
