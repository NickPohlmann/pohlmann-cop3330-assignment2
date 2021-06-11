/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex32;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        NumberGame newGame = new NumberGame();

        System.out.print("Let's play Guess the Number!\n\n");
        newGame.playGame();

    }

    private void playGame() {
        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) {
            int numGuesses = guessTheNumber();
            System.out.println(String.format("You got it in %d guesses!\n", numGuesses));
            System.out.print("Do you wish to play again (Y/N)? ");
            playAgain = in.nextLine();
        }
    }

    private int guessTheNumber() {
        int numGuesses = 0;
        int difficulty = getDifficultlyLevel("Enter the difficulty level (1, 2, or 3): ");
        int correctNum = getCorrectNum(difficulty);
        boolean youWon = false;
        while (!youWon) {
            numGuesses = numGuesses + 1;
            int guess = getGuess(numGuesses);
            if (guess < correctNum) {
                System.out.print("Too low. ");
            } else if (guess > correctNum) {
                System.out.print("Too high. ");
            } else {
                youWon = true;
            }
        }
        return numGuesses;
    }

    private int getGuess(int numGuesses) {
        int yourGuess = 0;
        boolean isGuessInt = false;
        while (!isGuessInt) {
            if (numGuesses == 1) {
                System.out.print("I have my number. What's your guess? ");
            } else {
                System.out.print("Guess again: ");
            }
            String guessStr = in.nextLine();
            try {
                yourGuess = Integer.parseInt(guessStr);
                isGuessInt = true;
            } catch (NumberFormatException nfe) {
                isGuessInt = false;
                System.out.println("Please enter a valid input.");
            }
        }
        return yourGuess;
    }

    private int getCorrectNum(int difficultyLevel) {
        int rangeOfGame = 10^difficultyLevel;
        Random randNum = new Random();
        int correctNum = 1 + randNum.nextInt(rangeOfGame);
        return correctNum;
    }

    private int getDifficultlyLevel(String str) {
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
            if (input < 0 || input > 4) {
                isInputInt = false;
                System.out.println(String.format("Please enter 1, 2, or 3"));
            }
        }
        return input;
    }
}
