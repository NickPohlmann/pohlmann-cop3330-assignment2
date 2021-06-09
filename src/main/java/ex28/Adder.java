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
    }

    private double[] getInput() {
        double[] numArray = new double[];
        System.out.print("How many numbers do you want to add? ");
        int getArrayLen = in.nextInt();
        for (int i = 0; i < getArrayLen; i++) {
            System.out.print("Enter a number: ");
            double num = in.nextDouble();
            numArray[i] = num;
        }
        return numArray;
    }
}
