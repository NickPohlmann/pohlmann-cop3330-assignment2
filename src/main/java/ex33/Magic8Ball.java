/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex33;

import java.util.Scanner;
import java.util.Random;

public class Magic8Ball {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Magic8Ball newShake = new Magic8Ball();

        newShake.readInput("What's your question?");
        String response = newShake.getResponse();
        newShake.printResponse(response);
    }

    private void printResponse(String response) {
        System.out.println(response);
    }

    private String getResponse() {
        String[] promptArray = new String[]{"Yes", "No", "Maybe", "Ask again later"};
        int promptNum = getRandomNum(promptArray.length);
        String response = promptArray[promptNum];
        return response;
    }

    protected int getRandomNum(int bound) {
        Random randNum = new Random();
        int promptNum = randNum.nextInt(bound);
        return promptNum;
    }

    private String readInput(String str) {
        System.out.println(str);
        String input = in.nextLine();
        return input;
    }
}
