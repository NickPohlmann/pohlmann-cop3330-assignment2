/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex38;

import java.util.ArrayList;
import java.util.Scanner;

public class ValueFilter {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ValueFilter newFilter = new ValueFilter();

        ArrayList<Integer> inputList = newFilter.getInputList();
        ArrayList<Integer> evenNumList = newFilter.filterOutOdds(inputList);
        String outputString = newFilter.generateOutputString(evenNumList);
        newFilter.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(ArrayList<Integer> evenNumList) {
        String outputString = "The even numbers are ";
        for (int i = 0; i < evenNumList.size(); i++) {
            outputString += String.format("%d ", evenNumList.get(i));
        }
        return outputString;
    }

    protected ArrayList<Integer> filterOutOdds(ArrayList<Integer> inputList) {
        ArrayList<Integer> evenNumList = new ArrayList<Integer>();
        for (int i = 0; i < inputList.size(); i++) {
            int isEven = inputList.get(i) % 2;
            if (isEven == 0) {
                evenNumList.add(inputList.get(i));
            }
        }
        return evenNumList;
    }

    private ArrayList<Integer> getInputList() {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        System.out.print("Enter a list of numbers, separated by spaces: ");
        String input = in.nextLine();
        for (int i = 0; i < input.length(); i += 2) {
            try {
                int inputInt = Integer.parseInt(input.substring(i,i+1));
                inputList.add(inputInt);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid character");
            }
        }

        return inputList;
    }
}
