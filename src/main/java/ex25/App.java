/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex25.App myApp = new ex25.App();

        String passwordInput = myApp.readInput("Enter the password: ");
        int passwordStrength = myApp.passwordValidator(passwordInput);
        String outputString = myApp.generateOutputString(passwordInput, passwordStrength);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(String passwordInput, int passwordStrength) {
        String strengthOfPassword = null;
        if (passwordStrength == 1) {
            strengthOfPassword = "very weak";
        } else if (passwordStrength == 2) {
            strengthOfPassword = "weak";
        } else if (passwordStrength == 3) {
            strengthOfPassword = "strong";
        } else if (passwordStrength == 4) {
            strengthOfPassword = "very strong";
        }
        return String.format("The password '%s' is a %s password.", passwordInput, strengthOfPassword);
    }

    private int passwordValidator(String passwordInput) {
        int passwodLength = getPasswordLength(passwordInput);
        if (passwodLength < 8) {
            int weakness = determineWeakness(passwordInput);
            return weakness;
        } else {
            int strength = determineStrength(passwordInput);
            return strength;
        }
    }

    private int determineStrength(String passwordInput) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(passwordInput);
        boolean stringHasSpecialChar = matcher.find();
        if (stringHasSpecialChar) {
            return 4;
        } else {
            return 3;
        }
    }

    private int determineWeakness(String passwordInput) {
        try {
            int i = Integer.parseInt(passwordInput);
        } catch (NumberFormatException nfe) {
            return 2;
        }
        return 1;
    }

    private int getPasswordLength(String passwordInput) {
        int length = passwordInput.length();
        return length;
    }
    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }
}