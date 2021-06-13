/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatisticsCalculator {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        StatisticsCalculator myCalculator = new StatisticsCalculator();

        ArrayList<Integer> inputNumberList = myCalculator.getInputNumbers();
        double numListAverage = myCalculator.average(inputNumberList);
        int maxNum = myCalculator.max(inputNumberList);
        int minNum = myCalculator.min(inputNumberList);
        double stdNum = myCalculator.std(inputNumberList,numListAverage);
        String outputString = myCalculator.generateOutputString(inputNumberList, numListAverage, maxNum, minNum, stdNum);
        myCalculator.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(ArrayList<Integer> inputNumberList, double numListAverage, int maxNum, int minNum, double stdNum) {
        String outputString = "Numbers: ";
        for (int i = 0; i < inputNumberList.size()-1; i++) {
            outputString += String.format("%d, ", inputNumberList.get(i));
        }
        outputString += String.format("%d\n", inputNumberList.get(inputNumberList.size()-1));
        outputString += String.format("The average is %.1f\n", numListAverage);
        outputString += String.format("The minimum is %d\n", minNum);
        outputString += String.format("The maximum is %d\n", maxNum);
        outputString += String.format("The standard deviation is %.2f", stdNum);
        return outputString;
    }

    protected double std(ArrayList<Integer> inputNumberList, double numListAverage) {
        double std = 0;
        for (int i = 0; i < inputNumberList.size(); i++) {
            std += Math.pow((inputNumberList.get(i) - numListAverage), 2);
        }

        std = std / inputNumberList.size();
        std = Math.sqrt(std);
        return std;
    }

    protected int max(ArrayList<Integer> inputNumberList) {
        Collections.sort(inputNumberList);
        int maxNum = inputNumberList.get(inputNumberList.size()-1);
        return maxNum;
    }

    protected int min(ArrayList<Integer> inputNumberList) {
        Collections.sort(inputNumberList);
        int minNum = inputNumberList.get(0);
        return minNum;
    }

    protected double average(ArrayList<Integer> inputNumberList) {
        int sum = 0;
        for (int i = 0; i < inputNumberList.size(); i++) {
            sum += inputNumberList.get(i);
        }
        double average = sum / inputNumberList.size();
        return average;
    }

    private ArrayList<Integer> getInputNumbers() {
        ArrayList<Integer> inputNumberList = new ArrayList<Integer>();
        boolean enterMoreNumbers = true;
        while (enterMoreNumbers) {
            System.out.print("Enter a number: ");
            String inputNum = in.nextLine();
            if (inputNum.equalsIgnoreCase("done")) {
                enterMoreNumbers = false;
            }
            int input = 0;
            try {
                input = Integer.parseInt(inputNum);
                inputNumberList.add(input);
            } catch (NumberFormatException nfe) {
            }
        }
        return inputNumberList;
    }
}
