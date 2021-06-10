/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex28;

import java.util.Scanner;

public class Adder {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Adder myAdder = new Adder();

        double numArray[] = myAdder.getInput();
        double sum = myAdder.computeSum(numArray);
        String outputString = generateOutputString(sum);
        myAdder.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private static String generateOutputString(double sum) {
        return String.format("The total is %f.", sum);
    }

    public double computeSum(double[] numArray) {
        double sum = 0.0;
        for (int i = 0; i < numArray.length; i++) {
            sum += numArray[i];
        }
        return sum;
    }

    private double[] getInput() {
        System.out.print("How many numbers do you want to add? ");
        int getArrayLen = in.nextInt();
        double[] numArray = new double[getArrayLen];
        for (int i = 0; i < getArrayLen; i++) {
            System.out.print("Enter a number: ");
            double num = in.nextDouble();
            numArray[i] = num;
        }
        return numArray;
    }
}
