/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex35;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PickAWinner {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        PickAWinner newWinner = new PickAWinner();

        ArrayList<String> contestantList = newWinner.getContestants();
        String winner = newWinner.pickWinner(contestantList);
        newWinner.printWinner(winner);
    }

    private void printWinner(String winner) {
        System.out.println(String.format("The winner is... %s", winner));
    }

    private String pickWinner(ArrayList<String> contestantList) {
        Random randNum = new Random();

        int winningNum = randNum.nextInt(contestantList.size());
        String winner = contestantList.get(winningNum);
        return winner;
    }

    private ArrayList<String> getContestants() {
        ArrayList<String> contestantList = new ArrayList<String>();
        boolean enterMoreNames = true;
        while (enterMoreNames) {
            System.out.print("Enter a name: ");
            String contestant = in.nextLine();
            if (contestant.equals("")) {
                enterMoreNames = false;
            } else {
                contestantList.add(contestant);
            }
        }
        return contestantList;
    }
}
