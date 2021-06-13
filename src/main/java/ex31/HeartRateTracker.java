/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex31;

import java.util.Scanner;

public class HeartRateTracker {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        HeartRateTracker newTracker = new HeartRateTracker();

        int restingHR = newTracker.getIntInput("Enter your resting heart rate: ");
        int age = newTracker.getIntInput("Enter your age: ");

        String table = newTracker.createTable(restingHR, age);
        newTracker.printTable(table);
    }

    private void printTable(String table) {
        System.out.println(table);
    }

    protected String createTable(int restingHR, int age) {
        String table = String.format("Resting Pulse: %d \t Age: %d\n\n", restingHR, age);
        table += String.format("Intensity    | Rate   \n");
        table += "-------------|--------\n";
        for (int i = 55; i <= 95; i += 5) {
            int targetHR = calculateTargetHR(restingHR, age, i);
            table += String.format("%d%%          | %d bpm\n", i, targetHR);
        }
        return table;
    }

    protected int calculateTargetHR(int restingHR, int age, int intensity) {
        double intensityDecimal = intensity / 100.0;
        int targetHR = (int) Math.round((((220 - age) - restingHR) * intensityDecimal) + restingHR);
        return targetHR;
    }

    protected int getIntInput(String str) {
        boolean isInputInt = false;
        int input = 0;
        while (!isInputInt) {
            System.out.print(str);
            String inputStr = in.nextLine();
            try {
                input = Integer.parseInt(inputStr);
                isInputInt = true;
            } catch (NumberFormatException nfe) {
                isInputInt = false;
                System.out.println("The input enter is not valid, please enter an integer.");
            }
        }
        return input;
    }
}