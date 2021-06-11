/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    static Scanner in = new Scanner(System.in);

    public static  void main(String[] args) {
        PasswordGenerator newPassword = new PasswordGenerator();

        int minLen = newPassword.getInput("What's the minimum length? ");
        int numSpecialChar = newPassword.getInput("How many special characters? ");
        int numNumbers = newPassword.getInput("How many numbers? ");
        ArrayList<ArrayList<String>> arrayOfLists = newPassword.createArrayOfLists();
        String passwordUnshuffled = newPassword.generateUnshuffledPassword(minLen, numSpecialChar, numNumbers, arrayOfLists);
        String passwordShuffled = newPassword.shufflePassword(passwordUnshuffled);
        String outputString = newPassword.generateOutputString(passwordShuffled);
        newPassword.printOutputString(outputString);
    }

    private String shufflePassword(String passwordUnshuffled) {
        ArrayList<Character> passwordArray = new ArrayList<Character>();
        String shuffledPassword = "";

        for (int i = 0; i < passwordUnshuffled.length(); i++) {
            passwordArray.add(passwordUnshuffled.charAt(i));
        }
        Collections.shuffle(passwordArray);

        for (int i = 0; i < passwordUnshuffled.length(); i++) {
            shuffledPassword += passwordArray.get(i);
        }
        return shuffledPassword;
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(String password) {
        return String.format("Your password is %s",password);
    }

    private String generateUnshuffledPassword(int minLen, int numSpecialChar, int numNumbers, ArrayList<ArrayList<String>> arrayOfLists) {
        int lenPassword = generatePasswordLen(minLen, numSpecialChar, numNumbers);
        String password = "";
        password += generateSpecialChars(numSpecialChar, arrayOfLists);
        password += generateNumbers(numNumbers, arrayOfLists);
        password += generateLetters(lenPassword, numNumbers, numSpecialChar, arrayOfLists);
        System.out.println(password);
        return password;
    }

    private String generateLetters(int lenPassword, int numNumbers, int numSpecialChar, ArrayList<ArrayList<String>> arrayOfLists) {
        Random randomNumber = new Random();
        int numOfLetters = lenPassword - numNumbers - numSpecialChar;
        String letterStr = "";
        for (int i = 0; i < numOfLetters; i++) {
            int letterLenRand = randomNumber.nextInt(arrayOfLists.get(1).size());
            letterStr += arrayOfLists.get(1).get(letterLenRand);
        }
        return letterStr;
    }

    private String generateNumbers(int numNumbers, ArrayList<ArrayList<String>> arrayOfLists) {
        Random randomNumber = new Random();
        String numberStr = "";
        for (int i = 0; i < numNumbers; i++) {
            int numberLenRand = randomNumber.nextInt(numNumbers);
            numberStr += arrayOfLists.get(0).get(numberLenRand);
        }
        return numberStr;
    }

    private String generateSpecialChars(int numSpecialChar, ArrayList<ArrayList<String>> arrayOfLists) {
        Random randomNumber = new Random();
        String specialCharStr = "";
        for (int i = 0; i < numSpecialChar; i++) {
            int specialCharLenRand = randomNumber.nextInt(numSpecialChar);
            specialCharStr = specialCharStr + arrayOfLists.get(2).get(specialCharLenRand);
        }
        return specialCharStr;
    }

    private int generatePasswordLen(int minLen, int numSpecialChar, int numNumbers) {
        Random randomNumber = new Random();
        int randNum = randomNumber.nextInt(minLen);
        int lenPassword = minLen + numSpecialChar + numNumbers + randNum;
        return lenPassword;
    }

    private ArrayList<ArrayList<String>> createArrayOfLists() {
        ArrayList<String> numList = createNumList();
        ArrayList<String> letterList = createLetterList();
        ArrayList<String> specialCharList = createSpecialCharList();
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        listOfLists.add(numList);
        listOfLists.add(letterList);
        listOfLists.add(specialCharList);
        return listOfLists;
    }

    private ArrayList<String> createSpecialCharList() {
        ArrayList<String> specialCharList = new ArrayList<String>();
        specialCharList.add("!");
        specialCharList.add("@");
        specialCharList.add("#");
        specialCharList.add("$");
        specialCharList.add("%");
        specialCharList.add("^");
        specialCharList.add("&");
        specialCharList.add("*");
        return specialCharList;
    }

    private ArrayList<String> createLetterList() {
        ArrayList<String> letterList = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            letterList.add(String.valueOf(c));
        }
        return letterList;
    }


    private ArrayList<String> createNumList() {
        ArrayList<String> numList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            numList.add(String.valueOf(i));
        }
        return numList;
    }

    private int getInput(String str) {
        System.out.print(str);
        int input = in.nextInt();
        return input;
    }
}
