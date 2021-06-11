/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex37;

import java.util.ArrayList;
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
        String password = newPassword.generatePassword(minLen, numSpecialChar, numNumbers, arrayOfLists);
    }

    private String generatePassword(int minLen, int numSpecialChar, int numNumbers, ArrayList<ArrayList<String>> arrayOfLists) {
        int lenPassword = generatePasswordLen(minLen, numSpecialChar, numNumbers);
        String password = new String;
        password += generateSpecialChars(numSpecialChar, arrayOfLists);
    }

    private String generateSpecialChars(int numSpecialChar, ArrayList<ArrayList<String>> arrayOfLists) {
        Random randomNumber = new Random();
        String specialCharStr = new String;
        int specialCharLenRand = randomNumber.nextInt(arrayOfLists.get(3).size());
        for (int i = 0; i < numSpecialChar; i++) {
            specialCharStr += arrayOfLists.get(3).get(specialCharLenRand);
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
