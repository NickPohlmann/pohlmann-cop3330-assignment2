/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex25;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex25.App myApp = new ex25.App();

        String passwordInput = myApp.readInput("Enter the password: ");
        int passwordStrength = myApp.passwordValidator(passwordInput);
    }

    private int passwordValidator(String passwordInput) {
        int passwo
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